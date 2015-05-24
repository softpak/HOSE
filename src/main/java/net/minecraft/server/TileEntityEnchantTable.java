package net.minecraft.server;

import java.util.Random;

public class TileEntityEnchantTable extends TileEntity implements IUpdatePlayerListBox, ITileEntityContainer {

    public int a;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    private static Random o = new Random();
    private String p;

    public TileEntityEnchantTable() {}

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        if (this.hasCustomName()) {
            nbttagcompound.setString("CustomName", this.p);
        }

    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        if (nbttagcompound.hasKeyOfType("CustomName", 8)) {
            this.p = nbttagcompound.getString("CustomName");
        }

    }

    public void c() {
        this.k = this.j;
        this.m = this.l;
        EntityHuman entityhuman = this.world.findNearbyPlayer((double) ((float) this.position.getX() + 0.5F), (double) ((float) this.position.getY() + 0.5F), (double) ((float) this.position.getZ() + 0.5F), 3.0D);

        if (entityhuman != null) {
            double d0 = entityhuman.locX - (double) ((float) this.position.getX() + 0.5F);
            double d1 = entityhuman.locZ - (double) ((float) this.position.getZ() + 0.5F);

            this.n = (float) MathHelper.b(d1, d0);
            this.j += 0.1F;
            if (this.j < 0.5F || TileEntityEnchantTable.o.nextInt(40) == 0) {
                float f = this.h;

                do {
                    this.h += (float) (TileEntityEnchantTable.o.nextInt(4) - TileEntityEnchantTable.o.nextInt(4));
                } while (f == this.h);
            }
        } else {
            this.n += 0.02F;
            this.j -= 0.1F;
        }

        while (this.l >= 3.1415927F) {
            this.l -= 6.2831855F;
        }

        while (this.l < -3.1415927F) {
            this.l += 6.2831855F;
        }

        while (this.n >= 3.1415927F) {
            this.n -= 6.2831855F;
        }

        while (this.n < -3.1415927F) {
            this.n += 6.2831855F;
        }

        float f1;

        for (f1 = this.n - this.l; f1 >= 3.1415927F; f1 -= 6.2831855F) {
            ;
        }

        while (f1 < -3.1415927F) {
            f1 += 6.2831855F;
        }

        this.l += f1 * 0.4F;
        this.j = MathHelper.a(this.j, 0.0F, 1.0F);
        ++this.a;
        this.g = this.f;
        float f2 = (this.h - this.f) * 0.4F;
        float f3 = 0.2F;

        f2 = MathHelper.a(f2, -f3, f3);
        this.i += (f2 - this.i) * 0.9F;
        this.f += this.i;
    }

    public String getName() {
        return this.hasCustomName() ? this.p : "container.enchant";
    }

    public boolean hasCustomName() {
        return this.p != null && this.p.length() > 0;
    }

    public void a(String s) {
        this.p = s;
    }

    public IChatBaseComponent getScoreboardDisplayName() {
        return (IChatBaseComponent) (this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatMessage(this.getName(), new Object[0]));
    }

    public Container createContainer(PlayerInventory playerinventory, EntityHuman entityhuman) {
        return new ContainerEnchantTable(playerinventory, this.world, this.position);
    }

    public String getContainerName() {
        return "minecraft:enchanting_table";
    }
}
