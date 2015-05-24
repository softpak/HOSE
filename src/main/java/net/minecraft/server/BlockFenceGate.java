package net.minecraft.server;

public class BlockFenceGate extends BlockDirectional {

    public static final BlockStateBoolean OPEN = BlockStateBoolean.of("open");
    public static final BlockStateBoolean POWERED = BlockStateBoolean.of("powered");
    public static final BlockStateBoolean IN_WALL = BlockStateBoolean.of("in_wall");

    public BlockFenceGate(BlockWood.EnumLogVariant blockwood_enumlogvariant) {
        super(Material.WOOD, blockwood_enumlogvariant.c());
        this.j(this.blockStateList.getBlockData().set(BlockFenceGate.OPEN, Boolean.valueOf(false)).set(BlockFenceGate.POWERED, Boolean.valueOf(false)).set(BlockFenceGate.IN_WALL, Boolean.valueOf(false)));
        this.a(CreativeModeTab.d);
    }

    public IBlockData updateState(IBlockData iblockdata, IBlockAccess iblockaccess, BlockPosition blockposition) {
        EnumDirection.EnumAxis enumdirection_enumaxis = ((EnumDirection) iblockdata.get(BlockFenceGate.FACING)).k();

        if (enumdirection_enumaxis == EnumDirection.EnumAxis.Z && (iblockaccess.getType(blockposition.west()).getBlock() == Blocks.COBBLESTONE_WALL || iblockaccess.getType(blockposition.east()).getBlock() == Blocks.COBBLESTONE_WALL) || enumdirection_enumaxis == EnumDirection.EnumAxis.X && (iblockaccess.getType(blockposition.north()).getBlock() == Blocks.COBBLESTONE_WALL || iblockaccess.getType(blockposition.south()).getBlock() == Blocks.COBBLESTONE_WALL)) {
            iblockdata = iblockdata.set(BlockFenceGate.IN_WALL, Boolean.valueOf(true));
        }

        return iblockdata;
    }

    public boolean canPlace(World world, BlockPosition blockposition) {
        return world.getType(blockposition.down()).getBlock().getMaterial().isBuildable() ? super.canPlace(world, blockposition) : false;
    }

    public AxisAlignedBB a(World world, BlockPosition blockposition, IBlockData iblockdata) {
        if (((Boolean) iblockdata.get(BlockFenceGate.OPEN)).booleanValue()) {
            return null;
        } else {
            EnumDirection.EnumAxis enumdirection_enumaxis = ((EnumDirection) iblockdata.get(BlockFenceGate.FACING)).k();

            return enumdirection_enumaxis == EnumDirection.EnumAxis.Z ? new AxisAlignedBB((double) blockposition.getX(), (double) blockposition.getY(), (double) ((float) blockposition.getZ() + 0.375F), (double) (blockposition.getX() + 1), (double) ((float) blockposition.getY() + 1.5F), (double) ((float) blockposition.getZ() + 0.625F)) : new AxisAlignedBB((double) ((float) blockposition.getX() + 0.375F), (double) blockposition.getY(), (double) blockposition.getZ(), (double) ((float) blockposition.getX() + 0.625F), (double) ((float) blockposition.getY() + 1.5F), (double) (blockposition.getZ() + 1));
        }
    }

    public void updateShape(IBlockAccess iblockaccess, BlockPosition blockposition) {
        EnumDirection.EnumAxis enumdirection_enumaxis = ((EnumDirection) iblockaccess.getType(blockposition).get(BlockFenceGate.FACING)).k();

        if (enumdirection_enumaxis == EnumDirection.EnumAxis.Z) {
            this.a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
        } else {
            this.a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
        }

    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean b(IBlockAccess iblockaccess, BlockPosition blockposition) {
        return ((Boolean) iblockaccess.getType(blockposition).get(BlockFenceGate.OPEN)).booleanValue();
    }

    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        return this.getBlockData().set(BlockFenceGate.FACING, entityliving.getDirection()).set(BlockFenceGate.OPEN, Boolean.valueOf(false)).set(BlockFenceGate.POWERED, Boolean.valueOf(false)).set(BlockFenceGate.IN_WALL, Boolean.valueOf(false));
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (((Boolean) iblockdata.get(BlockFenceGate.OPEN)).booleanValue()) {
            iblockdata = iblockdata.set(BlockFenceGate.OPEN, Boolean.valueOf(false));
            world.setTypeAndData(blockposition, iblockdata, 2);
        } else {
            EnumDirection enumdirection1 = EnumDirection.fromAngle((double) entityhuman.yaw);

            if (iblockdata.get(BlockFenceGate.FACING) == enumdirection1.opposite()) {
                iblockdata = iblockdata.set(BlockFenceGate.FACING, enumdirection1);
            }

            iblockdata = iblockdata.set(BlockFenceGate.OPEN, Boolean.valueOf(true));
            world.setTypeAndData(blockposition, iblockdata, 2);
        }

        world.a(entityhuman, ((Boolean) iblockdata.get(BlockFenceGate.OPEN)).booleanValue() ? 1003 : 1006, blockposition, 0);
        return true;
    }

    public void doPhysics(World world, BlockPosition blockposition, IBlockData iblockdata, Block block) {
        if (!world.isClientSide) {
            boolean flag = world.isBlockIndirectlyPowered(blockposition);

            if (flag || block.isPowerSource()) {
                if (flag && !((Boolean) iblockdata.get(BlockFenceGate.OPEN)).booleanValue() && !((Boolean) iblockdata.get(BlockFenceGate.POWERED)).booleanValue()) {
                    world.setTypeAndData(blockposition, iblockdata.set(BlockFenceGate.OPEN, Boolean.valueOf(true)).set(BlockFenceGate.POWERED, Boolean.valueOf(true)), 2);
                    world.a((EntityHuman) null, 1003, blockposition, 0);
                } else if (!flag && ((Boolean) iblockdata.get(BlockFenceGate.OPEN)).booleanValue() && ((Boolean) iblockdata.get(BlockFenceGate.POWERED)).booleanValue()) {
                    world.setTypeAndData(blockposition, iblockdata.set(BlockFenceGate.OPEN, Boolean.valueOf(false)).set(BlockFenceGate.POWERED, Boolean.valueOf(false)), 2);
                    world.a((EntityHuman) null, 1006, blockposition, 0);
                } else if (flag != ((Boolean) iblockdata.get(BlockFenceGate.POWERED)).booleanValue()) {
                    world.setTypeAndData(blockposition, iblockdata.set(BlockFenceGate.POWERED, Boolean.valueOf(flag)), 2);
                }
            }

        }
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockFenceGate.FACING, EnumDirection.fromType2(i)).set(BlockFenceGate.OPEN, Boolean.valueOf((i & 4) != 0)).set(BlockFenceGate.POWERED, Boolean.valueOf((i & 8) != 0));
    }

    public int toLegacyData(IBlockData iblockdata) {
        byte b0 = 0;
        int i = b0 | ((EnumDirection) iblockdata.get(BlockFenceGate.FACING)).b();

        if (((Boolean) iblockdata.get(BlockFenceGate.POWERED)).booleanValue()) {
            i |= 8;
        }

        if (((Boolean) iblockdata.get(BlockFenceGate.OPEN)).booleanValue()) {
            i |= 4;
        }

        return i;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockFenceGate.FACING, BlockFenceGate.OPEN, BlockFenceGate.POWERED, BlockFenceGate.IN_WALL});
    }
}
