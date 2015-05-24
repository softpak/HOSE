package net.minecraft.server;

import java.util.Random;

public class WorldGenSand extends WorldGenerator {

    private Block a;
    private int b;

    public WorldGenSand(Block block, int i) {
        this.a = block;
        this.b = i;
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        if (world.getType(blockposition).getBlock().getMaterial() != Material.WATER) {
            return false;
        } else {
            int i = random.nextInt(this.b - 2) + 2;
            byte b0 = 2;

            for (int j = blockposition.getX() - i; j <= blockposition.getX() + i; ++j) {
                for (int k = blockposition.getZ() - i; k <= blockposition.getZ() + i; ++k) {
                    int l = j - blockposition.getX();
                    int i1 = k - blockposition.getZ();

                    if (l * l + i1 * i1 <= i * i) {
                        for (int j1 = blockposition.getY() - b0; j1 <= blockposition.getY() + b0; ++j1) {
                            BlockPosition blockposition1 = new BlockPosition(j, j1, k);
                            Block block = world.getType(blockposition1).getBlock();

                            if (block == Blocks.DIRT || block == Blocks.GRASS) {
                                world.setTypeAndData(blockposition1, this.a.getBlockData(), 2);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
