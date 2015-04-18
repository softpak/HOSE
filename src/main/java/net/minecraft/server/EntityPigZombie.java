package net.minecraft.server;

import java.util.UUID;

public class EntityPigZombie extends EntityZombie {

    private static final UUID b = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
    private static final AttributeModifier c = (new AttributeModifier(EntityPigZombie.b, "Attacking speed boost", 0.05D, 0)).a(false);
    public int angerLevel; // CraftBukkit - public
    private int soundDelay;
    private UUID hurtBy;

    public EntityPigZombie(World world) {
        super(world);
        this.fireProof = true;
    }

    public void b(EntityLiving entityliving) {
        super.b(entityliving);
        if (entityliving != null) {
            this.hurtBy = entityliving.getUniqueID();
        }

    }

    protected void n() {
        this.targetSelector.a(1, new EntityPigZombie.PathfinderGoalAngerOther(this));
        this.targetSelector.a(2, new EntityPigZombie.PathfinderGoalAnger(this));
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityPigZombie.a).setValue(0.0D);
        this.getAttributeInstance(GenericAttributes.d).setValue(0.23000000417232513D);
        this.getAttributeInstance(GenericAttributes.e).setValue(5.0D);
    }

    public void t_() {
        super.t_();
    }

    protected void E() {
        AttributeInstance attributeinstance = this.getAttributeInstance(GenericAttributes.d);

        if (this.cm()) {
            if (!this.isBaby() && !attributeinstance.a(EntityPigZombie.c)) {
                attributeinstance.b(EntityPigZombie.c);
            }

            --this.angerLevel;
        } else if (attributeinstance.a(EntityPigZombie.c)) {
            attributeinstance.c(EntityPigZombie.c);
        }

        if (this.soundDelay > 0 && --this.soundDelay == 0) {
            this.makeSound("mob.zombiepig.zpigangry", this.bB() * 2.0F, ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 1.8F);
        }

        if (this.angerLevel > 0 && this.hurtBy != null && this.getLastDamager() == null) {
            EntityHuman entityhuman = this.world.b(this.hurtBy);

            this.b((EntityLiving) entityhuman);
            this.killer = entityhuman;
            this.lastDamageByPlayerTime = this.be();
        }

        super.E();
    }

    public boolean bR() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }

    public boolean canSpawn() {
        return this.world.a(this.getBoundingBox(), (Entity) this) && this.world.getCubes(this, this.getBoundingBox()).isEmpty() && !this.world.containsLiquid(this.getBoundingBox());
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setShort("Anger", (short) this.angerLevel);
        if (this.hurtBy != null) {
            nbttagcompound.setString("HurtBy", this.hurtBy.toString());
        } else {
            nbttagcompound.setString("HurtBy", "");
        }

    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.angerLevel = nbttagcompound.getShort("Anger");
        String s = nbttagcompound.getString("HurtBy");

        if (s.length() > 0) {
            this.hurtBy = UUID.fromString(s);
            EntityHuman entityhuman = this.world.b(this.hurtBy);

            this.b((EntityLiving) entityhuman);
            if (entityhuman != null) {
                this.killer = entityhuman;
                this.lastDamageByPlayerTime = this.be();
            }
        }

    }

    public boolean damageEntity(DamageSource damagesource, float f) {
        if (this.isInvulnerable(damagesource)) {
            return false;
        } else {
            Entity entity = damagesource.getEntity();

            if (entity instanceof EntityHuman) {
                this.b(entity);
            }

            return super.damageEntity(damagesource, f);
        }
    }

    private void b(Entity entity) {
        this.angerLevel = 400 + this.random.nextInt(400);
        this.soundDelay = this.random.nextInt(40);
        if (entity instanceof EntityLiving) {
            this.b((EntityLiving) entity);
        }

    }

    public boolean cm() {
        return this.angerLevel > 0;
    }

    protected String z() {
        return "mob.zombiepig.zpig";
    }

    protected String bo() {
        return "mob.zombiepig.zpighurt";
    }

    protected String bp() {
        return "mob.zombiepig.zpigdeath";
    }

    protected void dropDeathLoot(boolean flag, int i) {
        int j = this.random.nextInt(2 + i);

        int k;

        for (k = 0; k < j; ++k) {
            this.a(Items.ROTTEN_FLESH, 1);
        }

        j = this.random.nextInt(2 + i);

        for (k = 0; k < j; ++k) {
            this.a(Items.GOLD_NUGGET, 1);
        }

    }

    public boolean a(EntityHuman entityhuman) {
        return false;
    }

    protected void getRareDrop() {
        this.a(Items.GOLD_INGOT, 1);
    }

    protected void a(DifficultyDamageScaler difficultydamagescaler) {
        this.setEquipment(0, new ItemStack(Items.GOLDEN_SWORD));
    }

    public GroupDataEntity prepare(DifficultyDamageScaler difficultydamagescaler, GroupDataEntity groupdataentity) {
        super.prepare(difficultydamagescaler, groupdataentity);
        this.setVillager(false);
        return groupdataentity;
    }

    static class PathfinderGoalAnger extends PathfinderGoalNearestAttackableTarget<EntityHuman> {

        public PathfinderGoalAnger(EntityPigZombie entitypigzombie) {
            super(entitypigzombie, EntityHuman.class, true);
        }

        public boolean a() {
            return ((EntityPigZombie) this.e).cm() && super.a();
        }
    }

    static class PathfinderGoalAngerOther extends PathfinderGoalHurtByTarget {

        public PathfinderGoalAngerOther(EntityPigZombie entitypigzombie) {
            super(entitypigzombie, true, new Class[0]);
        }

        protected void a(EntityCreature entitycreature, EntityLiving entityliving) {
            super.a(entitycreature, entityliving);
            if (entitycreature instanceof EntityPigZombie) {
                ((EntityPigZombie) entitycreature).b((Entity) entityliving);
            }

        }
    }
}
