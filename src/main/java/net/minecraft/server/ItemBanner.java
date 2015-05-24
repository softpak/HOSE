package net.minecraft.server;

public class ItemBanner extends ItemBlock {

    public ItemBanner() {
        super(Blocks.STANDING_BANNER);
        this.maxStackSize = 16;
        this.a(CreativeModeTab.c);
        this.a(true);
        this.setMaxDurability(0);
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
            } else if (!Blocks.STANDING_BANNER.canPlace(world, blockposition)) {
                return false;
            } else if (world.isClientSide) {
                return true;
            } else {
                if (enumdirection == EnumDirection.UP) {
                    int i = MathHelper.floor((double) ((entityhuman.yaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;

                    world.setTypeAndData(blockposition, Blocks.STANDING_BANNER.getBlockData().set(BlockFloorSign.ROTATION, Integer.valueOf(i)), 3);
                } else {
                    world.setTypeAndData(blockposition, Blocks.WALL_BANNER.getBlockData().set(BlockWallSign.FACING, enumdirection), 3);
                }

                --itemstack.count;
                TileEntity tileentity = world.getTileEntity(blockposition);

                if (tileentity instanceof TileEntityBanner) {
                    ((TileEntityBanner) tileentity).a(itemstack);
                }

                return true;
            }
        }
    }

    public String a(ItemStack itemstack) {
        String s = "item.banner.";
        EnumColor enumcolor = this.h(itemstack);

        s = s + enumcolor.d() + ".name";
        return LocaleI18n.get(s);
    }

    private EnumColor h(ItemStack itemstack) {
        NBTTagCompound nbttagcompound = itemstack.a("BlockEntityTag", false);
        EnumColor enumcolor = null;

        if (nbttagcompound != null && nbttagcompound.hasKey("Base")) {
            enumcolor = EnumColor.fromInvColorIndex(nbttagcompound.getInt("Base"));
        } else {
            enumcolor = EnumColor.fromInvColorIndex(itemstack.getData());
        }

        return enumcolor;
    }
}
