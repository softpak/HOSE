package net.minecraft.server;

public class BlockMinecartTrack extends BlockMinecartTrackAbstract {

    public static final BlockStateEnum<BlockMinecartTrackAbstract.EnumTrackPosition> SHAPE = BlockStateEnum.of("shape", BlockMinecartTrackAbstract.EnumTrackPosition.class);

    protected BlockMinecartTrack() {
        super(false);
        this.j(this.blockStateList.getBlockData().set(BlockMinecartTrack.SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH));
    }

    protected void b(World world, BlockPosition blockposition, IBlockData iblockdata, Block block) {
        if (block.isPowerSource() && (new BlockMinecartTrackAbstract.MinecartTrackLogic(world, blockposition, iblockdata)).a() == 3) {
            this.a(world, blockposition, iblockdata, false);
        }

    }

    public IBlockState<BlockMinecartTrackAbstract.EnumTrackPosition> n() {
        return BlockMinecartTrack.SHAPE;
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockMinecartTrack.SHAPE, BlockMinecartTrackAbstract.EnumTrackPosition.a(i));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((BlockMinecartTrackAbstract.EnumTrackPosition) iblockdata.get(BlockMinecartTrack.SHAPE)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockMinecartTrack.SHAPE});
    }
}
