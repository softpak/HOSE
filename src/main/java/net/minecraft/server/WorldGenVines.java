package net.minecraft.server;

import java.util.Random;

public class WorldGenVines extends WorldGenerator {

    public WorldGenVines() {}

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        for (; blockposition.getY() < 128; blockposition = blockposition.up()) {
            if (world.isEmpty(blockposition)) {
                EnumDirection[] aenumdirection = EnumDirection.EnumDirectionLimit.HORIZONTAL.a();
                int i = aenumdirection.length;

                for (int j = 0; j < i; ++j) {
                    EnumDirection enumdirection = aenumdirection[j];

                    if (Blocks.VINE.canPlace(world, blockposition, enumdirection)) {
                        IBlockData iblockdata = Blocks.VINE.getBlockData().set(BlockVine.NORTH, Boolean.valueOf(enumdirection == EnumDirection.NORTH)).set(BlockVine.EAST, Boolean.valueOf(enumdirection == EnumDirection.EAST)).set(BlockVine.SOUTH, Boolean.valueOf(enumdirection == EnumDirection.SOUTH)).set(BlockVine.WEST, Boolean.valueOf(enumdirection == EnumDirection.WEST));

                        world.setTypeAndData(blockposition, iblockdata, 2);
                        break;
                    }
                }
            } else {
                blockposition = blockposition.a(random.nextInt(4) - random.nextInt(4), 0, random.nextInt(4) - random.nextInt(4));
            }
        }

        return true;
    }
}
