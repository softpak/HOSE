package net.minecraft.server;

public class ItemLeaves extends ItemBlock {

    private final BlockLeaves b;

    public ItemLeaves(BlockLeaves blockleaves) {
        super(blockleaves);
        this.b = blockleaves;
        this.setMaxDurability(0);
        this.a(true);
    }

    public int filterData(int i) {
        return i | 4;
    }

    public String e_(ItemStack itemstack) {
        return super.getName() + "." + this.b.b(itemstack.getData()).d();
    }
}
