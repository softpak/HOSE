package net.minecraft.server;

public class BlockSand extends BlockFalling {

    public static final BlockStateEnum<BlockSand.EnumSandVariant> VARIANT = BlockStateEnum.of("variant", BlockSand.EnumSandVariant.class);

    public BlockSand() {
        this.j(this.blockStateList.getBlockData().set(BlockSand.VARIANT, BlockSand.EnumSandVariant.SAND));
    }

    public int getDropData(IBlockData iblockdata) {
        return ((BlockSand.EnumSandVariant) iblockdata.get(BlockSand.VARIANT)).a();
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return ((BlockSand.EnumSandVariant) iblockdata.get(BlockSand.VARIANT)).c();
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockSand.VARIANT, BlockSand.EnumSandVariant.a(i));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((BlockSand.EnumSandVariant) iblockdata.get(BlockSand.VARIANT)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockSand.VARIANT});
    }

    public static enum EnumSandVariant implements INamable {

        SAND(0, "sand", "default", MaterialMapColor.d), RED_SAND(1, "red_sand", "red", MaterialMapColor.q);

        private static final BlockSand.EnumSandVariant[] c = new BlockSand.EnumSandVariant[values().length];
        private final int d;
        private final String e;
        private final MaterialMapColor f;
        private final String g;

        private EnumSandVariant(int i, String s, String s1, MaterialMapColor materialmapcolor) {
            this.d = i;
            this.e = s;
            this.f = materialmapcolor;
            this.g = s1;
        }

        public int a() {
            return this.d;
        }

        public String toString() {
            return this.e;
        }

        public MaterialMapColor c() {
            return this.f;
        }

        public static BlockSand.EnumSandVariant a(int i) {
            if (i < 0 || i >= BlockSand.EnumSandVariant.c.length) {
                i = 0;
            }

            return BlockSand.EnumSandVariant.c[i];
        }

        public String getName() {
            return this.e;
        }

        public String d() {
            return this.g;
        }

        static {
            BlockSand.EnumSandVariant[] ablocksand_enumsandvariant = values();
            int i = ablocksand_enumsandvariant.length;

            for (int j = 0; j < i; ++j) {
                BlockSand.EnumSandVariant blocksand_enumsandvariant = ablocksand_enumsandvariant[j];

                BlockSand.EnumSandVariant.c[blocksand_enumsandvariant.a()] = blocksand_enumsandvariant;
            }

        }
    }
}
