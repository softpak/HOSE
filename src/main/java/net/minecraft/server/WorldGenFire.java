package net.minecraft.server;

import java.util.Random;
import org.HOSE.HRandom;

public class WorldGenFire extends WorldGenerator {

    public WorldGenFire() {}
    public static HRandom hrnd = new HRandom();
    public boolean generate(World world, Random random, BlockPosition blockposition) {
        
        for (int i = 0; i < 64; ++i) {
            //BlockPosition blockposition1 = blockposition.a(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            BlockPosition blockposition1 = blockposition.a(hrnd.nextInt(8) - hrnd.nextInt(8), hrnd.nextInt(4) - hrnd.nextInt(4), hrnd.nextInt(8) - hrnd.nextInt(8));

            if (world.isEmpty(blockposition1) && world.getType(blockposition1.down()).getBlock() == Blocks.NETHERRACK) {
                world.setTypeAndData(blockposition1, Blocks.FIRE.getBlockData(), 2);
            }
        }

        return true;
    }
}
