package net.minecraft.server;

public class ItemReed extends Item {

    private Block a;

    public ItemReed(Block block) {
        this.a = block;
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2) {
        IBlockData iblockdata = world.getType(blockposition);
        Block block = iblockdata.getBlock();

        if (block == Blocks.SNOW_LAYER && ((Integer) iblockdata.get(BlockSnow.LAYERS)).intValue() < 1) {
            enumdirection = EnumDirection.UP;
        } else if (!block.a(world, blockposition)) {
            blockposition = blockposition.shift(enumdirection);
        }

        if (!entityhuman.a(blockposition, enumdirection, itemstack)) {
            return false;
        } else if (itemstack.count == 0) {
            return false;
        } else {
            if (world.a(this.a, blockposition, false, enumdirection, (Entity) null, itemstack)) {
                IBlockData iblockdata1 = this.a.getPlacedState(world, blockposition, enumdirection, f, f1, f2, 0, entityhuman);

                if (world.setTypeAndData(blockposition, iblockdata1, 3)) {
                    iblockdata1 = world.getType(blockposition);
                    if (iblockdata1.getBlock() == this.a) {
                        ItemBlock.a(world, blockposition, itemstack);
                        iblockdata1.getBlock().postPlace(world, blockposition, iblockdata1, entityhuman, itemstack);
                    }

                    world.makeSound((double) ((float) blockposition.getX() + 0.5F), (double) ((float) blockposition.getY() + 0.5F), (double) ((float) blockposition.getZ() + 0.5F), this.a.stepSound.getPlaceSound(), (this.a.stepSound.getVolume1() + 1.0F) / 2.0F, this.a.stepSound.getVolume2() * 0.8F);
                    --itemstack.count;
                    return true;
                }
            }

            return false;
        }
    }
}
