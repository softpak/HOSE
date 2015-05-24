package net.minecraft.server;

public class BlockActionData {

    private BlockPosition a;
    private Block b;
    private int c;
    private int d;

    public BlockActionData(BlockPosition blockposition, Block block, int i, int j) {
        this.a = blockposition;
        this.c = i;
        this.d = j;
        this.b = block;
    }

    public BlockPosition a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public Block d() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (!(object instanceof BlockActionData)) {
            return false;
        } else {
            BlockActionData blockactiondata = (BlockActionData) object;

            return this.a.equals(blockactiondata.a) && this.c == blockactiondata.c && this.d == blockactiondata.d && this.b == blockactiondata.b;
        }
    }

    public String toString() {
        return "TE(" + this.a + ")," + this.c + "," + this.d + "," + this.b;
    }
}
