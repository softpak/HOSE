package net.minecraft.server;

import com.amd.aparapi.Aparapi;
import com.amd.aparapi.Device;

public class WorldProviderHell extends WorldProvider {

    public WorldProviderHell() {}

    public void b() {
        this.c = new WorldChunkManagerHell(BiomeBase.HELL, 0.0F);
        this.d = true;
        this.e = true;
        this.dimension = -1;
    }

    protected void a() {
        float f = 0.1F;

        Aparapi.range(16).forEach( i -> {
            float f1 = 1.0F - (float) i / 15.0F;
            this.f[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        });
        /*
        for (int i = 0; i <= 15; ++i) {
            float f1 = 1.0F - (float) i / 15.0F;

            this.f[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        }*/

    }

    public IChunkProvider getChunkProvider() {
        return new ChunkProviderHell(this.b, this.b.getWorldData().shouldGenerateMapFeatures(), this.b.getSeed());
    }

    public boolean d() {
        return false;
    }

    public boolean canSpawn(int i, int j) {
        return false;
    }

    public float a(long i, float f) {
        return 0.5F;
    }

    public boolean e() {
        return false;
    }

    public String getName() {
        return "Nether";
    }

    public String getSuffix() {
        return "_nether";
    }

    public WorldBorder getWorldBorder() {
        return new WorldBorder() {
            public double getCenterX() {
                return super.getCenterX() / 8.0D;
            }

            public double getCenterZ() {
                return super.getCenterZ() / 8.0D;
            }
        };
    }
}
