package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class WorldGenMineshaftPieces {

    private static final List<StructurePieceTreasure> a = Lists.newArrayList(new StructurePieceTreasure[] { new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 1, 3, 5), new StructurePieceTreasure(Items.REDSTONE, 0, 4, 9, 5), new StructurePieceTreasure(Items.DYE, EnumColor.BLUE.getInvColorIndex(), 4, 9, 5), new StructurePieceTreasure(Items.DIAMOND, 0, 1, 2, 3), new StructurePieceTreasure(Items.COAL, 0, 3, 8, 10), new StructurePieceTreasure(Items.BREAD, 0, 1, 3, 15), new StructurePieceTreasure(Items.IRON_PICKAXE, 0, 1, 1, 1), new StructurePieceTreasure(Item.getItemOf(Blocks.RAIL), 0, 4, 8, 1), new StructurePieceTreasure(Items.MELON_SEEDS, 0, 2, 4, 10), new StructurePieceTreasure(Items.PUMPKIN_SEEDS, 0, 2, 4, 10), new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 3), new StructurePieceTreasure(Items.IRON_HORSE_ARMOR, 0, 1, 1, 1)});

    public static void a() {
        WorldGenFactory.a(WorldGenMineshaftPieces.WorldGenMineshaftCorridor.class, "MSCorridor");
        WorldGenFactory.a(WorldGenMineshaftPieces.WorldGenMineshaftCross.class, "MSCrossing");
        WorldGenFactory.a(WorldGenMineshaftPieces.WorldGenMineshaftRoom.class, "MSRoom");
        WorldGenFactory.a(WorldGenMineshaftPieces.WorldGenMineshaftStairs.class, "MSStairs");
    }

    private static StructurePiece a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
        int i1 = random.nextInt(100);
        StructureBoundingBox structureboundingbox;

        if (i1 >= 80) {
            structureboundingbox = WorldGenMineshaftPieces.WorldGenMineshaftCross.a(list, random, i, j, k, enumdirection);
            if (structureboundingbox != null) {
                return new WorldGenMineshaftPieces.WorldGenMineshaftCross(l, random, structureboundingbox, enumdirection);
            }
        } else if (i1 >= 70) {
            structureboundingbox = WorldGenMineshaftPieces.WorldGenMineshaftStairs.a(list, random, i, j, k, enumdirection);
            if (structureboundingbox != null) {
                return new WorldGenMineshaftPieces.WorldGenMineshaftStairs(l, random, structureboundingbox, enumdirection);
            }
        } else {
            structureboundingbox = WorldGenMineshaftPieces.WorldGenMineshaftCorridor.a(list, random, i, j, k, enumdirection);
            if (structureboundingbox != null) {
                return new WorldGenMineshaftPieces.WorldGenMineshaftCorridor(l, random, structureboundingbox, enumdirection);
            }
        }

        return null;
    }

    private static StructurePiece b(StructurePiece structurepiece, List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
        if (l > 8) {
            return null;
        } else if (Math.abs(i - structurepiece.c().a) <= 80 && Math.abs(k - structurepiece.c().c) <= 80) {
            StructurePiece structurepiece1 = a(list, random, i, j, k, enumdirection, l + 1);

            if (structurepiece1 != null) {
                list.add(structurepiece1);
                structurepiece1.a(structurepiece, list, random);
            }

            return structurepiece1;
        } else {
            return null;
        }
    }

    static class SyntheticClass_1 {

        static final int[] a = new int[EnumDirection.values().length];

        static {
            try {
                WorldGenMineshaftPieces.SyntheticClass_1.a[EnumDirection.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
                WorldGenMineshaftPieces.SyntheticClass_1.a[EnumDirection.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

            try {
                WorldGenMineshaftPieces.SyntheticClass_1.a[EnumDirection.WEST.ordinal()] = 3;
            } catch (NoSuchFieldError nosuchfielderror2) {
                ;
            }

            try {
                WorldGenMineshaftPieces.SyntheticClass_1.a[EnumDirection.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError nosuchfielderror3) {
                ;
            }

        }
    }

    public static class WorldGenMineshaftStairs extends StructurePiece {

        public WorldGenMineshaftStairs() {}

        public WorldGenMineshaftStairs(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        protected void a(NBTTagCompound nbttagcompound) {}

        protected void b(NBTTagCompound nbttagcompound) {}

        public static StructureBoundingBox a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection) {
            StructureBoundingBox structureboundingbox = new StructureBoundingBox(i, j - 5, k, i, j + 2, k);

            switch (WorldGenMineshaftPieces.SyntheticClass_1.a[enumdirection.ordinal()]) {
            case 1:
                structureboundingbox.d = i + 2;
                structureboundingbox.c = k - 8;
                break;

            case 2:
                structureboundingbox.d = i + 2;
                structureboundingbox.f = k + 8;
                break;

            case 3:
                structureboundingbox.a = i - 8;
                structureboundingbox.f = k + 2;
                break;

            case 4:
                structureboundingbox.d = i + 8;
                structureboundingbox.f = k + 2;
            }

            return StructurePiece.a(list, structureboundingbox) != null ? null : structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            int i = this.d();

            if (this.m != null) {
                switch (WorldGenMineshaftPieces.SyntheticClass_1.a[this.m.ordinal()]) {
                case 1:
                    WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a, this.l.b, this.l.c - 1, EnumDirection.NORTH, i);
                    break;

                case 2:
                    WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a, this.l.b, this.l.f + 1, EnumDirection.SOUTH, i);
                    break;

                case 3:
                    WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a - 1, this.l.b, this.l.c, EnumDirection.WEST, i);
                    break;

                case 4:
                    WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d + 1, this.l.b, this.l.c, EnumDirection.EAST, i);
                }
            }

        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            if (this.a(world, structureboundingbox)) {
                return false;
            } else {
                this.a(world, structureboundingbox, 0, 5, 0, 2, 7, 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                this.a(world, structureboundingbox, 0, 0, 7, 2, 2, 8, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);

                for (int i = 0; i < 5; ++i) {
                    this.a(world, structureboundingbox, 0, 5 - i - (i < 4 ? 1 : 0), 2 + i, 2, 7 - i, 2 + i, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                }

                return true;
            }
        }
    }

    public static class WorldGenMineshaftCross extends StructurePiece {

        private EnumDirection a;
        private boolean b;

        public WorldGenMineshaftCross() {}

        protected void a(NBTTagCompound nbttagcompound) {
            nbttagcompound.setBoolean("tf", this.b);
            nbttagcompound.setInt("D", this.a.b());
        }

        protected void b(NBTTagCompound nbttagcompound) {
            this.b = nbttagcompound.getBoolean("tf");
            this.a = EnumDirection.fromType2(nbttagcompound.getInt("D"));
        }

        public WorldGenMineshaftCross(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.a = enumdirection;
            this.l = structureboundingbox;
            this.b = structureboundingbox.d() > 3;
        }

        public static StructureBoundingBox a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection) {
            StructureBoundingBox structureboundingbox = new StructureBoundingBox(i, j, k, i, j + 2, k);

            if (random.nextInt(4) == 0) {
                structureboundingbox.e += 4;
            }

            switch (WorldGenMineshaftPieces.SyntheticClass_1.a[enumdirection.ordinal()]) {
            case 1:
                structureboundingbox.a = i - 1;
                structureboundingbox.d = i + 3;
                structureboundingbox.c = k - 4;
                break;

            case 2:
                structureboundingbox.a = i - 1;
                structureboundingbox.d = i + 3;
                structureboundingbox.f = k + 4;
                break;

            case 3:
                structureboundingbox.a = i - 4;
                structureboundingbox.c = k - 1;
                structureboundingbox.f = k + 3;
                break;

            case 4:
                structureboundingbox.d = i + 4;
                structureboundingbox.c = k - 1;
                structureboundingbox.f = k + 3;
            }

            return StructurePiece.a(list, structureboundingbox) != null ? null : structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            int i = this.d();

            switch (WorldGenMineshaftPieces.SyntheticClass_1.a[this.a.ordinal()]) {
            case 1:
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a + 1, this.l.b, this.l.c - 1, EnumDirection.NORTH, i);
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a - 1, this.l.b, this.l.c + 1, EnumDirection.WEST, i);
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d + 1, this.l.b, this.l.c + 1, EnumDirection.EAST, i);
                break;

            case 2:
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a + 1, this.l.b, this.l.f + 1, EnumDirection.SOUTH, i);
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a - 1, this.l.b, this.l.c + 1, EnumDirection.WEST, i);
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d + 1, this.l.b, this.l.c + 1, EnumDirection.EAST, i);
                break;

            case 3:
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a + 1, this.l.b, this.l.c - 1, EnumDirection.NORTH, i);
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a + 1, this.l.b, this.l.f + 1, EnumDirection.SOUTH, i);
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a - 1, this.l.b, this.l.c + 1, EnumDirection.WEST, i);
                break;

            case 4:
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a + 1, this.l.b, this.l.c - 1, EnumDirection.NORTH, i);
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a + 1, this.l.b, this.l.f + 1, EnumDirection.SOUTH, i);
                WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d + 1, this.l.b, this.l.c + 1, EnumDirection.EAST, i);
            }

            if (this.b) {
                if (random.nextBoolean()) {
                    WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a + 1, this.l.b + 3 + 1, this.l.c - 1, EnumDirection.NORTH, i);
                }

                if (random.nextBoolean()) {
                    WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a - 1, this.l.b + 3 + 1, this.l.c + 1, EnumDirection.WEST, i);
                }

                if (random.nextBoolean()) {
                    WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d + 1, this.l.b + 3 + 1, this.l.c + 1, EnumDirection.EAST, i);
                }

                if (random.nextBoolean()) {
                    WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a + 1, this.l.b + 3 + 1, this.l.f + 1, EnumDirection.SOUTH, i);
                }
            }

        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            if (this.a(world, structureboundingbox)) {
                return false;
            } else {
                if (this.b) {
                    this.a(world, structureboundingbox, this.l.a + 1, this.l.b, this.l.c, this.l.d - 1, this.l.b + 3 - 1, this.l.f, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                    this.a(world, structureboundingbox, this.l.a, this.l.b, this.l.c + 1, this.l.d, this.l.b + 3 - 1, this.l.f - 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                    this.a(world, structureboundingbox, this.l.a + 1, this.l.e - 2, this.l.c, this.l.d - 1, this.l.e, this.l.f, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                    this.a(world, structureboundingbox, this.l.a, this.l.e - 2, this.l.c + 1, this.l.d, this.l.e, this.l.f - 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                    this.a(world, structureboundingbox, this.l.a + 1, this.l.b + 3, this.l.c + 1, this.l.d - 1, this.l.b + 3, this.l.f - 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                } else {
                    this.a(world, structureboundingbox, this.l.a + 1, this.l.b, this.l.c, this.l.d - 1, this.l.e, this.l.f, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                    this.a(world, structureboundingbox, this.l.a, this.l.b, this.l.c + 1, this.l.d, this.l.e, this.l.f - 1, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                }

                this.a(world, structureboundingbox, this.l.a + 1, this.l.b, this.l.c + 1, this.l.a + 1, this.l.e, this.l.c + 1, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
                this.a(world, structureboundingbox, this.l.a + 1, this.l.b, this.l.f - 1, this.l.a + 1, this.l.e, this.l.f - 1, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
                this.a(world, structureboundingbox, this.l.d - 1, this.l.b, this.l.c + 1, this.l.d - 1, this.l.e, this.l.c + 1, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
                this.a(world, structureboundingbox, this.l.d - 1, this.l.b, this.l.f - 1, this.l.d - 1, this.l.e, this.l.f - 1, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);

                for (int i = this.l.a; i <= this.l.d; ++i) {
                    for (int j = this.l.c; j <= this.l.f; ++j) {
                        if (this.a(world, i, this.l.b - 1, j, structureboundingbox).getBlock().getMaterial() == Material.AIR) {
                            this.a(world, Blocks.PLANKS.getBlockData(), i, this.l.b - 1, j, structureboundingbox);
                        }
                    }
                }

                return true;
            }
        }
    }

    public static class WorldGenMineshaftCorridor extends StructurePiece {

        private boolean a;
        private boolean b;
        private boolean c;
        private int d;

        public WorldGenMineshaftCorridor() {}

        protected void a(NBTTagCompound nbttagcompound) {
            nbttagcompound.setBoolean("hr", this.a);
            nbttagcompound.setBoolean("sc", this.b);
            nbttagcompound.setBoolean("hps", this.c);
            nbttagcompound.setInt("Num", this.d);
        }

        protected void b(NBTTagCompound nbttagcompound) {
            this.a = nbttagcompound.getBoolean("hr");
            this.b = nbttagcompound.getBoolean("sc");
            this.c = nbttagcompound.getBoolean("hps");
            this.d = nbttagcompound.getInt("Num");
        }

        public WorldGenMineshaftCorridor(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
            this.a = random.nextInt(3) == 0;
            this.b = !this.a && random.nextInt(23) == 0;
            if (this.m != EnumDirection.NORTH && this.m != EnumDirection.SOUTH) {
                this.d = structureboundingbox.c() / 5;
            } else {
                this.d = structureboundingbox.e() / 5;
            }

        }

        public static StructureBoundingBox a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection) {
            StructureBoundingBox structureboundingbox = new StructureBoundingBox(i, j, k, i, j + 2, k);

            int l;

            for (l = random.nextInt(3) + 2; l > 0; --l) {
                int i1 = l * 5;

                switch (WorldGenMineshaftPieces.SyntheticClass_1.a[enumdirection.ordinal()]) {
                case 1:
                    structureboundingbox.d = i + 2;
                    structureboundingbox.c = k - (i1 - 1);
                    break;

                case 2:
                    structureboundingbox.d = i + 2;
                    structureboundingbox.f = k + (i1 - 1);
                    break;

                case 3:
                    structureboundingbox.a = i - (i1 - 1);
                    structureboundingbox.f = k + 2;
                    break;

                case 4:
                    structureboundingbox.d = i + (i1 - 1);
                    structureboundingbox.f = k + 2;
                }

                if (StructurePiece.a(list, structureboundingbox) == null) {
                    break;
                }
            }

            return l > 0 ? structureboundingbox : null;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            int i = this.d();
            int j = random.nextInt(4);

            if (this.m != null) {
                switch (WorldGenMineshaftPieces.SyntheticClass_1.a[this.m.ordinal()]) {
                case 1:
                    if (j <= 1) {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a, this.l.b - 1 + random.nextInt(3), this.l.c - 1, this.m, i);
                    } else if (j == 2) {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a - 1, this.l.b - 1 + random.nextInt(3), this.l.c, EnumDirection.WEST, i);
                    } else {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d + 1, this.l.b - 1 + random.nextInt(3), this.l.c, EnumDirection.EAST, i);
                    }
                    break;

                case 2:
                    if (j <= 1) {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a, this.l.b - 1 + random.nextInt(3), this.l.f + 1, this.m, i);
                    } else if (j == 2) {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a - 1, this.l.b - 1 + random.nextInt(3), this.l.f - 3, EnumDirection.WEST, i);
                    } else {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d + 1, this.l.b - 1 + random.nextInt(3), this.l.f - 3, EnumDirection.EAST, i);
                    }
                    break;

                case 3:
                    if (j <= 1) {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a - 1, this.l.b - 1 + random.nextInt(3), this.l.c, this.m, i);
                    } else if (j == 2) {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a, this.l.b - 1 + random.nextInt(3), this.l.c - 1, EnumDirection.NORTH, i);
                    } else {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a, this.l.b - 1 + random.nextInt(3), this.l.f + 1, EnumDirection.SOUTH, i);
                    }
                    break;

                case 4:
                    if (j <= 1) {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d + 1, this.l.b - 1 + random.nextInt(3), this.l.c, this.m, i);
                    } else if (j == 2) {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d - 3, this.l.b - 1 + random.nextInt(3), this.l.c - 1, EnumDirection.NORTH, i);
                    } else {
                        WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d - 3, this.l.b - 1 + random.nextInt(3), this.l.f + 1, EnumDirection.SOUTH, i);
                    }
                }
            }

            if (i < 8) {
                int k;
                int l;

                if (this.m != EnumDirection.NORTH && this.m != EnumDirection.SOUTH) {
                    for (k = this.l.a + 3; k + 3 <= this.l.d; k += 5) {
                        l = random.nextInt(5);
                        if (l == 0) {
                            WorldGenMineshaftPieces.b(structurepiece, list, random, k, this.l.b, this.l.c - 1, EnumDirection.NORTH, i + 1);
                        } else if (l == 1) {
                            WorldGenMineshaftPieces.b(structurepiece, list, random, k, this.l.b, this.l.f + 1, EnumDirection.SOUTH, i + 1);
                        }
                    }
                } else {
                    for (k = this.l.c + 3; k + 3 <= this.l.f; k += 5) {
                        l = random.nextInt(5);
                        if (l == 0) {
                            WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a - 1, this.l.b, k, EnumDirection.WEST, i + 1);
                        } else if (l == 1) {
                            WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d + 1, this.l.b, k, EnumDirection.EAST, i + 1);
                        }
                    }
                }
            }

        }

        protected boolean a(World world, StructureBoundingBox structureboundingbox, Random random, int i, int j, int k, List<StructurePieceTreasure> list, int l) {
            BlockPosition blockposition = new BlockPosition(this.a(i, k), this.d(j), this.b(i, k));

            if (structureboundingbox.b((BaseBlockPosition) blockposition) && world.getType(blockposition).getBlock().getMaterial() == Material.AIR) {
                int i1 = random.nextBoolean() ? 1 : 0;

                world.setTypeAndData(blockposition, Blocks.RAIL.fromLegacyData(this.a(Blocks.RAIL, i1)), 2);
                EntityMinecartChest entityminecartchest = new EntityMinecartChest(world, (double) ((float) blockposition.getX() + 0.5F), (double) ((float) blockposition.getY() + 0.5F), (double) ((float) blockposition.getZ() + 0.5F));

                StructurePieceTreasure.a(random, list, (IInventory) entityminecartchest, l);
                world.addEntity(entityminecartchest);
                return true;
            } else {
                return false;
            }
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            if (this.a(world, structureboundingbox)) {
                return false;
            } else {
                boolean flag = false;
                boolean flag1 = true;
                boolean flag2 = false;
                boolean flag3 = true;
                int i = this.d * 5 - 1;

                this.a(world, structureboundingbox, 0, 0, 0, 2, 1, i, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                this.a(world, structureboundingbox, random, 0.8F, 0, 2, 0, 2, 2, i, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                if (this.b) {
                    this.a(world, structureboundingbox, random, 0.6F, 0, 0, 0, 2, 1, i, Blocks.WEB.getBlockData(), Blocks.AIR.getBlockData(), false);
                }

                int j;
                int k;

                for (j = 0; j < this.d; ++j) {
                    k = 2 + j * 5;
                    this.a(world, structureboundingbox, 0, 0, k, 0, 1, k, Blocks.FENCE.getBlockData(), Blocks.AIR.getBlockData(), false);
                    this.a(world, structureboundingbox, 2, 0, k, 2, 1, k, Blocks.FENCE.getBlockData(), Blocks.AIR.getBlockData(), false);
                    if (random.nextInt(4) == 0) {
                        this.a(world, structureboundingbox, 0, 2, k, 0, 2, k, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
                        this.a(world, structureboundingbox, 2, 2, k, 2, 2, k, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
                    } else {
                        this.a(world, structureboundingbox, 0, 2, k, 2, 2, k, Blocks.PLANKS.getBlockData(), Blocks.AIR.getBlockData(), false);
                    }

                    this.a(world, structureboundingbox, random, 0.1F, 0, 2, k - 1, Blocks.WEB.getBlockData());
                    this.a(world, structureboundingbox, random, 0.1F, 2, 2, k - 1, Blocks.WEB.getBlockData());
                    this.a(world, structureboundingbox, random, 0.1F, 0, 2, k + 1, Blocks.WEB.getBlockData());
                    this.a(world, structureboundingbox, random, 0.1F, 2, 2, k + 1, Blocks.WEB.getBlockData());
                    this.a(world, structureboundingbox, random, 0.05F, 0, 2, k - 2, Blocks.WEB.getBlockData());
                    this.a(world, structureboundingbox, random, 0.05F, 2, 2, k - 2, Blocks.WEB.getBlockData());
                    this.a(world, structureboundingbox, random, 0.05F, 0, 2, k + 2, Blocks.WEB.getBlockData());
                    this.a(world, structureboundingbox, random, 0.05F, 2, 2, k + 2, Blocks.WEB.getBlockData());
                    this.a(world, structureboundingbox, random, 0.05F, 1, 2, k - 1, Blocks.TORCH.fromLegacyData(EnumDirection.UP.a()));
                    this.a(world, structureboundingbox, random, 0.05F, 1, 2, k + 1, Blocks.TORCH.fromLegacyData(EnumDirection.UP.a()));
                    if (random.nextInt(100) == 0) {
                        this.a(world, structureboundingbox, random, 2, 0, k - 1, StructurePieceTreasure.a(WorldGenMineshaftPieces.a, new StructurePieceTreasure[] { Items.ENCHANTED_BOOK.b(random)}), 3 + random.nextInt(4));
                    }

                    if (random.nextInt(100) == 0) {
                        this.a(world, structureboundingbox, random, 0, 0, k + 1, StructurePieceTreasure.a(WorldGenMineshaftPieces.a, new StructurePieceTreasure[] { Items.ENCHANTED_BOOK.b(random)}), 3 + random.nextInt(4));
                    }

                    if (this.b && !this.c) {
                        int l = this.d(0);
                        int i1 = k - 1 + random.nextInt(3);
                        int j1 = this.a(1, i1);

                        i1 = this.b(1, i1);
                        BlockPosition blockposition = new BlockPosition(j1, l, i1);

                        if (structureboundingbox.b((BaseBlockPosition) blockposition)) {
                            this.c = true;
                            world.setTypeAndData(blockposition, Blocks.MOB_SPAWNER.getBlockData(), 2);
                            TileEntity tileentity = world.getTileEntity(blockposition);

                            if (tileentity instanceof TileEntityMobSpawner) {
                                ((TileEntityMobSpawner) tileentity).getSpawner().setMobName("CaveSpider");
                            }
                        }
                    }
                }

                for (j = 0; j <= 2; ++j) {
                    for (k = 0; k <= i; ++k) {
                        byte b0 = -1;
                        IBlockData iblockdata = this.a(world, j, b0, k, structureboundingbox);

                        if (iblockdata.getBlock().getMaterial() == Material.AIR) {
                            byte b1 = -1;

                            this.a(world, Blocks.PLANKS.getBlockData(), j, b1, k, structureboundingbox);
                        }
                    }
                }

                if (this.a) {
                    for (j = 0; j <= i; ++j) {
                        IBlockData iblockdata1 = this.a(world, 1, -1, j, structureboundingbox);

                        if (iblockdata1.getBlock().getMaterial() != Material.AIR && iblockdata1.getBlock().o()) {
                            this.a(world, structureboundingbox, random, 0.7F, 1, 0, j, Blocks.RAIL.fromLegacyData(this.a(Blocks.RAIL, 0)));
                        }
                    }
                }

                return true;
            }
        }
    }

    public static class WorldGenMineshaftRoom extends StructurePiece {

        private List<StructureBoundingBox> a = Lists.newLinkedList();

        public WorldGenMineshaftRoom() {}

        public WorldGenMineshaftRoom(int i, Random random, int j, int k) {
            super(i);
            this.l = new StructureBoundingBox(j, 50, k, j + 7 + random.nextInt(6), 54 + random.nextInt(6), k + 7 + random.nextInt(6));
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            int i = this.d();
            int j = this.l.d() - 3 - 1;

            if (j <= 0) {
                j = 1;
            }

            int k;
            StructurePiece structurepiece1;
            StructureBoundingBox structureboundingbox;

            for (k = 0; k < this.l.c(); k += 4) {
                k += random.nextInt(this.l.c());
                if (k + 3 > this.l.c()) {
                    break;
                }

                structurepiece1 = WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a + k, this.l.b + random.nextInt(j) + 1, this.l.c - 1, EnumDirection.NORTH, i);
                if (structurepiece1 != null) {
                    structureboundingbox = structurepiece1.c();
                    this.a.add(new StructureBoundingBox(structureboundingbox.a, structureboundingbox.b, this.l.c, structureboundingbox.d, structureboundingbox.e, this.l.c + 1));
                }
            }

            for (k = 0; k < this.l.c(); k += 4) {
                k += random.nextInt(this.l.c());
                if (k + 3 > this.l.c()) {
                    break;
                }

                structurepiece1 = WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a + k, this.l.b + random.nextInt(j) + 1, this.l.f + 1, EnumDirection.SOUTH, i);
                if (structurepiece1 != null) {
                    structureboundingbox = structurepiece1.c();
                    this.a.add(new StructureBoundingBox(structureboundingbox.a, structureboundingbox.b, this.l.f - 1, structureboundingbox.d, structureboundingbox.e, this.l.f));
                }
            }

            for (k = 0; k < this.l.e(); k += 4) {
                k += random.nextInt(this.l.e());
                if (k + 3 > this.l.e()) {
                    break;
                }

                structurepiece1 = WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.a - 1, this.l.b + random.nextInt(j) + 1, this.l.c + k, EnumDirection.WEST, i);
                if (structurepiece1 != null) {
                    structureboundingbox = structurepiece1.c();
                    this.a.add(new StructureBoundingBox(this.l.a, structureboundingbox.b, structureboundingbox.c, this.l.a + 1, structureboundingbox.e, structureboundingbox.f));
                }
            }

            for (k = 0; k < this.l.e(); k += 4) {
                k += random.nextInt(this.l.e());
                if (k + 3 > this.l.e()) {
                    break;
                }

                structurepiece1 = WorldGenMineshaftPieces.b(structurepiece, list, random, this.l.d + 1, this.l.b + random.nextInt(j) + 1, this.l.c + k, EnumDirection.EAST, i);
                if (structurepiece1 != null) {
                    structureboundingbox = structurepiece1.c();
                    this.a.add(new StructureBoundingBox(this.l.d - 1, structureboundingbox.b, structureboundingbox.c, this.l.d, structureboundingbox.e, structureboundingbox.f));
                }
            }

        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            if (this.a(world, structureboundingbox)) {
                return false;
            } else {
                this.a(world, structureboundingbox, this.l.a, this.l.b, this.l.c, this.l.d, this.l.b, this.l.f, Blocks.DIRT.getBlockData(), Blocks.AIR.getBlockData(), true);
                this.a(world, structureboundingbox, this.l.a, this.l.b + 1, this.l.c, this.l.d, Math.min(this.l.b + 3, this.l.e), this.l.f, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                Iterator iterator = this.a.iterator();

                while (iterator.hasNext()) {
                    StructureBoundingBox structureboundingbox1 = (StructureBoundingBox) iterator.next();

                    this.a(world, structureboundingbox, structureboundingbox1.a, structureboundingbox1.e - 2, structureboundingbox1.c, structureboundingbox1.d, structureboundingbox1.e, structureboundingbox1.f, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                }

                this.a(world, structureboundingbox, this.l.a, this.l.b + 4, this.l.c, this.l.d, this.l.e, this.l.f, Blocks.AIR.getBlockData(), false);
                return true;
            }
        }

        public void a(int i, int j, int k) {
            super.a(i, j, k);
            Iterator iterator = this.a.iterator();

            while (iterator.hasNext()) {
                StructureBoundingBox structureboundingbox = (StructureBoundingBox) iterator.next();

                structureboundingbox.a(i, j, k);
            }

        }

        protected void a(NBTTagCompound nbttagcompound) {
            NBTTagList nbttaglist = new NBTTagList();
            Iterator iterator = this.a.iterator();

            while (iterator.hasNext()) {
                StructureBoundingBox structureboundingbox = (StructureBoundingBox) iterator.next();

                nbttaglist.add(structureboundingbox.g());
            }

            nbttagcompound.set("Entrances", nbttaglist);
        }

        protected void b(NBTTagCompound nbttagcompound) {
            NBTTagList nbttaglist = nbttagcompound.getList("Entrances", 11);

            for (int i = 0; i < nbttaglist.size(); ++i) {
                this.a.add(new StructureBoundingBox(nbttaglist.c(i)));
            }

        }
    }
}
