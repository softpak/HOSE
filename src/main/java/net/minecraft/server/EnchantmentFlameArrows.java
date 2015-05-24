package net.minecraft.server;

public class EnchantmentFlameArrows extends Enchantment {

    public EnchantmentFlameArrows(int i, MinecraftKey minecraftkey, int j) {
        super(i, minecraftkey, j, EnchantmentSlotType.BOW);
        this.c("arrowFire");
    }

    public int a(int i) {
        return 20;
    }

    public int b(int i) {
        return 50;
    }

    public int getMaxLevel() {
        return 1;
    }
}
