package net.minecraft.server;

public class ChestLock {

    public static final ChestLock a = new ChestLock("");
    private final String b;

    public ChestLock(String s) {
        this.b = s;
    }

    public boolean a() {
        return this.b == null || this.b.isEmpty();
    }

    public String b() {
        return this.b;
    }

    public void a(NBTTagCompound nbttagcompound) {
        nbttagcompound.setString("Lock", this.b);
    }

    public static ChestLock b(NBTTagCompound nbttagcompound) {
        if (nbttagcompound.hasKeyOfType("Lock", 8)) {
            String s = nbttagcompound.getString("Lock");

            return new ChestLock(s);
        } else {
            return ChestLock.a;
        }
    }
}
