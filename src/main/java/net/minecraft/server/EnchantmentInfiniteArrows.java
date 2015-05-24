package net.minecraft.server;

public class EnchantmentInfiniteArrows extends Enchantment {

    public EnchantmentInfiniteArrows(int i, MinecraftKey minecraftkey, int j) {
        super(i, minecraftkey, j, EnchantmentSlotType.BOW);
        this.c("arrowInfinite");
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
