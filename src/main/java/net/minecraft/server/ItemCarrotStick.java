package net.minecraft.server;

public class ItemCarrotStick extends Item {

    public ItemCarrotStick() {
        this.a(CreativeModeTab.e);
        this.c(1);
        this.setMaxDurability(25);
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (entityhuman.au() && entityhuman.vehicle instanceof EntityPig) {
            EntityPig entitypig = (EntityPig) entityhuman.vehicle;

            if (entitypig.cm().h() && itemstack.j() - itemstack.getData() >= 7) {
                entitypig.cm().g();
                itemstack.damage(7, entityhuman);
                if (itemstack.count == 0) {
                    ItemStack itemstack1 = new ItemStack(Items.FISHING_ROD);

                    itemstack1.setTag(itemstack.getTag());
                    return itemstack1;
                }
            }
        }

        entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
        return itemstack;
    }
}
