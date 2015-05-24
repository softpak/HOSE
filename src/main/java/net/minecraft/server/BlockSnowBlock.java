package net.minecraft.server;

import java.util.Random;

public class BlockSnowBlock extends Block {

    protected BlockSnowBlock() {
        super(Material.SNOW_BLOCK);
        this.a(true);
        this.a(CreativeModeTab.b);
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Items.SNOWBALL;
    }

    public int a(Random random) {
        return 4;
    }

    public void b(World world, BlockPosition blockposition, IBlockData iblockdata, Random random) {
        if (world.b(EnumSkyBlock.BLOCK, blockposition) > 11) {
            this.b(world, blockposition, world.getType(blockposition), 0);
            world.setAir(blockposition);
        }

    }
}
