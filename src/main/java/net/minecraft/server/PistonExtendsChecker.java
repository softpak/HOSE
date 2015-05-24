package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class PistonExtendsChecker {

    private final World a;
    private final BlockPosition b;
    private final BlockPosition c;
    private final EnumDirection d;
    private final List<BlockPosition> e = Lists.newArrayList();
    private final List<BlockPosition> f = Lists.newArrayList();

    public PistonExtendsChecker(World world, BlockPosition blockposition, EnumDirection enumdirection, boolean flag) {
        this.a = world;
        this.b = blockposition;
        if (flag) {
            this.d = enumdirection;
            this.c = blockposition.shift(enumdirection);
        } else {
            this.d = enumdirection.opposite();
            this.c = blockposition.shift(enumdirection, 2);
        }

    }

    public boolean a() {
        this.e.clear();
        this.f.clear();
        Block block = this.a.getType(this.c).getBlock();

        if (!BlockPiston.a(block, this.a, this.c, this.d, false)) {
            if (block.k() != 1) {
                return false;
            } else {
                this.f.add(this.c);
                return true;
            }
        } else if (!this.a(this.c)) {
            return false;
        } else {
            for (int i = 0; i < this.e.size(); ++i) {
                BlockPosition blockposition = (BlockPosition) this.e.get(i);

                if (this.a.getType(blockposition).getBlock() == Blocks.SLIME && !this.b(blockposition)) {
                    return false;
                }
            }

            return true;
        }
    }

    private boolean a(BlockPosition blockposition) {
        Block block = this.a.getType(blockposition).getBlock();

        if (block.getMaterial() == Material.AIR) {
            return true;
        } else if (!BlockPiston.a(block, this.a, blockposition, this.d, false)) {
            return true;
        } else if (blockposition.equals(this.b)) {
            return true;
        } else if (this.e.contains(blockposition)) {
            return true;
        } else {
            int i = 1;

            if (i + this.e.size() > 12) {
                return false;
            } else {
                while (block == Blocks.SLIME) {
                    BlockPosition blockposition1 = blockposition.shift(this.d.opposite(), i);

                    block = this.a.getType(blockposition1).getBlock();
                    if (block.getMaterial() == Material.AIR || !BlockPiston.a(block, this.a, blockposition1, this.d, false) || blockposition1.equals(this.b)) {
                        break;
                    }

                    ++i;
                    if (i + this.e.size() > 12) {
                        return false;
                    }
                }

                int j = 0;

                int k;

                for (k = i - 1; k >= 0; --k) {
                    this.e.add(blockposition.shift(this.d.opposite(), k));
                    ++j;
                }

                k = 1;

                while (true) {
                    BlockPosition blockposition2 = blockposition.shift(this.d, k);
                    int l = this.e.indexOf(blockposition2);

                    if (l > -1) {
                        this.a(j, l);

                        for (int i1 = 0; i1 <= l + j; ++i1) {
                            BlockPosition blockposition3 = (BlockPosition) this.e.get(i1);

                            if (this.a.getType(blockposition3).getBlock() == Blocks.SLIME && !this.b(blockposition3)) {
                                return false;
                            }
                        }

                        return true;
                    }

                    block = this.a.getType(blockposition2).getBlock();
                    if (block.getMaterial() == Material.AIR) {
                        return true;
                    }

                    if (!BlockPiston.a(block, this.a, blockposition2, this.d, true) || blockposition2.equals(this.b)) {
                        return false;
                    }

                    if (block.k() == 1) {
                        this.f.add(blockposition2);
                        return true;
                    }

                    if (this.e.size() >= 12) {
                        return false;
                    }

                    this.e.add(blockposition2);
                    ++j;
                    ++k;
                }
            }
        }
    }

    private void a(int i, int j) {
        ArrayList arraylist = Lists.newArrayList();
        ArrayList arraylist1 = Lists.newArrayList();
        ArrayList arraylist2 = Lists.newArrayList();

        arraylist.addAll(this.e.subList(0, j));
        arraylist1.addAll(this.e.subList(this.e.size() - i, this.e.size()));
        arraylist2.addAll(this.e.subList(j, this.e.size() - i));
        this.e.clear();
        this.e.addAll(arraylist);
        this.e.addAll(arraylist1);
        this.e.addAll(arraylist2);
    }

    private boolean b(BlockPosition blockposition) {
        EnumDirection[] aenumdirection = EnumDirection.values();
        int i = aenumdirection.length;

        for (int j = 0; j < i; ++j) {
            EnumDirection enumdirection = aenumdirection[j];

            if (enumdirection.k() != this.d.k() && !this.a(blockposition.shift(enumdirection))) {
                return false;
            }
        }

        return true;
    }

    public List<BlockPosition> getMovedBlocks() {
        return this.e;
    }

    public List<BlockPosition> getBrokenBlocks() {
        return this.f;
    }
}
