package net.minecraft.server;

public class EnchantmentWaterWorker extends Enchantment {

    public EnchantmentWaterWorker(int i, MinecraftKey minecraftkey, int j) {
        super(i, minecraftkey, j, EnchantmentSlotType.ARMOR_HEAD);
        this.c("waterWorker");
    }

    public int a(int i) {
        return 1;
    }

    public int b(int i) {
        return this.a(i) + 40;
    }

    public int getMaxLevel() {
        return 1;
    }
}
