package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class BlockCauldron extends Block {

    public static final BlockStateInteger LEVEL = BlockStateInteger.of("level", 0, 3);

    public BlockCauldron() {
        super(Material.ORE, MaterialMapColor.m);
        this.j(this.blockStateList.getBlockData().set(BlockCauldron.LEVEL, Integer.valueOf(0)));
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, AxisAlignedBB axisalignedbb, List<AxisAlignedBB> list, Entity entity) {
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        float f = 0.125F;

        this.a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        this.a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        this.a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        this.j();
    }

    public void j() {
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, Entity entity) {
        int i = ((Integer) iblockdata.get(BlockCauldron.LEVEL)).intValue();
        float f = (float) blockposition.getY() + (6.0F + (float) (3 * i)) / 16.0F;

        if (!world.isClientSide && entity.isBurning() && i > 0 && entity.getBoundingBox().b <= (double) f) {
            entity.extinguish();
            this.a(world, blockposition, iblockdata, i - 1);
        }

    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (world.isClientSide) {
            return true;
        } else {
            ItemStack itemstack = entityhuman.inventory.getItemInHand();

            if (itemstack == null) {
                return true;
            } else {
                int i = ((Integer) iblockdata.get(BlockCauldron.LEVEL)).intValue();
                Item item = itemstack.getItem();

                if (item == Items.WATER_BUCKET) {
                    if (i < 3) {
                        if (!entityhuman.abilities.canInstantlyBuild) {
                            entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, new ItemStack(Items.BUCKET));
                        }

                        entityhuman.b(StatisticList.I);
                        this.a(world, blockposition, iblockdata, 3);
                    }

                    return true;
                } else {
                    ItemStack itemstack1;

                    if (item == Items.GLASS_BOTTLE) {
                        if (i > 0) {
                            if (!entityhuman.abilities.canInstantlyBuild) {
                                itemstack1 = new ItemStack(Items.POTION, 1, 0);
                                if (!entityhuman.inventory.pickup(itemstack1)) {
                                    world.addEntity(new EntityItem(world, (double) blockposition.getX() + 0.5D, (double) blockposition.getY() + 1.5D, (double) blockposition.getZ() + 0.5D, itemstack1));
                                } else if (entityhuman instanceof EntityPlayer) {
                                    ((EntityPlayer) entityhuman).updateInventory(entityhuman.defaultContainer);
                                }

                                entityhuman.b(StatisticList.J);
                                --itemstack.count;
                                if (itemstack.count <= 0) {
                                    entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, (ItemStack) null);
                                }
                            }

                            this.a(world, blockposition, iblockdata, i - 1);
                        }

                        return true;
                    } else {
                        if (i > 0 && item instanceof ItemArmor) {
                            ItemArmor itemarmor = (ItemArmor) item;

                            if (itemarmor.x_() == ItemArmor.EnumArmorMaterial.LEATHER && itemarmor.d_(itemstack)) {
                                itemarmor.c(itemstack);
                                this.a(world, blockposition, iblockdata, i - 1);
                                entityhuman.b(StatisticList.K);
                                return true;
                            }
                        }

                        if (i > 0 && item instanceof ItemBanner && TileEntityBanner.c(itemstack) > 0) {
                            itemstack1 = itemstack.cloneItemStack();
                            itemstack1.count = 1;
                            TileEntityBanner.e(itemstack1);
                            if (itemstack.count <= 1 && !entityhuman.abilities.canInstantlyBuild) {
                                entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, itemstack1);
                            } else {
                                if (!entityhuman.inventory.pickup(itemstack1)) {
                                    world.addEntity(new EntityItem(world, (double) blockposition.getX() + 0.5D, (double) blockposition.getY() + 1.5D, (double) blockposition.getZ() + 0.5D, itemstack1));
                                } else if (entityhuman instanceof EntityPlayer) {
                                    ((EntityPlayer) entityhuman).updateInventory(entityhuman.defaultContainer);
                                }

                                entityhuman.b(StatisticList.L);
                                if (!entityhuman.abilities.canInstantlyBuild) {
                                    --itemstack.count;
                                }
                            }

                            if (!entityhuman.abilities.canInstantlyBuild) {
                                this.a(world, blockposition, iblockdata, i - 1);
                            }

                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, int i) {
        world.setTypeAndData(blockposition, iblockdata.set(BlockCauldron.LEVEL, Integer.valueOf(MathHelper.clamp(i, 0, 3))), 2);
        world.updateAdjacentComparators(blockposition, this);
    }

    public void k(World world, BlockPosition blockposition) {
        if (world.random.nextInt(20) == 1) {
            IBlockData iblockdata = world.getType(blockposition);

            if (((Integer) iblockdata.get(BlockCauldron.LEVEL)).intValue() < 3) {
                world.setTypeAndData(blockposition, iblockdata.a(BlockCauldron.LEVEL), 2);
            }

        }
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Items.CAULDRON;
    }

    public boolean isComplexRedstone() {
        return true;
    }

    public int l(World world, BlockPosition blockposition) {
        return ((Integer) world.getType(blockposition).get(BlockCauldron.LEVEL)).intValue();
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockCauldron.LEVEL, Integer.valueOf(i));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((Integer) iblockdata.get(BlockCauldron.LEVEL)).intValue();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockCauldron.LEVEL});
    }
}
