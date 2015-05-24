package net.minecraft.server;

public class EntityBlaze extends EntityMonster {

    private float a = 0.5F;
    private int b;

    public EntityBlaze(World world) {
        super(world);
        this.fireProof = true;
        this.b_ = 10;
        this.goalSelector.a(4, new EntityBlaze.PathfinderGoalBlazeFireball(this));
        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true, new Class[0]));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(GenericAttributes.e).setValue(6.0D);
        this.getAttributeInstance(GenericAttributes.d).setValue(0.23000000417232513D);
        this.getAttributeInstance(GenericAttributes.b).setValue(48.0D);
    }

    protected void h() {
        super.h();
        this.datawatcher.a(16, new Byte((byte) 0));
    }

    protected String z() {
        return "mob.blaze.breathe";
    }

    protected String bo() {
        return "mob.blaze.hit";
    }

    protected String bp() {
        return "mob.blaze.death";
    }

    public float c(float f) {
        return 1.0F;
    }

    public void m() {
        if (!this.onGround && this.motY < 0.0D) {
            this.motY *= 0.6D;
        }

        if (this.world.isClientSide) {
            if (this.random.nextInt(24) == 0 && !this.R()) {
                this.world.a(this.locX + 0.5D, this.locY + 0.5D, this.locZ + 0.5D, "fire.fire", 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
            }

            for (int i = 0; i < 2; ++i) {
                this.world.addParticle(EnumParticle.SMOKE_LARGE, this.locX + (this.random.nextDouble() - 0.5D) * (double) this.width, this.locY + this.random.nextDouble() * (double) this.length, this.locZ + (this.random.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }

        super.m();
    }

    protected void E() {
        if (this.U()) {
            this.damageEntity(DamageSource.DROWN, 1.0F);
        }

        --this.b;
        if (this.b <= 0) {
            this.b = 100;
            this.a = 0.5F + (float) this.random.nextGaussian() * 3.0F;
        }

        EntityLiving entityliving = this.getGoalTarget();

        if (entityliving != null && entityliving.locY + (double) entityliving.getHeadHeight() > this.locY + (double) this.getHeadHeight() + (double) this.a) {
            this.motY += (0.30000001192092896D - this.motY) * 0.30000001192092896D;
            this.ai = true;
        }

        super.E();
    }

    public void e(float f, float f1) {}

    protected Item getLoot() {
        return Items.BLAZE_ROD;
    }

    public boolean isBurning() {
        return this.n();
    }

    protected void dropDeathLoot(boolean flag, int i) {
        if (flag) {
            int j = this.random.nextInt(2 + i);

            for (int k = 0; k < j; ++k) {
                this.a(Items.BLAZE_ROD, 1);
            }
        }

    }

    public boolean n() {
        return (this.datawatcher.getByte(16) & 1) != 0;
    }

    public void a(boolean flag) {
        byte b0 = this.datawatcher.getByte(16);

        if (flag) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 &= -2;
        }

        this.datawatcher.watch(16, Byte.valueOf(b0));
    }

    protected boolean n_() {
        return true;
    }

    static class PathfinderGoalBlazeFireball extends PathfinderGoal {

        private EntityBlaze a;
        private int b;
        private int c;

        public PathfinderGoalBlazeFireball(EntityBlaze entityblaze) {
            this.a = entityblaze;
            this.a(3);
        }

        public boolean a() {
            EntityLiving entityliving = this.a.getGoalTarget();

            return entityliving != null && entityliving.isAlive();
        }

        public void c() {
            this.b = 0;
        }

        public void d() {
            this.a.a(false);
        }

        public void e() {
            --this.c;
            EntityLiving entityliving = this.a.getGoalTarget();
            double d0 = this.a.h(entityliving);

            if (d0 < 4.0D) {
                if (this.c <= 0) {
                    this.c = 20;
                    this.a.r(entityliving);
                }

                this.a.getControllerMove().a(entityliving.locX, entityliving.locY, entityliving.locZ, 1.0D);
            } else if (d0 < 256.0D) {
                double d1 = entityliving.locX - this.a.locX;
                double d2 = entityliving.getBoundingBox().b + (double) (entityliving.length / 2.0F) - (this.a.locY + (double) (this.a.length / 2.0F));
                double d3 = entityliving.locZ - this.a.locZ;

                if (this.c <= 0) {
                    ++this.b;
                    if (this.b == 1) {
                        this.c = 60;
                        this.a.a(true);
                    } else if (this.b <= 4) {
                        this.c = 6;
                    } else {
                        this.c = 100;
                        this.b = 0;
                        this.a.a(false);
                    }

                    if (this.b > 1) {
                        float f = MathHelper.c(MathHelper.sqrt(d0)) * 0.5F;

                        this.a.world.a((EntityHuman) null, 1009, new BlockPosition((int) this.a.locX, (int) this.a.locY, (int) this.a.locZ), 0);

                        for (int i = 0; i < 1; ++i) {
                            EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.a.world, this.a, d1 + this.a.bc().nextGaussian() * (double) f, d2, d3 + this.a.bc().nextGaussian() * (double) f);

                            entitysmallfireball.locY = this.a.locY + (double) (this.a.length / 2.0F) + 0.5D;
                            this.a.world.addEntity(entitysmallfireball);
                        }
                    }
                }

                this.a.getControllerLook().a(entityliving, 10.0F, 10.0F);
            } else {
                this.a.getNavigation().n();
                this.a.getControllerMove().a(entityliving.locX, entityliving.locY, entityliving.locZ, 1.0D);
            }

            super.e();
        }
    }
}
