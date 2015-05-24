package net.minecraft.server;

public class NavigationGuardian extends NavigationAbstract {

    public NavigationGuardian(EntityInsentient entityinsentient, World world) {
        super(entityinsentient, world);
    }

    protected Pathfinder a() {
        return new Pathfinder(new PathfinderWater());
    }

    protected boolean b() {
        return this.o();
    }

    protected Vec3D c() {
        return new Vec3D(this.b.locX, this.b.locY + (double) this.b.length * 0.5D, this.b.locZ);
    }

    protected void l() {
        Vec3D vec3d = this.c();
        float f = this.b.width * this.b.width;
        byte b0 = 6;

        if (vec3d.distanceSquared(this.d.a(this.b, this.d.e())) < (double) f) {
            this.d.a();
        }

        for (int i = Math.min(this.d.e() + b0, this.d.d() - 1); i > this.d.e(); --i) {
            Vec3D vec3d1 = this.d.a(this.b, i);

            if (vec3d1.distanceSquared(vec3d) <= 36.0D && this.a(vec3d, vec3d1, 0, 0, 0)) {
                this.d.c(i);
                break;
            }
        }

        this.a(vec3d);
    }

    protected void d() {
        super.d();
    }

    protected boolean a(Vec3D vec3d, Vec3D vec3d1, int i, int j, int k) {
        MovingObjectPosition movingobjectposition = this.c.rayTrace(vec3d, new Vec3D(vec3d1.a, vec3d1.b + (double) this.b.length * 0.5D, vec3d1.c), false, true, false);

        return movingobjectposition == null || movingobjectposition.type == MovingObjectPosition.EnumMovingObjectType.MISS;
    }
}
