package net.minecraft.server;

import com.google.common.base.Predicate;

public class BlockLog2 extends BlockLogAbstract {

    public static final BlockStateEnum<BlockWood.EnumLogVariant> VARIANT = BlockStateEnum.a("variant", BlockWood.EnumLogVariant.class, new Predicate() {
        public boolean a(BlockWood.EnumLogVariant blockwood_enumlogvariant) {
            return blockwood_enumlogvariant.a() >= 4;
        }

        public boolean apply(Object object) {
            return this.a((BlockWood.EnumLogVariant) object);
        }
    });

    public BlockLog2() {
        this.j(this.blockStateList.getBlockData().set(BlockLog2.VARIANT, BlockWood.EnumLogVariant.ACACIA).set(BlockLog2.AXIS, BlockLogAbstract.EnumLogRotation.Y));
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        BlockWood.EnumLogVariant blockwood_enumlogvariant = (BlockWood.EnumLogVariant) iblockdata.get(BlockLog2.VARIANT);

        switch (BlockLog2.SyntheticClass_1.b[((BlockLogAbstract.EnumLogRotation) iblockdata.get(BlockLog2.AXIS)).ordinal()]) {
        case 1:
        case 2:
        case 3:
        default:
            switch (BlockLog2.SyntheticClass_1.a[blockwood_enumlogvariant.ordinal()]) {
            case 1:
            default:
                return MaterialMapColor.m;

            case 2:
                return BlockWood.EnumLogVariant.DARK_OAK.c();
            }

        case 4:
            return blockwood_enumlogvariant.c();
        }
    }

    public IBlockData fromLegacyData(int i) {
        IBlockData iblockdata = this.getBlockData().set(BlockLog2.VARIANT, BlockWood.EnumLogVariant.a((i & 3) + 4));

        switch (i & 12) {
        case 0:
            iblockdata = iblockdata.set(BlockLog2.AXIS, BlockLogAbstract.EnumLogRotation.Y);
            break;

        case 4:
            iblockdata = iblockdata.set(BlockLog2.AXIS, BlockLogAbstract.EnumLogRotation.X);
            break;

        case 8:
            iblockdata = iblockdata.set(BlockLog2.AXIS, BlockLogAbstract.EnumLogRotation.Z);
            break;

        default:
            iblockdata = iblockdata.set(BlockLog2.AXIS, BlockLogAbstract.EnumLogRotation.NONE);
        }

        return iblockdata;
    }

    public int toLegacyData(IBlockData iblockdata) {
        byte b0 = 0;
        int i = b0 | ((BlockWood.EnumLogVariant) iblockdata.get(BlockLog2.VARIANT)).a() - 4;

        switch (BlockLog2.SyntheticClass_1.b[((BlockLogAbstract.EnumLogRotation) iblockdata.get(BlockLog2.AXIS)).ordinal()]) {
        case 1:
            i |= 4;
            break;

        case 2:
            i |= 8;
            break;

        case 3:
            i |= 12;
        }

        return i;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockLog2.VARIANT, BlockLog2.AXIS});
    }

    protected ItemStack i(IBlockData iblockdata) {
        return new ItemStack(Item.getItemOf(this), 1, ((BlockWood.EnumLogVariant) iblockdata.get(BlockLog2.VARIANT)).a() - 4);
    }

    public int getDropData(IBlockData iblockdata) {
        return ((BlockWood.EnumLogVariant) iblockdata.get(BlockLog2.VARIANT)).a() - 4;
    }

    static class SyntheticClass_1 {

        static final int[] a;
        static final int[] b = new int[BlockLogAbstract.EnumLogRotation.values().length];

        static {
            try {
                BlockLog2.SyntheticClass_1.b[BlockLogAbstract.EnumLogRotation.X.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
                BlockLog2.SyntheticClass_1.b[BlockLogAbstract.EnumLogRotation.Z.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

            try {
                BlockLog2.SyntheticClass_1.b[BlockLogAbstract.EnumLogRotation.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError nosuchfielderror2) {
                ;
            }

            try {
                BlockLog2.SyntheticClass_1.b[BlockLogAbstract.EnumLogRotation.Y.ordinal()] = 4;
            } catch (NoSuchFieldError nosuchfielderror3) {
                ;
            }

            a = new int[BlockWood.EnumLogVariant.values().length];

            try {
                BlockLog2.SyntheticClass_1.a[BlockWood.EnumLogVariant.ACACIA.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror4) {
                ;
            }

            try {
                BlockLog2.SyntheticClass_1.a[BlockWood.EnumLogVariant.DARK_OAK.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror5) {
                ;
            }

        }
    }
}
