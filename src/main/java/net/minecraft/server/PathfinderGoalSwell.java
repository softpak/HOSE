package net.minecraft.server;

public class PathfinderGoalSwell extends PathfinderGoal {

    EntityCreeper a;
    // EntityLiving b; // Spigot

    public PathfinderGoalSwell(EntityCreeper entitycreeper) {
        this.a = entitycreeper;
        this.a(1);
    }

    public boolean a() {
        EntityLiving entityliving = this.a.getGoalTarget();

        return this.a.cm() > 0 || entityliving != null && this.a.h(entityliving) < 9.0D;
    }

    public void c() {
        this.a.getNavigation().n();
        // this.b = this.a.getGoalTarget(); // Spigot
    }

    public void d() {
        // this.b = null; // Spigot
    }

    public void e() {
        // Spigot start
        EntityLiving b = this.a.getGoalTarget();
        if (b == null) {
            this.a.a(-1);
        } else if (this.a.h(b) > 49.0D) {
            this.a.a(-1);
        } else if (!this.a.getEntitySenses().a(b)) {
            this.a.a(-1);
        } else {
            this.a.a(1);
        }
        // Spigot end
    }
}
