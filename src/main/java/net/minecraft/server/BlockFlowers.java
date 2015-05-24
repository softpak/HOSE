package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;

public abstract class BlockFlowers extends BlockPlant {

    protected BlockStateEnum<BlockFlowers.EnumFlowerVarient> TYPE;

    protected BlockFlowers() {
        this.j(this.blockStateList.getBlockData().set(this.n(), this.l() == BlockFlowers.EnumFlowerType.RED ? BlockFlowers.EnumFlowerVarient.POPPY : BlockFlowers.EnumFlowerVarient.DANDELION));
    }

    public int getDropData(IBlockData iblockdata) {
        return ((BlockFlowers.EnumFlowerVarient) iblockdata.get(this.n())).b();
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(this.n(), BlockFlowers.EnumFlowerVarient.a(this.l(), i));
    }

    public abstract BlockFlowers.EnumFlowerType l();

    public IBlockState<BlockFlowers.EnumFlowerVarient> n() {
        if (this.TYPE == null) {
            this.TYPE = BlockStateEnum.a("type", BlockFlowers.EnumFlowerVarient.class, new Predicate() {
                public boolean a(BlockFlowers.EnumFlowerVarient blockflowers_enumflowervarient) {
                    return blockflowers_enumflowervarient.a() == BlockFlowers.this.l();
                }

                public boolean apply(Object object) {
                    return this.a((BlockFlowers.EnumFlowerVarient) object);
                }
            });
        }

        return this.TYPE;
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((BlockFlowers.EnumFlowerVarient) iblockdata.get(this.n())).b();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { this.n()});
    }

    public static enum EnumFlowerVarient implements INamable {

        DANDELION(BlockFlowers.EnumFlowerType.YELLOW, 0, "dandelion"), POPPY(BlockFlowers.EnumFlowerType.RED, 0, "poppy"), BLUE_ORCHID(BlockFlowers.EnumFlowerType.RED, 1, "blue_orchid", "blueOrchid"), ALLIUM(BlockFlowers.EnumFlowerType.RED, 2, "allium"), HOUSTONIA(BlockFlowers.EnumFlowerType.RED, 3, "houstonia"), RED_TULIP(BlockFlowers.EnumFlowerType.RED, 4, "red_tulip", "tulipRed"), ORANGE_TULIP(BlockFlowers.EnumFlowerType.RED, 5, "orange_tulip", "tulipOrange"), WHITE_TULIP(BlockFlowers.EnumFlowerType.RED, 6, "white_tulip", "tulipWhite"), PINK_TULIP(BlockFlowers.EnumFlowerType.RED, 7, "pink_tulip", "tulipPink"), OXEYE_DAISY(BlockFlowers.EnumFlowerType.RED, 8, "oxeye_daisy", "oxeyeDaisy");

        private static final BlockFlowers.EnumFlowerVarient[][] k = new BlockFlowers.EnumFlowerVarient[BlockFlowers.EnumFlowerType.values().length][];
        private final BlockFlowers.EnumFlowerType l;
        private final int m;
        private final String n;
        private final String o;

        private EnumFlowerVarient(BlockFlowers.EnumFlowerType blockflowers_enumflowertype, int i, String s) {
            this(blockflowers_enumflowertype, i, s, s);
        }

        private EnumFlowerVarient(BlockFlowers.EnumFlowerType blockflowers_enumflowertype, int i, String s, String s1) {
            this.l = blockflowers_enumflowertype;
            this.m = i;
            this.n = s;
            this.o = s1;
        }

        public BlockFlowers.EnumFlowerType a() {
            return this.l;
        }

        public int b() {
            return this.m;
        }

        public static BlockFlowers.EnumFlowerVarient a(BlockFlowers.EnumFlowerType blockflowers_enumflowertype, int i) {
            BlockFlowers.EnumFlowerVarient[] ablockflowers_enumflowervarient = BlockFlowers.EnumFlowerVarient.k[blockflowers_enumflowertype.ordinal()];

            if (i < 0 || i >= ablockflowers_enumflowervarient.length) {
                i = 0;
            }

            return ablockflowers_enumflowervarient[i];
        }

        public String toString() {
            return this.n;
        }

        public String getName() {
            return this.n;
        }

        public String d() {
            return this.o;
        }

        static {
            BlockFlowers.EnumFlowerType[] ablockflowers_enumflowertype = BlockFlowers.EnumFlowerType.values();
            int i = ablockflowers_enumflowertype.length;

            for (int j = 0; j < i; ++j) {
                final BlockFlowers.EnumFlowerType blockflowers_enumflowertype = ablockflowers_enumflowertype[j];
                Collection collection = Collections2.filter(Lists.newArrayList(values()), new Predicate() {
                    public boolean a(BlockFlowers.EnumFlowerVarient blockflowers_enumflowervarient) {
                        return blockflowers_enumflowervarient.a() == blockflowers_enumflowertype;
                    }

                    public boolean apply(Object object) {
                        return this.a((BlockFlowers.EnumFlowerVarient) object);
                    }
                });

                BlockFlowers.EnumFlowerVarient.k[blockflowers_enumflowertype.ordinal()] = (BlockFlowers.EnumFlowerVarient[]) collection.toArray(new BlockFlowers.EnumFlowerVarient[collection.size()]);
            }

        }
    }

    public static enum EnumFlowerType {

        YELLOW, RED;

        private EnumFlowerType() {}

        public BlockFlowers a() {
            return this == BlockFlowers.EnumFlowerType.YELLOW ? Blocks.YELLOW_FLOWER : Blocks.RED_FLOWER;
        }
    }
}
