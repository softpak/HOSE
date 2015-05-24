package net.minecraft.server;

import java.util.Random;

public class BiomeSwamp extends BiomeBase {

    protected BiomeSwamp(int i) {
        super(i);
        this.as.A = 2;
        this.as.B = 1;
        this.as.D = 1;
        this.as.E = 8;
        this.as.F = 10;
        this.as.J = 1;
        this.as.z = 4;
        this.as.I = 0;
        this.as.H = 0;
        this.as.C = 5;
        this.ar = 14745518;
        this.at.add(new BiomeBase.BiomeMeta(EntitySlime.class, 1, 1, 1));
    }

    public WorldGenTreeAbstract a(Random random) {
        return this.aC;
    }

    public BlockFlowers.EnumFlowerVarient a(Random random, BlockPosition blockposition) {
        return BlockFlowers.EnumFlowerVarient.BLUE_ORCHID;
    }

    public void a(World world, Random random, ChunkSnapshot chunksnapshot, int i, int j, double d0) {
        double d1 = BiomeSwamp.af.a((double) i * 0.25D, (double) j * 0.25D);

        if (d1 > 0.0D) {
            int k = i & 15;
            int l = j & 15;

            for (int i1 = 255; i1 >= 0; --i1) {
                if (chunksnapshot.a(l, i1, k).getBlock().getMaterial() != Material.AIR) {
                    if (i1 == 62 && chunksnapshot.a(l, i1, k).getBlock() != Blocks.WATER) {
                        chunksnapshot.a(l, i1, k, Blocks.WATER.getBlockData());
                        if (d1 < 0.12D) {
                            chunksnapshot.a(l, i1 + 1, k, Blocks.WATERLILY.getBlockData());
                        }
                    }
                    break;
                }
            }
        }

        this.b(world, random, chunksnapshot, i, j, d0);
    }
}
