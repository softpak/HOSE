package net.minecraft.server;

import com.google.common.base.Predicate;

public class BlockWallSign extends BlockSign {

    public static final BlockStateDirection FACING = BlockStateDirection.of("facing", (Predicate) EnumDirection.EnumDirectionLimit.HORIZONTAL);

    public BlockWallSign() {
        this.j(this.blockStateList.getBlockData().set(BlockWallSign.FACING, EnumDirection.NORTH));
    }

    public void updateShape(IBlockAccess iblockaccess, BlockPosition blockposition) {
        EnumDirection enumdirection = (EnumDirection) iblockaccess.getType(blockposition).get(BlockWallSign.FACING);
        float f = 0.28125F;
        float f1 = 0.78125F;
        float f2 = 0.0F;
        float f3 = 1.0F;
        float f4 = 0.125F;

        this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        switch (BlockWallSign.SyntheticClass_1.a[enumdirection.ordinal()]) {
        case 1:
            this.a(f2, f, 1.0F - f4, f3, f1, 1.0F);
            break;

        case 2:
            this.a(f2, f, 0.0F, f3, f1, f4);
            break;

        case 3:
            this.a(1.0F - f4, f, f2, 1.0F, f1, f3);
            break;

        case 4:
            this.a(0.0F, f, f2, f4, f1, f3);
        }

    }

    public void doPhysics(World world, BlockPosition blockposition, IBlockData iblockdata, Block block) {
        EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockWallSign.FACING);

        if (!world.getType(blockposition.shift(enumdirection.opposite())).getBlock().getMaterial().isBuildable()) {
            this.b(world, blockposition, iblockdata, 0);
            world.setAir(blockposition);
        }

        super.doPhysics(world, blockposition, iblockdata, block);
    }

    public IBlockData fromLegacyData(int i) {
        EnumDirection enumdirection = EnumDirection.fromType1(i);

        if (enumdirection.k() == EnumDirection.EnumAxis.Y) {
            enumdirection = EnumDirection.NORTH;
        }

        return this.getBlockData().set(BlockWallSign.FACING, enumdirection);
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((EnumDirection) iblockdata.get(BlockWallSign.FACING)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockWallSign.FACING});
    }

    static class SyntheticClass_1 {

        static final int[] a = new int[EnumDirection.values().length];

        static {
            try {
                BlockWallSign.SyntheticClass_1.a[EnumDirection.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
                BlockWallSign.SyntheticClass_1.a[EnumDirection.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

            try {
                BlockWallSign.SyntheticClass_1.a[EnumDirection.WEST.ordinal()] = 3;
            } catch (NoSuchFieldError nosuchfielderror2) {
                ;
            }

            try {
                BlockWallSign.SyntheticClass_1.a[EnumDirection.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError nosuchfielderror3) {
                ;
            }

        }
    }
}
