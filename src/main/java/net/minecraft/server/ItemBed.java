package net.minecraft.server;

public class ItemBed extends Item {

    public ItemBed() {
        this.a(CreativeModeTab.c);
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2) {
        if (world.isClientSide) {
            return true;
        } else if (enumdirection != EnumDirection.UP) {
            return false;
        } else {
            IBlockData iblockdata = world.getType(blockposition);
            Block block = iblockdata.getBlock();
            boolean flag = block.a(world, blockposition);

            if (!flag) {
                blockposition = blockposition.up();
            }

            int i = MathHelper.floor((double) (entityhuman.yaw * 4.0F / 360.0F) + 0.5D) & 3;
            EnumDirection enumdirection1 = EnumDirection.fromType2(i);
            BlockPosition blockposition1 = blockposition.shift(enumdirection1);

            if (entityhuman.a(blockposition, enumdirection, itemstack) && entityhuman.a(blockposition1, enumdirection, itemstack)) {
                boolean flag1 = world.getType(blockposition1).getBlock().a(world, blockposition1);
                boolean flag2 = flag || world.isEmpty(blockposition);
                boolean flag3 = flag1 || world.isEmpty(blockposition1);

                if (flag2 && flag3 && World.a((IBlockAccess) world, blockposition.down()) && World.a((IBlockAccess) world, blockposition1.down())) {
                    IBlockData iblockdata1 = Blocks.BED.getBlockData().set(BlockBed.OCCUPIED, Boolean.valueOf(false)).set(BlockBed.FACING, enumdirection1).set(BlockBed.PART, BlockBed.EnumBedPart.FOOT);

                    if (world.setTypeAndData(blockposition, iblockdata1, 3)) {
                        IBlockData iblockdata2 = iblockdata1.set(BlockBed.PART, BlockBed.EnumBedPart.HEAD);

                        world.setTypeAndData(blockposition1, iblockdata2, 3);
                    }

                    --itemstack.count;
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
