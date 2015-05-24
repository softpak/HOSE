package net.minecraft.server;

public class BlockHay extends BlockRotatable {

    public BlockHay() {
        super(Material.GRASS, MaterialMapColor.t);
        this.j(this.blockStateList.getBlockData().set(BlockHay.AXIS, EnumDirection.EnumAxis.Y));
        this.a(CreativeModeTab.b);
    }

    public IBlockData fromLegacyData(int i) {
        EnumDirection.EnumAxis enumdirection_enumaxis = EnumDirection.EnumAxis.Y;
        int j = i & 12;

        if (j == 4) {
            enumdirection_enumaxis = EnumDirection.EnumAxis.X;
        } else if (j == 8) {
            enumdirection_enumaxis = EnumDirection.EnumAxis.Z;
        }

        return this.getBlockData().set(BlockHay.AXIS, enumdirection_enumaxis);
    }

    public int toLegacyData(IBlockData iblockdata) {
        int i = 0;
        EnumDirection.EnumAxis enumdirection_enumaxis = (EnumDirection.EnumAxis) iblockdata.get(BlockHay.AXIS);

        if (enumdirection_enumaxis == EnumDirection.EnumAxis.X) {
            i |= 4;
        } else if (enumdirection_enumaxis == EnumDirection.EnumAxis.Z) {
            i |= 8;
        }

        return i;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockHay.AXIS});
    }

    protected ItemStack i(IBlockData iblockdata) {
        return new ItemStack(Item.getItemOf(this), 1, 0);
    }

    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        return super.getPlacedState(world, blockposition, enumdirection, f, f1, f2, i, entityliving).set(BlockHay.AXIS, enumdirection.k());
    }
}
