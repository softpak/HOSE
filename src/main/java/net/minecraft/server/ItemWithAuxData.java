package net.minecraft.server;

public class ItemWithAuxData extends ItemBlock {

    private final Block b;
    private String[] c;

    public ItemWithAuxData(Block block, boolean flag) {
        super(block);
        this.b = block;
        if (flag) {
            this.setMaxDurability(0);
            this.a(true);
        }

    }

    public int filterData(int i) {
        return i;
    }

    public ItemWithAuxData a(String[] astring) {
        this.c = astring;
        return this;
    }

    public String e_(ItemStack itemstack) {
        if (this.c == null) {
            return super.e_(itemstack);
        } else {
            int i = itemstack.getData();

            return i >= 0 && i < this.c.length ? super.e_(itemstack) + "." + this.c[i] : super.e_(itemstack);
        }
    }
}
