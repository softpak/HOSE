package net.minecraft.server;

import java.util.Random;

public abstract class BlockDoubleStoneStepAbstract extends BlockStepAbstract {

    public static final BlockStateBoolean SEAMLESS = BlockStateBoolean.of("seamless");
    public static final BlockStateEnum<BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant> VARIANT = BlockStateEnum.of("variant", BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant.class);

    public BlockDoubleStoneStepAbstract() {
        super(Material.STONE);
        IBlockData iblockdata = this.blockStateList.getBlockData();

        if (this.l()) {
            iblockdata = iblockdata.set(BlockDoubleStoneStepAbstract.SEAMLESS, Boolean.valueOf(false));
        } else {
            iblockdata = iblockdata.set(BlockDoubleStoneStepAbstract.HALF, BlockStepAbstract.EnumSlabHalf.BOTTOM);
        }

        this.j(iblockdata.set(BlockDoubleStoneStepAbstract.VARIANT, BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant.RED_SANDSTONE));
        this.a(CreativeModeTab.b);
    }

    public String getName() {
        return LocaleI18n.get(this.a() + ".red_sandstone.name");
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Item.getItemOf(Blocks.STONE_SLAB2);
    }

    public String b(int i) {
        return super.a() + "." + BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant.a(i).d();
    }

    public IBlockState<?> n() {
        return BlockDoubleStoneStepAbstract.VARIANT;
    }

    public Object a(ItemStack itemstack) {
        return BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant.a(itemstack.getData() & 7);
    }

    public IBlockData fromLegacyData(int i) {
        IBlockData iblockdata = this.getBlockData().set(BlockDoubleStoneStepAbstract.VARIANT, BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant.a(i & 7));

        if (this.l()) {
            iblockdata = iblockdata.set(BlockDoubleStoneStepAbstract.SEAMLESS, Boolean.valueOf((i & 8) != 0));
        } else {
            iblockdata = iblockdata.set(BlockDoubleStoneStepAbstract.HALF, (i & 8) == 0 ? BlockStepAbstract.EnumSlabHalf.BOTTOM : BlockStepAbstract.EnumSlabHalf.TOP);
        }

        return iblockdata;
    }

    public int toLegacyData(IBlockData iblockdata) {
        byte b0 = 0;
        int i = b0 | ((BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant) iblockdata.get(BlockDoubleStoneStepAbstract.VARIANT)).a();

        if (this.l()) {
            if (((Boolean) iblockdata.get(BlockDoubleStoneStepAbstract.SEAMLESS)).booleanValue()) {
                i |= 8;
            }
        } else if (iblockdata.get(BlockDoubleStoneStepAbstract.HALF) == BlockStepAbstract.EnumSlabHalf.TOP) {
            i |= 8;
        }

        return i;
    }

    protected BlockStateList getStateList() {
        return this.l() ? new BlockStateList(this, new IBlockState[] { BlockDoubleStoneStepAbstract.SEAMLESS, BlockDoubleStoneStepAbstract.VARIANT}) : new BlockStateList(this, new IBlockState[] { BlockDoubleStoneStepAbstract.HALF, BlockDoubleStoneStepAbstract.VARIANT});
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return ((BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant) iblockdata.get(BlockDoubleStoneStepAbstract.VARIANT)).c();
    }

    public int getDropData(IBlockData iblockdata) {
        return ((BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant) iblockdata.get(BlockDoubleStoneStepAbstract.VARIANT)).a();
    }

    public static enum EnumStoneSlab2Variant implements INamable {

        RED_SANDSTONE(0, "red_sandstone", BlockSand.EnumSandVariant.RED_SAND.c());

        private static final BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant[] b = new BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant[values().length];
        private final int c;
        private final String d;
        private final MaterialMapColor e;

        private EnumStoneSlab2Variant(int i, String s, MaterialMapColor materialmapcolor) {
            this.c = i;
            this.d = s;
            this.e = materialmapcolor;
        }

        public int a() {
            return this.c;
        }

        public MaterialMapColor c() {
            return this.e;
        }

        public String toString() {
            return this.d;
        }

        public static BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant a(int i) {
            if (i < 0 || i >= BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant.b.length) {
                i = 0;
            }

            return BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant.b[i];
        }

        public String getName() {
            return this.d;
        }

        public String d() {
            return this.d;
        }

        static {
            BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant[] ablockdoublestonestepabstract_enumstoneslab2variant = values();
            int i = ablockdoublestonestepabstract_enumstoneslab2variant.length;

            for (int j = 0; j < i; ++j) {
                BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant blockdoublestonestepabstract_enumstoneslab2variant = ablockdoublestonestepabstract_enumstoneslab2variant[j];

                BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant.b[blockdoublestonestepabstract_enumstoneslab2variant.a()] = blockdoublestonestepabstract_enumstoneslab2variant;
            }

        }
    }
}
