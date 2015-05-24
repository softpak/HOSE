package net.minecraft.server;

import java.util.Random;

public class BiomeIcePlains extends BiomeBase {

    private boolean aD;
    private WorldGenPackedIce2 aE = new WorldGenPackedIce2();
    private WorldGenPackedIce1 aF = new WorldGenPackedIce1(4);

    public BiomeIcePlains(int i, boolean flag) {
        super(i);
        this.aD = flag;
        if (flag) {
            this.ak = Blocks.SNOW.getBlockData();
        }

        this.au.clear();
    }

    public void a(World world, Random random, BlockPosition blockposition) {
        if (this.aD) {
            int i;
            int j;
            int k;

            for (i = 0; i < 3; ++i) {
                j = random.nextInt(16) + 8;
                k = random.nextInt(16) + 8;
                this.aE.generate(world, random, world.getHighestBlockYAt(blockposition.a(j, 0, k)));
            }

            for (i = 0; i < 2; ++i) {
                j = random.nextInt(16) + 8;
                k = random.nextInt(16) + 8;
                this.aF.generate(world, random, world.getHighestBlockYAt(blockposition.a(j, 0, k)));
            }
        }

        super.a(world, random, blockposition);
    }

    public WorldGenTreeAbstract a(Random random) {
        return new WorldGenTaiga2(false);
    }

    protected BiomeBase d(int i) {
        BiomeBase biomebase = (new BiomeIcePlains(i, true)).a(13828095, true).a(this.ah + " Spikes").c().a(0.0F, 0.5F).a(new BiomeBase.BiomeTemperature(this.an + 0.1F, this.ao + 0.1F));

        biomebase.an = this.an + 0.3F;
        biomebase.ao = this.ao + 0.4F;
        return biomebase;
    }
}
