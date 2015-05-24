package net.minecraft.server;

import java.util.Random;

public class BlockStone extends Block {

    public static final BlockStateEnum<BlockStone.EnumStoneVariant> VARIANT = BlockStateEnum.of("variant", BlockStone.EnumStoneVariant.class);

    public BlockStone() {
        super(Material.STONE);
        this.j(this.blockStateList.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.STONE));
        this.a(CreativeModeTab.b);
    }

    public String getName() {
        return LocaleI18n.get(this.a() + "." + BlockStone.EnumStoneVariant.STONE.d() + ".name");
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return ((BlockStone.EnumStoneVariant) iblockdata.get(BlockStone.VARIANT)).c();
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return iblockdata.get(BlockStone.VARIANT) == BlockStone.EnumStoneVariant.STONE ? Item.getItemOf(Blocks.COBBLESTONE) : Item.getItemOf(Blocks.STONE);
    }

    public int getDropData(IBlockData iblockdata) {
        return ((BlockStone.EnumStoneVariant) iblockdata.get(BlockStone.VARIANT)).a();
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.a(i));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((BlockStone.EnumStoneVariant) iblockdata.get(BlockStone.VARIANT)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockStone.VARIANT});
    }

    public static enum EnumStoneVariant implements INamable {

        STONE(0, MaterialMapColor.m, "stone"), GRANITE(1, MaterialMapColor.l, "granite"), GRANITE_SMOOTH(2, MaterialMapColor.l, "smooth_granite", "graniteSmooth"), DIORITE(3, MaterialMapColor.p, "diorite"), DIORITE_SMOOTH(4, MaterialMapColor.p, "smooth_diorite", "dioriteSmooth"), ANDESITE(5, MaterialMapColor.m, "andesite"), ANDESITE_SMOOTH(6, MaterialMapColor.m, "smooth_andesite", "andesiteSmooth");

        private static final BlockStone.EnumStoneVariant[] h = new BlockStone.EnumStoneVariant[values().length];
        private final int i;
        private final String j;
        private final String k;
        private final MaterialMapColor l;

        private EnumStoneVariant(int i, MaterialMapColor materialmapcolor, String s) {
            this(i, materialmapcolor, s, s);
        }

        private EnumStoneVariant(int i, MaterialMapColor materialmapcolor, String s, String s1) {
            this.i = i;
            this.j = s;
            this.k = s1;
            this.l = materialmapcolor;
        }

        public int a() {
            return this.i;
        }

        public MaterialMapColor c() {
            return this.l;
        }

        public String toString() {
            return this.j;
        }

        public static BlockStone.EnumStoneVariant a(int i) {
            if (i < 0 || i >= BlockStone.EnumStoneVariant.h.length) {
                i = 0;
            }

            return BlockStone.EnumStoneVariant.h[i];
        }

        public String getName() {
            return this.j;
        }

        public String d() {
            return this.k;
        }

        static {
            BlockStone.EnumStoneVariant[] ablockstone_enumstonevariant = values();
            int i = ablockstone_enumstonevariant.length;

            for (int j = 0; j < i; ++j) {
                BlockStone.EnumStoneVariant blockstone_enumstonevariant = ablockstone_enumstonevariant[j];

                BlockStone.EnumStoneVariant.h[blockstone_enumstonevariant.a()] = blockstone_enumstonevariant;
            }

        }
    }
}
