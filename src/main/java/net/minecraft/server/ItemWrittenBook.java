package net.minecraft.server;

public class ItemWrittenBook extends Item {

    public ItemWrittenBook() {
        this.c(1);
    }

    public static boolean b(NBTTagCompound nbttagcompound) {
        if (!ItemBookAndQuill.b(nbttagcompound)) {
            return false;
        } else if (!nbttagcompound.hasKeyOfType("title", 8)) {
            return false;
        } else {
            String s = nbttagcompound.getString("title");

            return s != null && s.length() <= 32 ? nbttagcompound.hasKeyOfType("author", 8) : false;
        }
    }

    public static int h(ItemStack itemstack) {
        return itemstack.getTag().getInt("generation");
    }

    public String a(ItemStack itemstack) {
        if (itemstack.hasTag()) {
            NBTTagCompound nbttagcompound = itemstack.getTag();
            String s = nbttagcompound.getString("title");

            if (!UtilColor.b(s)) {
                return s;
            }
        }

        return super.a(itemstack);
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!world.isClientSide) {
            this.a(itemstack, entityhuman);
        }

        entityhuman.openBook(itemstack);
        entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
        return itemstack;
    }

    private void a(ItemStack itemstack, EntityHuman entityhuman) {
        if (itemstack != null && itemstack.getTag() != null) {
            NBTTagCompound nbttagcompound = itemstack.getTag();

            if (!nbttagcompound.getBoolean("resolved")) {
                nbttagcompound.setBoolean("resolved", true);
                if (b(nbttagcompound)) {
                    NBTTagList nbttaglist = nbttagcompound.getList("pages", 8);

                    for (int i = 0; i < nbttaglist.size(); ++i) {
                        String s = nbttaglist.getString(i);

                        Object object;

                        try {
                            IChatBaseComponent ichatbasecomponent = IChatBaseComponent.ChatSerializer.a(s);

                            object = ChatComponentUtils.filterForDisplay(entityhuman, ichatbasecomponent, entityhuman);
                        } catch (Exception exception) {
                            object = new ChatComponentText(s);
                        }

                        nbttaglist.a(i, new NBTTagString(IChatBaseComponent.ChatSerializer.a((IChatBaseComponent) object)));
                    }

                    nbttagcompound.set("pages", nbttaglist);
                    if (entityhuman instanceof EntityPlayer && entityhuman.bZ() == itemstack) {
                        Slot slot = entityhuman.activeContainer.getSlot(entityhuman.inventory, entityhuman.inventory.itemInHandIndex);

                        ((EntityPlayer) entityhuman).playerConnection.sendPacket(new PacketPlayOutSetSlot(0, slot.rawSlotIndex, itemstack));
                    }

                }
            }
        }
    }
}
