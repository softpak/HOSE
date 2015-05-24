package net.minecraft.server;

public abstract class PathfinderGoalGotoTarget extends PathfinderGoal {

    private final EntityCreature c;
    private final double d;
    protected int a;
    private int e;
    private int f;
    protected BlockPosition b;
    private boolean g;
    private int h;

    public PathfinderGoalGotoTarget(EntityCreature entitycreature, double d0, int i) {
        this.b = BlockPosition.ZERO;
        this.c = entitycreature;
        this.d = d0;
        this.h = i;
        this.a(5);
    }

    public boolean a() {
        if (this.a > 0) {
            --this.a;
            return false;
        } else {
            this.a = 200 + this.c.bc().nextInt(200);
            return this.g();
        }
    }

    public boolean b() {
        return this.e >= -this.f && this.e <= 1200 && this.a(this.c.world, this.b);
    }

    public void c() {
        this.c.getNavigation().a((double) ((float) this.b.getX()) + 0.5D, (double) (this.b.getY() + 1), (double) ((float) this.b.getZ()) + 0.5D, this.d);
        this.e = 0;
        this.f = this.c.bc().nextInt(this.c.bc().nextInt(1200) + 1200) + 1200;
    }

    public void d() {}

    public void e() {
        if (this.c.c(this.b.up()) > 1.0D) {
            this.g = false;
            ++this.e;
            if (this.e % 40 == 0) {
                this.c.getNavigation().a((double) ((float) this.b.getX()) + 0.5D, (double) (this.b.getY() + 1), (double) ((float) this.b.getZ()) + 0.5D, this.d);
            }
        } else {
            this.g = true;
            --this.e;
        }

    }

    protected boolean f() {
        return this.g;
    }

    private boolean g() {
        int i = this.h;
        boolean flag = true;
        BlockPosition blockposition = new BlockPosition(this.c);

        for (int j = 0; j <= 1; j = j > 0 ? -j : 1 - j) {
            for (int k = 0; k < i; ++k) {
                for (int l = 0; l <= k; l = l > 0 ? -l : 1 - l) {
                    for (int i1 = l < k && l > -k ? k : 0; i1 <= k; i1 = i1 > 0 ? -i1 : 1 - i1) {
                        BlockPosition blockposition1 = blockposition.a(l, j - 1, i1);

                        if (this.c.e(blockposition1) && this.a(this.c.world, blockposition1)) {
                            this.b = blockposition1;
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    protected abstract boolean a(World world, BlockPosition blockposition);
}
