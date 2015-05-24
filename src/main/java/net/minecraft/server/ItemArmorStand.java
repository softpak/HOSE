package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class ItemArmorStand extends Item {

    public ItemArmorStand() {
        this.a(CreativeModeTab.c);
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2) {
        if (enumdirection == EnumDirection.DOWN) {
            return false;
        } else {
            boolean flag = world.getType(blockposition).getBlock().a(world, blockposition);
            BlockPosition blockposition1 = flag ? blockposition : blockposition.shift(enumdirection);

            if (!entityhuman.a(blockposition1, enumdirection, itemstack)) {
                return false;
            } else {
                BlockPosition blockposition2 = blockposition1.up();
                boolean flag1 = !world.isEmpty(blockposition1) && !world.getType(blockposition1).getBlock().a(world, blockposition1);

                flag1 |= !world.isEmpty(blockposition2) && !world.getType(blockposition2).getBlock().a(world, blockposition2);
                if (flag1) {
                    return false;
                } else {
                    double d0 = (double) blockposition1.getX();
                    double d1 = (double) blockposition1.getY();
                    double d2 = (double) blockposition1.getZ();
                    List list = world.getEntities((Entity) null, AxisAlignedBB.a(d0, d1, d2, d0 + 1.0D, d1 + 2.0D, d2 + 1.0D));

                    if (list.size() > 0) {
                        return false;
                    } else {
                        if (!world.isClientSide) {
                            world.setAir(blockposition1);
                            world.setAir(blockposition2);
                            EntityArmorStand entityarmorstand = new EntityArmorStand(world, d0 + 0.5D, d1, d2 + 0.5D);
                            float f3 = (float) MathHelper.d((MathHelper.g(entityhuman.yaw - 180.0F) + 22.5F) / 45.0F) * 45.0F;

                            entityarmorstand.setPositionRotation(d0 + 0.5D, d1, d2 + 0.5D, f3, 0.0F);
                            this.a(entityarmorstand, world.random);
                            NBTTagCompound nbttagcompound = itemstack.getTag();

                            if (nbttagcompound != null && nbttagcompound.hasKeyOfType("EntityTag", 10)) {
                                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                                entityarmorstand.d(nbttagcompound1);
                                nbttagcompound1.a(nbttagcompound.getCompound("EntityTag"));
                                entityarmorstand.f(nbttagcompound1);
                            }

                            world.addEntity(entityarmorstand);
                        }

                        --itemstack.count;
                        return true;
                    }
                }
            }
        }
    }

    private void a(EntityArmorStand entityarmorstand, Random random) {
        Vector3f vector3f = entityarmorstand.t();
        float f = random.nextFloat() * 5.0F;
        float f1 = random.nextFloat() * 20.0F - 10.0F;
        Vector3f vector3f1 = new Vector3f(vector3f.getX() + f, vector3f.getY() + f1, vector3f.getZ());

        entityarmorstand.setHeadPose(vector3f1);
        vector3f = entityarmorstand.u();
        f = random.nextFloat() * 10.0F - 5.0F;
        vector3f1 = new Vector3f(vector3f.getX(), vector3f.getY() + f, vector3f.getZ());
        entityarmorstand.setBodyPose(vector3f1);
    }
}
