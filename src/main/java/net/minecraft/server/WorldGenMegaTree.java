package net.minecraft.server;

import java.util.Random;

public class WorldGenMegaTree extends WorldGenMegaTreeAbstract {

    private static final IBlockData e = Blocks.LOG.getBlockData().set(BlockLog1.VARIANT, BlockWood.EnumLogVariant.SPRUCE);
    private static final IBlockData f = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.SPRUCE).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    private static final IBlockData g = Blocks.DIRT.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.PODZOL);
    private boolean h;

    public WorldGenMegaTree(boolean flag, boolean flag1) {
        super(flag, 13, 15, WorldGenMegaTree.e, WorldGenMegaTree.f);
        this.h = flag1;
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        int i = this.a(random);

        if (!this.a(world, random, blockposition, i)) {
            return false;
        } else {
            this.a(world, blockposition.getX(), blockposition.getZ(), blockposition.getY() + i, 0, random);

            for (int j = 0; j < i; ++j) {
                Block block = world.getType(blockposition.up(j)).getBlock();

                if (block.getMaterial() == Material.AIR || block.getMaterial() == Material.LEAVES) {
                    this.a(world, blockposition.up(j), this.b);
                }

                if (j < i - 1) {
                    block = world.getType(blockposition.a(1, j, 0)).getBlock();
                    if (block.getMaterial() == Material.AIR || block.getMaterial() == Material.LEAVES) {
                        this.a(world, blockposition.a(1, j, 0), this.b);
                    }

                    block = world.getType(blockposition.a(1, j, 1)).getBlock();
                    if (block.getMaterial() == Material.AIR || block.getMaterial() == Material.LEAVES) {
                        this.a(world, blockposition.a(1, j, 1), this.b);
                    }

                    block = world.getType(blockposition.a(0, j, 1)).getBlock();
                    if (block.getMaterial() == Material.AIR || block.getMaterial() == Material.LEAVES) {
                        this.a(world, blockposition.a(0, j, 1), this.b);
                    }
                }
            }

            return true;
        }
    }

    
    //lambda
    int i1, j1;
    private void a(World world, int i, int j, int k, int l, Random random) {
        //int i1 = random.nextInt(5) + (this.h ? this.a : 3);
        //int j1 = 0;
        i1 = random.nextInt(5) + (this.h ? this.a : 3);
        j1 = 0;

        for (int k1 = k - i1; k1 <= k; ++k1) {
            int l1 = k - k1;
            int i2 = l + MathHelper.d((float) l1 / (float) i1 * 3.5F);

            this.a(world, new BlockPosition(i, k1, j), i2 + (l1 > 0 && i2 == j1 && (k1 & 1) == 0 ? 1 : 0));
            j1 = i2;
        }

    }

    
    //lambda
    public void a(World world, Random random, BlockPosition blockposition) {
        this.b(world, blockposition.west().north());
        this.b(world, blockposition.east(2).north());
        this.b(world, blockposition.west().south(2));
        this.b(world, blockposition.east(2).south(2));

        for (int i = 0; i < 5; ++i) {
            int j = random.nextInt(64);
            int k = j % 8;
            int l = j / 8;

            if (k == 0 || k == 7 || l == 0 || l == 7) {
                this.b(world, blockposition.a(-3 + k, 0, -3 + l));
            }
        }

    }

    //lambda
    private void b(World world, BlockPosition blockposition) {
        for (int i = -2; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                if (Math.abs(i) != 2 || Math.abs(j) != 2) {
                    this.c(world, blockposition.a(i, 0, j));
                }
            }
        }

    }

    private void c(World world, BlockPosition blockposition) {
        for (int i = 2; i >= -3; --i) {
            BlockPosition blockposition1 = blockposition.up(i);
            Block block = world.getType(blockposition1).getBlock();

            if (block == Blocks.GRASS || block == Blocks.DIRT) {
                this.a(world, blockposition1, WorldGenMegaTree.g);
                break;
            }

            if (block.getMaterial() != Material.AIR && i < 0) {
                break;
            }
        }

    }
}
