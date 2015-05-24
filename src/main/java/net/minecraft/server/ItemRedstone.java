package net.minecraft.server;

public class ItemRedstone extends Item {

    public ItemRedstone() {
        this.a(CreativeModeTab.d);
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2) {
        boolean flag = world.getType(blockposition).getBlock().a(world, blockposition);
        BlockPosition blockposition1 = flag ? blockposition : blockposition.shift(enumdirection);

        if (!entityhuman.a(blockposition1, enumdirection, itemstack)) {
            return false;
        } else {
            Block block = world.getType(blockposition1).getBlock();

            if (!world.a(block, blockposition1, false, enumdirection, (Entity) null, itemstack)) {
                return false;
            } else if (Blocks.REDSTONE_WIRE.canPlace(world, blockposition1)) {
                --itemstack.count;
                world.setTypeUpdate(blockposition1, Blocks.REDSTONE_WIRE.getBlockData());
                return true;
            } else {
                return false;
            }
        }
    }
}
