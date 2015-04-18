package org.spigotmc;

import gnu.trove.set.TByteSet;
import gnu.trove.set.hash.TByteHashSet;
import net.minecraft.server.Block;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.Blocks;
import net.minecraft.server.World;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;

public class AntiXray
{

    private static final CustomTimingsHandler update = new CustomTimingsHandler( "xray - update" );
    private static final CustomTimingsHandler obfuscate = new CustomTimingsHandler( "xray - obfuscate" );
    /*========================================================================*/
    // Used to keep track of which blocks to obfuscate
    private final boolean[] obfuscateBlocks = new boolean[ Short.MAX_VALUE ];
    // Used to select a random replacement ore
    private final byte[] replacementOres;

    public AntiXray(SpigotWorldConfig config)
    {
        // Set all listed blocks as true to be obfuscated
        for ( int id : ( config.engineMode == 1 ) ? config.hiddenBlocks : config.replaceBlocks )
        {
            obfuscateBlocks[id] = true;
        }

        // For every block
        TByteSet blocks = new TByteHashSet();
        for ( Integer i : config.hiddenBlocks )
        {
            Block block = Block.getById( i );
            // Check it exists and is not a tile entity
            if ( block != null && !block.isTileEntity() )
            {
                // Add it to the set of replacement blocks
                blocks.add( (byte) (int) i );
            }
        }
        // Bake it to a flat array of replacements
        replacementOres = blocks.toArray();
    }

    /**
     * Starts the timings handler, then updates all blocks within the set radius
     * of the given coordinate, revealing them if they are hidden ores.
     */
    public void updateNearbyBlocks(World world, BlockPosition position)
    {
        if ( world.spigotConfig.antiXray )
        {
            update.startTiming();
            updateNearbyBlocks( world, position, 2, false ); // 2 is the radius, we shouldn't change it as that would make it exponentially slower
            update.stopTiming();
        }
    }

    /**
     * Starts the timings handler, and then removes all non exposed ores from
     * the chunk buffer.
     */
    public void obfuscateSync(int chunkX, int chunkY, int bitmask, byte[] buffer, World world)
    {
        if ( world.spigotConfig.antiXray )
        {
            obfuscate.startTiming();
            obfuscate( chunkX, chunkY, bitmask, buffer, world );
            obfuscate.stopTiming();
        }
    }

    /**
     * Removes all non exposed ores from the chunk buffer.
     */
    public void obfuscate(int chunkX, int chunkY, int bitmask, byte[] buffer, World world)
    {
        // If the world is marked as obfuscated
        if ( world.spigotConfig.antiXray )
        {
            // Initial radius to search around for air
            int initialRadius = 1;
            // Which block in the buffer we are looking at, anywhere from 0 to 16^4
            int index = 0;
            // The iterator marking which random ore we should use next
            int randomOre = 0;

            // Chunk corner X and Z blocks
            int startX = chunkX << 4;
            int startZ = chunkY << 4;

            byte replaceWithTypeId;
            switch ( world.getWorld().getEnvironment() )
            {
                case NETHER:
                    replaceWithTypeId = (byte) CraftMagicNumbers.getId(Blocks.NETHERRACK);
                    break;
                case THE_END:
                    replaceWithTypeId = (byte) CraftMagicNumbers.getId(Blocks.END_STONE);
                    break;
                default:
                    replaceWithTypeId = (byte) CraftMagicNumbers.getId(Blocks.STONE);
                    break;
            }

            // Chunks can have up to 16 sections
            for ( int i = 0; i < 16; i++ )
            {
                // If the bitmask indicates this chunk is sent...
                if ( ( bitmask & 1 << i ) != 0 )
                {
                    // Work through all blocks in the chunk, y,z,x
                    for ( int y = 0; y < 16; y++ )
                    {
                        for ( int z = 0; z < 16; z++ )
                        {
                            for ( int x = 0; x < 16; x++ )
                            {
                                // For some reason we can get too far ahead of ourselves (concurrent modification on bulk chunks?) so if we do, just abort and move on
                                if ( index >= buffer.length )
                                {
                                    index++;
                                    continue;
                                }
                                // Grab the block ID in the buffer.
                                // TODO: extended IDs are not yet supported
                                int blockId = (buffer[index << 1] & 0xFF) 
                                        | ((buffer[(index << 1) + 1] & 0xFF) << 8);
                                blockId >>>= 4;
                                // Check if the block should be obfuscated
                                if ( obfuscateBlocks[blockId] )
                                {
                                    // The world isn't loaded, bail out
                                    if ( !isLoaded( world, new BlockPosition( startX + x, ( i << 4 ) + y, startZ + z ), initialRadius ) )
                                    {
                                        index++;
                                        continue;
                                    }
                                    // On the otherhand, if radius is 0, or the nearby blocks are all non air, we can obfuscate
                                    if ( !hasTransparentBlockAdjacent( world, new BlockPosition( startX + x, ( i << 4 ) + y, startZ + z ), initialRadius ) )
                                    {
                                        int newId = blockId;
                                        switch ( world.spigotConfig.engineMode )
                                        {
                                            case 1:
                                                // Replace with replacement material
                                                newId = replaceWithTypeId & 0xFF;
                                                break;
                                            case 2:
                                                // Replace with random ore.
                                                if ( randomOre >= replacementOres.length )
                                                {
                                                    randomOre = 0;
                                                }
                                                newId = replacementOres[randomOre++] & 0xFF;
                                                break;
                                        }
                                        newId <<= 4;
                                        buffer[index << 1] = (byte) (newId & 0xFF);
                                        buffer[(index << 1) + 1] = (byte) ((newId >> 8) & 0xFF);
                                    }
                                }

                                index++;
                            }
                        }
                    }
                }
            }
        }
    }

