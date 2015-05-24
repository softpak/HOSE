package net.minecraft.server;

import java.util.List;

public class EntityMinecartHopper extends EntityMinecartContainer implements IHopper {

    private boolean a = true;
    private int b = -1;
    private BlockPosition c;

    public EntityMinecartHopper(World world) {
        super(world);
        this.c = BlockPosition.ZERO;
    }

    public EntityMinecartHopper(World world, double d0, double d1, double d2) {
        super(world, d0, d1, d2);
        this.c = BlockPosition.ZERO;
    }

    public EntityMinecartAbstract.EnumMinecartType s() {
        return EntityMinecartAbstract.EnumMinecartType.HOPPER;
    }

    public IBlockData u() {
        return Blocks.HOPPER.getBlockData();
    }

    public int w() {
        return 1;
    }

    public int getSize() {
        return 5;
    }

    public boolean e(EntityHuman entityhuman) {
        if (!this.world.isClientSide) {
            entityhuman.openContainer(this);
        }

        return true;
    }

    public void a(int i, int j, int k, boolean flag) {
        boolean flag1 = !flag;

        if (flag1 != this.y()) {
            this.i(flag1);
        }

    }

    public boolean y() {
        return this.a;
    }

    public void i(boolean flag) {
        this.a = flag;
    }

    public World getWorld() {
        return this.world;
    }

    public double A() {
        return this.locX;
    }

    public double B() {
        return this.locY + 0.5D;
    }

    public double C() {
        return this.locZ;
    }

    public void t_() {
        super.t_();
        if (!this.world.isClientSide && this.isAlive() && this.y()) {
            BlockPosition blockposition = new BlockPosition(this);

            if (blockposition.equals(this.c)) {
                --this.b;
            } else {
                this.m(0);
            }

            if (!this.E()) {
                this.m(0);
                if (this.D()) {
                    this.m(4);
                    this.update();
                }
            }
        }

    }

    public boolean D() {
        if (TileEntityHopper.a((IHopper) this)) {
            return true;
        } else {
            List list = this.world.a(EntityItem.class, this.getBoundingBox().grow(0.25D, 0.0D, 0.25D), IEntitySelector.a);

            if (list.size() > 0) {
                TileEntityHopper.a((IInventory) this, (EntityItem) list.get(0));
            }

            return false;
        }
    }

    public void a(DamageSource damagesource) {
        super.a(damagesource);
        if (this.world.getGameRules().getBoolean("doEntityDrops")) {
            this.a(Item.getItemOf(Blocks.HOPPER), 1, 0.0F);
        }

    }

    protected void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setInt("TransferCooldown", this.b);
    }

    protected void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.b = nbttagcompound.getInt("TransferCooldown");
    }

    public void m(int i) {
        this.b = i;
    }

    public boolean E() {
        return this.b > 0;
    }

    public String getContainerName() {
        return "minecraft:hopper";
    }

    public Container createContainer(PlayerInventory playerinventory, EntityHuman entityhuman) {
        return new ContainerHopper(playerinventory, this, entityhuman);
    }
}
