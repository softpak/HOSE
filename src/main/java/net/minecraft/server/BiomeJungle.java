package net.minecraft.server;

import java.util.Random;

public class BiomeJungle extends BiomeBase {

    private boolean aD;
    private static final IBlockData aE = Blocks.LOG.getBlockData().set(BlockLog1.VARIANT, BlockWood.EnumLogVariant.JUNGLE);
    private static final IBlockData aF = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.JUNGLE).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    private static final IBlockData aG = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.OAK).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

    public BiomeJungle(int i, boolean flag) {
        super(i);
        this.aD = flag;
        if (flag) {
            this.as.A = 2;
        } else {
            this.as.A = 50;
        }

        this.as.C = 25;
        this.as.B = 4;
        if (!flag) {
            this.at.add(new BiomeBase.BiomeMeta(EntityOcelot.class, 2, 1, 1));
        }

        this.au.add(new BiomeBase.BiomeMeta(EntityChicken.class, 10, 4, 4));
    }

    public WorldGenTreeAbstract a(Random random) {
        return (WorldGenTreeAbstract) (random.nextInt(10) == 0 ? this.aB : (random.nextInt(2) == 0 ? new WorldGenGroundBush(BiomeJungle.aE, BiomeJungle.aG) : (!this.aD && random.nextInt(3) == 0 ? new WorldGenJungleTree(false, 10, 20, BiomeJungle.aE, BiomeJungle.aF) : new WorldGenTrees(false, 4 + random.nextInt(7), BiomeJungle.aE, BiomeJungle.aF, true))));
    }

    public WorldGenerator b(Random random) {
        return random.nextInt(4) == 0 ? new WorldGenGrass(BlockLongGrass.EnumTallGrassType.FERN) : new WorldGenGrass(BlockLongGrass.EnumTallGrassType.GRASS);
    }

    public void a(World world, Random random, BlockPosition blockposition) {
        super.a(world, random, blockposition);
        int i = random.nextInt(16) + 8;
        int j = random.nextInt(16) + 8;
        int k = random.nextInt(world.getHighestBlockYAt(blockposition.a(i, 0, j)).getY() * 2);

        (new WorldGenMelon()).generate(world, random, blockposition.a(i, k, j));
        WorldGenVines worldgenvines = new WorldGenVines();

        for (j = 0; j < 50; ++j) {
            k = random.nextInt(16) + 8;
            boolean flag = true;
            int l = random.nextInt(16) + 8;

            worldgenvines.generate(world, random, blockposition.a(k, 128, l));
        }

    }
}
