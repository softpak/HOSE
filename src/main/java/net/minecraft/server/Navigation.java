package net.minecraft.server;

import java.util.Iterator;

public class Navigation extends NavigationAbstract {

    protected PathfinderNormal a;
    private boolean f;

    public Navigation(EntityInsentient entityinsentient, World world) {
        super(entityinsentient, world);
    }

    protected Pathfinder a() {
        this.a = new PathfinderNormal();
        this.a.a(true);
        return new Pathfinder(this.a);
    }

    protected boolean b() {
        return this.b.onGround || this.h() && this.o() || this.b.au() && this.b instanceof EntityZombie && this.b.vehicle instanceof EntityChicken;
    }

    protected Vec3D c() {
        return new Vec3D(this.b.locX, (double) this.p(), this.b.locZ);
    }

    private int p() {
        if (this.b.V() && this.h()) {
            int i = (int) this.b.getBoundingBox().b;
            Block block = this.c.getType(new BlockPosition(MathHelper.floor(this.b.locX), i, MathHelper.floor(this.b.locZ))).getBlock();
            int j = 0;

            do {
                if (block != Blocks.FLOWING_WATER && block != Blocks.WATER) {
                    return i;
                }

                ++i;
                block = this.c.getType(new BlockPosition(MathHelper.floor(this.b.locX), i, MathHelper.floor(this.b.locZ))).getBlock();
                ++j;
            } while (j <= 16);

            return (int) this.b.getBoundingBox().b;
        } else {
            return (int) (this.b.getBoundingBox().b + 0.5D);
        }
    }

    protected void d() {
        super.d();
        if (this.f) {
            if (this.c.i(new BlockPosition(MathHelper.floor(this.b.locX), (int) (this.b.getBoundingBox().b + 0.5D), MathHelper.floor(this.b.locZ)))) {
                return;
            }

            for (int i = 0; i < this.d.d(); ++i) {
                PathPoint pathpoint = this.d.a(i);

                if (this.c.i(new BlockPosition(pathpoint.a, pathpoint.b, pathpoint.c))) {
                    this.d.b(i - 1);
                    return;
                }
            }
        }

    }

    protected boolean a(Vec3D vec3d, Vec3D vec3d1, int i, int j, int k) {
        int l = MathHelper.floor(vec3d.a);
        int i1 = MathHelper.floor(vec3d.c);
        double d0 = vec3d1.a - vec3d.a;
        double d1 = vec3d1.c - vec3d.c;
        double d2 = d0 * d0 + d1 * d1;

        if (d2 < 1.0E-8D) {
            return false;
        } else {
            double d3 = 1.0D / Math.sqrt(d2);

            d0 *= d3;
            d1 *= d3;
            i += 2;
            k += 2;
            if (!this.a(l, (int) vec3d.b, i1, i, j, k, vec3d, d0, d1)) {
                return false;
            } else {
                i -= 2;
                k -= 2;
                double d4 = 1.0D / Math.abs(d0);
                double d5 = 1.0D / Math.abs(d1);
                double d6 = (double) (l * 1) - vec3d.a;
                double d7 = (double) (i1 * 1) - vec3d.c;

                if (d0 >= 0.0D) {
                    ++d6;
                }

                if (d1 >= 0.0D) {
                    ++d7;
                }

                d6 /= d0;
                d7 /= d1;
                int j1 = d0 < 0.0D ? -1 : 1;
                int k1 = d1 < 0.0D ? -1 : 1;
                int l1 = MathHelper.floor(vec3d1.a);
                int i2 = MathHelper.floor(vec3d1.c);
                int j2 = l1 - l;
                int k2 = i2 - i1;

                do {
                    if (j2 * j1 <= 0 && k2 * k1 <= 0) {
                        return true;
                    }

                    if (d6 < d7) {
                        d6 += d4;
                        l += j1;
                        j2 = l1 - l;
                    } else {
                        d7 += d5;
                        i1 += k1;
                        k2 = i2 - i1;
                    }
                } while (this.a(l, (int) vec3d.b, i1, i, j, k, vec3d, d0, d1));

                return false;
            }
        }
    }

    private boolean a(int i, int j, int k, int l, int i1, int j1, Vec3D vec3d, double d0, double d1) {
        int k1 = i - l / 2;
        int l1 = k - j1 / 2;

        if (!this.b(k1, j, l1, l, i1, j1, vec3d, d0, d1)) {
            return false;
        } else {
            for (int i2 = k1; i2 < k1 + l; ++i2) {
                for (int j2 = l1; j2 < l1 + j1; ++j2) {
                    double d2 = (double) i2 + 0.5D - vec3d.a;
                    double d3 = (double) j2 + 0.5D - vec3d.c;

                    if (d2 * d0 + d3 * d1 >= 0.0D) {
                        Block block = this.c.getType(new BlockPosition(i2, j - 1, j2)).getBlock();
                        Material material = block.getMaterial();

                        if (material == Material.AIR) {
                            return false;
                        }

                        if (material == Material.WATER && !this.b.V()) {
                            return false;
                        }

                        if (material == Material.LAVA) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }
    }

    private boolean b(int i, int j, int k, int l, int i1, int j1, Vec3D vec3d, double d0, double d1) {
        Iterator iterator = BlockPosition.a(new BlockPosition(i, j, k), new BlockPosition(i + l - 1, j + i1 - 1, k + j1 - 1)).iterator();

        while (iterator.hasNext()) {
            BlockPosition blockposition = (BlockPosition) iterator.next();
            double d2 = (double) blockposition.getX() + 0.5D - vec3d.a;
            double d3 = (double) blockposition.getZ() + 0.5D - vec3d.c;

            if (d2 * d0 + d3 * d1 >= 0.0D) {
                Block block = this.c.getType(blockposition).getBlock();

                if (!block.b(this.c, blockposition)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void a(boolean flag) {
        this.a.c(flag);
    }

    public boolean e() {
        return this.a.e();
    }

    public void b(boolean flag) {
        this.a.b(flag);
    }

    public void c(boolean flag) {
        this.a.a(flag);
    }

    public boolean g() {
        return this.a.b();
    }

    public void d(boolean flag) {
        this.a.d(flag);
    }

    public boolean h() {
        return this.a.d();
    }

    public void e(boolean flag) {
        this.f = flag;
    }
}
