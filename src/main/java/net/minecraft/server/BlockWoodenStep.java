package net.minecraft.server;

import java.util.Random;

public abstract class BlockWoodenStep extends BlockStepAbstract {

    public static final BlockStateEnum<BlockWood.EnumLogVariant> VARIANT = BlockStateEnum.of("variant", BlockWood.EnumLogVariant.class);

    public BlockWoodenStep() {
        super(Material.WOOD);
        IBlockData iblockdata = this.blockStateList.getBlockData();

        if (!this.l()) {
            iblockdata = iblockdata.set(BlockWoodenStep.HALF, BlockStepAbstract.EnumSlabHalf.BOTTOM);
        }

        this.j(iblockdata.set(BlockWoodenStep.VARIANT, BlockWood.EnumLogVariant.OAK));
        this.a(CreativeModeTab.b);
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return ((BlockWood.EnumLogVariant) iblockdata.get(BlockWoodenStep.VARIANT)).c();
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Item.getItemOf(Blocks.WOODEN_SLAB);
    }

    public String b(int i) {
        return super.a() + "." + BlockWood.EnumLogVariant.a(i).d();
    }

    public IBlockState<?> n() {
        return BlockWoodenStep.VARIANT;
    }

    public Object a(ItemStack itemstack) {
        return BlockWood.EnumLogVariant.a(itemstack.getData() & 7);
    }

    public IBlockData fromLegacyData(int i) {
        IBlockData iblockdata = this.getBlockData().set(BlockWoodenStep.VARIANT, BlockWood.EnumLogVariant.a(i & 7));

        if (!this.l()) {
            iblockdata = iblockdata.set(BlockWoodenStep.HALF, (i & 8) == 0 ? BlockStepAbstract.EnumSlabHalf.BOTTOM : BlockStepAbstract.EnumSlabHalf.TOP);
        }

        return iblockdata;
    }

    public int toLegacyData(IBlockData iblockdata) {
        byte b0 = 0;
        int i = b0 | ((BlockWood.EnumLogVariant) iblockdata.get(BlockWoodenStep.VARIANT)).a();

        if (!this.l() && iblockdata.get(BlockWoodenStep.HALF) == BlockStepAbstract.EnumSlabHalf.TOP) {
            i |= 8;
        }

        return i;
    }

    protected BlockStateList getStateList() {
        return this.l() ? new BlockStateList(this, new IBlockState[] { BlockWoodenStep.VARIANT}) : new BlockStateList(this, new IBlockState[] { BlockWoodenStep.HALF, BlockWoodenStep.VARIANT});
    }

    public int getDropData(IBlockData iblockdata) {
        return ((BlockWood.EnumLogVariant) iblockdata.get(BlockWoodenStep.VARIANT)).a();
    }
}
