package net.minecraft.server;

public class BlockStainedGlassPane extends BlockThin {

    public static final BlockStateEnum<EnumColor> COLOR = BlockStateEnum.of("color", EnumColor.class);

    public BlockStainedGlassPane() {
        super(Material.SHATTERABLE, false);
        this.j(this.blockStateList.getBlockData().set(BlockStainedGlassPane.NORTH, Boolean.valueOf(false)).set(BlockStainedGlassPane.EAST, Boolean.valueOf(false)).set(BlockStainedGlassPane.SOUTH, Boolean.valueOf(false)).set(BlockStainedGlassPane.WEST, Boolean.valueOf(false)).set(BlockStainedGlassPane.COLOR, EnumColor.WHITE));
        this.a(CreativeModeTab.c);
    }

    public int getDropData(IBlockData iblockdata) {
        return ((EnumColor) iblockdata.get(BlockStainedGlassPane.COLOR)).getColorIndex();
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return ((EnumColor) iblockdata.get(BlockStainedGlassPane.COLOR)).e();
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockStainedGlassPane.COLOR, EnumColor.fromColorIndex(i));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((EnumColor) iblockdata.get(BlockStainedGlassPane.COLOR)).getColorIndex();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockStainedGlassPane.NORTH, BlockStainedGlassPane.EAST, BlockStainedGlassPane.WEST, BlockStainedGlassPane.SOUTH, BlockStainedGlassPane.COLOR});
    }

    public void onPlace(World world, BlockPosition blockposition, IBlockData iblockdata) {
        if (!world.isClientSide) {
            BlockBeacon.f(world, blockposition);
        }

    }

    public void remove(World world, BlockPosition blockposition, IBlockData iblockdata) {
        if (!world.isClientSide) {
            BlockBeacon.f(world, blockposition);
        }

    }
}
