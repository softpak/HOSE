package net.minecraft.server;

import java.util.Random;

public abstract class WorldGenerator {

    private final boolean a;

    public WorldGenerator() {
        this(false);
    }

    public WorldGenerator(boolean flag) {
        this.a = flag;
    }

    public abstract boolean generate(World world, Random random, BlockPosition blockposition);

    public void e() {}

    protected void a(World world, BlockPosition blockposition, IBlockData iblockdata) {
        if (this.a) {
            world.setTypeAndData(blockposition, iblockdata, 3);
        } else {
            world.setTypeAndData(blockposition, iblockdata, 2);
        }

    }
}
