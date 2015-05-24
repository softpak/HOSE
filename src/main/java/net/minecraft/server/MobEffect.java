package net.minecraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MobEffect {

    private static final Logger a = LogManager.getLogger();
    private int effectId;
    private int duration;
    private int amplification;
    private boolean splash;
    private boolean ambient;
    private boolean particles;

    public MobEffect(int i, int j) {
        this(i, j, 0);
    }

    public MobEffect(int i, int j, int k) {
        this(i, j, k, false, true);
    }

    public MobEffect(int i, int j, int k, boolean flag, boolean flag1) {
        this.effectId = i;
        this.duration = j;
        this.amplification = k;
        this.ambient = flag;
        this.particles = flag1;
    }

    public MobEffect(MobEffect mobeffect) {
        this.effectId = mobeffect.effectId;
        this.duration = mobeffect.duration;
        this.amplification = mobeffect.amplification;
        this.ambient = mobeffect.ambient;
        this.particles = mobeffect.particles;
    }

    public void a(MobEffect mobeffect) {
        if (this.effectId != mobeffect.effectId) {
            MobEffect.a.warn("This method should only be called for matching effects!");
        }

        if (mobeffect.amplification > this.amplification) {
            this.amplification = mobeffect.amplification;
            this.duration = mobeffect.duration;
        } else if (mobeffect.amplification == this.amplification && this.duration < mobeffect.duration) {
            this.duration = mobeffect.duration;
        } else if (!mobeffect.ambient && this.ambient) {
            this.ambient = mobeffect.ambient;
        }

        this.particles = mobeffect.particles;
    }

    public int getEffectId() {
        return this.effectId;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getAmplifier() {
        return this.amplification;
    }

    public void setSplash(boolean flag) {
        this.splash = flag;
    }

    public boolean isAmbient() {
        return this.ambient;
    }

    public boolean isShowParticles() {
        return this.particles;
    }

    public boolean tick(EntityLiving entityliving) {
        if (this.duration > 0) {
            if (MobEffectList.byId[this.effectId].a(this.duration, this.amplification)) {
                this.b(entityliving);
            }

            this.i();
        }

        return this.duration > 0;
    }

    private int i() {
        return --this.duration;
    }

    public void b(EntityLiving entityliving) {
        if (this.duration > 0) {
            MobEffectList.byId[this.effectId].tick(entityliving, this.amplification);
        }

    }

    public String g() {
        return MobEffectList.byId[this.effectId].a();
    }

    public int hashCode() {
        return this.effectId;
    }

    public String toString() {
        String s = "";

        if (this.getAmplifier() > 0) {
            s = this.g() + " x " + (this.getAmplifier() + 1) + ", Duration: " + this.getDuration();
        } else {
            s = this.g() + ", Duration: " + this.getDuration();
        }

        if (this.splash) {
            s = s + ", Splash: true";
        }

        if (!this.particles) {
            s = s + ", Particles: false";
        }

        return MobEffectList.byId[this.effectId].j() ? "(" + s + ")" : s;
    }

    public boolean equals(Object object) {
        if (!(object instanceof MobEffect)) {
            return false;
        } else {
            MobEffect mobeffect = (MobEffect) object;

            return this.effectId == mobeffect.effectId && this.amplification == mobeffect.amplification && this.duration == mobeffect.duration && this.splash == mobeffect.splash && this.ambient == mobeffect.ambient;
        }
    }

    public NBTTagCompound a(NBTTagCompound nbttagcompound) {
        nbttagcompound.setByte("Id", (byte) this.getEffectId());
        nbttagcompound.setByte("Amplifier", (byte) this.getAmplifier());
        nbttagcompound.setInt("Duration", this.getDuration());
        nbttagcompound.setBoolean("Ambient", this.isAmbient());
        nbttagcompound.setBoolean("ShowParticles", this.isShowParticles());
        return nbttagcompound;
    }

    public static MobEffect b(NBTTagCompound nbttagcompound) {
        byte b0 = nbttagcompound.getByte("Id");

        if (b0 >= 0 && b0 < MobEffectList.byId.length && MobEffectList.byId[b0] != null) {
            byte b1 = nbttagcompound.getByte("Amplifier");
            int i = nbttagcompound.getInt("Duration");
            boolean flag = nbttagcompound.getBoolean("Ambient");
            boolean flag1 = true;

            if (nbttagcompound.hasKeyOfType("ShowParticles", 1)) {
                flag1 = nbttagcompound.getBoolean("ShowParticles");
            }

            return new MobEffect(b0, i, b1, flag, flag1);
        } else {
            return null;
        }
    }
}
