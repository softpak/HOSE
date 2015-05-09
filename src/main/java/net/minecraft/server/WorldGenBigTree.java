package net.minecraft.server;

import com.amd.aparapi.Aparapi;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class WorldGenBigTree extends WorldGenTreeAbstract {

    private Random k;
    private World l;
    private BlockPosition m;
    int a;
    int b;
    double c;
    double d;
    double e;
    double f;
    int g;
    int h;
    int i;
    List<WorldGenBigTree.Position> j;

    public WorldGenBigTree(boolean flag) {
        super(flag);
        this.m = BlockPosition.ZERO;
        this.c = 0.618D;
        this.d = 0.381D;
        this.e = 1.0D;
        this.f = 1.0D;
        this.g = 1;
        this.h = 12;
        this.i = 4;
    }

    void a() {
        this.b = (int) ((double) this.a * this.c);
        if (this.b >= this.a) {
            this.b = this.a - 1;
        }

        int i = (int) (1.382D + Math.pow(this.f * (double) this.a / 13.0D, 2.0D));

        if (i < 1) {
            i = 1;
        }

        int j = this.m.getY() + this.b;
        int k = this.a - this.i;

        this.j = Lists.newArrayList();
        this.j.add(new WorldGenBigTree.Position(this.m.up(k), j));

        for (; k >= 0; --k) {
            float f = this.a(k);

            if (f >= 0.0F) {
                
                for (int l = 0; l < i; ++l) {
                    double d0 = this.e * (double) f * ((double) this.k.nextFloat() + 0.328D);
                    double d1 = (double) (this.k.nextFloat() * 2.0F) * 3.141592653589793D;
                    double d2 = d0 * Math.sin(d1) + 0.5D;
                    double d3 = d0 * Math.cos(d1) + 0.5D;
                    BlockPosition blockposition = this.m.a(d2, (double) (k - 1), d3);
                    BlockPosition blockposition1 = blockposition.up(this.i);

                    if (this.a(blockposition, blockposition1) == -1) {
                        int i1 = this.m.getX() - blockposition.getX();
                        int j1 = this.m.getZ() - blockposition.getZ();
                        double d4 = (double) blockposition.getY() - Math.sqrt((double) (i1 * i1 + j1 * j1)) * this.d;
                        int k1 = d4 > (double) j ? j : (int) d4;
                        BlockPosition blockposition2 = new BlockPosition(this.m.getX(), k1, this.m.getZ());

                        if (this.a(blockposition2, blockposition) == -1) {
                            this.j.add(new WorldGenBigTree.Position(blockposition, blockposition2.getY()));
                        }
                    }
                }
            }
        }

    }

    void a(BlockPosition blockposition, float f, IBlockData iblockdata) {
        int i = (int) ((double) f + 0.618D);

        IntStream.range(-i, i).forEach( j -> {
            IntStream.range(-i, i).forEach( k -> {
                if (Math.pow((double) Math.abs(j) + 0.5D, 2.0D) + Math.pow((double) Math.abs(k) + 0.5D, 2.0D) <= (double) (f * f)) {
                    BlockPosition blockposition1 = blockposition.a(j, 0, k);
                    Material material = this.l.getType(blockposition1).getBlock().getMaterial();

                    if (material == Material.AIR || material == Material.LEAVES) {
                        this.a(this.l, blockposition1, iblockdata);
                    }
                }
            });
        });
        /*
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                if (Math.pow((double) Math.abs(j) + 0.5D, 2.0D) + Math.pow((double) Math.abs(k) + 0.5D, 2.0D) <= (double) (f * f)) {
                    BlockPosition blockposition1 = blockposition.a(j, 0, k);
                    Material material = this.l.getType(blockposition1).getBlock().getMaterial();

                    if (material == Material.AIR || material == Material.LEAVES) {
                        this.a(this.l, blockposition1, iblockdata);
                    }
                }
            }
        }*/

    }

    float a(int i) {
        if ((float) i < (float) this.a * 0.3F) {
            return -1.0F;
        } else {
            float f = (float) this.a / 2.0F;
            float f1 = f - (float) i;
            float f2 = MathHelper.c(f * f - f1 * f1);

            if (f1 == 0.0F) {
                f2 = f;
            } else if (Math.abs(f1) >= f) {
                return 0.0F;
            }

            return f2 * 0.5F;
        }
    }

    float b(int i) {
        return i >= 0 && i < this.i ? (i != 0 && i != this.i - 1 ? 3.0F : 2.0F) : -1.0F;
    }

    void a(BlockPosition blockposition) {
        Aparapi.range(this.i).forEach(gid_i -> {
            this.a(blockposition.up(gid_i), this.b(gid_i), Blocks.LEAVES.getBlockData().set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)));
        });
        /*
        for (int i = 0; i < this.i; ++i) {
            this.a(blockposition.up(i), this.b(i), Blocks.LEAVES.getBlockData().set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)));
        }*/

    }

    void a(BlockPosition blockposition, BlockPosition blockposition1, Block block) {
        BlockPosition blockposition2 = blockposition1.a(-blockposition.getX(), -blockposition.getY(), -blockposition.getZ());
        int i = this.b(blockposition2);
        float f = (float) blockposition2.getX() / (float) i;
        float f1 = (float) blockposition2.getY() / (float) i;
        float f2 = (float) blockposition2.getZ() / (float) i;

        IntStream.range(0, i).forEach( j -> {
            BlockLogAbstract.EnumLogRotation blocklogabstract_enumlogrotation = this.b(blockposition, blockposition.a((double) (0.5F + (float) j * f), (double) (0.5F + (float) j * f1), (double) (0.5F + (float) j * f2)));

            this.a(this.l, blockposition.a((double) (0.5F + (float) j * f), (double) (0.5F + (float) j * f1), (double) (0.5F + (float) j * f2)), block.getBlockData().set(BlockLogAbstract.AXIS, blocklogabstract_enumlogrotation));
        });
        /*
        for (int j = 0; j <= i; ++j) {
            BlockPosition blockposition3 = blockposition.a((double) (0.5F + (float) j * f), (double) (0.5F + (float) j * f1), (double) (0.5F + (float) j * f2));
            BlockLogAbstract.EnumLogRotation blocklogabstract_enumlogrotation = this.b(blockposition, blockposition3);

            this.a(this.l, blockposition3, block.getBlockData().set(BlockLogAbstract.AXIS, blocklogabstract_enumlogrotation));
        }*/

    }

    private int b(BlockPosition blockposition) {
        int i = MathHelper.a(blockposition.getX());
        int j = MathHelper.a(blockposition.getY());
        int k = MathHelper.a(blockposition.getZ());

        return k > i && k > j ? k : (j > i ? j : i);
    }

    private BlockLogAbstract.EnumLogRotation b(BlockPosition blockposition, BlockPosition blockposition1) {
        BlockLogAbstract.EnumLogRotation blocklogabstract_enumlogrotation = BlockLogAbstract.EnumLogRotation.Y;
        int i = Math.abs(blockposition1.getX() - blockposition.getX());
        int j = Math.abs(blockposition1.getZ() - blockposition.getZ());
        int k = Math.max(i, j);

        if (k > 0) {
            if (i == k) {
                blocklogabstract_enumlogrotation = BlockLogAbstract.EnumLogRotation.X;
            } else if (j == k) {
                blocklogabstract_enumlogrotation = BlockLogAbstract.EnumLogRotation.Z;
            }
        }

        return blocklogabstract_enumlogrotation;
    }

    void b() {
        Iterator iterator = this.j.iterator();

        iterator.forEachRemaining(
            it -> {
                this.a((BlockPosition) (WorldGenBigTree.Position) it);
            }
        );
        /*
        while (iterator.hasNext()) {
            WorldGenBigTree.Position worldgenbigtree_position = (WorldGenBigTree.Position) iterator.next();

            this.a((BlockPosition) worldgenbigtree_position);
        }*/

    }

    boolean c(int i) {
        return (double) i >= (double) this.a * 0.2D;
    }

    void c() {
        BlockPosition blockposition = this.m;
        BlockPosition blockposition1 = this.m.up(this.b);
        Block block = Blocks.LOG;

        this.a(blockposition, blockposition1, block);
        if (this.g == 2) {
            this.a(blockposition.east(), blockposition1.east(), block);
            this.a(blockposition.east().south(), blockposition1.east().south(), block);
            this.a(blockposition.south(), blockposition1.south(), block);
        }

    }

    void d() {
        Iterator iterator = this.j.iterator();

        iterator.forEachRemaining(
            it -> {
                int i = ((WorldGenBigTree.Position) it).q();
                BlockPosition blockposition = new BlockPosition(this.m.getX(), i, this.m.getZ());

                if (!blockposition.equals((WorldGenBigTree.Position) it) && this.c(i - this.m.getY())) {
                    this.a(blockposition, (BlockPosition) (WorldGenBigTree.Position) it, Blocks.LOG);
                }
            }
        );
        /*
        while (iterator.hasNext()) {
            WorldGenBigTree.Position worldgenbigtree_position = (WorldGenBigTree.Position) iterator.next();
            int i = worldgenbigtree_position.q();
            BlockPosition blockposition = new BlockPosition(this.m.getX(), i, this.m.getZ());

            if (!blockposition.equals(worldgenbigtree_position) && this.c(i - this.m.getY())) {
                this.a(blockposition, (BlockPosition) worldgenbigtree_position, Blocks.LOG);
            }
        }*/

    }

    int a(BlockPosition blockposition, BlockPosition blockposition1) {
        BlockPosition blockposition2 = blockposition1.a(-blockposition.getX(), -blockposition.getY(), -blockposition.getZ());
        int i = this.b(blockposition2);
        float f = (float) blockposition2.getX() / (float) i;
        float f1 = (float) blockposition2.getY() / (float) i;
        float f2 = (float) blockposition2.getZ() / (float) i;

        if (i == 0) {
            return -1;
        } else {
            for (int j = 0; j <= i; ++j) {
                BlockPosition blockposition3 = blockposition.a((double) (0.5F + (float) j * f), (double) (0.5F + (float) j * f1), (double) (0.5F + (float) j * f2));

                if (!this.a(this.l.getType(blockposition3).getBlock())) {
                    return j;
                }
            }

            return -1;
        }
    }

    public void e() {
        this.i = 5;
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        this.l = world;
        this.m = blockposition;
        this.k = new Random(random.nextLong());
        if (this.a == 0) {
            this.a = 5 + this.k.nextInt(this.h);
        }

        if (!this.f()) {
            return false;
        } else {
            this.a();
            this.b();
            this.c();
            this.d();
            return true;
        }
    }

    private boolean f() {
        Block block = this.l.getType(this.m.down()).getBlock();

        if (block != Blocks.DIRT && block != Blocks.GRASS && block != Blocks.FARMLAND) {
            return false;
        } else {
            int i = this.a(this.m, this.m.up(this.a - 1));

            if (i == -1) {
                return true;
            } else if (i < 6) {
                return false;
            } else {
                this.a = i;
                return true;
            }
        }
    }

    static class Position extends BlockPosition {

        private final int c;

        public Position(BlockPosition blockposition, int i) {
            super(blockposition.getX(), blockposition.getY(), blockposition.getZ());
            this.c = i;
        }

        public int q() {
            return this.c;
        }
    }
}
