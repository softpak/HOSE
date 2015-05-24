package net.minecraft.server;

public class SlotFurnaceFuel extends Slot {

    public SlotFurnaceFuel(IInventory iinventory, int i, int j, int k) {
        super(iinventory, i, j, k);
    }

    public boolean isAllowed(ItemStack itemstack) {
        return TileEntityFurnace.isFuel(itemstack) || c_(itemstack);
    }

    public int getMaxStackSize(ItemStack itemstack) {
        return c_(itemstack) ? 1 : super.getMaxStackSize(itemstack);
    }

    public static boolean c_(ItemStack itemstack) {
        return itemstack != null && itemstack.getItem() != null && itemstack.getItem() == Items.BUCKET;
    }
}
