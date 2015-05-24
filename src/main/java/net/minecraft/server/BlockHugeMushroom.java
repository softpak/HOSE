package net.minecraft.server;

import java.util.Random;

public class BlockHugeMushroom extends Block {

    public static final BlockStateEnum<BlockHugeMushroom.EnumHugeMushroomVariant> VARIANT = BlockStateEnum.of("variant", BlockHugeMushroom.EnumHugeMushroomVariant.class);
    private final Block b;

    public BlockHugeMushroom(Material material, MaterialMapColor materialmapcolor, Block block) {
        super(material, materialmapcolor);
        this.j(this.blockStateList.getBlockData().set(BlockHugeMushroom.VARIANT, BlockHugeMushroom.EnumHugeMushroomVariant.ALL_OUTSIDE));
        this.b = block;
    }

    public int a(Random random) {
        return Math.max(0, random.nextInt(10) - 7);
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        switch (BlockHugeMushroom.SyntheticClass_1.a[((BlockHugeMushroom.EnumHugeMushroomVariant) iblockdata.get(BlockHugeMushroom.VARIANT)).ordinal()]) {
        case 1:
            return MaterialMapColor.e;

        case 2:
            return MaterialMapColor.d;

        case 3:
            return MaterialMapColor.d;

        default:
            return super.g(iblockdata);
        }
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Item.getItemOf(this.b);
    }

    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        return this.getBlockData();
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockHugeMushroom.VARIANT, BlockHugeMushroom.EnumHugeMushroomVariant.a(i));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((BlockHugeMushroom.EnumHugeMushroomVariant) iblockdata.get(BlockHugeMushroom.VARIANT)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockHugeMushroom.VARIANT});
    }

    static class SyntheticClass_1 {

        static final int[] a = new int[BlockHugeMushroom.EnumHugeMushroomVariant.values().length];

        static {
            try {
                BlockHugeMushroom.SyntheticClass_1.a[BlockHugeMushroom.EnumHugeMushroomVariant.ALL_STEM.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
                BlockHugeMushroom.SyntheticClass_1.a[BlockHugeMushroom.EnumHugeMushroomVariant.ALL_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

            try {
                BlockHugeMushroom.SyntheticClass_1.a[BlockHugeMushroom.EnumHugeMushroomVariant.STEM.ordinal()] = 3;
            } catch (NoSuchFieldError nosuchfielderror2) {
                ;
            }

        }
    }

    public static enum EnumHugeMushroomVariant implements INamable {

        NORTH_WEST(1, "north_west"), NORTH(2, "north"), NORTH_EAST(3, "north_east"), WEST(4, "west"), CENTER(5, "center"), EAST(6, "east"), SOUTH_WEST(7, "south_west"), SOUTH(8, "south"), SOUTH_EAST(9, "south_east"), STEM(10, "stem"), ALL_INSIDE(0, "all_inside"), ALL_OUTSIDE(14, "all_outside"), ALL_STEM(15, "all_stem");

        private static final BlockHugeMushroom.EnumHugeMushroomVariant[] n = new BlockHugeMushroom.EnumHugeMushroomVariant[16];
        private final int o;
        private final String p;

        private EnumHugeMushroomVariant(int i, String s) {
            this.o = i;
            this.p = s;
        }

        public int a() {
            return this.o;
        }

        public String toString() {
            return this.p;
        }

        public static BlockHugeMushroom.EnumHugeMushroomVariant a(int i) {
            if (i < 0 || i >= BlockHugeMushroom.EnumHugeMushroomVariant.n.length) {
                i = 0;
            }

            BlockHugeMushroom.EnumHugeMushroomVariant blockhugemushroom_enumhugemushroomvariant = BlockHugeMushroom.EnumHugeMushroomVariant.n[i];

            return blockhugemushroom_enumhugemushroomvariant == null ? BlockHugeMushroom.EnumHugeMushroomVariant.n[0] : blockhugemushroom_enumhugemushroomvariant;
        }

        public String getName() {
            return this.p;
        }

        static {
            BlockHugeMushroom.EnumHugeMushroomVariant[] ablockhugemushroom_enumhugemushroomvariant = values();
            int i = ablockhugemushroom_enumhugemushroomvariant.length;

            for (int j = 0; j < i; ++j) {
                BlockHugeMushroom.EnumHugeMushroomVariant blockhugemushroom_enumhugemushroomvariant = ablockhugemushroom_enumhugemushroomvariant[j];

                BlockHugeMushroom.EnumHugeMushroomVariant.n[blockhugemushroom_enumhugemushroomvariant.a()] = blockhugemushroom_enumhugemushroomvariant;
            }

        }
    }
}
