package net.minecraft.server;

import java.util.Random;

public abstract class WorldGenTreeAbstract extends WorldGenerator {

    public WorldGenTreeAbstract(boolean flag) {
        super(flag);
    }

    protected boolean a(Block block) {
        Material material = block.getMaterial();

        return material == Material.AIR || material == Material.LEAVES || block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.LOG || block == Blocks.LOG2 || block == Blocks.SAPLING || block == Blocks.VINE;
    }

    public void a(World world, Random random, BlockPosition blockposition) {}

    protected void a(World world, BlockPosition blockposition) {
        if (world.getType(blockposition).getBlock() != Blocks.DIRT) {
            this.a(world, blockposition, Blocks.DIRT.getBlockData());
        }

    }
}
