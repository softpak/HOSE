package net.minecraft.server;

public class SecondaryWorldData extends WorldData {

    private final WorldData b;

    public SecondaryWorldData(WorldData worlddata) {
        this.b = worlddata;
    }

    public NBTTagCompound a() {
        return this.b.a();
    }

    public NBTTagCompound a(NBTTagCompound nbttagcompound) {
        return this.b.a(nbttagcompound);
    }

    public long getSeed() {
        return this.b.getSeed();
    }

    public int c() {
        return this.b.c();
    }

    public int d() {
        return this.b.d();
    }

    public int e() {
        return this.b.e();
    }

    public long getTime() {
        return this.b.getTime();
    }

    public long getDayTime() {
        return this.b.getDayTime();
    }

    public NBTTagCompound i() {
        return this.b.i();
    }

    public String getName() {
        return this.b.getName();
    }

    public int l() {
        return this.b.l();
    }

    public boolean isThundering() {
        return this.b.isThundering();
    }

    public int getThunderDuration() {
        return this.b.getThunderDuration();
    }

    public boolean hasStorm() {
        return this.b.hasStorm();
    }

    public int getWeatherDuration() {
        return this.b.getWeatherDuration();
    }

    public WorldSettings.EnumGamemode getGameType() {
        return this.b.getGameType();
    }

    public void setTime(long i) {}

    public void setDayTime(long i) {}

    public void setSpawn(BlockPosition blockposition) {}

    public void a(String s) {}

    public void e(int i) {}

    public void setThundering(boolean flag) {}

    public void setThunderDuration(int i) {}

    public void setStorm(boolean flag) {}

    public void setWeatherDuration(int i) {}

    public boolean shouldGenerateMapFeatures() {
        return this.b.shouldGenerateMapFeatures();
    }

    public boolean isHardcore() {
        return this.b.isHardcore();
    }

    public WorldType getType() {
        return this.b.getType();
    }

    public void a(WorldType worldtype) {}

    public boolean v() {
        return this.b.v();
    }

    public void c(boolean flag) {}

    public boolean w() {
        return this.b.w();
    }

    public void d(boolean flag) {}

    public GameRules x() {
        return this.b.x();
    }

    public EnumDifficulty y() {
        return this.b.y();
    }

    public void setDifficulty(EnumDifficulty enumdifficulty) {}

    public boolean z() {
        return this.b.z();
    }

    public void e(boolean flag) {}
}
