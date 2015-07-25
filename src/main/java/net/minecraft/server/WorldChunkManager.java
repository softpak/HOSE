package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class WorldChunkManager {

    private GenLayer b;
    private GenLayer c;
    private BiomeCache d;
    private List<BiomeBase> e;
    private String f;

    protected WorldChunkManager() {
        this.d = new BiomeCache(this);
        this.f = "";
        this.e = Lists.newArrayList();
        this.e.add(BiomeBase.FOREST);
        this.e.add(BiomeBase.PLAINS);
        this.e.add(BiomeBase.TAIGA);
        this.e.add(BiomeBase.TAIGA_HILLS);
        this.e.add(BiomeBase.FOREST_HILLS);
        this.e.add(BiomeBase.JUNGLE);
        this.e.add(BiomeBase.JUNGLE_HILLS);
    }

    public WorldChunkManager(long i, WorldType worldtype, String s) {
        this();
        this.f = s;
        GenLayer[] agenlayer = GenLayer.a(i, worldtype, s);

        this.b = agenlayer[0];
        this.c = agenlayer[1];
    }

    public WorldChunkManager(World world) {
        this(world.getSeed(), world.getWorldData().getType(), world.getWorldData().getGeneratorOptions());
    }

    public List<BiomeBase> a() {
        return this.e;
    }

    public BiomeBase getBiome(BlockPosition blockposition) {
        return this.getBiome(blockposition, (BiomeBase) null);
    }

    public BiomeBase getBiome(BlockPosition blockposition, BiomeBase biomebase) {
        return this.d.a(blockposition.getX(), blockposition.getZ(), biomebase);
    }

    public float[] getWetness(float[] afloat, int i, int j, int k, int l) {
        IntCache.a();
        if (afloat == null || afloat.length < k * l) {
            afloat = new float[k * l];
        }

        int[] aint = this.c.a(i, j, k, l);

        for (int i1 = 0; i1 < k * l; ++i1) {
            try {
                float f = (float) BiomeBase.getBiome(aint[i1], BiomeBase.ad).h() / 65536.0F;

                if (f > 1.0F) {
                    f = 1.0F;
                }

                afloat[i1] = f;
            } catch (Throwable throwable) {
                CrashReport crashreport = CrashReport.a(throwable, "Invalid Biome id");
                CrashReportSystemDetails crashreportsystemdetails = crashreport.a("DownfallBlock");

                crashreportsystemdetails.a("biome id", (Object) Integer.valueOf(i1));
                crashreportsystemdetails.a("downfalls[] size", (Object) Integer.valueOf(afloat.length));
                crashreportsystemdetails.a("x", (Object) Integer.valueOf(i));
                crashreportsystemdetails.a("z", (Object) Integer.valueOf(j));
                crashreportsystemdetails.a("w", (Object) Integer.valueOf(k));
                crashreportsystemdetails.a("h", (Object) Integer.valueOf(l));
                throw new ReportedException(crashreport);
            }
        }

        return afloat;
    }

    public BiomeBase[] getBiomes(BiomeBase[] abiomebase, int i, int j, int k, int l) {
        IntCache.a();
        if (abiomebase == null || abiomebase.length < k * l) {
            abiomebase = new BiomeBase[k * l];
        }

        int[] aint = this.b.a(i, j, k, l);

        try {
            for (int i1 = 0; i1 < k * l; ++i1) {
                abiomebase[i1] = BiomeBase.getBiome(aint[i1], BiomeBase.ad);
            }

            return abiomebase;
        } catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.a(throwable, "Invalid Biome id");
            CrashReportSystemDetails crashreportsystemdetails = crashreport.a("RawBiomeBlock");

            crashreportsystemdetails.a("biomes[] size", (Object) Integer.valueOf(abiomebase.length));
            crashreportsystemdetails.a("x", (Object) Integer.valueOf(i));
            crashreportsystemdetails.a("z", (Object) Integer.valueOf(j));
            crashreportsystemdetails.a("w", (Object) Integer.valueOf(k));
            crashreportsystemdetails.a("h", (Object) Integer.valueOf(l));
            throw new ReportedException(crashreport);
        }
    }

    public BiomeBase[] getBiomeBlock(BiomeBase[] abiomebase, int i, int j, int k, int l) {
        return this.a(abiomebase, i, j, k, l, true);
    }

    public BiomeBase[] a(BiomeBase[] abiomebase, int i, int j, int k, int l, boolean flag) {
        IntCache.a();
        if (abiomebase == null || abiomebase.length < k * l) {
            abiomebase = new BiomeBase[k * l];
        }

        if (flag && k == 16 && l == 16 && (i & 15) == 0 && (j & 15) == 0) {
            BiomeBase[] abiomebase1 = this.d.c(i, j);

            System.arraycopy(abiomebase1, 0, abiomebase, 0, k * l);
            return abiomebase;
        } else {
            int[] aint = this.c.a(i, j, k, l);

            for (int i1 = 0; i1 < k * l; ++i1) {
                abiomebase[i1] = BiomeBase.getBiome(aint[i1], BiomeBase.ad);
            }

            return abiomebase;
        }
    }

    public boolean a(int i, int j, int k, List<BiomeBase> list) {
        IntCache.a();
        int l = i - k >> 2;
        int i1 = j - k >> 2;
        int j1 = i + k >> 2;
        int k1 = j + k >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.b.a(l, i1, l1, i2);

        try {
            for (int j2 = 0; j2 < l1 * i2; ++j2) {
                BiomeBase biomebase = BiomeBase.getBiome(aint[j2]);

                if (!list.contains(biomebase)) {
                    return false;
                }
            }

            return true;
        } catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.a(throwable, "Invalid Biome id");
            CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Layer");

            crashreportsystemdetails.a("Layer", (Object) this.b.toString());
            crashreportsystemdetails.a("x", (Object) Integer.valueOf(i));
            crashreportsystemdetails.a("z", (Object) Integer.valueOf(j));
            crashreportsystemdetails.a("radius", (Object) Integer.valueOf(k));
            crashreportsystemdetails.a("allowed", (Object) list);
            throw new ReportedException(crashreport);
        }
    }

    public BlockPosition a(int i, int j, int k, List<BiomeBase> list, Random random) {
        IntCache.a();
        int l = i - k >> 2;
        int i1 = j - k >> 2;
        int j1 = i + k >> 2;
        int k1 = j + k >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.b.a(l, i1, l1, i2);
        BlockPosition blockposition = null;
        int j2 = 0;

        for (int k2 = 0; k2 < l1 * i2; ++k2) {
            int l2 = l + k2 % l1 << 2;
            int i3 = i1 + k2 / l1 << 2;
            BiomeBase biomebase = BiomeBase.getBiome(aint[k2]);

            if (list.contains(biomebase) && (blockposition == null || random.nextInt(j2 + 1) == 0)) {
                blockposition = new BlockPosition(l2, 0, i3);
                ++j2;
            }
        }

        return blockposition;
    }

    public void b() {
        this.d.a();
    }
}
