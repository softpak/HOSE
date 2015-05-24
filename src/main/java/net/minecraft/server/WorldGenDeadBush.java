package net.minecraft.server;

import java.util.Random;

public class WorldGenDeadBush extends WorldGenerator {

    public WorldGenDeadBush() {}

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        Block block;

        while (((block = world.getType(blockposition).getBlock()).getMaterial() == Material.AIR || block.getMaterial() == Material.LEAVES) && blockposition.getY() > 0) {
            blockposition = blockposition.down();
        }

        for (int i = 0; i < 4; ++i) {
            BlockPosition blockposition1 = blockposition.a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

            if (world.isEmpty(blockposition1) && Blocks.DEADBUSH.f(world, blockposition1, Blocks.DEADBUSH.getBlockData())) {
                world.setTypeAndData(blockposition1, Blocks.DEADBUSH.getBlockData(), 2);
            }
        }

        return true;
    }
}
