package net.minecraft.server;

public class WorldProviderTheEnd extends WorldProvider {

    public WorldProviderTheEnd() {}

    public void b() {
        this.c = new WorldChunkManagerHell(BiomeBase.SKY, 0.0F);
        this.dimension = 1;
        this.e = true;
    }

    public IChunkProvider getChunkProvider() {
        return new ChunkProviderTheEnd(this.b, this.b.getSeed());
    }

    public float a(long i, float f) {
        return 0.0F;
    }

    public boolean e() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean canSpawn(int i, int j) {
        return this.b.c(new BlockPosition(i, 0, j)).getMaterial().isSolid();
    }

    public BlockPosition h() {
        return new BlockPosition(100, 50, 0);
    }

    public int getSeaLevel() {
        return 50;
    }

    public String getName() {
        return "The End";
    }

    public String getSuffix() {
        return "_end";
    }
}
