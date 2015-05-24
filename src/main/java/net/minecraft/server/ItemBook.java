package net.minecraft.server;

public class ItemBook extends Item {

    public ItemBook() {}

    public boolean f_(ItemStack itemstack) {
        return itemstack.count == 1;
    }

    public int b() {
        return 1;
    }
}
