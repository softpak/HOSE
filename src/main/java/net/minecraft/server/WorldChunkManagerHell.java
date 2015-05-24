package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WorldChunkManagerHell extends WorldChunkManager {

    private BiomeBase b;
    private float c;

    public WorldChunkManagerHell(BiomeBase biomebase, float f) {
        this.b = biomebase;
        this.c = f;
    }

    public BiomeBase getBiome(BlockPosition blockposition) {
        return this.b;
    }

    public BiomeBase[] getBiomes(BiomeBase[] abiomebase, int i, int j, int k, int l) {
        if (abiomebase == null || abiomebase.length < k * l) {
            abiomebase = new BiomeBase[k * l];
        }

        Arrays.fill(abiomebase, 0, k * l, this.b);
        return abiomebase;
    }

    public float[] getWetness(float[] afloat, int i, int j, int k, int l) {
        if (afloat == null || afloat.length < k * l) {
            afloat = new float[k * l];
        }

        Arrays.fill(afloat, 0, k * l, this.c);
        return afloat;
    }

    public BiomeBase[] getBiomeBlock(BiomeBase[] abiomebase, int i, int j, int k, int l) {
        if (abiomebase == null || abiomebase.length < k * l) {
            abiomebase = new BiomeBase[k * l];
        }

        Arrays.fill(abiomebase, 0, k * l, this.b);
        return abiomebase;
    }

    public BiomeBase[] a(BiomeBase[] abiomebase, int i, int j, int k, int l, boolean flag) {
        return this.getBiomeBlock(abiomebase, i, j, k, l);
    }

    public BlockPosition a(int i, int j, int k, List<BiomeBase> list, Random random) {
        return list.contains(this.b) ? new BlockPosition(i - k + random.nextInt(k * 2 + 1), 0, j - k + random.nextInt(k * 2 + 1)) : null;
    }

    public boolean a(int i, int j, int k, List<BiomeBase> list) {
        return list.contains(this.b);
    }
}
