package net.minecraft.server;

public class PathfinderGoalOpenDoor extends PathfinderGoalDoorInteract {

    boolean g;
    int h;

    public PathfinderGoalOpenDoor(EntityInsentient entityinsentient, boolean flag) {
        super(entityinsentient);
        this.a = entityinsentient;
        this.g = flag;
    }

    public boolean b() {
        return this.g && this.h > 0 && super.b();
    }

    public void c() {
        this.h = 20;
        this.c.setDoor(this.a.world, this.b, true);
    }

    public void d() {
        if (this.g) {
            this.c.setDoor(this.a.world, this.b, false);
        }

    }

    public void e() {
        --this.h;
        super.e();
    }
}
