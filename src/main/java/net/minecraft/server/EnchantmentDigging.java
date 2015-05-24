package net.minecraft.server;

public class EnchantmentDigging extends Enchantment {

    protected EnchantmentDigging(int i, MinecraftKey minecraftkey, int j) {
        super(i, minecraftkey, j, EnchantmentSlotType.DIGGER);
        this.c("digging");
    }

    public int a(int i) {
        return 1 + 10 * (i - 1);
    }

    public int b(int i) {
        return super.a(i) + 50;
    }

    public int getMaxLevel() {
        return 5;
    }

    public boolean canEnchant(ItemStack itemstack) {
        return itemstack.getItem() == Items.SHEARS ? true : super.canEnchant(itemstack);
    }
}
