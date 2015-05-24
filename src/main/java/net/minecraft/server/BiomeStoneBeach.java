package net.minecraft.server;

public class BiomeStoneBeach extends BiomeBase {

    public BiomeStoneBeach(int i) {
        super(i);
        this.au.clear();
        this.ak = Blocks.STONE.getBlockData();
        this.al = Blocks.STONE.getBlockData();
        this.as.A = -999;
        this.as.D = 0;
        this.as.F = 0;
        this.as.G = 0;
    }
}
