package net.minecraft.server;

public class BlockQuartz extends Block {

    public static final BlockStateEnum<BlockQuartz.EnumQuartzVariant> VARIANT = BlockStateEnum.of("variant", BlockQuartz.EnumQuartzVariant.class);

    public BlockQuartz() {
        super(Material.STONE);
        this.j(this.blockStateList.getBlockData().set(BlockQuartz.VARIANT, BlockQuartz.EnumQuartzVariant.DEFAULT));
        this.a(CreativeModeTab.b);
    }

    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        if (i == BlockQuartz.EnumQuartzVariant.LINES_Y.a()) {
            switch (BlockQuartz.SyntheticClass_1.a[enumdirection.k().ordinal()]) {
            case 1:
                return this.getBlockData().set(BlockQuartz.VARIANT, BlockQuartz.EnumQuartzVariant.LINES_Z);

            case 2:
                return this.getBlockData().set(BlockQuartz.VARIANT, BlockQuartz.EnumQuartzVariant.LINES_X);

            case 3:
            default:
                return this.getBlockData().set(BlockQuartz.VARIANT, BlockQuartz.EnumQuartzVariant.LINES_Y);
            }
        } else {
            return i == BlockQuartz.EnumQuartzVariant.CHISELED.a() ? this.getBlockData().set(BlockQuartz.VARIANT, BlockQuartz.EnumQuartzVariant.CHISELED) : this.getBlockData().set(BlockQuartz.VARIANT, BlockQuartz.EnumQuartzVariant.DEFAULT);
        }
    }

    public int getDropData(IBlockData iblockdata) {
        BlockQuartz.EnumQuartzVariant blockquartz_enumquartzvariant = (BlockQuartz.EnumQuartzVariant) iblockdata.get(BlockQuartz.VARIANT);

        return blockquartz_enumquartzvariant != BlockQuartz.EnumQuartzVariant.LINES_X && blockquartz_enumquartzvariant != BlockQuartz.EnumQuartzVariant.LINES_Z ? blockquartz_enumquartzvariant.a() : BlockQuartz.EnumQuartzVariant.LINES_Y.a();
    }

    protected ItemStack i(IBlockData iblockdata) {
        BlockQuartz.EnumQuartzVariant blockquartz_enumquartzvariant = (BlockQuartz.EnumQuartzVariant) iblockdata.get(BlockQuartz.VARIANT);

        return blockquartz_enumquartzvariant != BlockQuartz.EnumQuartzVariant.LINES_X && blockquartz_enumquartzvariant != BlockQuartz.EnumQuartzVariant.LINES_Z ? super.i(iblockdata) : new ItemStack(Item.getItemOf(this), 1, BlockQuartz.EnumQuartzVariant.LINES_Y.a());
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return MaterialMapColor.p;
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockQuartz.VARIANT, BlockQuartz.EnumQuartzVariant.a(i));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((BlockQuartz.EnumQuartzVariant) iblockdata.get(BlockQuartz.VARIANT)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockQuartz.VARIANT});
    }

    static class SyntheticClass_1 {

        static final int[] a = new int[EnumDirection.EnumAxis.values().length];

        static {
            try {
                BlockQuartz.SyntheticClass_1.a[EnumDirection.EnumAxis.Z.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
                BlockQuartz.SyntheticClass_1.a[EnumDirection.EnumAxis.X.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

            try {
                BlockQuartz.SyntheticClass_1.a[EnumDirection.EnumAxis.Y.ordinal()] = 3;
            } catch (NoSuchFieldError nosuchfielderror2) {
                ;
            }

        }
    }

    public static enum EnumQuartzVariant implements INamable {

        DEFAULT(0, "default", "default"), CHISELED(1, "chiseled", "chiseled"), LINES_Y(2, "lines_y", "lines"), LINES_X(3, "lines_x", "lines"), LINES_Z(4, "lines_z", "lines");

        private static final BlockQuartz.EnumQuartzVariant[] f = new BlockQuartz.EnumQuartzVariant[values().length];
        private final int g;
        private final String h;
        private final String i;

        private EnumQuartzVariant(int i, String s, String s1) {
            this.g = i;
            this.h = s;
            this.i = s1;
        }

        public int a() {
            return this.g;
        }

        public String toString() {
            return this.i;
        }

        public static BlockQuartz.EnumQuartzVariant a(int i) {
            if (i < 0 || i >= BlockQuartz.EnumQuartzVariant.f.length) {
                i = 0;
            }

            return BlockQuartz.EnumQuartzVariant.f[i];
        }

        public String getName() {
            return this.h;
        }

        static {
            BlockQuartz.EnumQuartzVariant[] ablockquartz_enumquartzvariant = values();
            int i = ablockquartz_enumquartzvariant.length;

            for (int j = 0; j < i; ++j) {
                BlockQuartz.EnumQuartzVariant blockquartz_enumquartzvariant = ablockquartz_enumquartzvariant[j];

                BlockQuartz.EnumQuartzVariant.f[blockquartz_enumquartzvariant.a()] = blockquartz_enumquartzvariant;
            }

        }
    }
}
