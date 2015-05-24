package net.minecraft.server;

public class BlockWood extends Block {

    public static final BlockStateEnum<BlockWood.EnumLogVariant> VARIANT = BlockStateEnum.of("variant", BlockWood.EnumLogVariant.class);

    public BlockWood() {
        super(Material.WOOD);
        this.j(this.blockStateList.getBlockData().set(BlockWood.VARIANT, BlockWood.EnumLogVariant.OAK));
        this.a(CreativeModeTab.b);
    }

    public int getDropData(IBlockData iblockdata) {
        return ((BlockWood.EnumLogVariant) iblockdata.get(BlockWood.VARIANT)).a();
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockWood.VARIANT, BlockWood.EnumLogVariant.a(i));
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return ((BlockWood.EnumLogVariant) iblockdata.get(BlockWood.VARIANT)).c();
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((BlockWood.EnumLogVariant) iblockdata.get(BlockWood.VARIANT)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockWood.VARIANT});
    }

    public static enum EnumLogVariant implements INamable {

        OAK(0, "oak", MaterialMapColor.o), SPRUCE(1, "spruce", MaterialMapColor.J), BIRCH(2, "birch", MaterialMapColor.d), JUNGLE(3, "jungle", MaterialMapColor.l), ACACIA(4, "acacia", MaterialMapColor.q), DARK_OAK(5, "dark_oak", "big_oak", MaterialMapColor.B);

        private static final BlockWood.EnumLogVariant[] g = new BlockWood.EnumLogVariant[values().length];
        private final int h;
        private final String i;
        private final String j;
        private final MaterialMapColor k;

        private EnumLogVariant(int i, String s, MaterialMapColor materialmapcolor) {
            this(i, s, s, materialmapcolor);
        }

        private EnumLogVariant(int i, String s, String s1, MaterialMapColor materialmapcolor) {
            this.h = i;
            this.i = s;
            this.j = s1;
            this.k = materialmapcolor;
        }

        public int a() {
            return this.h;
        }

        public MaterialMapColor c() {
            return this.k;
        }

        public String toString() {
            return this.i;
        }

        public static BlockWood.EnumLogVariant a(int i) {
            if (i < 0 || i >= BlockWood.EnumLogVariant.g.length) {
                i = 0;
            }

            return BlockWood.EnumLogVariant.g[i];
        }

        public String getName() {
            return this.i;
        }

        public String d() {
            return this.j;
        }

        static {
            BlockWood.EnumLogVariant[] ablockwood_enumlogvariant = values();
            int i = ablockwood_enumlogvariant.length;

            for (int j = 0; j < i; ++j) {
                BlockWood.EnumLogVariant blockwood_enumlogvariant = ablockwood_enumlogvariant[j];

                BlockWood.EnumLogVariant.g[blockwood_enumlogvariant.a()] = blockwood_enumlogvariant;
            }

        }
    }
}
