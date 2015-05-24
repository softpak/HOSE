package net.minecraft.server;

import java.util.concurrent.Callable;

public abstract class GenLayer {

    private long c;
    protected GenLayer a;
    private long d;
    protected long b;

    public static GenLayer[] a(long i, WorldType worldtype, String s) {
        LayerIsland layerisland = new LayerIsland(1L);
        GenLayerZoomFuzzy genlayerzoomfuzzy = new GenLayerZoomFuzzy(2000L, layerisland);
        GenLayerIsland genlayerisland = new GenLayerIsland(1L, genlayerzoomfuzzy);
        GenLayerZoom genlayerzoom = new GenLayerZoom(2001L, genlayerisland);

        genlayerisland = new GenLayerIsland(2L, genlayerzoom);
        genlayerisland = new GenLayerIsland(50L, genlayerisland);
        genlayerisland = new GenLayerIsland(70L, genlayerisland);
        GenLayerIcePlains genlayericeplains = new GenLayerIcePlains(2L, genlayerisland);
        GenLayerTopSoil genlayertopsoil = new GenLayerTopSoil(2L, genlayericeplains);

        genlayerisland = new GenLayerIsland(3L, genlayertopsoil);
        GenLayerSpecial genlayerspecial = new GenLayerSpecial(2L, genlayerisland, GenLayerSpecial.EnumGenLayerSpecial.COOL_WARM);

        genlayerspecial = new GenLayerSpecial(2L, genlayerspecial, GenLayerSpecial.EnumGenLayerSpecial.HEAT_ICE);
        genlayerspecial = new GenLayerSpecial(3L, genlayerspecial, GenLayerSpecial.EnumGenLayerSpecial.SPECIAL);
        genlayerzoom = new GenLayerZoom(2002L, genlayerspecial);
        genlayerzoom = new GenLayerZoom(2003L, genlayerzoom);
        genlayerisland = new GenLayerIsland(4L, genlayerzoom);
        GenLayerMushroomIsland genlayermushroomisland = new GenLayerMushroomIsland(5L, genlayerisland);
        GenLayerDeepOcean genlayerdeepocean = new GenLayerDeepOcean(4L, genlayermushroomisland);
        GenLayer genlayer = GenLayerZoom.b(1000L, genlayerdeepocean, 0);
        CustomWorldSettingsFinal customworldsettingsfinal = null;
        int j = 4;
        int k = j;

        if (worldtype == WorldType.CUSTOMIZED && s.length() > 0) {
            customworldsettingsfinal = CustomWorldSettingsFinal.CustomWorldSettings.a(s).b();
            j = customworldsettingsfinal.G;
            k = customworldsettingsfinal.H;
        }

        if (worldtype == WorldType.LARGE_BIOMES) {
            j = 6;
        }

        GenLayer genlayer1 = GenLayerZoom.b(1000L, genlayer, 0);
        GenLayerCleaner genlayercleaner = new GenLayerCleaner(100L, genlayer1);
        GenLayerBiome genlayerbiome = new GenLayerBiome(200L, genlayer, worldtype, s);
        GenLayer genlayer2 = GenLayerZoom.b(1000L, genlayerbiome, 2);
        GenLayerDesert genlayerdesert = new GenLayerDesert(1000L, genlayer2);
        GenLayer genlayer3 = GenLayerZoom.b(1000L, genlayercleaner, 2);
        GenLayerRegionHills genlayerregionhills = new GenLayerRegionHills(1000L, genlayerdesert, genlayer3);

        genlayer1 = GenLayerZoom.b(1000L, genlayercleaner, 2);
        genlayer1 = GenLayerZoom.b(1000L, genlayer1, k);
        GenLayerRiver genlayerriver = new GenLayerRiver(1L, genlayer1);
        GenLayerSmooth genlayersmooth = new GenLayerSmooth(1000L, genlayerriver);
        Object object = new GenLayerPlains(1001L, genlayerregionhills);

        for (int l = 0; l < j; ++l) {
            object = new GenLayerZoom((long) (1000 + l), (GenLayer) object);
            if (l == 0) {
                object = new GenLayerIsland(3L, (GenLayer) object);
            }

            if (l == 1 || j == 1) {
                object = new GenLayerMushroomShore(1000L, (GenLayer) object);
            }
        }

        GenLayerSmooth genlayersmooth1 = new GenLayerSmooth(1000L, (GenLayer) object);
        GenLayerRiverMix genlayerrivermix = new GenLayerRiverMix(100L, genlayersmooth1, genlayersmooth);
        GenLayerZoomVoronoi genlayerzoomvoronoi = new GenLayerZoomVoronoi(10L, genlayerrivermix);

        genlayerrivermix.a(i);
        genlayerzoomvoronoi.a(i);
        return new GenLayer[] { genlayerrivermix, genlayerzoomvoronoi, genlayerrivermix};
    }

