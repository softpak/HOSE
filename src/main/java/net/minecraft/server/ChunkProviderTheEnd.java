package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class ChunkProviderTheEnd implements IChunkProvider {

    private Random h;
    private NoiseGeneratorOctaves i;
    private NoiseGeneratorOctaves j;
    private NoiseGeneratorOctaves k;
    public NoiseGeneratorOctaves a;
    public NoiseGeneratorOctaves b;
    private World l;
    private double[] m;
    private BiomeBase[] n;
    double[] c;
    double[] d;
    double[] e;
    double[] f;
    double[] g;

    public ChunkProviderTheEnd(World world, long i) {
        this.l = world;
        this.h = new Random(i);
        this.i = new NoiseGeneratorOctaves(this.h, 16);
        this.j = new NoiseGeneratorOctaves(this.h, 16);
        this.k = new NoiseGeneratorOctaves(this.h, 8);
        this.a = new NoiseGeneratorOctaves(this.h, 10);
        this.b = new NoiseGeneratorOctaves(this.h, 16);
    }

    public void a(int i, int j, ChunkSnapshot chunksnapshot) {
        byte b0 = 2;
        int k = b0 + 1;
        byte b1 = 33;
        int l = b0 + 1;

        this.m = this.a(this.m, i * b0, 0, j * b0, k, b1, l);

        for (int i1 = 0; i1 < b0; ++i1) {
            for (int j1 = 0; j1 < b0; ++j1) {
                for (int k1 = 0; k1 < 32; ++k1) {
                    double d0 = 0.25D;
                    double d1 = this.m[((i1 + 0) * l + j1 + 0) * b1 + k1 + 0];
                    double d2 = this.m[((i1 + 0) * l + j1 + 1) * b1 + k1 + 0];
                    double d3 = this.m[((i1 + 1) * l + j1 + 0) * b1 + k1 + 0];
                    double d4 = this.m[((i1 + 1) * l + j1 + 1) * b1 + k1 + 0];
                    double d5 = (this.m[((i1 + 0) * l + j1 + 0) * b1 + k1 + 1] - d1) * d0;
                    double d6 = (this.m[((i1 + 0) * l + j1 + 1) * b1 + k1 + 1] - d2) * d0;
                    double d7 = (this.m[((i1 + 1) * l + j1 + 0) * b1 + k1 + 1] - d3) * d0;
                    double d8 = (this.m[((i1 + 1) * l + j1 + 1) * b1 + k1 + 1] - d4) * d0;

                    for (int l1 = 0; l1 < 4; ++l1) {
                        double d9 = 0.125D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i2 = 0; i2 < 8; ++i2) {
                            double d14 = 0.125D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;

                            for (int j2 = 0; j2 < 8; ++j2) {
                                IBlockData iblockdata = null;

                                if (d15 > 0.0D) {
                                    iblockdata = Blocks.END_STONE.getBlockData();
                                }

                                int k2 = i2 + i1 * 8;
                                int l2 = l1 + k1 * 4;
                                int i3 = j2 + j1 * 8;

                                chunksnapshot.a(k2, l2, i3, iblockdata);
                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }

    }

    public void a(ChunkSnapshot chunksnapshot) {
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                byte b0 = 1;
                int k = -1;
                IBlockData iblockdata = Blocks.END_STONE.getBlockData();
                IBlockData iblockdata1 = Blocks.END_STONE.getBlockData();

                for (int l = 127; l >= 0; --l) {
                    IBlockData iblockdata2 = chunksnapshot.a(i, l, j);

                    if (iblockdata2.getBlock().getMaterial() == Material.AIR) {
                        k = -1;
                    } else if (iblockdata2.getBlock() == Blocks.STONE) {
                        if (k == -1) {
                            if (b0 <= 0) {
                                iblockdata = Blocks.AIR.getBlockData();
                                iblockdata1 = Blocks.END_STONE.getBlockData();
                            }

                            k = b0;
                            if (l >= 0) {
                                chunksnapshot.a(i, l, j, iblockdata);
                            } else {
                                chunksnapshot.a(i, l, j, iblockdata1);
                            }
                        } else if (k > 0) {
                            --k;
                            chunksnapshot.a(i, l, j, iblockdata1);
                        }
                    }
                }
            }
        }

    }

    public Chunk getOrCreateChunk(int i, int j) {
        this.h.setSeed((long) i * 341873128712L + (long) j * 132897987541L);
        ChunkSnapshot chunksnapshot = new ChunkSnapshot();

        this.n = this.l.getWorldChunkManager().getBiomeBlock(this.n, i * 16, j * 16, 16, 16);
        this.a(i, j, chunksnapshot);
        this.a(chunksnapshot);
        Chunk chunk = new Chunk(this.l, chunksnapshot, i, j);
        byte[] abyte = chunk.getBiomeIndex();

        for (int k = 0; k < abyte.length; ++k) {
            abyte[k] = (byte) this.n[k].id;
        }

        chunk.initLighting();
        return chunk;
    }

    private double[] a(double[] adouble, int i, int j, int k, int l, int i1, int j1) {
        if (adouble == null) {
            adouble = new double[l * i1 * j1];
        }

        double d0 = 684.412D;
        double d1 = 684.412D;

        this.f = this.a.a(this.f, i, k, l, j1, 1.121D, 1.121D, 0.5D);
        this.g = this.b.a(this.g, i, k, l, j1, 200.0D, 200.0D, 0.5D);
        d0 *= 2.0D;
        this.c = this.k.a(this.c, i, j, k, l, i1, j1, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
        this.d = this.i.a(this.d, i, j, k, l, i1, j1, d0, d1, d0);
        this.e = this.j.a(this.e, i, j, k, l, i1, j1, d0, d1, d0);
        int k1 = 0;

        for (int l1 = 0; l1 < l; ++l1) {
            for (int i2 = 0; i2 < j1; ++i2) {
                float f = (float) (l1 + i) / 1.0F;
                float f1 = (float) (i2 + k) / 1.0F;
                float f2 = 100.0F - MathHelper.c(f * f + f1 * f1) * 8.0F;

                if (f2 > 80.0F) {
                    f2 = 80.0F;
                }

                if (f2 < -100.0F) {
                    f2 = -100.0F;
                }

                for (int j2 = 0; j2 < i1; ++j2) {
                    double d2 = 0.0D;
                    double d3 = this.d[k1] / 512.0D;
                    double d4 = this.e[k1] / 512.0D;
                    double d5 = (this.c[k1] / 10.0D + 1.0D) / 2.0D;

                    if (d5 < 0.0D) {
                        d2 = d3;
                    } else if (d5 > 1.0D) {
                        d2 = d4;
                    } else {
                        d2 = d3 + (d4 - d3) * d5;
                    }

                    d2 -= 8.0D;
                    d2 += (double) f2;
                    byte b0 = 2;
                    double d6;

                    if (j2 > i1 / 2 - b0) {
                        d6 = (double) ((float) (j2 - (i1 / 2 - b0)) / 64.0F);
                        d6 = MathHelper.a(d6, 0.0D, 1.0D);
                        d2 = d2 * (1.0D - d6) + -3000.0D * d6;
                    }

                    b0 = 8;
                    if (j2 < b0) {
                        d6 = (double) ((float) (b0 - j2) / ((float) b0 - 1.0F));
                        d2 = d2 * (1.0D - d6) + -30.0D * d6;
                    }

                    adouble[k1] = d2;
                    ++k1;
                }
            }
        }

        return adouble;
    }

    public boolean isChunkLoaded(int i, int j) {
        return true;
    }

    public void getChunkAt(IChunkProvider ichunkprovider, int i, int j) {
        BlockFalling.instaFall = true;
        BlockPosition blockposition = new BlockPosition(i * 16, 0, j * 16);

        this.l.getBiome(blockposition.a(16, 0, 16)).a(this.l, this.l.random, blockposition);
        BlockFalling.instaFall = false;
    }

    public boolean a(IChunkProvider ichunkprovider, Chunk chunk, int i, int j) {
        return false;
    }

    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
        return true;
    }

    public void c() {}

    public boolean unloadChunks() {
        return false;
    }

    public boolean canSave() {
        return true;
    }

    public String getName() {
        return "RandomLevelSource";
    }

    public List<BiomeBase.BiomeMeta> getMobsFor(EnumCreatureType enumcreaturetype, BlockPosition blockposition) {
        return this.l.getBiome(blockposition).getMobs(enumcreaturetype);
    }

    public BlockPosition findNearestMapFeature(World world, String s, BlockPosition blockposition) {
        return null;
    }

    public int getLoadedChunks() {
        return 0;
    }

    public void recreateStructures(Chunk chunk, int i, int j) {}

    public Chunk getChunkAt(BlockPosition blockposition) {
        return this.getOrCreateChunk(blockposition.getX() >> 4, blockposition.getZ() >> 4);
    }
}
