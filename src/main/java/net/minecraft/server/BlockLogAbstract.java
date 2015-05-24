package net.minecraft.server;

import java.util.Iterator;

public abstract class BlockLogAbstract extends BlockRotatable {

    public static final BlockStateEnum<BlockLogAbstract.EnumLogRotation> AXIS = BlockStateEnum.of("axis", BlockLogAbstract.EnumLogRotation.class);

    public BlockLogAbstract() {
        super(Material.WOOD);
        this.a(CreativeModeTab.b);
        this.c(2.0F);
        this.a(BlockLogAbstract.f);
    }

    public void remove(World world, BlockPosition blockposition, IBlockData iblockdata) {
        byte b0 = 4;
        int i = b0 + 1;

        if (world.areChunksLoadedBetween(blockposition.a(-i, -i, -i), blockposition.a(i, i, i))) {
            Iterator iterator = BlockPosition.a(blockposition.a(-b0, -b0, -b0), blockposition.a(b0, b0, b0)).iterator();

            while (iterator.hasNext()) {
                BlockPosition blockposition1 = (BlockPosition) iterator.next();
                IBlockData iblockdata1 = world.getType(blockposition1);

                if (iblockdata1.getBlock().getMaterial() == Material.LEAVES && !((Boolean) iblockdata1.get(BlockLeaves.CHECK_DECAY)).booleanValue()) {
                    world.setTypeAndData(blockposition1, iblockdata1.set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(true)), 4);
                }
            }

        }
    }

    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        return super.getPlacedState(world, blockposition, enumdirection, f, f1, f2, i, entityliving).set(BlockLogAbstract.AXIS, BlockLogAbstract.EnumLogRotation.a(enumdirection.k()));
    }

    static class SyntheticClass_1 {

        static final int[] a = new int[EnumDirection.EnumAxis.values().length];

        static {
            try {
                BlockLogAbstract.SyntheticClass_1.a[EnumDirection.EnumAxis.X.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
                BlockLogAbstract.SyntheticClass_1.a[EnumDirection.EnumAxis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

            try {
                BlockLogAbstract.SyntheticClass_1.a[EnumDirection.EnumAxis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError nosuchfielderror2) {
                ;
            }

        }
    }

    public static enum EnumLogRotation implements INamable {

        X("x"), Y("y"), Z("z"), NONE("none");

        private final String e;

        private EnumLogRotation(String s) {
            this.e = s;
        }

        public String toString() {
            return this.e;
        }

        public static BlockLogAbstract.EnumLogRotation a(EnumDirection.EnumAxis enumdirection_enumaxis) {
            switch (BlockLogAbstract.SyntheticClass_1.a[enumdirection_enumaxis.ordinal()]) {
            case 1:
                return BlockLogAbstract.EnumLogRotation.X;

            case 2:
                return BlockLogAbstract.EnumLogRotation.Y;

            case 3:
                return BlockLogAbstract.EnumLogRotation.Z;

            default:
                return BlockLogAbstract.EnumLogRotation.NONE;
            }
        }

        public String getName() {
            return this.e;
        }
    }
}
