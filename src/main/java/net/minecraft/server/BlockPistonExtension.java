package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class BlockPistonExtension extends Block {

    public static final BlockStateDirection FACING = BlockStateDirection.of("facing");
    public static final BlockStateEnum<BlockPistonExtension.EnumPistonType> TYPE = BlockStateEnum.of("type", BlockPistonExtension.EnumPistonType.class);
    public static final BlockStateBoolean SHORT = BlockStateBoolean.of("short");

    public BlockPistonExtension() {
        super(Material.PISTON);
        this.j(this.blockStateList.getBlockData().set(BlockPistonExtension.FACING, EnumDirection.NORTH).set(BlockPistonExtension.TYPE, BlockPistonExtension.EnumPistonType.DEFAULT).set(BlockPistonExtension.SHORT, Boolean.valueOf(false)));
        this.a(BlockPistonExtension.i);
        this.c(0.5F);
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman) {
        if (entityhuman.abilities.canInstantlyBuild) {
            EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockPistonExtension.FACING);

            if (enumdirection != null) {
                BlockPosition blockposition1 = blockposition.shift(enumdirection.opposite());
                Block block = world.getType(blockposition1).getBlock();

                if (block == Blocks.PISTON || block == Blocks.STICKY_PISTON) {
                    world.setAir(blockposition1);
                }
            }
        }

        super.a(world, blockposition, iblockdata, entityhuman);
    }

    public void remove(World world, BlockPosition blockposition, IBlockData iblockdata) {
        super.remove(world, blockposition, iblockdata);
        EnumDirection enumdirection = ((EnumDirection) iblockdata.get(BlockPistonExtension.FACING)).opposite();

        blockposition = blockposition.shift(enumdirection);
        IBlockData iblockdata1 = world.getType(blockposition);

        if ((iblockdata1.getBlock() == Blocks.PISTON || iblockdata1.getBlock() == Blocks.STICKY_PISTON) && ((Boolean) iblockdata1.get(BlockPiston.EXTENDED)).booleanValue()) {
            iblockdata1.getBlock().b(world, blockposition, iblockdata1, 0);
            world.setAir(blockposition);
        }

    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean canPlace(World world, BlockPosition blockposition) {
        return false;
    }

    public boolean canPlace(World world, BlockPosition blockposition, EnumDirection enumdirection) {
        return false;
    }

    public int a(Random random) {
        return 0;
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, AxisAlignedBB axisalignedbb, List<AxisAlignedBB> list, Entity entity) {
        this.d(iblockdata);
        super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        this.e(iblockdata);
        super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    private void e(IBlockData iblockdata) {
        float f = 0.25F;
        float f1 = 0.375F;
        float f2 = 0.625F;
        float f3 = 0.25F;
        float f4 = 0.75F;

        switch (BlockPistonExtension.SyntheticClass_1.a[((EnumDirection) iblockdata.get(BlockPistonExtension.FACING)).ordinal()]) {
        case 1:
            this.a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
            break;

        case 2:
            this.a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
            break;

        case 3:
            this.a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
            break;

        case 4:
            this.a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
            break;

        case 5:
            this.a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
            break;

        case 6:
            this.a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
        }

    }

    public void updateShape(IBlockAccess iblockaccess, BlockPosition blockposition) {
        this.d(iblockaccess.getType(blockposition));
    }

    public void d(IBlockData iblockdata) {
        float f = 0.25F;
        EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockPistonExtension.FACING);

        if (enumdirection != null) {
            switch (BlockPistonExtension.SyntheticClass_1.a[enumdirection.ordinal()]) {
            case 1:
                this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
                break;

            case 2:
                this.a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
                break;

            case 3:
                this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
                break;

            case 4:
                this.a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
                break;

            case 5:
                this.a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
                break;

            case 6:
                this.a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }

        }
    }

    public void doPhysics(World world, BlockPosition blockposition, IBlockData iblockdata, Block block) {
        EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockPistonExtension.FACING);
        BlockPosition blockposition1 = blockposition.shift(enumdirection.opposite());
        IBlockData iblockdata1 = world.getType(blockposition1);

        if (iblockdata1.getBlock() != Blocks.PISTON && iblockdata1.getBlock() != Blocks.STICKY_PISTON) {
            world.setAir(blockposition);
        } else {
            iblockdata1.getBlock().doPhysics(world, blockposition1, iblockdata1, block);
        }

    }

    public static EnumDirection b(int i) {
        int j = i & 7;

        return j > 5 ? null : EnumDirection.fromType1(j);
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockPistonExtension.FACING, b(i)).set(BlockPistonExtension.TYPE, (i & 8) > 0 ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
    }

    public int toLegacyData(IBlockData iblockdata) {
        byte b0 = 0;
        int i = b0 | ((EnumDirection) iblockdata.get(BlockPistonExtension.FACING)).a();

        if (iblockdata.get(BlockPistonExtension.TYPE) == BlockPistonExtension.EnumPistonType.STICKY) {
            i |= 8;
        }

        return i;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockPistonExtension.FACING, BlockPistonExtension.TYPE, BlockPistonExtension.SHORT});
    }

    static class SyntheticClass_1 {

        static final int[] a = new int[EnumDirection.values().length];

        static {
            try {
                BlockPistonExtension.SyntheticClass_1.a[EnumDirection.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
                BlockPistonExtension.SyntheticClass_1.a[EnumDirection.UP.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

            try {
                BlockPistonExtension.SyntheticClass_1.a[EnumDirection.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError nosuchfielderror2) {
                ;
            }

            try {
                BlockPistonExtension.SyntheticClass_1.a[EnumDirection.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError nosuchfielderror3) {
                ;
            }

            try {
                BlockPistonExtension.SyntheticClass_1.a[EnumDirection.WEST.ordinal()] = 5;
            } catch (NoSuchFieldError nosuchfielderror4) {
                ;
            }

            try {
                BlockPistonExtension.SyntheticClass_1.a[EnumDirection.EAST.ordinal()] = 6;
            } catch (NoSuchFieldError nosuchfielderror5) {
                ;
            }

        }
    }

    public static enum EnumPistonType implements INamable {

        DEFAULT("normal"), STICKY("sticky");

        private final String c;

        private EnumPistonType(String s) {
            this.c = s;
        }

        public String toString() {
            return this.c;
        }

        public String getName() {
            return this.c;
        }
    }
}
