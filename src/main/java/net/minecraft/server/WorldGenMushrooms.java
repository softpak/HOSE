package net.minecraft.server;

import java.util.Random;

public class WorldGenMushrooms extends WorldGenerator {

    private BlockPlant a;

    public WorldGenMushrooms(BlockPlant blockplant) {
        this.a = blockplant;
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        for (int i = 0; i < 64; ++i) {
            BlockPosition blockposition1 = blockposition.a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

            if (world.isEmpty(blockposition1) && (!world.worldProvider.o() || blockposition1.getY() < 255) && this.a.f(world, blockposition1, this.a.getBlockData())) {
                world.setTypeAndData(blockposition1, this.a.getBlockData(), 2);
            }
        }

        return true;
    }
}
