package net.minecraft.server;

import java.util.Random;

public class BiomeBigHills extends BiomeBase {

    private WorldGenerator aD;
    private WorldGenTaiga2 aE;
    private int aF;
    private int aG;
    private int aH;
    private int aI;

    protected BiomeBigHills(int i, boolean flag) {
        super(i);
        this.aD = new WorldGenMinable(Blocks.MONSTER_EGG.getBlockData().set(BlockMonsterEggs.VARIANT, BlockMonsterEggs.EnumMonsterEggVarient.STONE), 9);
        this.aE = new WorldGenTaiga2(false);
        this.aF = 0;
        this.aG = 1;
        this.aH = 2;
        this.aI = this.aF;
        if (flag) {
            this.as.A = 3;
            this.aI = this.aG;
        }

    }

    public WorldGenTreeAbstract a(Random random) {
        return (WorldGenTreeAbstract) (random.nextInt(3) > 0 ? this.aE : super.a(random));
    }

    public void a(World world, Random random, BlockPosition blockposition) {
        super.a(world, random, blockposition);
        int i = 3 + random.nextInt(6);

        int j;
        int k;
        int l;

        for (j = 0; j < i; ++j) {
            k = random.nextInt(16);
            l = random.nextInt(28) + 4;
            int i1 = random.nextInt(16);
            BlockPosition blockposition1 = blockposition.a(k, l, i1);

            if (world.getType(blockposition1).getBlock() == Blocks.STONE) {
                world.setTypeAndData(blockposition1, Blocks.EMERALD_ORE.getBlockData(), 2);
            }
        }

        for (i = 0; i < 7; ++i) {
            j = random.nextInt(16);
            k = random.nextInt(64);
            l = random.nextInt(16);
            this.aD.generate(world, random, blockposition.a(j, k, l));
        }

    }

    public void a(World world, Random random, ChunkSnapshot chunksnapshot, int i, int j, double d0) {
        this.ak = Blocks.GRASS.getBlockData();
        this.al = Blocks.DIRT.getBlockData();
        if ((d0 < -1.0D || d0 > 2.0D) && this.aI == this.aH) {
            this.ak = Blocks.GRAVEL.getBlockData();
            this.al = Blocks.GRAVEL.getBlockData();
        } else if (d0 > 1.0D && this.aI != this.aG) {
            this.ak = Blocks.STONE.getBlockData();
            this.al = Blocks.STONE.getBlockData();
        }

        this.b(world, random, chunksnapshot, i, j, d0);
    }

    private BiomeBigHills b(BiomeBase biomebase) {
        this.aI = this.aH;
        this.a(biomebase.ai, true);
        this.a(biomebase.ah + " M");
        this.a(new BiomeBase.BiomeTemperature(biomebase.an, biomebase.ao));
        this.a(biomebase.temperature, biomebase.humidity);
        return this;
    }

    protected BiomeBase d(int i) {
        return (new BiomeBigHills(i, false)).b((BiomeBase) this);
    }
}
