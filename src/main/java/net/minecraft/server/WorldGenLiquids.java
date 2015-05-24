package net.minecraft.server;

import java.util.Random;

public class WorldGenLiquids extends WorldGenerator {

    private Block a;

    public WorldGenLiquids(Block block) {
        this.a = block;
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        if (world.getType(blockposition.up()).getBlock() != Blocks.STONE) {
            return false;
        } else if (world.getType(blockposition.down()).getBlock() != Blocks.STONE) {
            return false;
        } else if (world.getType(blockposition).getBlock().getMaterial() != Material.AIR && world.getType(blockposition).getBlock() != Blocks.STONE) {
            return false;
        } else {
            int i = 0;

            if (world.getType(blockposition.west()).getBlock() == Blocks.STONE) {
                ++i;
            }

            if (world.getType(blockposition.east()).getBlock() == Blocks.STONE) {
                ++i;
            }

            if (world.getType(blockposition.north()).getBlock() == Blocks.STONE) {
                ++i;
            }

            if (world.getType(blockposition.south()).getBlock() == Blocks.STONE) {
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

            if (i == 3 && j == 1) {
                world.setTypeAndData(blockposition, this.a.getBlockData(), 2);
                world.a(this.a, blockposition, random);
            }

            return true;
        }
    }
}
