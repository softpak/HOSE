package net.minecraft.server;

import java.util.Random;

public class WorldGenPumpkin extends WorldGenerator {

    public WorldGenPumpkin() {}

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        for (int i = 0; i < 64; ++i) {
            BlockPosition blockposition1 = blockposition.a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

            if (world.isEmpty(blockposition1) && world.getType(blockposition1.down()).getBlock() == Blocks.GRASS && Blocks.PUMPKIN.canPlace(world, blockposition1)) {
                world.setTypeAndData(blockposition1, Blocks.PUMPKIN.getBlockData().set(BlockPumpkin.FACING, EnumDirection.EnumDirectionLimit.HORIZONTAL.a(random)), 2);
            }
        }

        return true;
    }
}