    private void updateNearbyBlocks(World world, BlockPosition position, int radius, boolean updateSelf)
    {
        // If the block in question is loaded
        if ( world.isLoaded( position ) )
        {
            // Get block id
            Block block = world.getType(position).getBlock();

            // See if it needs update
            if ( updateSelf && obfuscateBlocks[Block.getId( block )] )
            {
                // Send the update
                world.notify( position );
            }

            // Check other blocks for updates
            if ( radius > 0 )
            {
                updateNearbyBlocks( world, position.east(), radius - 1, true );
                updateNearbyBlocks( world, position.west(), radius - 1, true );
                updateNearbyBlocks( world, position.up(), radius - 1, true );
                updateNearbyBlocks( world, position.down(), radius - 1, true );
                updateNearbyBlocks( world, position.south(), radius - 1, true );
                updateNearbyBlocks( world, position.north(), radius - 1, true );
            }
        }
    }

    private static boolean isLoaded(World world, BlockPosition position, int radius)
    {
        return world.isLoaded( position )
                && ( radius == 0 ||
                ( isLoaded( world, position.east(), radius - 1 )
                && isLoaded( world, position.west(), radius - 1 )
                && isLoaded( world, position.up(), radius - 1 )
                && isLoaded( world, position.down(), radius - 1 )
                && isLoaded( world, position.south(), radius - 1 )
                && isLoaded( world, position.north(), radius - 1 ) ) );
    }

    private static boolean hasTransparentBlockAdjacent(World world, BlockPosition position, int radius)
    {
        return !isSolidBlock(world.getType(position, false).getBlock()) /* isSolidBlock */
                || ( radius > 0
                && ( hasTransparentBlockAdjacent( world, position.east(), radius - 1 )
                || hasTransparentBlockAdjacent( world, position.west(), radius - 1 )
                || hasTransparentBlockAdjacent( world, position.up(), radius - 1 )
                || hasTransparentBlockAdjacent( world, position.down(), radius - 1 )
                || hasTransparentBlockAdjacent( world, position.south(), radius - 1 )
                || hasTransparentBlockAdjacent( world, position.north(), radius - 1 ) ) );
    }

    private static boolean isSolidBlock(Block block) {
        // Mob spawners are treated as solid blocks as far as the
        // game is concerned for lighting and other tasks but for
        // rendering they can be seen through therefor we special
        // case them so that the antixray doesn't show the fake
        // blocks around them.
        return block.isOccluding() && block != Blocks.MOB_SPAWNER;
    }
}
