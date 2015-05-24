package net.minecraft.server;

public final class WorldSettings {

    private final long a;
    private final WorldSettings.EnumGamemode b;
    private final boolean c;
    private final boolean d;
    private final WorldType e;
    private boolean f;
    private boolean g;
    private String h;

    public WorldSettings(long i, WorldSettings.EnumGamemode worldsettings_enumgamemode, boolean flag, boolean flag1, WorldType worldtype) {
        this.h = "";
        this.a = i;
        this.b = worldsettings_enumgamemode;
        this.c = flag;
        this.d = flag1;
        this.e = worldtype;
    }

    public WorldSettings(WorldData worlddata) {
        this(worlddata.getSeed(), worlddata.getGameType(), worlddata.shouldGenerateMapFeatures(), worlddata.isHardcore(), worlddata.getType());
    }

    public WorldSettings a() {
        this.g = true;
        return this;
    }

    public WorldSettings setGeneratorSettings(String s) {
        this.h = s;
        return this;
    }

    public boolean c() {
        return this.g;
    }

    public long d() {
        return this.a;
    }

    public WorldSettings.EnumGamemode e() {
        return this.b;
    }

    public boolean f() {
        return this.d;
    }

    public boolean g() {
        return this.c;
    }

    public WorldType h() {
        return this.e;
    }

    public boolean i() {
        return this.f;
    }

    public static WorldSettings.EnumGamemode a(int i) {
        return WorldSettings.EnumGamemode.getById(i);
    }

    public String j() {
        return this.h;
    }

    public static enum EnumGamemode {

        NOT_SET(-1, ""), SURVIVAL(0, "survival"), CREATIVE(1, "creative"), ADVENTURE(2, "adventure"), SPECTATOR(3, "spectator");

        int f;
        String g;

        private EnumGamemode(int i, String s) {
            this.f = i;
            this.g = s;
        }

        public int getId() {
            return this.f;
        }

        public String b() {
            return this.g;
        }

        public void a(PlayerAbilities playerabilities) {
            if (this == WorldSettings.EnumGamemode.CREATIVE) {
                playerabilities.canFly = true;
                playerabilities.canInstantlyBuild = true;
                playerabilities.isInvulnerable = true;
            } else if (this == WorldSettings.EnumGamemode.SPECTATOR) {
                playerabilities.canFly = true;
                playerabilities.canInstantlyBuild = false;
                playerabilities.isInvulnerable = true;
                playerabilities.isFlying = true;
            } else {
                playerabilities.canFly = false;
                playerabilities.canInstantlyBuild = false;
                playerabilities.isInvulnerable = false;
                playerabilities.isFlying = false;
            }

            playerabilities.mayBuild = !this.c();
        }

        public boolean c() {
            return this == WorldSettings.EnumGamemode.ADVENTURE || this == WorldSettings.EnumGamemode.SPECTATOR;
        }

        public boolean d() {
            return this == WorldSettings.EnumGamemode.CREATIVE;
        }

        public boolean e() {
            return this == WorldSettings.EnumGamemode.SURVIVAL || this == WorldSettings.EnumGamemode.ADVENTURE;
        }

        public static WorldSettings.EnumGamemode getById(int i) {
            WorldSettings.EnumGamemode[] aworldsettings_enumgamemode = values();
            int j = aworldsettings_enumgamemode.length;

            for (int k = 0; k < j; ++k) {
                WorldSettings.EnumGamemode worldsettings_enumgamemode = aworldsettings_enumgamemode[k];

                if (worldsettings_enumgamemode.f == i) {
                    return worldsettings_enumgamemode;
                }
            }

            return WorldSettings.EnumGamemode.SURVIVAL;
        }
    }
}
