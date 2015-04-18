package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;

public class EntityGuardian extends EntityMonster {

    private float a;
    private float b;
    private float c;
    private float bm;
    private float bn;
    private EntityLiving bo;
    private int bp;
    private boolean bq;
    public PathfinderGoalRandomStroll br; // CraftBukkit - public, PAIL: Rename goalRandomStroll

    public EntityGuardian(World world) {
        super(world);
        this.b_ = 10;
        this.setSize(0.85F, 0.85F);
        this.goalSelector.a(4, new EntityGuardian.PathfinderGoalGuardianAttack(this));
        PathfinderGoalMoveTowardsRestriction pathfindergoalmovetowardsrestriction;

        this.goalSelector.a(5, pathfindergoalmovetowardsrestriction = new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
        this.goalSelector.a(7, this.br = new PathfinderGoalRandomStroll(this, 1.0D, 80));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityGuardian.class, 12.0F, 0.01F));
        this.goalSelector.a(9, new PathfinderGoalRandomLookaround(this));
        this.br.a(3);
        pathfindergoalmovetowardsrestriction.a(3);
        this.targetSelector.a(1, new PathfinderGoalNearestAttackableTarget(this, EntityLiving.class, 10, true, false, new EntityGuardian.EntitySelectorGuardianTargetHumanSquid(this)));
        this.moveController = new EntityGuardian.ControllerMoveGuardian(this);
        this.b = this.a = this.random.nextFloat();
    }

    public void initAttributes() { // CraftBukkit - public
        super.initAttributes();
        this.getAttributeInstance(GenericAttributes.e).setValue(6.0D);
        this.getAttributeInstance(GenericAttributes.d).setValue(0.5D);
        this.getAttributeInstance(GenericAttributes.b).setValue(16.0D);
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(30.0D);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.a(nbttagcompound.getBoolean("Elder"));
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setBoolean("Elder", this.cn());
    }

    protected NavigationAbstract b(World world) {
        return new NavigationGuardian(this, world);
    }

    protected void h() {
        super.h();
        this.datawatcher.a(16, Integer.valueOf(0));
        this.datawatcher.a(17, Integer.valueOf(0));
    }

    private boolean a(int i) {
        return (this.datawatcher.getInt(16) & i) != 0;
    }

    private void a(int i, boolean flag) {
        int j = this.datawatcher.getInt(16);

        if (flag) {
            this.datawatcher.watch(16, Integer.valueOf(j | i));
        } else {
            this.datawatcher.watch(16, Integer.valueOf(j & ~i));
        }

    }

    public boolean n() {
        return this.a(2);
    }

    private void l(boolean flag) {
        this.a(2, flag);
    }

    public int cm() {
        return this.cn() ? 60 : 80;
    }

    public boolean cn() {
        return this.a(4);
    }

    public void a(boolean flag) {
        this.a(4, flag);
        if (flag) {
            this.setSize(1.9975F, 1.9975F);
            this.getAttributeInstance(GenericAttributes.d).setValue(0.30000001192092896D);
            this.getAttributeInstance(GenericAttributes.e).setValue(8.0D);
            this.getAttributeInstance(GenericAttributes.maxHealth).setValue(80.0D);
            this.bX();
            this.br.b(400);
        }

    }

    private void b(int i) {
        this.datawatcher.watch(17, Integer.valueOf(i));
    }

    public boolean cp() {
        return this.datawatcher.getInt(17) != 0;
    }

    public EntityLiving cq() {
        if (!this.cp()) {
            return null;
        } else if (this.world.isClientSide) {
            if (this.bo != null) {
                return this.bo;
            } else {
                Entity entity = this.world.a(this.datawatcher.getInt(17));

                if (entity instanceof EntityLiving) {
                    this.bo = (EntityLiving) entity;
                    return this.bo;
                } else {
                    return null;
                }
            }
        } else {
            return this.getGoalTarget();
        }
    }

    public void i(int i) {
        super.i(i);
        if (i == 16) {
            if (this.cn() && this.width < 1.0F) {
                this.setSize(1.9975F, 1.9975F);
            }
        } else if (i == 17) {
            this.bp = 0;
            this.bo = null;
        }

    }

    public int w() {
        return 160;
    }

    protected String z() {
        return !this.V() ? "mob.guardian.land.idle" : (this.cn() ? "mob.guardian.elder.idle" : "mob.guardian.idle");
    }

    protected String bo() {
        return !this.V() ? "mob.guardian.land.hit" : (this.cn() ? "mob.guardian.elder.hit" : "mob.guardian.hit");
    }

    protected String bp() {
        return !this.V() ? "mob.guardian.land.death" : (this.cn() ? "mob.guardian.elder.death" : "mob.guardian.death");
    }

    protected boolean s_() {
        return false;
    }

    public float getHeadHeight() {
        return this.length * 0.5F;
    }

    public float a(BlockPosition blockposition) {
        return this.world.getType(blockposition).getBlock().getMaterial() == Material.WATER ? 10.0F + this.world.o(blockposition) - 0.5F : super.a(blockposition);
    }

    public void m() {
        if (this.world.isClientSide) {
            this.b = this.a;
            if (!this.V()) {
                this.c = 2.0F;
                if (this.motY > 0.0D && this.bq && !this.R()) {
                    this.world.a(this.locX, this.locY, this.locZ, "mob.guardian.flop", 1.0F, 1.0F, false);
                }

                this.bq = this.motY < 0.0D && this.world.d((new BlockPosition(this)).down(), false);
            } else if (this.n()) {
                if (this.c < 0.5F) {
                    this.c = 4.0F;
                } else {
                    this.c += (0.5F - this.c) * 0.1F;
                }
            } else {
                this.c += (0.125F - this.c) * 0.2F;
            }

            this.a += this.c;
            this.bn = this.bm;
            if (!this.V()) {
                this.bm = this.random.nextFloat();
            } else if (this.n()) {
                this.bm += (0.0F - this.bm) * 0.25F;
            } else {
                this.bm += (1.0F - this.bm) * 0.06F;
            }

            if (this.n() && this.V()) {
                Vec3D vec3d = this.d(0.0F);

                for (int i = 0; i < 2; ++i) {
                    this.world.addParticle(EnumParticle.WATER_BUBBLE, this.locX + (this.random.nextDouble() - 0.5D) * (double) this.width - vec3d.a * 1.5D, this.locY + this.random.nextDouble() * (double) this.length - vec3d.b * 1.5D, this.locZ + (this.random.nextDouble() - 0.5D) * (double) this.width - vec3d.c * 1.5D, 0.0D, 0.0D, 0.0D, new int[0]);
                }
            }

            if (this.cp()) {
                if (this.bp < this.cm()) {
                    ++this.bp;
                }

                EntityLiving entityliving = this.cq();

                if (entityliving != null) {
                    this.getControllerLook().a(entityliving, 90.0F, 90.0F);
                    this.getControllerLook().a();
                    double d0 = (double) this.q(0.0F);
                    double d1 = entityliving.locX - this.locX;
                    double d2 = entityliving.locY + (double) (entityliving.length * 0.5F) - (this.locY + (double) this.getHeadHeight());
                    double d3 = entityliving.locZ - this.locZ;
                    double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);

                    d1 /= d4;
                    d2 /= d4;
                    d3 /= d4;
                    double d5 = this.random.nextDouble();

                    while (d5 < d4) {
                        d5 += 1.8D - d0 + this.random.nextDouble() * (1.7D - d0);
                        this.world.addParticle(EnumParticle.WATER_BUBBLE, this.locX + d1 * d5, this.locY + d2 * d5 + (double) this.getHeadHeight(), this.locZ + d3 * d5, 0.0D, 0.0D, 0.0D, new int[0]);
                    }
                }
            }
        }

        if (this.inWater) {
            this.setAirTicks(300);
        } else if (this.onGround) {
            this.motY += 0.5D;
            this.motX += (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.motZ += (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.yaw = this.random.nextFloat() * 360.0F;
            this.onGround = false;
            this.ai = true;
        }

        if (this.cp()) {
            this.yaw = this.aK;
        }

        super.m();
    }

    public float q(float f) {
        return ((float) this.bp + f) / (float) this.cm();
    }

    protected void E() {
        super.E();
        if (this.cn()) {
            boolean flag = true;
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;

            if ((this.ticksLived + this.getId()) % 1200 == 0) {
                MobEffectList mobeffectlist = MobEffectList.SLOWER_DIG;
                List list = this.world.b(EntityPlayer.class, new Predicate() {
                    public boolean a(EntityPlayer entityplayer) {
                        return EntityGuardian.this.h(entityplayer) < 2500.0D && entityplayer.playerInteractManager.c();
                    }

                    public boolean apply(Object object) {
                        return this.a((EntityPlayer) object);
                    }
                });
                Iterator iterator = list.iterator();

                while (iterator.hasNext()) {
                    EntityPlayer entityplayer = (EntityPlayer) iterator.next();

                    if (!entityplayer.hasEffect(mobeffectlist) || entityplayer.getEffect(mobeffectlist).getAmplifier() < 2 || entityplayer.getEffect(mobeffectlist).getDuration() < 1200) {
                        entityplayer.playerConnection.sendPacket(new PacketPlayOutGameStateChange(10, 0.0F));
                        entityplayer.addEffect(new MobEffect(mobeffectlist.id, 6000, 2));
                    }
                }
            }

            if (!this.ck()) {
                this.a(new BlockPosition(this), 16);
            }
        }

    }

    protected void dropDeathLoot(boolean flag, int i) {
        int j = this.random.nextInt(3) + this.random.nextInt(i + 1);

        if (j > 0) {
            this.a(new ItemStack(Items.PRISMARINE_SHARD, j, 0), 1.0F);
        }

        if (this.random.nextInt(3 + i) > 1) {
            this.a(new ItemStack(Items.FISH, 1, ItemFish.EnumFish.COD.a()), 1.0F);
        } else if (this.random.nextInt(3 + i) > 1) {
            this.a(new ItemStack(Items.PRISMARINE_CRYSTALS, 1, 0), 1.0F);
        }

        if (flag && this.cn()) {
            this.a(new ItemStack(Blocks.SPONGE, 1, 1), 1.0F);
        }

    }

    protected void getRareDrop() {
        ItemStack itemstack = ((PossibleFishingResult) WeightedRandom.a(this.random, EntityFishingHook.j())).a(this.random);

        this.a(itemstack, 1.0F);
    }

    protected boolean n_() {
        return true;
    }

    public boolean canSpawn() {
        return this.world.a(this.getBoundingBox(), (Entity) this) && this.world.getCubes(this, this.getBoundingBox()).isEmpty();
    }

    public boolean bR() {
        return (this.random.nextInt(20) == 0 || !this.world.j(new BlockPosition(this))) && super.bR();
    }

    public boolean damageEntity(DamageSource damagesource, float f) {
        if (!this.n() && !damagesource.isMagic() && damagesource.i() instanceof EntityLiving) {
            EntityLiving entityliving = (EntityLiving) damagesource.i();

            if (!damagesource.isExplosion()) {
                entityliving.damageEntity(DamageSource.a(this), 2.0F);
                entityliving.makeSound("damage.thorns", 0.5F, 1.0F);
            }
        }

        this.br.f();
        return super.damageEntity(damagesource, f);
    }

    public int bQ() {
        return 180;
    }

    public void g(float f, float f1) {
        if (this.bM()) {
            if (this.V()) {
                this.a(f, f1, 0.1F);
                this.move(this.motX, this.motY, this.motZ);
                this.motX *= 0.8999999761581421D;
                this.motY *= 0.8999999761581421D;
                this.motZ *= 0.8999999761581421D;
                if (!this.n() && this.getGoalTarget() == null) {
                    this.motY -= 0.005D;
                }
            } else {
                super.g(f, f1);
            }
        } else {
            super.g(f, f1);
        }

    }

    static class ControllerMoveGuardian extends ControllerMove {

        private EntityGuardian g;

        public ControllerMoveGuardian(EntityGuardian entityguardian) {
            super(entityguardian);
            this.g = entityguardian;
        }

        public void c() {
            if (this.f && !this.g.getNavigation().m()) {
                double d0 = this.b - this.g.locX;
                double d1 = this.c - this.g.locY;
                double d2 = this.d - this.g.locZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

                d3 = (double) MathHelper.sqrt(d3);
                d1 /= d3;
                float f = (float) (MathHelper.b(d2, d0) * 180.0D / 3.1415927410125732D) - 90.0F;

                this.g.yaw = this.a(this.g.yaw, f, 30.0F);
                this.g.aI = this.g.yaw;
                float f1 = (float) (this.e * this.g.getAttributeInstance(GenericAttributes.d).getValue());

                this.g.k(this.g.bI() + (f1 - this.g.bI()) * 0.125F);
                double d4 = Math.sin((double) (this.g.ticksLived + this.g.getId()) * 0.5D) * 0.05D;
                double d5 = Math.cos((double) (this.g.yaw * 3.1415927F / 180.0F));
                double d6 = Math.sin((double) (this.g.yaw * 3.1415927F / 180.0F));

                this.g.motX += d4 * d5;
                this.g.motZ += d4 * d6;
                d4 = Math.sin((double) (this.g.ticksLived + this.g.getId()) * 0.75D) * 0.05D;
                this.g.motY += d4 * (d6 + d5) * 0.25D;
                this.g.motY += (double) this.g.bI() * d1 * 0.1D;
                ControllerLook controllerlook = this.g.getControllerLook();
                double d7 = this.g.locX + d0 / d3 * 2.0D;
                double d8 = (double) this.g.getHeadHeight() + this.g.locY + d1 / d3 * 1.0D;
                double d9 = this.g.locZ + d2 / d3 * 2.0D;
                double d10 = controllerlook.e();
                double d11 = controllerlook.f();
                double d12 = controllerlook.g();

                if (!controllerlook.b()) {
                    d10 = d7;
                    d11 = d8;
                    d12 = d9;
                }

                this.g.getControllerLook().a(d10 + (d7 - d10) * 0.125D, d11 + (d8 - d11) * 0.125D, d12 + (d9 - d12) * 0.125D, 10.0F, 40.0F);
                this.g.l(true);
            } else {
                this.g.k(0.0F);
                this.g.l(false);
            }
        }
    }

    static class PathfinderGoalGuardianAttack extends PathfinderGoal {

        private EntityGuardian a;
        private int b;

        public PathfinderGoalGuardianAttack(EntityGuardian entityguardian) {
            this.a = entityguardian;
            this.a(3);
        }

        public boolean a() {
            EntityLiving entityliving = this.a.getGoalTarget();

            return entityliving != null && entityliving.isAlive();
        }

        public boolean b() {
            return super.b() && (this.a.cn() || this.a.h(this.a.getGoalTarget()) > 9.0D);
        }

        public void c() {
            this.b = -10;
            this.a.getNavigation().n();
            this.a.getControllerLook().a(this.a.getGoalTarget(), 90.0F, 90.0F);
            this.a.ai = true;
        }

        public void d() {
            this.a.b(0);
            this.a.setGoalTarget((EntityLiving) null);
            this.a.br.f();
        }

        public void e() {
            EntityLiving entityliving = this.a.getGoalTarget();

            this.a.getNavigation().n();
            this.a.getControllerLook().a(entityliving, 90.0F, 90.0F);
            if (!this.a.hasLineOfSight(entityliving)) {
                this.a.setGoalTarget((EntityLiving) null);
            } else {
                ++this.b;
                if (this.b == 0) {
                    this.a.b(this.a.getGoalTarget().getId());
                    this.a.world.broadcastEntityEffect(this.a, (byte) 21);
                } else if (this.b >= this.a.cm()) {
                    float f = 1.0F;

                    if (this.a.world.getDifficulty() == EnumDifficulty.HARD) {
                        f += 2.0F;
                    }

                    if (this.a.cn()) {
                        f += 2.0F;
                    }

                    entityliving.damageEntity(DamageSource.b(this.a, this.a), f);
                    entityliving.damageEntity(DamageSource.mobAttack(this.a), (float) this.a.getAttributeInstance(GenericAttributes.e).getValue());
                    this.a.setGoalTarget((EntityLiving) null);
                } else if (this.b >= 60 && this.b % 20 == 0) {
                    ;
                }

                super.e();
            }
        }
    }

    static class EntitySelectorGuardianTargetHumanSquid implements Predicate<EntityLiving> {

        private EntityGuardian a;

        public EntitySelectorGuardianTargetHumanSquid(EntityGuardian entityguardian) {
            this.a = entityguardian;
        }

        public boolean a(EntityLiving entityliving) {
            return (entityliving instanceof EntityHuman || entityliving instanceof EntitySquid) && entityliving.h(this.a) > 9.0D;
        }

        public boolean apply(EntityLiving object) { // CraftBukkit - fix decompile error
            return this.a((EntityLiving) object);
        }
    }
}
