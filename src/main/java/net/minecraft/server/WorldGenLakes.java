package net.minecraft.server;

import java.util.Random;

public class WorldGenLakes extends WorldGenerator {

    private Block a;

    public WorldGenLakes(Block block) {
        this.a = block;
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        for (blockposition = blockposition.a(-8, 0, -8); blockposition.getY() > 5 && world.isEmpty(blockposition); blockposition = blockposition.down()) {
            ;
        }

        if (blockposition.getY() <= 4) {
            return false;
        } else {
            blockposition = blockposition.down(4);
            boolean[] aboolean = new boolean[2048];
            int i = random.nextInt(4) + 4;

            int j;

            for (j = 0; j < i; ++j) {
                double d0 = random.nextDouble() * 6.0D + 3.0D;
                double d1 = random.nextDouble() * 4.0D + 2.0D;
                double d2 = random.nextDouble() * 6.0D + 3.0D;
                double d3 = random.nextDouble() * (16.0D - d0 - 2.0D) + 1.0D + d0 / 2.0D;
                double d4 = random.nextDouble() * (8.0D - d1 - 4.0D) + 2.0D + d1 / 2.0D;
                double d5 = random.nextDouble() * (16.0D - d2 - 2.0D) + 1.0D + d2 / 2.0D;

                for (int k = 1; k < 15; ++k) {
                    for (int l = 1; l < 15; ++l) {
                        for (int i1 = 1; i1 < 7; ++i1) {
                            double d6 = ((double) k - d3) / (d0 / 2.0D);
                            double d7 = ((double) i1 - d4) / (d1 / 2.0D);
                            double d8 = ((double) l - d5) / (d2 / 2.0D);
                            double d9 = d6 * d6 + d7 * d7 + d8 * d8;

                            if (d9 < 1.0D) {
                                aboolean[(k * 16 + l) * 8 + i1] = true;
                            }
                        }
                    }
                }
            }

            int j1;
            int k1;
            boolean flag;

            for (j = 0; j < 16; ++j) {
                for (k1 = 0; k1 < 16; ++k1) {
                    for (j1 = 0; j1 < 8; ++j1) {
                        flag = !aboolean[(j * 16 + k1) * 8 + j1] && (j < 15 && aboolean[((j + 1) * 16 + k1) * 8 + j1] || j > 0 && aboolean[((j - 1) * 16 + k1) * 8 + j1] || k1 < 15 && aboolean[(j * 16 + k1 + 1) * 8 + j1] || k1 > 0 && aboolean[(j * 16 + (k1 - 1)) * 8 + j1] || j1 < 7 && aboolean[(j * 16 + k1) * 8 + j1 + 1] || j1 > 0 && aboolean[(j * 16 + k1) * 8 + (j1 - 1)]);
                        if (flag) {
                            Material material = world.getType(blockposition.a(j, j1, k1)).getBlock().getMaterial();

                            if (j1 >= 4 && material.isLiquid()) {
                                return false;
                            }

                            if (j1 < 4 && !material.isBuildable() && world.getType(blockposition.a(j, j1, k1)).getBlock() != this.a) {
                                return false;
                            }
                        }
                    }
                }
            }

            for (j = 0; j < 16; ++j) {
                for (k1 = 0; k1 < 16; ++k1) {
                    for (j1 = 0; j1 < 8; ++j1) {
                        if (aboolean[(j * 16 + k1) * 8 + j1]) {
                            world.setTypeAndData(blockposition.a(j, j1, k1), j1 >= 4 ? Blocks.AIR.getBlockData() : this.a.getBlockData(), 2);
                        }
                    }
                }
            }

            for (j = 0; j < 16; ++j) {
                for (k1 = 0; k1 < 16; ++k1) {
                    for (j1 = 4; j1 < 8; ++j1) {
                        if (aboolean[(j * 16 + k1) * 8 + j1]) {
                            BlockPosition blockposition1 = blockposition.a(j, j1 - 1, k1);

                            if (world.getType(blockposition1).getBlock() == Blocks.DIRT && world.b(EnumSkyBlock.SKY, blockposition.a(j, j1, k1)) > 0) {
                                BiomeBase biomebase = world.getBiome(blockposition1);

                                if (biomebase.ak.getBlock() == Blocks.MYCELIUM) {
                                    world.setTypeAndData(blockposition1, Blocks.MYCELIUM.getBlockData(), 2);
                                } else {
                                    world.setTypeAndData(blockposition1, Blocks.GRASS.getBlockData(), 2);
                                }
                            }
                        }
                    }
                }
            }

            if (this.a.getMaterial() == Material.LAVA) {
                for (j = 0; j < 16; ++j) {
                    for (k1 = 0; k1 < 16; ++k1) {
                        for (j1 = 0; j1 < 8; ++j1) {
                            flag = !aboolean[(j * 16 + k1) * 8 + j1] && (j < 15 && aboolean[((j + 1) * 16 + k1) * 8 + j1] || j > 0 && aboolean[((j - 1) * 16 + k1) * 8 + j1] || k1 < 15 && aboolean[(j * 16 + k1 + 1) * 8 + j1] || k1 > 0 && aboolean[(j * 16 + (k1 - 1)) * 8 + j1] || j1 < 7 && aboolean[(j * 16 + k1) * 8 + j1 + 1] || j1 > 0 && aboolean[(j * 16 + k1) * 8 + (j1 - 1)]);
                            if (flag && (j1 < 4 || random.nextInt(2) != 0) && world.getType(blockposition.a(j, j1, k1)).getBlock().getMaterial().isBuildable()) {
                                world.setTypeAndData(blockposition.a(j, j1, k1), Blocks.STONE.getBlockData(), 2);
                            }
                        }
                    }
                }
            }

            if (this.a.getMaterial() == Material.WATER) {
                for (j = 0; j < 16; ++j) {
                    for (k1 = 0; k1 < 16; ++k1) {
                        byte b0 = 4;

                        if (world.v(blockposition.a(j, b0, k1))) {
                            world.setTypeAndData(blockposition.a(j, b0, k1), Blocks.ICE.getBlockData(), 2);
                        }
                    }
                }
            }

            return true;
        }
    }
}
