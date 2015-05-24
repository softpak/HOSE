package net.minecraft.server;

import java.util.Random;

public class BiomeOcean extends BiomeBase {

    public BiomeOcean(int i) {
        super(i);
        this.au.clear();
    }

    public BiomeBase.EnumTemperature m() {
        return BiomeBase.EnumTemperature.OCEAN;
    }

    public void a(World world, Random random, ChunkSnapshot chunksnapshot, int i, int j, double d0) {
        super.a(world, random, chunksnapshot, i, j, d0);
    }
}
