package net.minecraft.server;

import java.util.Random;

public class WorldGenFlowers extends WorldGenerator {

    private BlockFlowers a;
    private IBlockData b;

    public WorldGenFlowers(BlockFlowers blockflowers, BlockFlowers.EnumFlowerVarient blockflowers_enumflowervarient) {
        this.a(blockflowers, blockflowers_enumflowervarient);
    }

    public void a(BlockFlowers blockflowers, BlockFlowers.EnumFlowerVarient blockflowers_enumflowervarient) {
        this.a = blockflowers;
        this.b = blockflowers.getBlockData().set(blockflowers.n(), blockflowers_enumflowervarient);
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        for (int i = 0; i < 64; ++i) {
            BlockPosition blockposition1 = blockposition.a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

            if (world.isEmpty(blockposition1) && (!world.worldProvider.o() || blockposition1.getY() < 255) && this.a.f(world, blockposition1, this.b)) {
                world.setTypeAndData(blockposition1, this.b, 2);
            }
        }

        return true;
    }
}
