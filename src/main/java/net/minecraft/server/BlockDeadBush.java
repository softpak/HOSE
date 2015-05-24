package net.minecraft.server;

import java.util.Random;

public class BlockDeadBush extends BlockPlant {

    protected BlockDeadBush() {
        super(Material.REPLACEABLE_PLANT);
        float f = 0.4F;

        this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return MaterialMapColor.o;
    }

    protected boolean c(Block block) {
        return block == Blocks.SAND || block == Blocks.HARDENED_CLAY || block == Blocks.STAINED_HARDENED_CLAY || block == Blocks.DIRT;
    }

    public boolean a(World world, BlockPosition blockposition) {
        return true;
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return null;
    }

    public void a(World world, EntityHuman entityhuman, BlockPosition blockposition, IBlockData iblockdata, TileEntity tileentity) {
        if (!world.isClientSide && entityhuman.bZ() != null && entityhuman.bZ().getItem() == Items.SHEARS) {
            entityhuman.b(StatisticList.MINE_BLOCK_COUNT[Block.getId(this)]);
            a(world, blockposition, new ItemStack(Blocks.DEADBUSH, 1, 0));
        } else {
            super.a(world, entityhuman, blockposition, iblockdata, tileentity);
        }

    }
}
