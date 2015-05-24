package net.minecraft.server;

public class PathfinderGoalInteract extends PathfinderGoalLookAtPlayer {

    public PathfinderGoalInteract(EntityInsentient entityinsentient, Class<? extends Entity> oclass, float f, float f1) {
        super(entityinsentient, oclass, f, f1);
        this.a(3);
    }
}
