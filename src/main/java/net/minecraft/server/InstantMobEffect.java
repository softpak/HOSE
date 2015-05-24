package net.minecraft.server;

public class InstantMobEffect extends MobEffectList {

    public InstantMobEffect(int i, MinecraftKey minecraftkey, boolean flag, int j) {
        super(i, minecraftkey, flag, j);
    }

    public boolean isInstant() {
        return true;
    }

    public boolean a(int i, int j) {
        return i >= 1;
    }
}
