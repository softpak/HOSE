package net.minecraft.server;

public class PathfinderGoalLookAtPlayer extends PathfinderGoal {

    protected EntityInsentient a;
    protected Entity b;
    protected float c;
    private int e;
    private float f;
    protected Class<? extends Entity> d;

    public PathfinderGoalLookAtPlayer(EntityInsentient entityinsentient, Class<? extends Entity> oclass, float f) {
        this.a = entityinsentient;
        this.d = oclass;
        this.c = f;
        this.f = 0.02F;
        this.a(2);
    }

    public PathfinderGoalLookAtPlayer(EntityInsentient entityinsentient, Class<? extends Entity> oclass, float f, float f1) {
        this.a = entityinsentient;
        this.d = oclass;
        this.c = f;
        this.f = f1;
        this.a(2);
    }

    public boolean a() {
        if (this.a.bc().nextFloat() >= this.f) {
            return false;
        } else {
            if (this.a.getGoalTarget() != null) {
                this.b = this.a.getGoalTarget();
            }

            if (this.d == EntityHuman.class) {
                this.b = this.a.world.findNearbyPlayer(this.a, (double) this.c);
            } else {
                this.b = this.a.world.a(this.d, this.a.getBoundingBox().grow((double) this.c, 3.0D, (double) this.c), (Entity) this.a);
            }

            return this.b != null;
        }
    }

    public boolean b() {
        return !this.b.isAlive() ? false : (this.a.h(this.b) > (double) (this.c * this.c) ? false : this.e > 0);
    }

    public void c() {
        this.e = 40 + this.a.bc().nextInt(40);
    }

    public void d() {
        this.b = null;
    }

    public void e() {
        this.a.getControllerLook().a(this.b.locX, this.b.locY + (double) this.b.getHeadHeight(), this.b.locZ, 10.0F, (float) this.a.bQ());
        --this.e;
    }
}
