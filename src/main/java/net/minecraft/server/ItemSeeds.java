package net.minecraft.server;

public class ItemSeeds extends Item {

    private Block a;
    private Block b;

    public ItemSeeds(Block block, Block block1) {
        this.a = block;
        this.b = block1;
        this.a(CreativeModeTab.l);
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2) {
        if (enumdirection != EnumDirection.UP) {
            return false;
        } else if (!entityhuman.a(blockposition.shift(enumdirection), enumdirection, itemstack)) {
            return false;
        } else if (world.getType(blockposition).getBlock() == this.b && world.isEmpty(blockposition.up())) {
            world.setTypeUpdate(blockposition.up(), this.a.getBlockData());
            --itemstack.count;
            return true;
        } else {
            return false;
        }
    }
}
