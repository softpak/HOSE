package net.minecraft.server;

public class EntityDamageSource extends DamageSource {

    protected Entity q;
    private boolean r = false;

    public EntityDamageSource(String s, Entity entity) {
        super(s);
        this.q = entity;
    }

    public EntityDamageSource v() {
        this.r = true;
        return this;
    }

    public boolean w() {
        return this.r;
    }

    public Entity getEntity() {
        return this.q;
    }

    public IChatBaseComponent getLocalizedDeathMessage(EntityLiving entityliving) {
        ItemStack itemstack = this.q instanceof EntityLiving ? ((EntityLiving) this.q).bA() : null;
        String s = "death.attack." + this.translationIndex;
        String s1 = s + ".item";

        return itemstack != null && itemstack.hasName() && LocaleI18n.c(s1) ? new ChatMessage(s1, new Object[] { entityliving.getScoreboardDisplayName(), this.q.getScoreboardDisplayName(), itemstack.C()}) : new ChatMessage(s, new Object[] { entityliving.getScoreboardDisplayName(), this.q.getScoreboardDisplayName()});
    }

    public boolean r() {
        return this.q != null && this.q instanceof EntityLiving && !(this.q instanceof EntityHuman);
    }
}
