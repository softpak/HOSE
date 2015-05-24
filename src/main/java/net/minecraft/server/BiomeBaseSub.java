package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Random;

public class BiomeBaseSub extends BiomeBase {

    protected BiomeBase aE;

    public BiomeBaseSub(int i, BiomeBase biomebase) {
        super(i);
        this.aE = biomebase;
        this.a(biomebase.ai, true);
        this.ah = biomebase.ah + " M";
        this.ak = biomebase.ak;
        this.al = biomebase.al;
        this.am = biomebase.am;
        this.an = biomebase.an;
        this.ao = biomebase.ao;
        this.temperature = biomebase.temperature;
        this.humidity = biomebase.humidity;
        this.ar = biomebase.ar;
        this.ax = biomebase.ax;
        this.ay = biomebase.ay;
        this.au = Lists.newArrayList(biomebase.au);
        this.at = Lists.newArrayList(biomebase.at);
        this.aw = Lists.newArrayList(biomebase.aw);
        this.av = Lists.newArrayList(biomebase.av);
        this.temperature = biomebase.temperature;
        this.humidity = biomebase.humidity;
        this.an = biomebase.an + 0.1F;
        this.ao = biomebase.ao + 0.2F;
    }

    public void a(World world, Random random, BlockPosition blockposition) {
        this.aE.as.a(world, random, this, blockposition);
    }

    public void a(World world, Random random, ChunkSnapshot chunksnapshot, int i, int j, double d0) {
        this.aE.a(world, random, chunksnapshot, i, j, d0);
    }

    public float g() {
        return this.aE.g();
    }

    public WorldGenTreeAbstract a(Random random) {
        return this.aE.a(random);
    }

    public Class<? extends BiomeBase> l() {
        return this.aE.l();
    }

    public boolean a(BiomeBase biomebase) {
        return this.aE.a(biomebase);
    }

    public BiomeBase.EnumTemperature m() {
        return this.aE.m();
    }
}
