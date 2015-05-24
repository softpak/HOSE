package net.minecraft.server;

import java.util.Random;

public class BiomeForest extends BiomeBase {

    private int aG;
    protected static final WorldGenForest aD = new WorldGenForest(false, true);
    protected static final WorldGenForest aE = new WorldGenForest(false, false);
    protected static final WorldGenForestTree aF = new WorldGenForestTree(false);

    public BiomeForest(int i, int j) {
        super(i);
        this.aG = j;
        this.as.A = 10;
        this.as.C = 2;
        if (this.aG == 1) {
            this.as.A = 6;
            this.as.B = 100;
            this.as.C = 1;
        }

        this.a(5159473);
        this.a(0.7F, 0.8F);
        if (this.aG == 2) {
            this.aj = 353825;
            this.ai = 3175492;
            this.a(0.6F, 0.6F);
        }

        if (this.aG == 0) {
            this.au.add(new BiomeBase.BiomeMeta(EntityWolf.class, 5, 4, 4));
        }

        if (this.aG == 3) {
            this.as.A = -999;
        }

    }

    protected BiomeBase a(int i, boolean flag) {
        if (this.aG == 2) {
            this.aj = 353825;
            this.ai = i;
            if (flag) {
                this.aj = (this.aj & 16711422) >> 1;
            }

            return this;
        } else {
            return super.a(i, flag);
        }
    }

    public WorldGenTreeAbstract a(Random random) {
        return (WorldGenTreeAbstract) (this.aG == 3 && random.nextInt(3) > 0 ? BiomeForest.aF : (this.aG != 2 && random.nextInt(5) != 0 ? this.aA : BiomeForest.aE));
    }

    public BlockFlowers.EnumFlowerVarient a(Random random, BlockPosition blockposition) {
        if (this.aG == 1) {
            double d0 = MathHelper.a((1.0D + BiomeForest.af.a((double) blockposition.getX() / 48.0D, (double) blockposition.getZ() / 48.0D)) / 2.0D, 0.0D, 0.9999D);
            BlockFlowers.EnumFlowerVarient blockflowers_enumflowervarient = BlockFlowers.EnumFlowerVarient.values()[(int) (d0 * (double) BlockFlowers.EnumFlowerVarient.values().length)];

            return blockflowers_enumflowervarient == BlockFlowers.EnumFlowerVarient.BLUE_ORCHID ? BlockFlowers.EnumFlowerVarient.POPPY : blockflowers_enumflowervarient;
        } else {
            return super.a(random, blockposition);
        }
    }

    public void a(World world, Random random, BlockPosition blockposition) {
        int i;
        int j;
        int k;
        int l;

        if (this.aG == 3) {
            for (i = 0; i < 4; ++i) {
                for (j = 0; j < 4; ++j) {
                    k = i * 4 + 1 + 8 + random.nextInt(3);
                    l = j * 4 + 1 + 8 + random.nextInt(3);
                    BlockPosition blockposition1 = world.getHighestBlockYAt(blockposition.a(k, 0, l));

                    if (random.nextInt(20) == 0) {
                        WorldGenHugeMushroom worldgenhugemushroom = new WorldGenHugeMushroom();

                        worldgenhugemushroom.generate(world, random, blockposition1);
                    } else {
                        WorldGenTreeAbstract worldgentreeabstract = this.a(random);

                        worldgentreeabstract.e();
                        if (worldgentreeabstract.generate(world, random, blockposition1)) {
                            worldgentreeabstract.a(world, random, blockposition1);
                        }
                    }
                }
            }
        }

        i = random.nextInt(5) - 3;
        if (this.aG == 1) {
            i += 2;
        }

        j = 0;

        while (j < i) {
            k = random.nextInt(3);
            if (k == 0) {
                BiomeForest.ag.a(BlockTallPlant.EnumTallFlowerVariants.SYRINGA);
            } else if (k == 1) {
                BiomeForest.ag.a(BlockTallPlant.EnumTallFlowerVariants.ROSE);
            } else if (k == 2) {
                BiomeForest.ag.a(BlockTallPlant.EnumTallFlowerVariants.PAEONIA);
            }

            l = 0;

            while (true) {
                if (l < 5) {
                    int i1 = random.nextInt(16) + 8;
                    int j1 = random.nextInt(16) + 8;
                    int k1 = random.nextInt(world.getHighestBlockYAt(blockposition.a(i1, 0, j1)).getY() + 32);

                    if (!BiomeForest.ag.generate(world, random, new BlockPosition(blockposition.getX() + i1, k1, blockposition.getZ() + j1))) {
                        ++l;
                        continue;
                    }
                }

                ++j;
                break;
            }
        }

        super.a(world, random, blockposition);
    }

    protected BiomeBase d(final int i) {
        if (this.id == BiomeBase.FOREST.id) {
            BiomeForest biomeforest = new BiomeForest(i, 1);

            biomeforest.a(new BiomeBase.BiomeTemperature(this.an, this.ao + 0.2F));
            biomeforest.a("Flower Forest");
            biomeforest.a(6976549, true);
            biomeforest.a(8233509);
            return biomeforest;
        } else {
            return this.id != BiomeBase.BIRCH_FOREST.id && this.id != BiomeBase.BIRCH_FOREST_HILLS.id ? new BiomeBaseSub(i, this) {
                public void a(World world, Random random, BlockPosition blockposition) {
                    this.aE.a(world, random, blockposition);
                }
            } : new BiomeBaseSub(i, this) {
                public WorldGenTreeAbstract a(Random random) {
                    return random.nextBoolean() ? BiomeForest.aD : BiomeForest.aE;
                }
            };
        }
    }
}
