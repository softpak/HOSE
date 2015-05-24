package net.minecraft.server;

import java.util.Random;

public class ItemEnchantedBook extends Item {

    public ItemEnchantedBook() {}

    public boolean f_(ItemStack itemstack) {
        return false;
    }

    public EnumItemRarity g(ItemStack itemstack) {
        return this.h(itemstack).size() > 0 ? EnumItemRarity.UNCOMMON : super.g(itemstack);
    }

    public NBTTagList h(ItemStack itemstack) {
        NBTTagCompound nbttagcompound = itemstack.getTag();

        return nbttagcompound != null && nbttagcompound.hasKeyOfType("StoredEnchantments", 9) ? (NBTTagList) nbttagcompound.get("StoredEnchantments") : new NBTTagList();
    }

    public void a(ItemStack itemstack, WeightedRandomEnchant weightedrandomenchant) {
        NBTTagList nbttaglist = this.h(itemstack);
        boolean flag = true;

        for (int i = 0; i < nbttaglist.size(); ++i) {
            NBTTagCompound nbttagcompound = nbttaglist.get(i);

            if (nbttagcompound.getShort("id") == weightedrandomenchant.enchantment.id) {
                if (nbttagcompound.getShort("lvl") < weightedrandomenchant.level) {
                    nbttagcompound.setShort("lvl", (short) weightedrandomenchant.level);
                }

                flag = false;
                break;
            }
        }

        if (flag) {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();

            nbttagcompound1.setShort("id", (short) weightedrandomenchant.enchantment.id);
            nbttagcompound1.setShort("lvl", (short) weightedrandomenchant.level);
            nbttaglist.add(nbttagcompound1);
        }

        if (!itemstack.hasTag()) {
            itemstack.setTag(new NBTTagCompound());
        }

        itemstack.getTag().set("StoredEnchantments", nbttaglist);
    }

    public ItemStack a(WeightedRandomEnchant weightedrandomenchant) {
        ItemStack itemstack = new ItemStack(this);

        this.a(itemstack, weightedrandomenchant);
        return itemstack;
    }

    public StructurePieceTreasure b(Random random) {
        return this.a(random, 1, 1, 1);
    }

    public StructurePieceTreasure a(Random random, int i, int j, int k) {
        ItemStack itemstack = new ItemStack(Items.BOOK, 1, 0);

        EnchantmentManager.a(random, itemstack, 30);
        return new StructurePieceTreasure(itemstack, i, j, k);
    }
}
