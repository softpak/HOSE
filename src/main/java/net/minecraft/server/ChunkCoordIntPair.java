package net.minecraft.server;

public class ChunkCoordIntPair {

    public final int x;
    public final int z;

    public ChunkCoordIntPair(int i, int j) {
        this.x = i;
        this.z = j;
    }

    public static long a(int i, int j) {
        return (long) i & 4294967295L | ((long) j & 4294967295L) << 32;
    }

    public int hashCode() {
        int i = 1664525 * this.x + 1013904223;
        int j = 1664525 * (this.z ^ -559038737) + 1013904223;

        return i ^ j;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof ChunkCoordIntPair)) {
            return false;
        } else {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) object;

            return this.x == chunkcoordintpair.x && this.z == chunkcoordintpair.z;
        }
    }

    public int a() {
        return (this.x << 4) + 8;
    }

    public int b() {
        return (this.z << 4) + 8;
    }

    public int c() {
        return this.x << 4;
    }

    public int d() {
        return this.z << 4;
    }

    public int e() {
        return (this.x << 4) + 15;
    }

    public int f() {
        return (this.z << 4) + 15;
    }

    public BlockPosition a(int i, int j, int k) {
        return new BlockPosition((this.x << 4) + i, j, (this.z << 4) + k);
    }

    public BlockPosition a(int i) {
        return new BlockPosition(this.a(), i, this.b());
    }

    public String toString() {
        return "[" + this.x + ", " + this.z + "]";
    }
}
