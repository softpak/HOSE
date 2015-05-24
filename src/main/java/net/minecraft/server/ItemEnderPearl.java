package net.minecraft.server;

public class ItemEnderPearl extends Item {

    public ItemEnderPearl() {
        this.maxStackSize = 16;
        this.a(CreativeModeTab.f);
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (entityhuman.abilities.canInstantlyBuild) {
            return itemstack;
        } else {
            --itemstack.count;
            world.makeSound(entityhuman, "random.bow", 0.5F, 0.4F / (ItemEnderPearl.g.nextFloat() * 0.4F + 0.8F));
            if (!world.isClientSide) {
                world.addEntity(new EntityEnderPearl(world, entityhuman));
            }

            entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
            return itemstack;
        }
    }
}
