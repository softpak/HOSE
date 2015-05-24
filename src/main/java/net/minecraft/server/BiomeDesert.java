package net.minecraft.server;

import java.util.Random;

public class BiomeDesert extends BiomeBase {

    public BiomeDesert(int i) {
        super(i);
        this.au.clear();
        this.ak = Blocks.SAND.getBlockData();
        this.al = Blocks.SAND.getBlockData();
        this.as.A = -999;
        this.as.D = 2;
        this.as.F = 50;
        this.as.G = 10;
        this.au.clear();
    }

    
    public void a(World world, Random random, BlockPosition blockposition) {
        super.a(world, random, blockposition);
        if (random.nextInt(1000) == 0) {
            int i = random.nextInt(16) + 8;
            int j = random.nextInt(16) + 8;
            BlockPosition blockposition1 = world.getHighestBlockYAt(blockposition.a(i, 0, j)).up();

            (new WorldGenDesertWell()).generate(world, random, blockposition1);
        }

    }
}
