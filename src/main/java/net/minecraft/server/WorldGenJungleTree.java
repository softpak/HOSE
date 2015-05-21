package net.minecraft.server;

import java.util.Random;

public class WorldGenJungleTree extends WorldGenMegaTreeAbstract {

    public WorldGenJungleTree(boolean flag, int i, int j, IBlockData iblockdata, IBlockData iblockdata1) {
        super(flag, i, j, iblockdata, iblockdata1);
    }

    //lambda
    int k, l, j;
    public boolean generate(World world, Random random, BlockPosition blockposition) {
        int i = this.a(random);

        if (!this.a(world, random, blockposition, i)) {
            return false;
        } else {
            this.c(world, blockposition.up(i), 2);
            
            for (j = blockposition.getY() + i - 2 - random.nextInt(4); j > blockposition.getY() + i / 2; j -= 2 + random.nextInt(4)) {
                float f = random.nextFloat() * 3.1415927F * 2.0F;
                //int k = blockposition.getX() + (int) (0.5F + MathHelper.cos(f) * 4.0F);
                //int l = blockposition.getZ() + (int) (0.5F + MathHelper.sin(f) * 4.0F);
                k = blockposition.getX() + (int) (0.5F + MathHelper.cos(f) * 4.0F);
                l = blockposition.getZ() + (int) (0.5F + MathHelper.sin(f) * 4.0F);

                int i1;

                for (i1 = 0; i1 < 5; ++i1) {
                    k = blockposition.getX() + (int) (1.5F + MathHelper.cos(f) * (float) i1);
                    l = blockposition.getZ() + (int) (1.5F + MathHelper.sin(f) * (float) i1);
                    this.a(world, new BlockPosition(k, j - 3 + i1 / 2, l), this.b);
                }

                i1 = 1 + random.nextInt(2);
                int j1 = j;

                for (int k1 = j - i1; k1 <= j1; ++k1) {
                    int l1 = k1 - j1;

                    this.b(world, new BlockPosition(k, k1, l), 1 - l1);
                }
            }

            for (int i2 = 0; i2 < i; ++i2) {
                BlockPosition blockposition1 = blockposition.up(i2);

                if (this.a(world.getType(blockposition1).getBlock())) {
                    this.a(world, blockposition1, this.b);
                    if (i2 > 0) {
                        this.a(world, random, blockposition1.west(), BlockVine.EAST);
                        this.a(world, random, blockposition1.north(), BlockVine.SOUTH);
                    }
                }

                if (i2 < i - 1) {
                    BlockPosition blockposition2 = blockposition1.east();

                    if (this.a(world.getType(blockposition2).getBlock())) {
                        this.a(world, blockposition2, this.b);
                        if (i2 > 0) {
                            this.a(world, random, blockposition2.east(), BlockVine.WEST);
                            this.a(world, random, blockposition2.north(), BlockVine.SOUTH);
                        }
                    }

                    BlockPosition blockposition3 = blockposition1.south().east();

                    if (this.a(world.getType(blockposition3).getBlock())) {
                        this.a(world, blockposition3, this.b);
                        if (i2 > 0) {
                            this.a(world, random, blockposition3.east(), BlockVine.WEST);
                            this.a(world, random, blockposition3.south(), BlockVine.NORTH);
                        }
                    }

                    BlockPosition blockposition4 = blockposition1.south();

                    if (this.a(world.getType(blockposition4).getBlock())) {
                        this.a(world, blockposition4, this.b);
                        if (i2 > 0) {
                            this.a(world, random, blockposition4.west(), BlockVine.EAST);
                            this.a(world, random, blockposition4.south(), BlockVine.NORTH);
                        }
                    }
                }
            }

            return true;
        }
    }

    private void a(World world, Random random, BlockPosition blockposition, BlockStateBoolean blockstateboolean) {
        if (random.nextInt(3) > 0 && world.isEmpty(blockposition)) {
            this.a(world, blockposition, Blocks.VINE.getBlockData().set(blockstateboolean, Boolean.valueOf(true)));
        }

    }

    private void c(World world, BlockPosition blockposition, int i) {
        byte b0 = 2;

        for (int j = -b0; j <= 0; ++j) {
            this.a(world, blockposition.up(j), i + 1 - j);
        }

    }
}
