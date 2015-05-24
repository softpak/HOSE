package net.minecraft.server;

public class PathfinderGoalLookAtTradingPlayer extends PathfinderGoalLookAtPlayer {

    private final EntityVillager e;

    public PathfinderGoalLookAtTradingPlayer(EntityVillager entityvillager) {
        super(entityvillager, EntityHuman.class, 8.0F);
        this.e = entityvillager;
    }

    public boolean a() {
        if (this.e.co()) {
            this.b = this.e.v_();
            return true;
        } else {
            return false;
        }
    }
}
