package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

public class WorldGenMonument extends StructureGenerator {

    private int f;
    private int g;
    public static final List<BiomeBase> d = Arrays.asList(new BiomeBase[] { BiomeBase.OCEAN, BiomeBase.DEEP_OCEAN, BiomeBase.RIVER, BiomeBase.FROZEN_OCEAN, BiomeBase.FROZEN_RIVER});
    private static final List<BiomeBase.BiomeMeta> h = Lists.newArrayList();

    public WorldGenMonument() {
        this.f = 32;
        this.g = 5;
    }

    public WorldGenMonument(Map<String, String> map) {
        this();
        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();

            if (((String) entry.getKey()).equals("spacing")) {
                this.f = MathHelper.a((String) entry.getValue(), this.f, 1);
            } else if (((String) entry.getKey()).equals("separation")) {
                this.g = MathHelper.a((String) entry.getValue(), this.g, 1);
            }
        }

    }

    public String a() {
        return "Monument";
    }

    protected boolean a(int i, int j) {
        int k = i;
        int l = j;

        if (i < 0) {
            i -= this.f - 1;
        }

        if (j < 0) {
            j -= this.f - 1;
        }

        int i1 = i / this.f;
        int j1 = j / this.f;
        Random random = this.c.a(i1, j1, 10387313);

        i1 *= this.f;
        j1 *= this.f;
        i1 += (random.nextInt(this.f - this.g) + random.nextInt(this.f - this.g)) / 2;
        j1 += (random.nextInt(this.f - this.g) + random.nextInt(this.f - this.g)) / 2;
        if (k == i1 && l == j1) {
            if (this.c.getWorldChunkManager().getBiome(new BlockPosition(k * 16 + 8, 64, l * 16 + 8), (BiomeBase) null) != BiomeBase.DEEP_OCEAN) {
                return false;
            }

            boolean flag = this.c.getWorldChunkManager().a(k * 16 + 8, l * 16 + 8, 29, WorldGenMonument.d);

            if (flag) {
                return true;
            }
        }

        return false;
    }

    protected StructureStart b(int i, int j) {
        return new WorldGenMonument.WorldGenMonumentStart(this.c, this.b, i, j);
    }

    public List<BiomeBase.BiomeMeta> b() {
        return WorldGenMonument.h;
    }

    static {
        WorldGenMonument.h.add(new BiomeBase.BiomeMeta(EntityGuardian.class, 1, 2, 4));
    }

    public static class WorldGenMonumentStart extends StructureStart {

        private Set<ChunkCoordIntPair> c = Sets.newHashSet();
        private boolean d;

        public WorldGenMonumentStart() {}

        public WorldGenMonumentStart(World world, Random random, int i, int j) {
            super(i, j);
            this.b(world, random, i, j);
        }

        private void b(World world, Random random, int i, int j) {
            random.setSeed(world.getSeed());
            long k = random.nextLong();
            long l = random.nextLong();
            long i1 = (long) i * k;
            long j1 = (long) j * l;

            random.setSeed(i1 ^ j1 ^ world.getSeed());
            int k1 = i * 16 + 8 - 29;
            int l1 = j * 16 + 8 - 29;
            EnumDirection enumdirection = EnumDirection.EnumDirectionLimit.HORIZONTAL.a(random);

            this.a.add(new WorldGenMonumentPieces.WorldGenMonumentPiece1(random, k1, l1, enumdirection));
            this.c();
            this.d = true;
        }

        public void a(World world, Random random, StructureBoundingBox structureboundingbox) {
            if (!this.d) {
                this.a.clear();
                this.b(world, random, this.e(), this.f());
            }

            super.a(world, random, structureboundingbox);
        }

        public boolean a(ChunkCoordIntPair chunkcoordintpair) {
            return this.c.contains(chunkcoordintpair) ? false : super.a(chunkcoordintpair);
        }

        public void b(ChunkCoordIntPair chunkcoordintpair) {
            super.b(chunkcoordintpair);
            this.c.add(chunkcoordintpair);
        }

        public void a(NBTTagCompound nbttagcompound) {
            super.a(nbttagcompound);
            NBTTagList nbttaglist = new NBTTagList();
            Iterator iterator = this.c.iterator();

            while (iterator.hasNext()) {
                ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) iterator.next();
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                nbttagcompound1.setInt("X", chunkcoordintpair.x);
                nbttagcompound1.setInt("Z", chunkcoordintpair.z);
                nbttaglist.add(nbttagcompound1);
            }

            nbttagcompound.set("Processed", nbttaglist);
        }

        public void b(NBTTagCompound nbttagcompound) {
            super.b(nbttagcompound);
            if (nbttagcompound.hasKeyOfType("Processed", 9)) {
                NBTTagList nbttaglist = nbttagcompound.getList("Processed", 10);

                for (int i = 0; i < nbttaglist.size(); ++i) {
                    NBTTagCompound nbttagcompound1 = nbttaglist.get(i);

                    this.c.add(new ChunkCoordIntPair(nbttagcompound1.getInt("X"), nbttagcompound1.getInt("Z")));
                }
            }

        }
    }
}
