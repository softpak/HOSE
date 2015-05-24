package net.minecraft.server;

public class NBTReadLimiter {

    public static final NBTReadLimiter a = new NBTReadLimiter(0L) {
        public void a(long i) {}
    };
    private final long b;
    private long c;

    public NBTReadLimiter(long i) {
        this.b = i;
    }

    public void a(long i) {
        this.c += i / 8L;
        if (this.c > this.b) {
            throw new RuntimeException("Tried to read NBT tag that was too big; tried to allocate: " + this.c + "bytes where max allowed: " + this.b);
        }
    }
}
