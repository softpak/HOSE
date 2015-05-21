package net.minecraft.server;

import java.util.Random;

public class WorldGenHugeMushroom extends WorldGenerator {

    private Block a;

    public WorldGenHugeMushroom(Block block) {
        super(true);
        this.a = block;
    }

    public WorldGenHugeMushroom() {
        super(false);
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        if (this.a == null) {
            this.a = random.nextBoolean() ? Blocks.BROWN_MUSHROOM_BLOCK : Blocks.RED_MUSHROOM_BLOCK;
        }

        int i = random.nextInt(3) + 4;
        boolean flag = true;

        if (blockposition.getY() >= 1 && blockposition.getY() + i + 1 < 256) {
            int j;
            int k;

            for (int l = blockposition.getY(); l <= blockposition.getY() + 1 + i; ++l) {
                byte b0 = 3;

                if (l <= blockposition.getY() + 3) {
                    b0 = 0;
                }

                BlockPosition.MutableBlockPosition blockposition_mutableblockposition = new BlockPosition.MutableBlockPosition();

                for (j = blockposition.getX() - b0; j <= blockposition.getX() + b0 && flag; ++j) {
                    for (k = blockposition.getZ() - b0; k <= blockposition.getZ() + b0 && flag; ++k) {
                        if (l >= 0 && l < 256) {
                            Block block = world.getType(blockposition_mutableblockposition.c(j, l, k)).getBlock();

                            if (block.getMaterial() != Material.AIR && block.getMaterial() != Material.LEAVES) {
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
                Block block1 = world.getType(blockposition.down()).getBlock();

                if (block1 != Blocks.DIRT && block1 != Blocks.GRASS && block1 != Blocks.MYCELIUM) {
                    return false;
                } else {
                    int i1 = blockposition.getY() + i;

                    if (this.a == Blocks.RED_MUSHROOM_BLOCK) {
                        i1 = blockposition.getY() + i - 3;
                    }

                    int j1;

                    for (j1 = i1; j1 <= blockposition.getY() + i; ++j1) {
                        j = 1;
                        if (j1 < blockposition.getY() + i) {
                            ++j;
                        }

                        if (this.a == Blocks.BROWN_MUSHROOM_BLOCK) {
                            j = 3;
                        }

                        k = blockposition.getX() - j;
                        int k1 = blockposition.getX() + j;
                        int l1 = blockposition.getZ() - j;
                        int i2 = blockposition.getZ() + j;

                        for (int j2 = k; j2 <= k1; ++j2) {
                            for (int k2 = l1; k2 <= i2; ++k2) {
                                int l2 = 5;

                                if (j2 == k) {
                                    --l2;
                                } else if (j2 == k1) {
                                    ++l2;
                                }

                                if (k2 == l1) {
                                    l2 -= 3;
                                } else if (k2 == i2) {
                                    l2 += 3;
                                }

                                BlockHugeMushroom.EnumHugeMushroomVariant blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.a(l2);

                                if (this.a == Blocks.BROWN_MUSHROOM_BLOCK || j1 < blockposition.getY() + i) {
                                    if ((j2 == k || j2 == k1) && (k2 == l1 || k2 == i2)) {
                                        continue;
                                    }

                                    if (j2 == blockposition.getX() - (j - 1) && k2 == l1) {
                                        blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.NORTH_WEST;
                                    }

                                    if (j2 == k && k2 == blockposition.getZ() - (j - 1)) {
                                        blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.NORTH_WEST;
                                    }

                                    if (j2 == blockposition.getX() + (j - 1) && k2 == l1) {
                                        blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.NORTH_EAST;
                                    }

                                    if (j2 == k1 && k2 == blockposition.getZ() - (j - 1)) {
                                        blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.NORTH_EAST;
                                    }

                                    if (j2 == blockposition.getX() - (j - 1) && k2 == i2) {
                                        blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.SOUTH_WEST;
                                    }

                                    if (j2 == k && k2 == blockposition.getZ() + (j - 1)) {
                                        blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.SOUTH_WEST;
                                    }

                                    if (j2 == blockposition.getX() + (j - 1) && k2 == i2) {
                                        blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.SOUTH_EAST;
                                    }

                                    if (j2 == k1 && k2 == blockposition.getZ() + (j - 1)) {
                                        blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.SOUTH_EAST;
                                    }
                                }

                                if (blockhugemushroom_enumhugemushroomvariant == BlockHugeMushroom.EnumHugeMushroomVariant.CENTER && j1 < blockposition.getY() + i) {
                                    blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.ALL_INSIDE;
                                }

                                if (blockposition.getY() >= blockposition.getY() + i - 1 || blockhugemushroom_enumhugemushroomvariant != BlockHugeMushroom.EnumHugeMushroomVariant.ALL_INSIDE) {
                                    BlockPosition blockposition1 = new BlockPosition(j2, j1, k2);

                                    if (!world.getType(blockposition1).getBlock().o()) {
                                        this.a(world, blockposition1, this.a.getBlockData().set(BlockHugeMushroom.VARIANT, blockhugemushroom_enumhugemushroomvariant));
                                    }
                                }
                            }
                        }
                    }

                    for (j1 = 0; j1 < i; ++j1) {
                        Block block2 = world.getType(blockposition.up(j1)).getBlock();

                        if (!block2.o()) {
                            this.a(world, blockposition.up(j1), this.a.getBlockData().set(BlockHugeMushroom.VARIANT, BlockHugeMushroom.EnumHugeMushroomVariant.STEM));
                        }
                    }

                    return true;
                }
            }
        } else {
            return false;
        }
    }
}
