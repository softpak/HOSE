package net.minecraft.server;

import org.apache.commons.lang3.StringUtils;

public abstract class PathfinderGoalTarget extends PathfinderGoal {

    protected final EntityCreature e;
    protected boolean f;
    private boolean a;
    private int b;
    private int c;
    private int d;

    public PathfinderGoalTarget(EntityCreature entitycreature, boolean flag) {
        this(entitycreature, flag, false);
    }

    public PathfinderGoalTarget(EntityCreature entitycreature, boolean flag, boolean flag1) {
        this.e = entitycreature;
        this.f = flag;
        this.a = flag1;
    }

    public boolean b() {
        EntityLiving entityliving = this.e.getGoalTarget();

        if (entityliving == null) {
            return false;
        } else if (!entityliving.isAlive()) {
            return false;
        } else {
            ScoreboardTeamBase scoreboardteambase = this.e.getScoreboardTeam();
            ScoreboardTeamBase scoreboardteambase1 = entityliving.getScoreboardTeam();

            if (scoreboardteambase != null && scoreboardteambase1 == scoreboardteambase) {
                return false;
            } else {
                double d0 = this.f();

                if (this.e.h(entityliving) > d0 * d0) {
                    return false;
                } else {
                    if (this.f) {
                        if (this.e.getEntitySenses().a(entityliving)) {
                            this.d = 0;
                        } else if (++this.d > 60) {
                            return false;
                        }
                    }

                    return !(entityliving instanceof EntityHuman) || !((EntityHuman) entityliving).abilities.isInvulnerable;
                }
            }
        }
    }

    protected double f() {
        AttributeInstance attributeinstance = this.e.getAttributeInstance(GenericAttributes.b);

        return attributeinstance == null ? 16.0D : attributeinstance.getValue();
    }

    public void c() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
    }

    public void d() {
        this.e.setGoalTarget((EntityLiving) null);
    }

    public static boolean a(EntityInsentient entityinsentient, EntityLiving entityliving, boolean flag, boolean flag1) {
        if (entityliving == null) {
            return false;
        } else if (entityliving == entityinsentient) {
            return false;
        } else if (!entityliving.isAlive()) {
            return false;
        } else if (!entityinsentient.a(entityliving.getClass())) {
            return false;
        } else {
            ScoreboardTeamBase scoreboardteambase = entityinsentient.getScoreboardTeam();
            ScoreboardTeamBase scoreboardteambase1 = entityliving.getScoreboardTeam();

            if (scoreboardteambase != null && scoreboardteambase1 == scoreboardteambase) {
                return false;
            } else {
                if (entityinsentient instanceof EntityOwnable && StringUtils.isNotEmpty(((EntityOwnable) entityinsentient).getOwnerUUID())) {
                    if (entityliving instanceof EntityOwnable && ((EntityOwnable) entityinsentient).getOwnerUUID().equals(((EntityOwnable) entityliving).getOwnerUUID())) {
                        return false;
                    }

                    if (entityliving == ((EntityOwnable) entityinsentient).getOwner()) {
                        return false;
                    }
                } else if (entityliving instanceof EntityHuman && !flag && ((EntityHuman) entityliving).abilities.isInvulnerable) {
                    return false;
                }

                return !flag1 || entityinsentient.getEntitySenses().a(entityliving);
            }
        }
    }

    protected boolean a(EntityLiving entityliving, boolean flag) {
        if (!a(this.e, entityliving, flag, this.f)) {
            return false;
        } else if (!this.e.e(new BlockPosition(entityliving))) {
            return false;
        } else {
            if (this.a) {
                if (--this.c <= 0) {
                    this.b = 0;
                }

                if (this.b == 0) {
                    this.b = this.a(entityliving) ? 1 : 2;
                }

                if (this.b == 2) {
                    return false;
                }
            }

            return true;
        }
    }

    private boolean a(EntityLiving entityliving) {
        this.c = 10 + this.e.bc().nextInt(5);
        PathEntity pathentity = this.e.getNavigation().a((Entity) entityliving);

        if (pathentity == null) {
            return false;
        } else {
            PathPoint pathpoint = pathentity.c();

            if (pathpoint == null) {
                return false;
            } else {
                int i = pathpoint.a - MathHelper.floor(entityliving.locX);
                int j = pathpoint.c - MathHelper.floor(entityliving.locZ);

                return (double) (i * i + j * j) <= 2.25D;
            }
        }
    }
}
