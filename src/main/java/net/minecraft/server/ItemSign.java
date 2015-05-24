package net.minecraft.server;

public class ItemSign extends Item {

    public ItemSign() {
        this.maxStackSize = 16;
        this.a(CreativeModeTab.c);
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2) {
        if (enumdirection == EnumDirection.DOWN) {
            return false;
        } else if (!world.getType(blockposition).getBlock().getMaterial().isBuildable()) {
            return false;
        } else {
            blockposition = blockposition.shift(enumdirection);
            if (!entityhuman.a(blockposition, enumdirection, itemstack)) {
                return false;
            } else if (!Blocks.STANDING_SIGN.canPlace(world, blockposition)) {
                return false;
            } else if (world.isClientSide) {
                return true;
            } else {
                if (enumdirection == EnumDirection.UP) {
                    int i = MathHelper.floor((double) ((entityhuman.yaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;

                    world.setTypeAndData(blockposition, Blocks.STANDING_SIGN.getBlockData().set(BlockFloorSign.ROTATION, Integer.valueOf(i)), 3);
                } else {
                    world.setTypeAndData(blockposition, Blocks.WALL_SIGN.getBlockData().set(BlockWallSign.FACING, enumdirection), 3);
                }

                --itemstack.count;
                TileEntity tileentity = world.getTileEntity(blockposition);

                if (tileentity instanceof TileEntitySign && !ItemBlock.a(world, blockposition, itemstack)) {
                    entityhuman.openSign((TileEntitySign) tileentity);
                }

                return true;
            }
        }
    }
}
