package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class WorldGenNetherPieces {

    private static final WorldGenNetherPieces.WorldGenNetherPieceWeight[] a = new WorldGenNetherPieces.WorldGenNetherPieceWeight[] { new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece3.class, 30, 0, true), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece1.class, 10, 4), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece13.class, 10, 4), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece14.class, 10, 3), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece12.class, 5, 2), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece6.class, 5, 1)};
    private static final WorldGenNetherPieces.WorldGenNetherPieceWeight[] b = new WorldGenNetherPieces.WorldGenNetherPieceWeight[] { new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece9.class, 25, 0, true), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece7.class, 15, 5), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece10.class, 5, 10), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece8.class, 5, 10), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece4.class, 10, 3, true), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece5.class, 7, 2), new WorldGenNetherPieces.WorldGenNetherPieceWeight(WorldGenNetherPieces.WorldGenNetherPiece11.class, 5, 2)};

    public static void a() {
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece1.class, "NeBCr");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece2.class, "NeBEF");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece3.class, "NeBS");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece4.class, "NeCCS");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece5.class, "NeCTB");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece6.class, "NeCE");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece7.class, "NeSCSC");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece8.class, "NeSCLT");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece9.class, "NeSC");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece10.class, "NeSCRT");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece11.class, "NeCSR");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece12.class, "NeMT");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece13.class, "NeRC");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece14.class, "NeSR");
        WorldGenFactory.a(WorldGenNetherPieces.WorldGenNetherPiece15.class, "NeStart");
    }

    private static WorldGenNetherPieces.WorldGenNetherPiece b(WorldGenNetherPieces.WorldGenNetherPieceWeight worldgennetherpieces_worldgennetherpieceweight, List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
        Class oclass = worldgennetherpieces_worldgennetherpieceweight.a;
        Object object = null;

        if (oclass == WorldGenNetherPieces.WorldGenNetherPiece3.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece3.a(list, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece1.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece1.a(list, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece13.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece13.a(list, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece14.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece14.a(list, random, i, j, k, l, enumdirection);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece12.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece12.a(list, random, i, j, k, l, enumdirection);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece6.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece6.a(list, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece9.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece9.a(list, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece10.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece10.a(list, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece8.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece8.a(list, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece4.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece4.a(list, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece5.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece5.a(list, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece7.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece7.a(list, random, i, j, k, enumdirection, l);
        } else if (oclass == WorldGenNetherPieces.WorldGenNetherPiece11.class) {
            object = WorldGenNetherPieces.WorldGenNetherPiece11.a(list, random, i, j, k, enumdirection, l);
        }

        return (WorldGenNetherPieces.WorldGenNetherPiece) object;
    }

    static class SyntheticClass_1 {

        static final int[] a = new int[EnumDirection.values().length];

        static {
            try {
                WorldGenNetherPieces.SyntheticClass_1.a[EnumDirection.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
                WorldGenNetherPieces.SyntheticClass_1.a[EnumDirection.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

            try {
                WorldGenNetherPieces.SyntheticClass_1.a[EnumDirection.WEST.ordinal()] = 3;
            } catch (NoSuchFieldError nosuchfielderror2) {
                ;
            }

            try {
                WorldGenNetherPieces.SyntheticClass_1.a[EnumDirection.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError nosuchfielderror3) {
                ;
            }

        }
    }

    public static class WorldGenNetherPiece5 extends WorldGenNetherPieces.WorldGenNetherPiece {

        public WorldGenNetherPiece5() {}

        public WorldGenNetherPiece5(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            byte b0 = 1;

            if (this.m == EnumDirection.WEST || this.m == EnumDirection.NORTH) {
                b0 = 5;
            }

            this.b((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 0, b0, random.nextInt(8) > 0);
            this.c((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 0, b0, random.nextInt(8) > 0);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece5 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -3, 0, 0, 9, 7, 9, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece5(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 0, 0, 8, 1, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 8, 5, 8, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 6, 0, 8, 6, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 2, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 2, 0, 8, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 3, 0, 1, 4, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 7, 3, 0, 7, 4, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 4, 8, 2, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 1, 4, 2, 2, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 1, 4, 7, 2, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 8, 8, 3, 8, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 6, 0, 3, 7, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 8, 3, 6, 8, 3, 7, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 4, 0, 5, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 8, 3, 4, 8, 5, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 3, 5, 2, 5, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 3, 5, 7, 5, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 4, 5, 1, 5, 5, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 7, 4, 5, 7, 5, 5, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);

            for (int i = 0; i <= 5; ++i) {
                for (int j = 0; j <= 8; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), j, -1, i, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece4 extends WorldGenNetherPieces.WorldGenNetherPiece {

        public WorldGenNetherPiece4() {}

        public WorldGenNetherPiece4(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.a((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 1, 0, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece4 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -1, -7, 0, 5, 14, 10, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece4(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            int i = this.a(Blocks.NETHER_BRICK_STAIRS, 2);

            for (int j = 0; j <= 9; ++j) {
                int k = Math.max(1, 7 - j);
                int l = Math.min(Math.max(k + 5, 14 - j), 13);
                int i1 = j;

                this.a(world, structureboundingbox, 0, 0, j, 4, k, j, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
                this.a(world, structureboundingbox, 1, k + 1, j, 3, l - 1, j, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                if (j <= 6) {
                    this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(i), 1, k + 1, j, structureboundingbox);
                    this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(i), 2, k + 1, j, structureboundingbox);
                    this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(i), 3, k + 1, j, structureboundingbox);
                }

                this.a(world, structureboundingbox, 0, l, j, 4, l, j, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
                this.a(world, structureboundingbox, 0, k + 1, j, 0, l - 1, j, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
                this.a(world, structureboundingbox, 4, k + 1, j, 4, l - 1, j, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
                if ((j & 1) == 0) {
                    this.a(world, structureboundingbox, 0, k + 2, j, 0, k + 3, j, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                    this.a(world, structureboundingbox, 4, k + 2, j, 4, k + 3, j, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                }

                for (int j1 = 0; j1 <= 4; ++j1) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), j1, -1, i1, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece8 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private boolean b;

        public WorldGenNetherPiece8() {}

        public WorldGenNetherPiece8(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
            this.b = random.nextInt(3) == 0;
        }

        protected void b(NBTTagCompound nbttagcompound) {
            super.b(nbttagcompound);
            this.b = nbttagcompound.getBoolean("Chest");
        }

        protected void a(NBTTagCompound nbttagcompound) {
            super.a(nbttagcompound);
            nbttagcompound.setBoolean("Chest", this.b);
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.b((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 0, 1, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece8 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -1, 0, 0, 5, 7, 5, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece8(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 4, 5, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 3, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 3, 3, 4, 4, 3, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 4, 3, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 3, 4, 1, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 3, 3, 4, 3, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            if (this.b && structureboundingbox.b((BaseBlockPosition) (new BlockPosition(this.a(3, 3), this.d(2), this.b(3, 3))))) {
                this.b = false;
                this.a(world, structureboundingbox, random, 3, 2, 3, WorldGenNetherPieces.WorldGenNetherPiece8.a, 2 + random.nextInt(4));
            }

            this.a(world, structureboundingbox, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 4; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece10 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private boolean b;

        public WorldGenNetherPiece10() {}

        public WorldGenNetherPiece10(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
            this.b = random.nextInt(3) == 0;
        }

        protected void b(NBTTagCompound nbttagcompound) {
            super.b(nbttagcompound);
            this.b = nbttagcompound.getBoolean("Chest");
        }

        protected void a(NBTTagCompound nbttagcompound) {
            super.a(nbttagcompound);
            nbttagcompound.setBoolean("Chest", this.b);
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.c((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 0, 1, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece10 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -1, 0, 0, 5, 7, 5, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece10(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 4, 5, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 3, 0, 4, 3, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 2, 4, 4, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 3, 4, 1, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 3, 3, 4, 3, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            if (this.b && structureboundingbox.b((BaseBlockPosition) (new BlockPosition(this.a(1, 3), this.d(2), this.b(1, 3))))) {
                this.b = false;
                this.a(world, structureboundingbox, random, 1, 2, 3, WorldGenNetherPieces.WorldGenNetherPiece10.a, 2 + random.nextInt(4));
            }

            this.a(world, structureboundingbox, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 4; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece7 extends WorldGenNetherPieces.WorldGenNetherPiece {

        public WorldGenNetherPiece7() {}

        public WorldGenNetherPiece7(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.a((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 1, 0, true);
            this.b((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 0, 1, true);
            this.c((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 0, 1, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece7 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -1, 0, 0, 5, 7, 5, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece7(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 4, 5, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 0, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 4, 0, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 2, 4, 4, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 4; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece9 extends WorldGenNetherPieces.WorldGenNetherPiece {

        public WorldGenNetherPiece9() {}

        public WorldGenNetherPiece9(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.a((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 1, 0, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece9 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -1, 0, 0, 5, 7, 5, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece9(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 4, 5, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 2, 0, 4, 5, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 3, 0, 4, 3, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 3, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 3, 3, 4, 4, 3, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 4; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece11 extends WorldGenNetherPieces.WorldGenNetherPiece {

        public WorldGenNetherPiece11() {}

        public WorldGenNetherPiece11(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.a((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 5, 3, true);
            this.a((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 5, 11, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece11 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -5, -3, 0, 13, 14, 13, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece11(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 5, 0, 12, 13, 12, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            int i;

            for (i = 1; i <= 11; i += 2) {
                this.a(world, structureboundingbox, i, 10, 0, i, 11, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                this.a(world, structureboundingbox, i, 10, 12, i, 11, 12, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                this.a(world, structureboundingbox, 0, 10, i, 0, 11, i, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                this.a(world, structureboundingbox, 12, 10, i, 12, 11, i, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                this.a(world, Blocks.NETHER_BRICK.getBlockData(), i, 13, 0, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK.getBlockData(), i, 13, 12, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK.getBlockData(), 0, 13, i, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK.getBlockData(), 12, 13, i, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), i + 1, 13, 0, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), i + 1, 13, 12, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, i + 1, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 12, 13, i + 1, structureboundingbox);
            }

            this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 0, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 12, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 0, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 12, 13, 0, structureboundingbox);

            for (i = 3; i <= 9; i += 2) {
                this.a(world, structureboundingbox, 1, 7, i, 1, 8, i, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                this.a(world, structureboundingbox, 11, 7, i, 11, 8, i, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            }

            i = this.a(Blocks.NETHER_BRICK_STAIRS, 3);

            int j;
            int k;
            int l;

            for (j = 0; j <= 6; ++j) {
                k = j + 4;

                for (l = 5; l <= 7; ++l) {
                    this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(i), l, 5 + j, k, structureboundingbox);
                }

                if (k >= 5 && k <= 8) {
                    this.a(world, structureboundingbox, 5, 5, k, 7, j + 4, k, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
                } else if (k >= 9 && k <= 10) {
                    this.a(world, structureboundingbox, 5, 8, k, 7, j + 4, k, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
                }

                if (j >= 1) {
                    this.a(world, structureboundingbox, 5, 6 + j, k, 7, 9 + j, k, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
                }
            }

            for (j = 5; j <= 7; ++j) {
                this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(i), j, 12, 11, structureboundingbox);
            }

            this.a(world, structureboundingbox, 5, 6, 7, 5, 7, 7, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 7, 6, 7, 7, 7, 7, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 13, 12, 7, 13, 12, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 5, 2, 3, 5, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 5, 9, 3, 5, 10, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 5, 4, 2, 5, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 9, 5, 2, 10, 5, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 9, 5, 9, 10, 5, 10, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 10, 5, 4, 10, 5, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            j = this.a(Blocks.NETHER_BRICK_STAIRS, 0);
            k = this.a(Blocks.NETHER_BRICK_STAIRS, 1);
            this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(k), 4, 5, 2, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(k), 4, 5, 3, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(k), 4, 5, 9, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(k), 4, 5, 10, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(j), 8, 5, 2, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(j), 8, 5, 3, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(j), 8, 5, 9, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_STAIRS.fromLegacyData(j), 8, 5, 10, structureboundingbox);
            this.a(world, structureboundingbox, 3, 4, 4, 4, 4, 8, Blocks.SOUL_SAND.getBlockData(), Blocks.SOUL_SAND.getBlockData(), false);
            this.a(world, structureboundingbox, 8, 4, 4, 9, 4, 8, Blocks.SOUL_SAND.getBlockData(), Blocks.SOUL_SAND.getBlockData(), false);
            this.a(world, structureboundingbox, 3, 5, 4, 4, 5, 8, Blocks.NETHER_WART.getBlockData(), Blocks.NETHER_WART.getBlockData(), false);
            this.a(world, structureboundingbox, 8, 5, 4, 9, 5, 8, Blocks.NETHER_WART.getBlockData(), Blocks.NETHER_WART.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            int i1;

            for (l = 4; l <= 8; ++l) {
                for (i1 = 0; i1 <= 2; ++i1) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), l, -1, i1, structureboundingbox);
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), l, -1, 12 - i1, structureboundingbox);
                }
            }

            for (l = 0; l <= 2; ++l) {
                for (i1 = 4; i1 <= 8; ++i1) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), l, -1, i1, structureboundingbox);
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), 12 - l, -1, i1, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece6 extends WorldGenNetherPieces.WorldGenNetherPiece {

        public WorldGenNetherPiece6() {}

        public WorldGenNetherPiece6(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.a((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 5, 3, true);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece6 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -5, -3, 0, 13, 14, 13, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece6(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 3, 0, 12, 4, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 5, 0, 12, 13, 12, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 5, 0, 1, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 11, 5, 0, 12, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 5, 11, 4, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 8, 5, 11, 10, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 9, 11, 7, 12, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 5, 0, 4, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 8, 5, 0, 10, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 9, 0, 7, 12, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 11, 2, 10, 12, 10, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 8, 0, 7, 8, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);

            int i;

            for (i = 1; i <= 11; i += 2) {
                this.a(world, structureboundingbox, i, 10, 0, i, 11, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                this.a(world, structureboundingbox, i, 10, 12, i, 11, 12, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                this.a(world, structureboundingbox, 0, 10, i, 0, 11, i, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                this.a(world, structureboundingbox, 12, 10, i, 12, 11, i, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                this.a(world, Blocks.NETHER_BRICK.getBlockData(), i, 13, 0, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK.getBlockData(), i, 13, 12, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK.getBlockData(), 0, 13, i, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK.getBlockData(), 12, 13, i, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), i + 1, 13, 0, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), i + 1, 13, 12, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, i + 1, structureboundingbox);
                this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 12, 13, i + 1, structureboundingbox);
            }

            this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 0, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 12, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 0, 13, 0, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 12, 13, 0, structureboundingbox);

            for (i = 3; i <= 9; i += 2) {
                this.a(world, structureboundingbox, 1, 7, i, 1, 8, i, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
                this.a(world, structureboundingbox, 11, 7, i, 11, 8, i, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            }

            this.a(world, structureboundingbox, 4, 2, 0, 8, 2, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 4, 12, 2, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 0, 0, 8, 1, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 0, 9, 8, 1, 12, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 0, 4, 3, 1, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 9, 0, 4, 12, 1, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            int j;

            for (i = 4; i <= 8; ++i) {
                for (j = 0; j <= 2; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, 12 - j, structureboundingbox);
                }
            }

            for (i = 0; i <= 2; ++i) {
                for (j = 4; j <= 8; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), 12 - i, -1, j, structureboundingbox);
                }
            }

            this.a(world, structureboundingbox, 5, 5, 5, 7, 5, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 1, 6, 6, 4, 6, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, Blocks.NETHER_BRICK.getBlockData(), 6, 0, 6, structureboundingbox);
            this.a(world, Blocks.FLOWING_LAVA.getBlockData(), 6, 5, 6, structureboundingbox);
            BlockPosition blockposition = new BlockPosition(this.a(6, 6), this.d(5), this.b(6, 6));

            if (structureboundingbox.b((BaseBlockPosition) blockposition)) {
                world.a((Block) Blocks.FLOWING_LAVA, blockposition, random);
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece12 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private boolean b;

        public WorldGenNetherPiece12() {}

        public WorldGenNetherPiece12(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        protected void b(NBTTagCompound nbttagcompound) {
            super.b(nbttagcompound);
            this.b = nbttagcompound.getBoolean("Mob");
        }

        protected void a(NBTTagCompound nbttagcompound) {
            super.a(nbttagcompound);
            nbttagcompound.setBoolean("Mob", this.b);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece12 a(List<StructurePiece> list, Random random, int i, int j, int k, int l, EnumDirection enumdirection) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -2, 0, 0, 7, 8, 9, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece12(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 2, 0, 6, 7, 7, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 0, 0, 5, 1, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 2, 1, 5, 2, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 3, 2, 5, 3, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 4, 3, 5, 4, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 2, 0, 1, 4, 2, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 2, 0, 5, 4, 2, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 5, 2, 1, 5, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 5, 2, 5, 5, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 5, 3, 0, 5, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 5, 3, 6, 5, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 5, 8, 5, 5, 8, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 1, 6, 3, structureboundingbox);
            this.a(world, Blocks.NETHER_BRICK_FENCE.getBlockData(), 5, 6, 3, structureboundingbox);
            this.a(world, structureboundingbox, 0, 6, 3, 0, 6, 8, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 6, 3, 6, 6, 8, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 6, 8, 5, 7, 8, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 8, 8, 4, 8, 8, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            if (!this.b) {
                BlockPosition blockposition = new BlockPosition(this.a(3, 5), this.d(5), this.b(3, 5));

                if (structureboundingbox.b((BaseBlockPosition) blockposition)) {
                    this.b = true;
                    world.setTypeAndData(blockposition, Blocks.MOB_SPAWNER.getBlockData(), 2);
                    TileEntity tileentity = world.getTileEntity(blockposition);

                    if (tileentity instanceof TileEntityMobSpawner) {
                        ((TileEntityMobSpawner) tileentity).getSpawner().setMobName("Blaze");
                    }
                }
            }

            for (int i = 0; i <= 6; ++i) {
                for (int j = 0; j <= 6; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece14 extends WorldGenNetherPieces.WorldGenNetherPiece {

        public WorldGenNetherPiece14() {}

        public WorldGenNetherPiece14(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.c((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 6, 2, false);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece14 a(List<StructurePiece> list, Random random, int i, int j, int k, int l, EnumDirection enumdirection) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -2, 0, 0, 7, 11, 7, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece14(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 6, 10, 6, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 1, 8, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 2, 0, 6, 8, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 1, 0, 8, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 2, 1, 6, 8, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 2, 6, 5, 8, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 2, 0, 5, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 3, 2, 6, 5, 2, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 3, 4, 6, 5, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, Blocks.NETHER_BRICK.getBlockData(), 5, 2, 5, structureboundingbox);
            this.a(world, structureboundingbox, 4, 2, 5, 4, 3, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 3, 2, 5, 3, 4, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 2, 5, 2, 5, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 2, 5, 1, 6, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 7, 1, 5, 7, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 8, 2, 6, 8, 4, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 6, 0, 4, 8, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 5, 0, 4, 5, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);

            for (int i = 0; i <= 6; ++i) {
                for (int j = 0; j <= 6; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece13 extends WorldGenNetherPieces.WorldGenNetherPiece {

        public WorldGenNetherPiece13() {}

        public WorldGenNetherPiece13(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.a((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 2, 0, false);
            this.b((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 0, 2, false);
            this.c((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 0, 2, false);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece13 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -2, 0, 0, 7, 9, 7, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece13(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 6, 7, 6, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 1, 6, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 6, 1, 6, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 2, 0, 6, 6, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 5, 2, 6, 6, 6, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 0, 6, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 5, 0, 6, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 2, 0, 6, 6, 1, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 2, 5, 6, 6, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 6, 0, 4, 6, 0, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 5, 0, 4, 5, 0, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 6, 6, 4, 6, 6, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 2, 5, 6, 4, 5, 6, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 6, 2, 0, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 5, 2, 0, 5, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 6, 2, 6, 6, 4, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 6, 5, 2, 6, 5, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);

            for (int i = 0; i <= 6; ++i) {
                for (int j = 0; j <= 6; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece1 extends WorldGenNetherPieces.WorldGenNetherPiece {

        public WorldGenNetherPiece1() {}

        public WorldGenNetherPiece1(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        protected WorldGenNetherPiece1(Random random, int i, int j) {
            super(0);
            this.m = EnumDirection.EnumDirectionLimit.HORIZONTAL.a(random);
            switch (WorldGenNetherPieces.SyntheticClass_1.a[this.m.ordinal()]) {
            case 1:
            case 2:
                this.l = new StructureBoundingBox(i, 64, j, i + 19 - 1, 73, j + 19 - 1);
                break;

            default:
                this.l = new StructureBoundingBox(i, 64, j, i + 19 - 1, 73, j + 19 - 1);
            }

        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.a((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 8, 3, false);
            this.b((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 3, 8, false);
            this.c((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 3, 8, false);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece1 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -8, -3, 0, 19, 10, 19, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece1(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 7, 3, 0, 11, 4, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 7, 18, 4, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 8, 5, 0, 10, 7, 18, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 5, 8, 18, 7, 10, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 7, 5, 0, 7, 5, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 7, 5, 11, 7, 5, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 11, 5, 0, 11, 5, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 11, 5, 11, 11, 5, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 5, 7, 7, 5, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 11, 5, 7, 18, 5, 7, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 5, 11, 7, 5, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 11, 5, 11, 18, 5, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 7, 2, 0, 11, 2, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 7, 2, 13, 11, 2, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 7, 0, 0, 11, 1, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 7, 0, 15, 11, 1, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            int i;
            int j;

            for (i = 7; i <= 11; ++i) {
                for (j = 0; j <= 2; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, 18 - j, structureboundingbox);
                }
            }

            this.a(world, structureboundingbox, 0, 2, 7, 5, 2, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 13, 2, 7, 18, 2, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 0, 7, 3, 1, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 15, 0, 7, 18, 1, 11, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            for (i = 0; i <= 2; ++i) {
                for (j = 7; j <= 11; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), 18 - i, -1, j, structureboundingbox);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece2 extends WorldGenNetherPieces.WorldGenNetherPiece {

        private int b;

        public WorldGenNetherPiece2() {}

        public WorldGenNetherPiece2(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
            this.b = random.nextInt();
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece2 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -1, -3, 0, 5, 10, 8, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece2(l, random, structureboundingbox, enumdirection) : null;
        }

        protected void b(NBTTagCompound nbttagcompound) {
            super.b(nbttagcompound);
            this.b = nbttagcompound.getInt("Seed");
        }

        protected void a(NBTTagCompound nbttagcompound) {
            super.a(nbttagcompound);
            nbttagcompound.setInt("Seed", this.b);
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            Random random1 = new Random((long) this.b);

            int i;
            int j;
            int k;

            for (i = 0; i <= 4; ++i) {
                for (j = 3; j <= 4; ++j) {
                    k = random1.nextInt(8);
                    this.a(world, structureboundingbox, i, j, 0, i, j, k, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
                }
            }

            i = random1.nextInt(8);
            this.a(world, structureboundingbox, 0, 5, 0, 0, 5, i, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            i = random1.nextInt(8);
            this.a(world, structureboundingbox, 4, 5, 0, 4, 5, i, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            for (i = 0; i <= 4; ++i) {
                j = random1.nextInt(5);
                this.a(world, structureboundingbox, i, 2, 0, i, 2, j, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            }

            for (i = 0; i <= 4; ++i) {
                for (j = 0; j <= 1; ++j) {
                    k = random1.nextInt(3);
                    this.a(world, structureboundingbox, i, j, 0, i, j, k, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
                }
            }

            return true;
        }
    }

    public static class WorldGenNetherPiece3 extends WorldGenNetherPieces.WorldGenNetherPiece {

        public WorldGenNetherPiece3() {}

        public WorldGenNetherPiece3(int i, Random random, StructureBoundingBox structureboundingbox, EnumDirection enumdirection) {
            super(i);
            this.m = enumdirection;
            this.l = structureboundingbox;
        }

        public void a(StructurePiece structurepiece, List<StructurePiece> list, Random random) {
            this.a((WorldGenNetherPieces.WorldGenNetherPiece15) structurepiece, list, random, 1, 3, false);
        }

        public static WorldGenNetherPieces.WorldGenNetherPiece3 a(List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.a(i, j, k, -1, -3, 0, 5, 10, 19, enumdirection);

            return a(structureboundingbox) && StructurePiece.a(list, structureboundingbox) == null ? new WorldGenNetherPieces.WorldGenNetherPiece3(l, random, structureboundingbox, enumdirection) : null;
        }

        public boolean a(World world, Random random, StructureBoundingBox structureboundingbox) {
            this.a(world, structureboundingbox, 0, 3, 0, 4, 4, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 1, 5, 0, 3, 7, 18, Blocks.AIR.getBlockData(), Blocks.AIR.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 5, 0, 0, 5, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 5, 0, 4, 5, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 0, 4, 2, 5, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 2, 13, 4, 2, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 0, 0, 4, 1, 3, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 0, 15, 4, 1, 18, Blocks.NETHER_BRICK.getBlockData(), Blocks.NETHER_BRICK.getBlockData(), false);

            for (int i = 0; i <= 4; ++i) {
                for (int j = 0; j <= 2; ++j) {
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, j, structureboundingbox);
                    this.b(world, Blocks.NETHER_BRICK.getBlockData(), i, -1, 18 - j, structureboundingbox);
                }
            }

            this.a(world, structureboundingbox, 0, 1, 1, 0, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 4, 0, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 3, 14, 0, 4, 14, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 0, 1, 17, 0, 4, 17, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 1, 1, 4, 4, 1, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 3, 4, 4, 4, 4, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 3, 14, 4, 4, 14, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            this.a(world, structureboundingbox, 4, 1, 17, 4, 4, 17, Blocks.NETHER_BRICK_FENCE.getBlockData(), Blocks.NETHER_BRICK_FENCE.getBlockData(), false);
            return true;
        }
    }

    public static class WorldGenNetherPiece15 extends WorldGenNetherPieces.WorldGenNetherPiece1 {

        public WorldGenNetherPieces.WorldGenNetherPieceWeight b;
        public List<WorldGenNetherPieces.WorldGenNetherPieceWeight> c;
        public List<WorldGenNetherPieces.WorldGenNetherPieceWeight> d;
        public List<StructurePiece> e = Lists.newArrayList();

        public WorldGenNetherPiece15() {}

        public WorldGenNetherPiece15(Random random, int i, int j) {
            super(random, i, j);
            this.c = Lists.newArrayList();
            WorldGenNetherPieces.WorldGenNetherPieceWeight[] aworldgennetherpieces_worldgennetherpieceweight = WorldGenNetherPieces.a;
            int k = aworldgennetherpieces_worldgennetherpieceweight.length;

            int l;
            WorldGenNetherPieces.WorldGenNetherPieceWeight worldgennetherpieces_worldgennetherpieceweight;

            for (l = 0; l < k; ++l) {
                worldgennetherpieces_worldgennetherpieceweight = aworldgennetherpieces_worldgennetherpieceweight[l];
                worldgennetherpieces_worldgennetherpieceweight.c = 0;
                this.c.add(worldgennetherpieces_worldgennetherpieceweight);
            }

            this.d = Lists.newArrayList();
            aworldgennetherpieces_worldgennetherpieceweight = WorldGenNetherPieces.b;
            k = aworldgennetherpieces_worldgennetherpieceweight.length;

            for (l = 0; l < k; ++l) {
                worldgennetherpieces_worldgennetherpieceweight = aworldgennetherpieces_worldgennetherpieceweight[l];
                worldgennetherpieces_worldgennetherpieceweight.c = 0;
                this.d.add(worldgennetherpieces_worldgennetherpieceweight);
            }

        }

        protected void b(NBTTagCompound nbttagcompound) {
            super.b(nbttagcompound);
        }

        protected void a(NBTTagCompound nbttagcompound) {
            super.a(nbttagcompound);
        }
    }

    abstract static class WorldGenNetherPiece extends StructurePiece {

        protected static final List<StructurePieceTreasure> a = Lists.newArrayList(new StructurePieceTreasure[] { new StructurePieceTreasure(Items.DIAMOND, 0, 1, 3, 5), new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 5), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 1, 3, 15), new StructurePieceTreasure(Items.GOLDEN_SWORD, 0, 1, 1, 5), new StructurePieceTreasure(Items.GOLDEN_CHESTPLATE, 0, 1, 1, 5), new StructurePieceTreasure(Items.FLINT_AND_STEEL, 0, 1, 1, 5), new StructurePieceTreasure(Items.NETHER_WART, 0, 3, 7, 5), new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 10), new StructurePieceTreasure(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 8), new StructurePieceTreasure(Items.IRON_HORSE_ARMOR, 0, 1, 1, 5), new StructurePieceTreasure(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 3), new StructurePieceTreasure(Item.getItemOf(Blocks.OBSIDIAN), 0, 2, 4, 2)});

        public WorldGenNetherPiece() {}

        protected WorldGenNetherPiece(int i) {
            super(i);
        }

        protected void b(NBTTagCompound nbttagcompound) {}

        protected void a(NBTTagCompound nbttagcompound) {}

        private int a(List<WorldGenNetherPieces.WorldGenNetherPieceWeight> list) {
            boolean flag = false;
            int i = 0;

            WorldGenNetherPieces.WorldGenNetherPieceWeight worldgennetherpieces_worldgennetherpieceweight;

            for (Iterator iterator = list.iterator(); iterator.hasNext(); i += worldgennetherpieces_worldgennetherpieceweight.b) {
                worldgennetherpieces_worldgennetherpieceweight = (WorldGenNetherPieces.WorldGenNetherPieceWeight) iterator.next();
                if (worldgennetherpieces_worldgennetherpieceweight.d > 0 && worldgennetherpieces_worldgennetherpieceweight.c < worldgennetherpieces_worldgennetherpieceweight.d) {
                    flag = true;
                }
            }

            return flag ? i : -1;
        }

        private WorldGenNetherPieces.WorldGenNetherPiece a(WorldGenNetherPieces.WorldGenNetherPiece15 worldgennetherpieces_worldgennetherpiece15, List<WorldGenNetherPieces.WorldGenNetherPieceWeight> list, List<StructurePiece> list1, Random random, int i, int j, int k, EnumDirection enumdirection, int l) {
            int i1 = this.a(list);
            boolean flag = i1 > 0 && l <= 30;
            int j1 = 0;

            while (j1 < 5 && flag) {
                ++j1;
                int k1 = random.nextInt(i1);
                Iterator iterator = list.iterator();

                while (iterator.hasNext()) {
                    WorldGenNetherPieces.WorldGenNetherPieceWeight worldgennetherpieces_worldgennetherpieceweight = (WorldGenNetherPieces.WorldGenNetherPieceWeight) iterator.next();

                    k1 -= worldgennetherpieces_worldgennetherpieceweight.b;
                    if (k1 < 0) {
                        if (!worldgennetherpieces_worldgennetherpieceweight.a(l) || worldgennetherpieces_worldgennetherpieceweight == worldgennetherpieces_worldgennetherpiece15.b && !worldgennetherpieces_worldgennetherpieceweight.e) {
                            break;
                        }

                        WorldGenNetherPieces.WorldGenNetherPiece worldgennetherpieces_worldgennetherpiece = WorldGenNetherPieces.b(worldgennetherpieces_worldgennetherpieceweight, list1, random, i, j, k, enumdirection, l);

                        if (worldgennetherpieces_worldgennetherpiece != null) {
                            ++worldgennetherpieces_worldgennetherpieceweight.c;
                            worldgennetherpieces_worldgennetherpiece15.b = worldgennetherpieces_worldgennetherpieceweight;
                            if (!worldgennetherpieces_worldgennetherpieceweight.a()) {
                                list.remove(worldgennetherpieces_worldgennetherpieceweight);
                            }

                            return worldgennetherpieces_worldgennetherpiece;
                        }
                    }
                }
            }

            return WorldGenNetherPieces.WorldGenNetherPiece2.a(list1, random, i, j, k, enumdirection, l);
        }

        private StructurePiece a(WorldGenNetherPieces.WorldGenNetherPiece15 worldgennetherpieces_worldgennetherpiece15, List<StructurePiece> list, Random random, int i, int j, int k, EnumDirection enumdirection, int l, boolean flag) {
            if (Math.abs(i - worldgennetherpieces_worldgennetherpiece15.c().a) <= 112 && Math.abs(k - worldgennetherpieces_worldgennetherpiece15.c().c) <= 112) {
                List list1 = worldgennetherpieces_worldgennetherpiece15.c;

                if (flag) {
                    list1 = worldgennetherpieces_worldgennetherpiece15.d;
                }

                WorldGenNetherPieces.WorldGenNetherPiece worldgennetherpieces_worldgennetherpiece = this.a(worldgennetherpieces_worldgennetherpiece15, list1, list, random, i, j, k, enumdirection, l + 1);

                if (worldgennetherpieces_worldgennetherpiece != null) {
                    list.add(worldgennetherpieces_worldgennetherpiece);
                    worldgennetherpieces_worldgennetherpiece15.e.add(worldgennetherpieces_worldgennetherpiece);
                }

                return worldgennetherpieces_worldgennetherpiece;
            } else {
                return WorldGenNetherPieces.WorldGenNetherPiece2.a(list, random, i, j, k, enumdirection, l);
            }
        }

        protected StructurePiece a(WorldGenNetherPieces.WorldGenNetherPiece15 worldgennetherpieces_worldgennetherpiece15, List<StructurePiece> list, Random random, int i, int j, boolean flag) {
            if (this.m != null) {
                switch (WorldGenNetherPieces.SyntheticClass_1.a[this.m.ordinal()]) {
                case 1:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.a + i, this.l.b + j, this.l.c - 1, this.m, this.d(), flag);

                case 2:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.a + i, this.l.b + j, this.l.f + 1, this.m, this.d(), flag);

                case 3:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.a - 1, this.l.b + j, this.l.c + i, this.m, this.d(), flag);

                case 4:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.d + 1, this.l.b + j, this.l.c + i, this.m, this.d(), flag);
                }
            }

            return null;
        }

        protected StructurePiece b(WorldGenNetherPieces.WorldGenNetherPiece15 worldgennetherpieces_worldgennetherpiece15, List<StructurePiece> list, Random random, int i, int j, boolean flag) {
            if (this.m != null) {
                switch (WorldGenNetherPieces.SyntheticClass_1.a[this.m.ordinal()]) {
                case 1:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.a - 1, this.l.b + i, this.l.c + j, EnumDirection.WEST, this.d(), flag);

                case 2:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.a - 1, this.l.b + i, this.l.c + j, EnumDirection.WEST, this.d(), flag);

                case 3:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.a + j, this.l.b + i, this.l.c - 1, EnumDirection.NORTH, this.d(), flag);

                case 4:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.a + j, this.l.b + i, this.l.c - 1, EnumDirection.NORTH, this.d(), flag);
                }
            }

            return null;
        }

        protected StructurePiece c(WorldGenNetherPieces.WorldGenNetherPiece15 worldgennetherpieces_worldgennetherpiece15, List<StructurePiece> list, Random random, int i, int j, boolean flag) {
            if (this.m != null) {
                switch (WorldGenNetherPieces.SyntheticClass_1.a[this.m.ordinal()]) {
                case 1:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.d + 1, this.l.b + i, this.l.c + j, EnumDirection.EAST, this.d(), flag);

                case 2:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.d + 1, this.l.b + i, this.l.c + j, EnumDirection.EAST, this.d(), flag);

                case 3:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.a + j, this.l.b + i, this.l.f + 1, EnumDirection.SOUTH, this.d(), flag);

                case 4:
                    return this.a(worldgennetherpieces_worldgennetherpiece15, list, random, this.l.a + j, this.l.b + i, this.l.f + 1, EnumDirection.SOUTH, this.d(), flag);
                }
            }

            return null;
        }

        protected static boolean a(StructureBoundingBox structureboundingbox) {
            return structureboundingbox != null && structureboundingbox.b > 10;
        }
    }

    static class WorldGenNetherPieceWeight {

        public Class<? extends WorldGenNetherPieces.WorldGenNetherPiece> a;
        public final int b;
        public int c;
        public int d;
        public boolean e;

        public WorldGenNetherPieceWeight(Class<? extends WorldGenNetherPieces.WorldGenNetherPiece> oclass, int i, int j, boolean flag) {
            this.a = oclass;
            this.b = i;
            this.d = j;
            this.e = flag;
        }

        public WorldGenNetherPieceWeight(Class<? extends WorldGenNetherPieces.WorldGenNetherPiece> oclass, int i, int j) {
            this(oclass, i, j, false);
        }

        public boolean a(int i) {
            return this.d == 0 || this.c < this.d;
        }

        public boolean a() {
            return this.d == 0 || this.c < this.d;
        }
    }
}
