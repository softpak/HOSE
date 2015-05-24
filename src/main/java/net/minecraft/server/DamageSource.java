package net.minecraft.server;

public class DamageSource {

    public static DamageSource FIRE = (new DamageSource("inFire")).setExplosion();
    public static DamageSource LIGHTNING = new DamageSource("lightningBolt");
    public static DamageSource BURN = (new DamageSource("onFire")).setIgnoreArmor().setExplosion();
    public static DamageSource LAVA = (new DamageSource("lava")).setExplosion();
    public static DamageSource STUCK = (new DamageSource("inWall")).setIgnoreArmor();
    public static DamageSource DROWN = (new DamageSource("drown")).setIgnoreArmor();
    public static DamageSource STARVE = (new DamageSource("starve")).setIgnoreArmor().m();
    public static DamageSource CACTUS = new DamageSource("cactus");
    public static DamageSource FALL = (new DamageSource("fall")).setIgnoreArmor();
    public static DamageSource OUT_OF_WORLD = (new DamageSource("outOfWorld")).setIgnoreArmor().l();
    public static DamageSource GENERIC = (new DamageSource("generic")).setIgnoreArmor();
    public static DamageSource MAGIC = (new DamageSource("magic")).setIgnoreArmor().setMagic();
    public static DamageSource WITHER = (new DamageSource("wither")).setIgnoreArmor();
    public static DamageSource ANVIL = new DamageSource("anvil");
    public static DamageSource FALLING_BLOCK = new DamageSource("fallingBlock");
    private boolean q;
    private boolean r;
    private boolean s;
    private float t = 0.3F;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    public String translationIndex;

    public static DamageSource mobAttack(EntityLiving entityliving) {
        return new EntityDamageSource("mob", entityliving);
    }

    public static DamageSource playerAttack(EntityHuman entityhuman) {
        return new EntityDamageSource("player", entityhuman);
    }

    public static DamageSource arrow(EntityArrow entityarrow, Entity entity) {
        return (new EntityDamageSourceIndirect("arrow", entityarrow, entity)).b();
    }

    public static DamageSource fireball(EntityFireball entityfireball, Entity entity) {
        return entity == null ? (new EntityDamageSourceIndirect("onFire", entityfireball, entityfireball)).setExplosion().b() : (new EntityDamageSourceIndirect("fireball", entityfireball, entity)).setExplosion().b();
    }

    public static DamageSource projectile(Entity entity, Entity entity1) {
        return (new EntityDamageSourceIndirect("thrown", entity, entity1)).b();
    }

    public static DamageSource b(Entity entity, Entity entity1) {
        return (new EntityDamageSourceIndirect("indirectMagic", entity, entity1)).setIgnoreArmor().setMagic();
    }

    public static DamageSource a(Entity entity) {
        return (new EntityDamageSource("thorns", entity)).v().setMagic();
    }

    public static DamageSource explosion(Explosion explosion) {
        return explosion != null && explosion.c() != null ? (new EntityDamageSource("explosion.player", explosion.c())).q().d() : (new DamageSource("explosion")).q().d();
    }

    public boolean a() {
        return this.v;
    }

    public DamageSource b() {
        this.v = true;
        return this;
    }

    public boolean isExplosion() {
        return this.y;
    }

    public DamageSource d() {
        this.y = true;
        return this;
    }

    public boolean ignoresArmor() {
        return this.q;
    }

    public float getExhaustionCost() {
        return this.t;
    }

    public boolean ignoresInvulnerability() {
        return this.r;
    }

    public boolean isStarvation() {
        return this.s;
    }

    protected DamageSource(String s) {
        this.translationIndex = s;
    }

    public Entity i() {
        return this.getEntity();
    }

    public Entity getEntity() {
        return null;
    }

    protected DamageSource setIgnoreArmor() {
        this.q = true;
        this.t = 0.0F;
        return this;
    }

    protected DamageSource l() {
        this.r = true;
        return this;
    }

    protected DamageSource m() {
        this.s = true;
        this.t = 0.0F;
        return this;
    }

    protected DamageSource setExplosion() {
        this.u = true;
        return this;
    }

    public IChatBaseComponent getLocalizedDeathMessage(EntityLiving entityliving) {
        EntityLiving entityliving1 = entityliving.bt();
        String s = "death.attack." + this.translationIndex;
        String s1 = s + ".player";

        return entityliving1 != null && LocaleI18n.c(s1) ? new ChatMessage(s1, new Object[] { entityliving.getScoreboardDisplayName(), entityliving1.getScoreboardDisplayName()}) : new ChatMessage(s, new Object[] { entityliving.getScoreboardDisplayName()});
    }

    public boolean o() {
        return this.u;
    }

    public String p() {
        return this.translationIndex;
    }

    public DamageSource q() {
        this.w = true;
        return this;
    }

    public boolean r() {
        return this.w;
    }

    public boolean isMagic() {
        return this.x;
    }

    public DamageSource setMagic() {
        this.x = true;
        return this;
    }

    public boolean u() {
        Entity entity = this.getEntity();

        return entity instanceof EntityHuman && ((EntityHuman) entity).abilities.canInstantlyBuild;
    }
}
