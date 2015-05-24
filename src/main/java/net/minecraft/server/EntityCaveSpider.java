package net.minecraft.server;

public class EntityCaveSpider extends EntitySpider {

    public EntityCaveSpider(World world) {
        super(world);
        this.setSize(0.7F, 0.5F);
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(12.0D);
    }

    public boolean r(Entity entity) {
        if (super.r(entity)) {
            if (entity instanceof EntityLiving) {
                byte b0 = 0;

                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    b0 = 7;
                } else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    b0 = 15;
                }

                if (b0 > 0) {
                    ((EntityLiving) entity).addEffect(new MobEffect(MobEffectList.POISON.id, b0 * 20, 0));
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public GroupDataEntity prepare(DifficultyDamageScaler difficultydamagescaler, GroupDataEntity groupdataentity) {
        return groupdataentity;
    }

    public float getHeadHeight() {
        return 0.45F;
    }
}
