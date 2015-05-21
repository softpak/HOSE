package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class WorldGenTrees extends WorldGenTreeAbstract {

    private static final IBlockData a = Blocks.LOG.getBlockData().set(BlockLog1.VARIANT, BlockWood.EnumLogVariant.OAK);
    private static final IBlockData b = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.OAK).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    private final int c;
    private final boolean d;
    private final IBlockData e;
    private final IBlockData f;

    public WorldGenTrees(boolean flag) {
        this(flag, 4, WorldGenTrees.a, WorldGenTrees.b, false);
    }

    public WorldGenTrees(boolean flag, int i, IBlockData iblockdata, IBlockData iblockdata1, boolean flag1) {
        super(flag);
        this.c = i;
        this.e = iblockdata;
        this.f = iblockdata1;
        this.d = flag1;
    }
    
    int j;
    public boolean generate(World world, Random random, BlockPosition blockposition) {
        int i = random.nextInt(3) + this.c;
        boolean flag = true;

        if (blockposition.getY() >= 1 && blockposition.getY() + i + 1 <= 256) {
            byte b0;
            //int j;
            int k;

            for (int l = blockposition.getY(); l <= blockposition.getY() + 1 + i; ++l) {
                b0 = 1;
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

                if ((block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.FARMLAND) && blockposition.getY() < 256 - i - 1) {
                    this.a(world, blockposition.down());
                    b0 = 3;
                    byte b1 = 0;

                    int i1;
                    int j1;
                    int k1;
                    BlockPosition blockposition1;

                    for (j = blockposition.getY() - b0 + i; j <= blockposition.getY() + i; ++j) {
                        k = j - (blockposition.getY() + i);
                        i1 = b1 + 1 - k / 2;

                        for (int l1 = blockposition.getX() - i1; l1 <= blockposition.getX() + i1; ++l1) {
                            j1 = l1 - blockposition.getX();

                            for (k1 = blockposition.getZ() - i1; k1 <= blockposition.getZ() + i1; ++k1) {
                                int i2 = k1 - blockposition.getZ();

                                if (Math.abs(j1) != i1 || Math.abs(i2) != i1 || random.nextInt(2) != 0 && k != 0) {
                                    blockposition1 = new BlockPosition(l1, j, k1);
                                    Block block1 = world.getType(blockposition1).getBlock();

                                    if (block1.getMaterial() == Material.AIR || block1.getMaterial() == Material.LEAVES || block1.getMaterial() == Material.REPLACEABLE_PLANT) {
                                        this.a(world, blockposition1, this.f);
                                    }
                                }
                            }
                        }
                    }

                    for (j = 0; j < i; ++j) {
                        Block block2 = world.getType(blockposition.up(j)).getBlock();

                        if (block2.getMaterial() == Material.AIR || block2.getMaterial() == Material.LEAVES || block2.getMaterial() == Material.REPLACEABLE_PLANT) {
                            this.a(world, blockposition.up(j), this.e);
                            if (this.d && j > 0) {
                                if (random.nextInt(3) > 0 && world.isEmpty(blockposition.a(-1, j, 0))) {
                                    this.a(world, blockposition.a(-1, j, 0), BlockVine.EAST);
                                }

                                if (random.nextInt(3) > 0 && world.isEmpty(blockposition.a(1, j, 0))) {
                                    this.a(world, blockposition.a(1, j, 0), BlockVine.WEST);
                                }

                                if (random.nextInt(3) > 0 && world.isEmpty(blockposition.a(0, j, -1))) {
                                    this.a(world, blockposition.a(0, j, -1), BlockVine.SOUTH);
                                }

                                if (random.nextInt(3) > 0 && world.isEmpty(blockposition.a(0, j, 1))) {
                                    this.a(world, blockposition.a(0, j, 1), BlockVine.NORTH);
                                }
                            }
                        }
                    }

                    if (this.d) {
                        for (j = blockposition.getY() - 3 + i; j <= blockposition.getY() + i; ++j) {
                            k = j - (blockposition.getY() + i);
                            i1 = 2 - k / 2;
                            BlockPosition.MutableBlockPosition blockposition_mutableblockposition1 = new BlockPosition.MutableBlockPosition();

                            for (j1 = blockposition.getX() - i1; j1 <= blockposition.getX() + i1; ++j1) {
                                for (k1 = blockposition.getZ() - i1; k1 <= blockposition.getZ() + i1; ++k1) {
                                    blockposition_mutableblockposition1.c(j1, j, k1);
                                    if (world.getType(blockposition_mutableblockposition1).getBlock().getMaterial() == Material.LEAVES) {
                                        BlockPosition blockposition2 = blockposition_mutableblockposition1.west();

                                        blockposition1 = blockposition_mutableblockposition1.east();
                                        BlockPosition blockposition3 = blockposition_mutableblockposition1.north();
                                        BlockPosition blockposition4 = blockposition_mutableblockposition1.south();

                                        if (random.nextInt(4) == 0 && world.getType(blockposition2).getBlock().getMaterial() == Material.AIR) {
                                            this.b(world, blockposition2, BlockVine.EAST);
                                        }

                                        if (random.nextInt(4) == 0 && world.getType(blockposition1).getBlock().getMaterial() == Material.AIR) {
                                            this.b(world, blockposition1, BlockVine.WEST);
                                        }

                                        if (random.nextInt(4) == 0 && world.getType(blockposition3).getBlock().getMaterial() == Material.AIR) {
                                            this.b(world, blockposition3, BlockVine.SOUTH);
                                        }

                                        if (random.nextInt(4) == 0 && world.getType(blockposition4).getBlock().getMaterial() == Material.AIR) {
                                            this.b(world, blockposition4, BlockVine.NORTH);
                                        }
                                    }
                                }
                            }
                        }

                        if (random.nextInt(5) == 0 && i > 5) {
                            for (j = 0; j < 2; ++j) {
                                Iterator iterator = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

                                while (iterator.hasNext()) {
                                    EnumDirection enumdirection = (EnumDirection) iterator.next();

                                    if (random.nextInt(4 - j) == 0) {
                                        EnumDirection enumdirection1 = enumdirection.opposite();

                                        this.a(world, random.nextInt(3), blockposition.a(enumdirection1.getAdjacentX(), i - 5 + j, enumdirection1.getAdjacentZ()), enumdirection);
                                    }
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

    private void a(World world, int i, BlockPosition blockposition, EnumDirection enumdirection) {
        this.a(world, blockposition, Blocks.COCOA.getBlockData().set(BlockCocoa.AGE, Integer.valueOf(i)).set(BlockCocoa.FACING, enumdirection));
    }

    private void a(World world, BlockPosition blockposition, BlockStateBoolean blockstateboolean) {
        this.a(world, blockposition, Blocks.VINE.getBlockData().set(blockstateboolean, Boolean.valueOf(true)));
    }

    private void b(World world, BlockPosition blockposition, BlockStateBoolean blockstateboolean) {
        this.a(world, blockposition, blockstateboolean);
        int i = 4;

        for (blockposition = blockposition.down(); world.getType(blockposition).getBlock().getMaterial() == Material.AIR && i > 0; --i) {
            this.a(world, blockposition, blockstateboolean);
            blockposition = blockposition.down();
        }

    }
}
