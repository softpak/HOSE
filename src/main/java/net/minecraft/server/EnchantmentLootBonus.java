package net.minecraft.server;

public class EnchantmentLootBonus extends Enchantment {

    protected EnchantmentLootBonus(int i, MinecraftKey minecraftkey, int j, EnchantmentSlotType enchantmentslottype) {
        super(i, minecraftkey, j, enchantmentslottype);
        if (enchantmentslottype == EnchantmentSlotType.DIGGER) {
            this.c("lootBonusDigger");
        } else if (enchantmentslottype == EnchantmentSlotType.FISHING_ROD) {
            this.c("lootBonusFishing");
        } else {
            this.c("lootBonus");
        }

    }

    public int a(int i) {
        return 15 + (i - 1) * 9;
    }

    public int b(int i) {
        return super.a(i) + 50;
    }

    public int getMaxLevel() {
        return 3;
    }

    public boolean a(Enchantment enchantment) {
        return super.a(enchantment) && enchantment.id != EnchantmentLootBonus.SILK_TOUCH.id;
    }
}
