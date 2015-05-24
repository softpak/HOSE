package net.minecraft.server;

import java.util.Random;

public class WorldGenPackedIce1 extends WorldGenerator {

    private Block a;
    private int b;

    public WorldGenPackedIce1(int i) {
        this.a = Blocks.PACKED_ICE;
        this.b = i;
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        while (world.isEmpty(blockposition) && blockposition.getY() > 2) {
            blockposition = blockposition.down();
        }

        if (world.getType(blockposition).getBlock() != Blocks.SNOW) {
            return false;
        } else {
            int i = random.nextInt(this.b - 2) + 2;
            byte b0 = 1;

            for (int j = blockposition.getX() - i; j <= blockposition.getX() + i; ++j) {
                for (int k = blockposition.getZ() - i; k <= blockposition.getZ() + i; ++k) {
                    int l = j - blockposition.getX();
                    int i1 = k - blockposition.getZ();

                    if (l * l + i1 * i1 <= i * i) {
                        for (int j1 = blockposition.getY() - b0; j1 <= blockposition.getY() + b0; ++j1) {
                            BlockPosition blockposition1 = new BlockPosition(j, j1, k);
                            Block block = world.getType(blockposition1).getBlock();

                            if (block == Blocks.DIRT || block == Blocks.SNOW || block == Blocks.ICE) {
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
