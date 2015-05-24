package net.minecraft.server;

public class ChunkSnapshot {

    private final short[] a = new short[65536];
    private final IBlockData b;

    public ChunkSnapshot() {
        this.b = Blocks.AIR.getBlockData();
    }

    public IBlockData a(int i, int j, int k) {
        int l = i << 12 | k << 8 | j;

        return this.a(l);
    }

    public IBlockData a(int i) {
        if (i >= 0 && i < this.a.length) {
            IBlockData iblockdata = (IBlockData) Block.d.a(this.a[i]);

            return iblockdata != null ? iblockdata : this.b;
        } else {
            throw new IndexOutOfBoundsException("The coordinate is out of range");
        }
    }

    public void a(int i, int j, int k, IBlockData iblockdata) {
        int l = i << 12 | k << 8 | j;

        this.a(l, iblockdata);
    }

    public void a(int i, IBlockData iblockdata) {
        if (i >= 0 && i < this.a.length) {
            this.a[i] = (short) Block.d.b(iblockdata);
        } else {
            throw new IndexOutOfBoundsException("The coordinate is out of range");
        }
    }
}
