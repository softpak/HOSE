package net.minecraft.server;

public class WorldType {

    public static final WorldType[] types = new WorldType[16];
    public static final WorldType NORMAL = (new WorldType(0, "default", 1)).i();
    public static final WorldType FLAT = new WorldType(1, "flat");
    public static final WorldType LARGE_BIOMES = new WorldType(2, "largeBiomes");
    public static final WorldType AMPLIFIED = (new WorldType(3, "amplified")).j();
    public static final WorldType CUSTOMIZED = new WorldType(4, "customized");
    public static final WorldType DEBUG_ALL_BLOCK_STATES = new WorldType(5, "debug_all_block_states");
    public static final WorldType NORMAL_1_1 = (new WorldType(8, "default_1_1", 0)).a(false);
    private final int i;
    private final String name;
    private final int version;
    private boolean l;
    private boolean m;
    private boolean n;

    private WorldType(int i, String s) {
        this(i, s, 0);
    }

    private WorldType(int i, String s, int j) {
        this.name = s;
        this.version = j;
        this.l = true;
        this.i = i;
        WorldType.types[i] = this;
    }

    public String name() {
        return this.name;
    }

    public int getVersion() {
        return this.version;
    }

    public WorldType a(int i) {
        return this == WorldType.NORMAL && i == 0 ? WorldType.NORMAL_1_1 : this;
    }

    private WorldType a(boolean flag) {
        this.l = flag;
        return this;
    }

    private WorldType i() {
        this.m = true;
        return this;
    }

    public boolean f() {
        return this.m;
    }

    public static WorldType getType(String s) {
        for (int i = 0; i < WorldType.types.length; ++i) {
            if (WorldType.types[i] != null && WorldType.types[i].name.equalsIgnoreCase(s)) {
                return WorldType.types[i];
            }
        }

        return null;
    }

    public int g() {
        return this.i;
    }

    private WorldType j() {
        this.n = true;
        return this;
    }
}
