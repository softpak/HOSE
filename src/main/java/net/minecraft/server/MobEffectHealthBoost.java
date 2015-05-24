package net.minecraft.server;

public class MobEffectHealthBoost extends MobEffectList {

    public MobEffectHealthBoost(int i, MinecraftKey minecraftkey, boolean flag, int j) {
        super(i, minecraftkey, flag, j);
    }

    public void a(EntityLiving entityliving, AttributeMapBase attributemapbase, int i) {
        super.a(entityliving, attributemapbase, i);
        if (entityliving.getHealth() > entityliving.getMaxHealth()) {
            entityliving.setHealth(entityliving.getMaxHealth());
        }

    }
}
