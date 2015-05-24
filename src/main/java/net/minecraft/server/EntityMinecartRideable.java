package net.minecraft.server;

public class EntityMinecartRideable extends EntityMinecartAbstract {

    public EntityMinecartRideable(World world) {
        super(world);
    }

    public EntityMinecartRideable(World world, double d0, double d1, double d2) {
        super(world, d0, d1, d2);
    }

    public boolean e(EntityHuman entityhuman) {
        if (this.passenger != null && this.passenger instanceof EntityHuman && this.passenger != entityhuman) {
            return true;
        } else if (this.passenger != null && this.passenger != entityhuman) {
            return false;
        } else {
            if (!this.world.isClientSide) {
                entityhuman.mount(this);
            }

            return true;
        }
    }

    public void a(int i, int j, int k, boolean flag) {
        if (flag) {
            if (this.passenger != null) {
                this.passenger.mount((Entity) null);
            }

            if (this.getType() == 0) {
                this.k(-this.r());
                this.j(10);
                this.setDamage(50.0F);
                this.ac();
            }
        }

    }

    public EntityMinecartAbstract.EnumMinecartType s() {
        return EntityMinecartAbstract.EnumMinecartType.RIDEABLE;
    }
}
