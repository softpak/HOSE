package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class WorldGenStronghold extends StructureGenerator {

    private List<BiomeBase> d;
    private boolean f;
    private ChunkCoordIntPair[] g;
    private double h;
    private int i;

    public WorldGenStronghold() {
        this.g = new ChunkCoordIntPair[3];
        this.h = 32.0D;
        this.i = 3;
        this.d = Lists.newArrayList();
        BiomeBase[] abiomebase = BiomeBase.getBiomes();
        int i = abiomebase.length;

        for (int j = 0; j < i; ++j) {
            BiomeBase biomebase = abiomebase[j];

            if (biomebase != null && biomebase.an > 0.0F) {
                this.d.add(biomebase);
            }
        }

    }

    public WorldGenStronghold(Map<String, String> map) {
        this();
        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();

            if (((String) entry.getKey()).equals("distance")) {
                this.h = MathHelper.a((String) entry.getValue(), this.h, 1.0D);
            } else if (((String) entry.getKey()).equals("count")) {
                this.g = new ChunkCoordIntPair[MathHelper.a((String) entry.getValue(), this.g.length, 1)];
            } else if (((String) entry.getKey()).equals("spread")) {
                this.i = MathHelper.a((String) entry.getValue(), this.i, 1);
            }
        }

    }

    public String a() {
        return "Stronghold";
    }

    protected boolean a(int i, int j) {
        if (!this.f) {
            Random random = new Random();

            random.setSeed(this.c.getSeed());
            double d0 = random.nextDouble() * 3.141592653589793D * 2.0D;
            int k = 1;

            for (int l = 0; l < this.g.length; ++l) {
                double d1 = (1.25D * (double) k + random.nextDouble()) * this.h * (double) k;
                int i1 = (int) Math.round(Math.cos(d0) * d1);
                int j1 = (int) Math.round(Math.sin(d0) * d1);
                BlockPosition blockposition = this.c.getWorldChunkManager().a((i1 << 4) + 8, (j1 << 4) + 8, 112, this.d, random);

                if (blockposition != null) {
                    i1 = blockposition.getX() >> 4;
                    j1 = blockposition.getZ() >> 4;
                }

                this.g[l] = new ChunkCoordIntPair(i1, j1);
                d0 += 6.283185307179586D * (double) k / (double) this.i;
                if (l == this.i) {
                    k += 2 + random.nextInt(5);
                    this.i += 1 + random.nextInt(2);
                }
            }

            this.f = true;
        }

        ChunkCoordIntPair[] achunkcoordintpair = this.g;
        int k1 = achunkcoordintpair.length;

        for (int l1 = 0; l1 < k1; ++l1) {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[l1];

            if (i == chunkcoordintpair.x && j == chunkcoordintpair.z) {
                return true;
            }
        }

        return false;
    }

    protected List<BlockPosition> z_() {
        ArrayList arraylist = Lists.newArrayList();
        ChunkCoordIntPair[] achunkcoordintpair = this.g;
        int i = achunkcoordintpair.length;

        for (int j = 0; j < i; ++j) {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[j];

            if (chunkcoordintpair != null) {
                arraylist.add(chunkcoordintpair.a(64));
            }
        }

        return arraylist;
    }

    protected StructureStart b(int i, int j) {
        WorldGenStronghold.WorldGenStronghold2Start worldgenstronghold_worldgenstronghold2start;

        for (worldgenstronghold_worldgenstronghold2start = new WorldGenStronghold.WorldGenStronghold2Start(this.c, this.b, i, j); worldgenstronghold_worldgenstronghold2start.b().isEmpty() || ((WorldGenStrongholdPieces.WorldGenStrongholdStart) worldgenstronghold_worldgenstronghold2start.b().get(0)).b == null; worldgenstronghold_worldgenstronghold2start = new WorldGenStronghold.WorldGenStronghold2Start(this.c, this.b, i, j)) {
            ;
        }

        return worldgenstronghold_worldgenstronghold2start;
    }

    public static class WorldGenStronghold2Start extends StructureStart {

        public WorldGenStronghold2Start() {}

        public WorldGenStronghold2Start(World world, Random random, int i, int j) {
            super(i, j);
            WorldGenStrongholdPieces.b();
            WorldGenStrongholdPieces.WorldGenStrongholdStart worldgenstrongholdpieces_worldgenstrongholdstart = new WorldGenStrongholdPieces.WorldGenStrongholdStart(0, random, (i << 4) + 2, (j << 4) + 2);

            this.a.add(worldgenstrongholdpieces_worldgenstrongholdstart);
            worldgenstrongholdpieces_worldgenstrongholdstart.a((StructurePiece) worldgenstrongholdpieces_worldgenstrongholdstart, (List) this.a, random);
            List list = worldgenstrongholdpieces_worldgenstrongholdstart.c;

            while (!list.isEmpty()) {
                int k = random.nextInt(list.size());
                StructurePiece structurepiece = (StructurePiece) list.remove(k);

                structurepiece.a((StructurePiece) worldgenstrongholdpieces_worldgenstrongholdstart, (List) this.a, random);
            }

            this.c();
            this.a(world, random, 10);
        }
    }
}
