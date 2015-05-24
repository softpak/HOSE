package net.minecraft.server;

import java.util.Random;

public class WorldGenMelon extends WorldGenerator {

    public WorldGenMelon() {}

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        for (int i = 0; i < 64; ++i) {
            BlockPosition blockposition1 = blockposition.a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

            if (Blocks.MELON_BLOCK.canPlace(world, blockposition1) && world.getType(blockposition1.down()).getBlock() == Blocks.GRASS) {
                world.setTypeAndData(blockposition1, Blocks.MELON_BLOCK.getBlockData(), 2);
            }
        }

        return true;
    }
}
