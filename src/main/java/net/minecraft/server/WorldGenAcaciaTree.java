package net.minecraft.server;

import java.util.Random;
import java.util.stream.IntStream;

public class WorldGenAcaciaTree extends WorldGenTreeAbstract {

    private static final IBlockData a = Blocks.LOG2.getBlockData().set(BlockLog2.VARIANT, BlockWood.EnumLogVariant.ACACIA);
    private static final IBlockData b = Blocks.LEAVES2.getBlockData().set(BlockLeaves2.VARIANT, BlockWood.EnumLogVariant.ACACIA).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

    public WorldGenAcaciaTree(boolean flag) {
        super(flag);
    }

    
    //lambda
    BlockPosition blockposition2, blockposition4;
    public boolean generate(World world, Random random, BlockPosition blockposition) {
        int i = random.nextInt(3) + random.nextInt(3) + 5;
        boolean flag = true;

        if (blockposition.getY() >= 1 && blockposition.getY() + i + 1 <= 256) {
            int j;
            int k;

            for (int l = blockposition.getY(); l <= blockposition.getY() + 1 + i; ++l) {
                byte b0 = 1;

                if (l == blockposition.getY()) {
                    b0 = 0;
                }

                if (l >= blockposition.getY() + 1 + i - 2) {
                    b0 = 2;
                }

                BlockPosition.MutableBlockPosition blockposition_mutableblockposition = new BlockPosition.MutableBlockPosition();

                for (j = blockposition.getX() - b0; j <= blockposition.getX() + b0 && flag; ++j) {
                    for (k = blockposition.getZ() - b0; k <= blockposition.getZ() + b0 && flag; ++k) {
                        if (l >= 0 && l < 256) {
                            if (!this.a(world.getType(blockposition_mutableblockposition.c(j, l, k)).getBlock())) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                Block block = world.getType(blockposition.down()).getBlock();

                if ((block == Blocks.GRASS || block == Blocks.DIRT) && blockposition.getY() < 256 - i - 1) {
                    this.a(world, blockposition.down());
                    EnumDirection enumdirection = EnumDirection.EnumDirectionLimit.HORIZONTAL.a(random);
                    int i1 = i - random.nextInt(4) - 1;

                    j = 3 - random.nextInt(3);
                    k = blockposition.getX();
                    int j1 = blockposition.getZ();
                    int k1 = 0;

                    int l1;

                    for (int i2 = 0; i2 < i; ++i2) {
                        l1 = blockposition.getY() + i2;
                        if (i2 >= i1 && j > 0) {
                            k += enumdirection.getAdjacentX();
                            j1 += enumdirection.getAdjacentZ();
                            --j;
                        }

                        BlockPosition blockposition1 = new BlockPosition(k, l1, j1);
                        Material material = world.getType(blockposition1).getBlock().getMaterial();

                        if (material == Material.AIR || material == Material.LEAVES) {
                            this.b(world, blockposition1);
                            k1 = l1;
                        }
                    }

                    //BlockPosition blockposition2 = new BlockPosition(k, k1, j1);
                    blockposition2 = new BlockPosition(k, k1, j1);

                    int j2;

                    IntStream.range(-3, 4).forEach( ll1 -> {
                        IntStream.range(-3, 4).forEach( jj2 -> {
                            if (Math.abs(ll1) != 3 || Math.abs(jj2) != 3) {
                                this.c(world, blockposition2.a(ll1, 0, jj2));
                            }
                        });
                    });
                    /*
                    for (l1 = -3; l1 <= 3; ++l1) {
                        for (j2 = -3; j2 <= 3; ++j2) {
                            if (Math.abs(l1) != 3 || Math.abs(j2) != 3) {
                                this.c(world, blockposition2.a(l1, 0, j2));
                            }
                        }
                    }*/

                    blockposition2 = blockposition2.up();

                    for (l1 = -1; l1 <= 1; ++l1) {
                        for (j2 = -1; j2 <= 1; ++j2) {
                            this.c(world, blockposition2.a(l1, 0, j2));
                        }
                    }

                    this.c(world, blockposition2.east(2));
                    this.c(world, blockposition2.west(2));
                    this.c(world, blockposition2.south(2));
                    this.c(world, blockposition2.north(2));
                    k = blockposition.getX();
                    j1 = blockposition.getZ();
                    EnumDirection enumdirection1 = EnumDirection.EnumDirectionLimit.HORIZONTAL.a(random);

                    if (enumdirection1 != enumdirection) {
                        l1 = i1 - random.nextInt(2) - 1;
                        j2 = 1 + random.nextInt(3);
                        k1 = 0;

                        int k2;

                        for (int l2 = l1; l2 < i && j2 > 0; --j2) {
                            if (l2 >= 1) {
                                k2 = blockposition.getY() + l2;
                                k += enumdirection1.getAdjacentX();
                                j1 += enumdirection1.getAdjacentZ();
                                BlockPosition blockposition3 = new BlockPosition(k, k2, j1);
                                Material material1 = world.getType(blockposition3).getBlock().getMaterial();

                                if (material1 == Material.AIR || material1 == Material.LEAVES) {
                                    this.b(world, blockposition3);
                                    k1 = k2;
                                }
                            }

                            ++l2;
                        }

                        if (k1 > 0) {
                            //BlockPosition blockposition4 = new BlockPosition(k, k1, j1);
                            blockposition4 = new BlockPosition(k, k1, j1);

                            int i3;

                            IntStream.range(-2, 3).forEach( kk2 -> {
                                IntStream.range(-2, 3).forEach( ii3 -> {
                                    if (Math.abs(kk2) != 2 || Math.abs(ii3) != 2) {
                                        this.c(world, blockposition4.a(kk2, 0, ii3));
                                    }
                                });
                            });
                            /*
                            for (k2 = -2; k2 <= 2; ++k2) {
                                for (i3 = -2; i3 <= 2; ++i3) {
                                    if (Math.abs(k2) != 2 || Math.abs(i3) != 2) {
                                        this.c(world, blockposition4.a(k2, 0, i3));
                                    }
                                }
                            }*/

                            blockposition4 = blockposition4.up();

                            for (k2 = -1; k2 <= 1; ++k2) {
                                for (i3 = -1; i3 <= 1; ++i3) {
                                    this.c(world, blockposition4.a(k2, 0, i3));
                                }
                            }
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    private void b(World world, BlockPosition blockposition) {
        this.a(world, blockposition, WorldGenAcaciaTree.a);
    }

    private void c(World world, BlockPosition blockposition) {
        Material material = world.getType(blockposition).getBlock().getMaterial();

        if (material == Material.AIR || material == Material.LEAVES) {
            this.a(world, blockposition, WorldGenAcaciaTree.b);
        }

    }
}
