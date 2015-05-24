package net.minecraft.server;

public class ItemEnderEye extends Item {

    public ItemEnderEye() {
        this.a(CreativeModeTab.f);
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2) {
        IBlockData iblockdata = world.getType(blockposition);

        if (entityhuman.a(blockposition.shift(enumdirection), enumdirection, itemstack) && iblockdata.getBlock() == Blocks.END_PORTAL_FRAME && !((Boolean) iblockdata.get(BlockEnderPortalFrame.EYE)).booleanValue()) {
            if (world.isClientSide) {
                return true;
            } else {
                world.setTypeAndData(blockposition, iblockdata.set(BlockEnderPortalFrame.EYE, Boolean.valueOf(true)), 2);
                world.updateAdjacentComparators(blockposition, Blocks.END_PORTAL_FRAME);
                --itemstack.count;

                for (int i = 0; i < 16; ++i) {
                    double d0 = (double) ((float) blockposition.getX() + (5.0F + ItemEnderEye.g.nextFloat() * 6.0F) / 16.0F);
                    double d1 = (double) ((float) blockposition.getY() + 0.8125F);
                    double d2 = (double) ((float) blockposition.getZ() + (5.0F + ItemEnderEye.g.nextFloat() * 6.0F) / 16.0F);
                    double d3 = 0.0D;
                    double d4 = 0.0D;
                    double d5 = 0.0D;

                    world.addParticle(EnumParticle.SMOKE_NORMAL, d0, d1, d2, d3, d4, d5, new int[0]);
                }

                EnumDirection enumdirection1 = (EnumDirection) iblockdata.get(BlockEnderPortalFrame.FACING);
                int j = 0;
                int k = 0;
                boolean flag = false;
                boolean flag1 = true;
                EnumDirection enumdirection2 = enumdirection1.e();

                for (int l = -2; l <= 2; ++l) {
                    BlockPosition blockposition1 = blockposition.shift(enumdirection2, l);
                    IBlockData iblockdata1 = world.getType(blockposition1);

                    if (iblockdata1.getBlock() == Blocks.END_PORTAL_FRAME) {
                        if (!((Boolean) iblockdata1.get(BlockEnderPortalFrame.EYE)).booleanValue()) {
                            flag1 = false;
                            break;
                        }

                        k = l;
                        if (!flag) {
                            j = l;
                            flag = true;
                        }
                    }
                }

                if (flag1 && k == j + 2) {
                    BlockPosition blockposition2 = blockposition.shift(enumdirection1, 4);

                    int i1;

                    for (i1 = j; i1 <= k; ++i1) {
                        BlockPosition blockposition3 = blockposition2.shift(enumdirection2, i1);
                        IBlockData iblockdata2 = world.getType(blockposition3);

                        if (iblockdata2.getBlock() != Blocks.END_PORTAL_FRAME || !((Boolean) iblockdata2.get(BlockEnderPortalFrame.EYE)).booleanValue()) {
                            flag1 = false;
                            break;
                        }
                    }

                    int j1;
                    BlockPosition blockposition4;

                    for (i1 = j - 1; i1 <= k + 1; i1 += 4) {
                        blockposition2 = blockposition.shift(enumdirection2, i1);

                        for (j1 = 1; j1 <= 3; ++j1) {
                            blockposition4 = blockposition2.shift(enumdirection1, j1);
                            IBlockData iblockdata3 = world.getType(blockposition4);

                            if (iblockdata3.getBlock() != Blocks.END_PORTAL_FRAME || !((Boolean) iblockdata3.get(BlockEnderPortalFrame.EYE)).booleanValue()) {
                                flag1 = false;
                                break;
                            }
                        }
                    }

                    if (flag1) {
                        for (i1 = j; i1 <= k; ++i1) {
                            blockposition2 = blockposition.shift(enumdirection2, i1);

                            for (j1 = 1; j1 <= 3; ++j1) {
                                blockposition4 = blockposition2.shift(enumdirection1, j1);
                                world.setTypeAndData(blockposition4, Blocks.END_PORTAL.getBlockData(), 2);
                            }
                        }
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        MovingObjectPosition movingobjectposition = this.a(world, entityhuman, false);

        if (movingobjectposition != null && movingobjectposition.type == MovingObjectPosition.EnumMovingObjectType.BLOCK && world.getType(movingobjectposition.a()).getBlock() == Blocks.END_PORTAL_FRAME) {
            return itemstack;
        } else {
            if (!world.isClientSide) {
                BlockPosition blockposition = world.a("Stronghold", new BlockPosition(entityhuman));

                if (blockposition != null) {
                    EntityEnderSignal entityendersignal = new EntityEnderSignal(world, entityhuman.locX, entityhuman.locY, entityhuman.locZ);

                    entityendersignal.a(blockposition);
                    world.addEntity(entityendersignal);
                    world.makeSound(entityhuman, "random.bow", 0.5F, 0.4F / (ItemEnderEye.g.nextFloat() * 0.4F + 0.8F));
                    world.a((EntityHuman) null, 1002, new BlockPosition(entityhuman), 0);
                    if (!entityhuman.abilities.canInstantlyBuild) {
                        --itemstack.count;
                    }

                    entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
                }
            }

            return itemstack;
        }
    }
}
