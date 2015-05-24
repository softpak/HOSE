package net.minecraft.server;

public enum EnumDifficulty {

    PEACEFUL(0, "options.difficulty.peaceful"), EASY(1, "options.difficulty.easy"), NORMAL(2, "options.difficulty.normal"), HARD(3, "options.difficulty.hard");

    private static final EnumDifficulty[] e = new EnumDifficulty[values().length];
    private final int f;
    private final String g;

    private EnumDifficulty(int i, String s) {
        this.f = i;
        this.g = s;
    }

    public int a() {
        return this.f;
    }

    public static EnumDifficulty getById(int i) {
        return EnumDifficulty.e[i % EnumDifficulty.e.length];
    }

    public String b() {
        return this.g;
    }

    static {
        EnumDifficulty[] aenumdifficulty = values();
        int i = aenumdifficulty.length;

        for (int j = 0; j < i; ++j) {
            EnumDifficulty enumdifficulty = aenumdifficulty[j];

            EnumDifficulty.e[enumdifficulty.f] = enumdifficulty;
        }

    }
}
