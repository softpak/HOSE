package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.List;

public class BiomeCache {

    private final WorldChunkManager a;
    private long b;
    private LongHashMap<BiomeCache.BiomeCacheBlock> c = new LongHashMap();
    private List<BiomeCache.BiomeCacheBlock> d = Lists.newArrayList();

    public BiomeCache(WorldChunkManager worldchunkmanager) {
        this.a = worldchunkmanager;
    }

    public BiomeCache.BiomeCacheBlock a(int i, int j) {
        i >>= 4;
        j >>= 4;
        long k = (long) i & 4294967295L | ((long) j & 4294967295L) << 32;
        BiomeCache.BiomeCacheBlock biomecache_biomecacheblock = (BiomeCache.BiomeCacheBlock) this.c.getEntry(k);

        if (biomecache_biomecacheblock == null) {
            biomecache_biomecacheblock = new BiomeCache.BiomeCacheBlock(i, j);
            this.c.put(k, biomecache_biomecacheblock);
            this.d.add(biomecache_biomecacheblock);
        }

        biomecache_biomecacheblock.e = MinecraftServer.ay();
        return biomecache_biomecacheblock;
    }

    public BiomeBase a(int i, int j, BiomeBase biomebase) {
        BiomeBase biomebase1 = this.a(i, j).a(i, j);

        return biomebase1 == null ? biomebase : biomebase1;
    }

    public void a() {
        long i = MinecraftServer.ay();
        long j = i - this.b;

        if (j > 7500L || j < 0L) {
            this.b = i;

            for (int k = 0; k < this.d.size(); ++k) {
                BiomeCache.BiomeCacheBlock biomecache_biomecacheblock = (BiomeCache.BiomeCacheBlock) this.d.get(k);
                long l = i - biomecache_biomecacheblock.e;

                if (l > 30000L || l < 0L) {
                    this.d.remove(k--);
                    long i1 = (long) biomecache_biomecacheblock.c & 4294967295L | ((long) biomecache_biomecacheblock.d & 4294967295L) << 32;

                    this.c.remove(i1);
                }
            }
        }

    }

    public BiomeBase[] c(int i, int j) {
        return this.a(i, j).b;
    }

    public class BiomeCacheBlock {

        public float[] a = new float[256];
        public BiomeBase[] b = new BiomeBase[256];
        public int c;
        public int d;
        public long e;

        public BiomeCacheBlock(int i, int j) {
            this.c = i;
            this.d = j;
            BiomeCache.this.a.getWetness(this.a, i << 4, j << 4, 16, 16);
            BiomeCache.this.a.a(this.b, i << 4, j << 4, 16, 16, false);
        }

        public BiomeBase a(int i, int j) {
            return this.b[i & 15 | (j & 15) << 4];
        }
    }
}
