package net.minecraft.server;

public class PathfinderGoalTempt extends PathfinderGoal {

    private EntityCreature a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private EntityHuman h;
    private int i;
    private boolean j;
    private Item k;
    private boolean l;
    private boolean m;

    public PathfinderGoalTempt(EntityCreature entitycreature, double d0, Item item, boolean flag) {
        this.a = entitycreature;
        this.b = d0;
        this.k = item;
        this.l = flag;
        this.a(3);
        if (!(entitycreature.getNavigation() instanceof Navigation)) {
            throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
        }
    }

    public boolean a() {
        if (this.i > 0) {
            --this.i;
            return false;
        } else {
            this.h = this.a.world.findNearbyPlayer(this.a, 10.0D);
            if (this.h == null) {
                return false;
            } else {
                ItemStack itemstack = this.h.bZ();

                return itemstack == null ? false : itemstack.getItem() == this.k;
            }
        }
    }

    public boolean b() {
        if (this.l) {
            if (this.a.h(this.h) < 36.0D) {
                if (this.h.e(this.c, this.d, this.e) > 0.010000000000000002D) {
                    return false;
                }

                if (Math.abs((double) this.h.pitch - this.f) > 5.0D || Math.abs((double) this.h.yaw - this.g) > 5.0D) {
                    return false;
                }
            } else {
                this.c = this.h.locX;
                this.d = this.h.locY;
                this.e = this.h.locZ;
            }

            this.f = (double) this.h.pitch;
            this.g = (double) this.h.yaw;
        }

        return this.a();
    }

    public void c() {
        this.c = this.h.locX;
        this.d = this.h.locY;
        this.e = this.h.locZ;
        this.j = true;
        this.m = ((Navigation) this.a.getNavigation()).e();
        ((Navigation) this.a.getNavigation()).a(false);
    }

    public void d() {
        this.h = null;
        this.a.getNavigation().n();
        this.i = 100;
        this.j = false;
        ((Navigation) this.a.getNavigation()).a(this.m);
    }

    public void e() {
        this.a.getControllerLook().a(this.h, 30.0F, (float) this.a.bQ());
        if (this.a.h(this.h) < 6.25D) {
            this.a.getNavigation().n();
        } else {
            this.a.getNavigation().a((Entity) this.h, this.b);
        }

    }

    public boolean f() {
        return this.j;
    }
}
