package net.minecraft.server;

import java.util.Random;

public class WorldGenHellLava extends WorldGenerator {

    private final Block a;
    private final boolean b;

    public WorldGenHellLava(Block block, boolean flag) {
        this.a = block;
        this.b = flag;
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        if (world.getType(blockposition.up()).getBlock() != Blocks.NETHERRACK) {
            return false;
        } else if (world.getType(blockposition).getBlock().getMaterial() != Material.AIR && world.getType(blockposition).getBlock() != Blocks.NETHERRACK) {
            return false;
        } else {
            int i = 0;

            if (world.getType(blockposition.west()).getBlock() == Blocks.NETHERRACK) {
                ++i;
            }

            if (world.getType(blockposition.east()).getBlock() == Blocks.NETHERRACK) {
                ++i;
            }

            if (world.getType(blockposition.north()).getBlock() == Blocks.NETHERRACK) {
                ++i;
            }

            if (world.getType(blockposition.south()).getBlock() == Blocks.NETHERRACK) {
                ++i;
            }

            if (world.getType(blockposition.down()).getBlock() == Blocks.NETHERRACK) {
                ++i;
            }

            int j = 0;

            if (world.isEmpty(blockposition.west())) {
                ++j;
            }

            if (world.isEmpty(blockposition.east())) {
                ++j;
            }

            if (world.isEmpty(blockposition.north())) {
                ++j;
            }

            if (world.isEmpty(blockposition.south())) {
                ++j;
            }

            if (world.isEmpty(blockposition.down())) {
                ++j;
            }

            if (!this.b && i == 4 && j == 1 || i == 5) {
                world.setTypeAndData(blockposition, this.a.getBlockData(), 2);
                world.a(this.a, blockposition, random);
            }

            return true;
        }
    }
}
