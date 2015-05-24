package net.minecraft.server;

import java.util.List;

public class BlockFence extends Block {

    public static final BlockStateBoolean NORTH = BlockStateBoolean.of("north");
    public static final BlockStateBoolean EAST = BlockStateBoolean.of("east");
    public static final BlockStateBoolean SOUTH = BlockStateBoolean.of("south");
    public static final BlockStateBoolean WEST = BlockStateBoolean.of("west");

    public BlockFence(Material material) {
        this(material, material.r());
    }

    public BlockFence(Material material, MaterialMapColor materialmapcolor) {
        super(material, materialmapcolor);
        this.j(this.blockStateList.getBlockData().set(BlockFence.NORTH, Boolean.valueOf(false)).set(BlockFence.EAST, Boolean.valueOf(false)).set(BlockFence.SOUTH, Boolean.valueOf(false)).set(BlockFence.WEST, Boolean.valueOf(false)));
        this.a(CreativeModeTab.c);
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, AxisAlignedBB axisalignedbb, List<AxisAlignedBB> list, Entity entity) {
        boolean flag = this.e(world, blockposition.north());
        boolean flag1 = this.e(world, blockposition.south());
        boolean flag2 = this.e(world, blockposition.west());
        boolean flag3 = this.e(world, blockposition.east());
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag) {
            f2 = 0.0F;
        }

        if (flag1) {
            f3 = 1.0F;
        }

        if (flag || flag1) {
            this.a(f, 0.0F, f2, f1, 1.5F, f3);
            super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        }

        f2 = 0.375F;
        f3 = 0.625F;
        if (flag2) {
            f = 0.0F;
        }

        if (flag3) {
            f1 = 1.0F;
        }

        if (flag2 || flag3 || !flag && !flag1) {
            this.a(f, 0.0F, f2, f1, 1.5F, f3);
            super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        }

        if (flag) {
            f2 = 0.0F;
        }

        if (flag1) {
            f3 = 1.0F;
        }

        this.a(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public void updateShape(IBlockAccess iblockaccess, BlockPosition blockposition) {
        boolean flag = this.e(iblockaccess, blockposition.north());
        boolean flag1 = this.e(iblockaccess, blockposition.south());
        boolean flag2 = this.e(iblockaccess, blockposition.west());
        boolean flag3 = this.e(iblockaccess, blockposition.east());
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag) {
            f2 = 0.0F;
        }

        if (flag1) {
            f3 = 1.0F;
        }

        if (flag2) {
            f = 0.0F;
        }

        if (flag3) {
            f1 = 1.0F;
        }

        this.a(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean b(IBlockAccess iblockaccess, BlockPosition blockposition) {
        return false;
    }

    public boolean e(IBlockAccess iblockaccess, BlockPosition blockposition) {
        Block block = iblockaccess.getType(blockposition).getBlock();

        return block == Blocks.BARRIER ? false : ((!(block instanceof BlockFence) || block.material != this.material) && !(block instanceof BlockFenceGate) ? (block.material.k() && block.d() ? block.material != Material.PUMPKIN : false) : true);
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        return world.isClientSide ? true : ItemLeash.a(entityhuman, world, blockposition);
    }

    public int toLegacyData(IBlockData iblockdata) {
        return 0;
    }

    public IBlockData updateState(IBlockData iblockdata, IBlockAccess iblockaccess, BlockPosition blockposition) {
        return iblockdata.set(BlockFence.NORTH, Boolean.valueOf(this.e(iblockaccess, blockposition.north()))).set(BlockFence.EAST, Boolean.valueOf(this.e(iblockaccess, blockposition.east()))).set(BlockFence.SOUTH, Boolean.valueOf(this.e(iblockaccess, blockposition.south()))).set(BlockFence.WEST, Boolean.valueOf(this.e(iblockaccess, blockposition.west())));
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockFence.NORTH, BlockFence.EAST, BlockFence.WEST, BlockFence.SOUTH});
    }
}
