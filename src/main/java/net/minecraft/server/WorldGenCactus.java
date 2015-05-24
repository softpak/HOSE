package net.minecraft.server;

import java.util.Random;

public class WorldGenCactus extends WorldGenerator {

    public WorldGenCactus() {}

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        for (int i = 0; i < 10; ++i) {
            BlockPosition blockposition1 = blockposition.a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

            if (world.isEmpty(blockposition1)) {
                int j = 1 + random.nextInt(random.nextInt(3) + 1);

                for (int k = 0; k < j; ++k) {
                    if (Blocks.CACTUS.e(world, blockposition1)) {
                        world.setTypeAndData(blockposition1.up(k), Blocks.CACTUS.getBlockData(), 2);
                    }
                }
            }
        }

        return true;
    }
}
