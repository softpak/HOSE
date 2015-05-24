package net.minecraft.server;

public class EnchantmentDepthStrider extends Enchantment {

    public EnchantmentDepthStrider(int i, MinecraftKey minecraftkey, int j) {
        super(i, minecraftkey, j, EnchantmentSlotType.ARMOR_FEET);
        this.c("waterWalker");
    }

    public int a(int i) {
        return i * 10;
    }

    public int b(int i) {
        return this.a(i) + 15;
    }

    public int getMaxLevel() {
        return 3;
    }
}
