package net.minecraft.server;

public class PathfinderGoalRestrictSun extends PathfinderGoal {

    private EntityCreature a;

    public PathfinderGoalRestrictSun(EntityCreature entitycreature) {
        this.a = entitycreature;
    }

    public boolean a() {
        return this.a.world.w();
    }

    public void c() {
        ((Navigation) this.a.getNavigation()).e(true);
    }

    public void d() {
        ((Navigation) this.a.getNavigation()).e(false);
    }
}
