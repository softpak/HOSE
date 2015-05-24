package net.minecraft.server;

public class WorldGenFlatLayerInfo {

    private final int a;
    private IBlockData b;
    private int c;
    private int d;

    public WorldGenFlatLayerInfo(int i, Block block) {
        this(3, i, block);
    }

    public WorldGenFlatLayerInfo(int i, int j, Block block) {
        this.c = 1;
        this.a = i;
        this.c = j;
        this.b = block.getBlockData();
    }

    public WorldGenFlatLayerInfo(int i, int j, Block block, int k) {
        this(i, j, block);
        this.b = block.fromLegacyData(k);
    }

    public int b() {
        return this.c;
    }

    public IBlockData c() {
        return this.b;
    }

    private Block e() {
        return this.b.getBlock();
    }

    private int f() {
        return this.b.getBlock().toLegacyData(this.b);
    }

    public int d() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public String toString() {
        String s;

        if (this.a >= 3) {
            MinecraftKey minecraftkey = (MinecraftKey) Block.REGISTRY.c(this.e());

            s = minecraftkey == null ? "null" : minecraftkey.toString();
            if (this.c > 1) {
                s = this.c + "*" + s;
            }
        } else {
            s = Integer.toString(Block.getId(this.e()));
            if (this.c > 1) {
                s = this.c + "x" + s;
            }
        }

        int i = this.f();

        if (i > 0) {
            s = s + ":" + i;
        }

        return s;
    }
}