    public GenLayer(long i) {
        long st = System.nanoTime();
        this.b = i;
        this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
        this.b += i;
        this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
        this.b += i;
        this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
        this.b += i;
        long et = System.nanoTime();
        System.out.println("GLGL Time use:"+(et-st)+"ns.");
    }

    public void a(long i) {
        this.c = i;
        if (this.a != null) {
            this.a.a(i);
        }

        this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
        this.c += this.b;
        this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
        this.c += this.b;
        this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
        this.c += this.b;
    }

    public void a(long i, long j) {
        this.d = this.c;
        this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
        this.d += i;
        this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
        this.d += j;
        this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
        this.d += i;
        this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
        this.d += j;
    }

    protected int a(int i) {
        int j = (int) ((this.d >> 24) % (long) i);

        if (j < 0) {
            j += i;
        }

        this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
        this.d += this.c;
        return j;
    }

    public abstract int[] a(int i, int j, int k, int l);

    protected static boolean a(int i, int j) {
        if (i == j) {
            return true;
        } else if (i != BiomeBase.MESA_PLATEAU_F.id && i != BiomeBase.MESA_PLATEAU.id) {
            final BiomeBase biomebase = BiomeBase.getBiome(i);
            final BiomeBase biomebase1 = BiomeBase.getBiome(j);

            try {
                return biomebase != null && biomebase1 != null ? biomebase.a(biomebase1) : false;
            } catch (Throwable throwable) {
                CrashReport crashreport = CrashReport.a(throwable, "Comparing biomes");
                CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Biomes being compared");

                crashreportsystemdetails.a("Biome A ID", (Object) Integer.valueOf(i));
                crashreportsystemdetails.a("Biome B ID", (Object) Integer.valueOf(j));
                crashreportsystemdetails.a("Biome A", new Callable() {
                    public String a() throws Exception {
                        return String.valueOf(biomebase);
                    }

                    public Object call() throws Exception {
                        return this.a();
                    }
                });
                crashreportsystemdetails.a("Biome B", new Callable() {
                    public String a() throws Exception {
                        return String.valueOf(biomebase);
                    }

                    public Object call() throws Exception {
                        return this.a();
                    }
                });
                throw new ReportedException(crashreport);
            }
        } else {
            return j == BiomeBase.MESA_PLATEAU_F.id || j == BiomeBase.MESA_PLATEAU.id;
        }
    }

    protected static boolean b(int i) {
        return i == BiomeBase.OCEAN.id || i == BiomeBase.DEEP_OCEAN.id || i == BiomeBase.FROZEN_OCEAN.id;
    }

    protected int a(int... aint) {
        return aint[this.a(aint.length)];
    }

    protected int b(int i, int j, int k, int l) {
        return j == k && k == l ? j : (i == j && i == k ? i : (i == j && i == l ? i : (i == k && i == l ? i : (i == j && k != l ? i : (i == k && j != l ? i : (i == l && j != k ? i : (j == k && i != l ? j : (j == l && i != k ? j : (k == l && i != j ? k : this.a(new int[] { i, j, k, l}))))))))));
    }
}
