package net.minecraft.server;

import java.util.Random;

public class PathfinderGoalFleeSun extends PathfinderGoal {

    private EntityCreature a;
    private double b;
    private double c;
    private double d;
    private double e;
    private World f;

    public PathfinderGoalFleeSun(EntityCreature entitycreature, double d0) {
        this.a = entitycreature;
        this.e = d0;
        this.f = entitycreature.world;
        this.a(1);
    }

    public boolean a() {
        if (!this.f.w()) {
            return false;
        } else if (!this.a.isBurning()) {
            return false;
        } else if (!this.f.i(new BlockPosition(this.a.locX, this.a.getBoundingBox().b, this.a.locZ))) {
            return false;
        } else {
            Vec3D vec3d = this.f();

            if (vec3d == null) {
                return false;
            } else {
                this.b = vec3d.a;
                this.c = vec3d.b;
                this.d = vec3d.c;
                return true;
            }
        }
    }

    public boolean b() {
        return !this.a.getNavigation().m();
    }

    public void c() {
        this.a.getNavigation().a(this.b, this.c, this.d, this.e);
    }

    private Vec3D f() {
        Random random = this.a.bc();
        BlockPosition blockposition = new BlockPosition(this.a.locX, this.a.getBoundingBox().b, this.a.locZ);

        for (int i = 0; i < 10; ++i) {
            BlockPosition blockposition1 = blockposition.a(random.nextInt(20) - 10, random.nextInt(6) - 3, random.nextInt(20) - 10);

            if (!this.f.i(blockposition1) && this.a.a(blockposition1) < 0.0F) {
                return new Vec3D((double) blockposition1.getX(), (double) blockposition1.getY(), (double) blockposition1.getZ());
            }
        }

        return null;
    }
}
