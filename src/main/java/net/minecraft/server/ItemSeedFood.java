package net.minecraft.server;

public class ItemSeedFood extends ItemFood {

    private Block b;
    private Block c;

    public ItemSeedFood(int i, float f, Block block, Block block1) {
        super(i, f, false);
        this.b = block;
        this.c = block1;
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2) {
        if (enumdirection != EnumDirection.UP) {
            return false;
        } else if (!entityhuman.a(blockposition.shift(enumdirection), enumdirection, itemstack)) {
            return false;
        } else if (world.getType(blockposition).getBlock() == this.c && world.isEmpty(blockposition.up())) {
            world.setTypeUpdate(blockposition.up(), this.b.getBlockData());
            --itemstack.count;
            return true;
        } else {
            return false;
        }
    }
}
