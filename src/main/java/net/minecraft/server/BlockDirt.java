package net.minecraft.server;

public class BlockDirt extends Block {

    public static final BlockStateEnum<BlockDirt.EnumDirtVariant> VARIANT = BlockStateEnum.of("variant", BlockDirt.EnumDirtVariant.class);
    public static final BlockStateBoolean SNOWY = BlockStateBoolean.of("snowy");

    protected BlockDirt() {
        super(Material.EARTH);
        this.j(this.blockStateList.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.DIRT).set(BlockDirt.SNOWY, Boolean.valueOf(false)));
        this.a(CreativeModeTab.b);
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return ((BlockDirt.EnumDirtVariant) iblockdata.get(BlockDirt.VARIANT)).d();
    }

    public IBlockData updateState(IBlockData iblockdata, IBlockAccess iblockaccess, BlockPosition blockposition) {
        if (iblockdata.get(BlockDirt.VARIANT) == BlockDirt.EnumDirtVariant.PODZOL) {
            Block block = iblockaccess.getType(blockposition.up()).getBlock();

            iblockdata = iblockdata.set(BlockDirt.SNOWY, Boolean.valueOf(block == Blocks.SNOW || block == Blocks.SNOW_LAYER));
        }

        return iblockdata;
    }

    public int getDropData(World world, BlockPosition blockposition) {
        IBlockData iblockdata = world.getType(blockposition);

        return iblockdata.getBlock() != this ? 0 : ((BlockDirt.EnumDirtVariant) iblockdata.get(BlockDirt.VARIANT)).a();
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.a(i));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((BlockDirt.EnumDirtVariant) iblockdata.get(BlockDirt.VARIANT)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockDirt.VARIANT, BlockDirt.SNOWY});
    }

    public int getDropData(IBlockData iblockdata) {
        BlockDirt.EnumDirtVariant blockdirt_enumdirtvariant = (BlockDirt.EnumDirtVariant) iblockdata.get(BlockDirt.VARIANT);

        if (blockdirt_enumdirtvariant == BlockDirt.EnumDirtVariant.PODZOL) {
            blockdirt_enumdirtvariant = BlockDirt.EnumDirtVariant.DIRT;
        }

        return blockdirt_enumdirtvariant.a();
    }

    public static enum EnumDirtVariant implements INamable {

        DIRT(0, "dirt", "default", MaterialMapColor.l), COARSE_DIRT(1, "coarse_dirt", "coarse", MaterialMapColor.l), PODZOL(2, "podzol", MaterialMapColor.J);

        private static final BlockDirt.EnumDirtVariant[] d = new BlockDirt.EnumDirtVariant[values().length];
        private final int e;
        private final String f;
        private final String g;
        private final MaterialMapColor h;

        private EnumDirtVariant(int i, String s, MaterialMapColor materialmapcolor) {
            this(i, s, s, materialmapcolor);
        }

        private EnumDirtVariant(int i, String s, String s1, MaterialMapColor materialmapcolor) {
            this.e = i;
            this.f = s;
            this.g = s1;
            this.h = materialmapcolor;
        }

        public int a() {
            return this.e;
        }

        public String c() {
            return this.g;
        }

        public MaterialMapColor d() {
            return this.h;
        }

        public String toString() {
            return this.f;
        }

        public static BlockDirt.EnumDirtVariant a(int i) {
            if (i < 0 || i >= BlockDirt.EnumDirtVariant.d.length) {
                i = 0;
            }

            return BlockDirt.EnumDirtVariant.d[i];
        }

        public String getName() {
            return this.f;
        }

        static {
            BlockDirt.EnumDirtVariant[] ablockdirt_enumdirtvariant = values();
            int i = ablockdirt_enumdirtvariant.length;

            for (int j = 0; j < i; ++j) {
                BlockDirt.EnumDirtVariant blockdirt_enumdirtvariant = ablockdirt_enumdirtvariant[j];

                BlockDirt.EnumDirtVariant.d[blockdirt_enumdirtvariant.a()] = blockdirt_enumdirtvariant;
            }

        }
    }
}
