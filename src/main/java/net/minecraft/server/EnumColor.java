package net.minecraft.server;

public enum EnumColor implements INamable {

    WHITE(0, 15, "white", "white", MaterialMapColor.j, EnumChatFormat.WHITE), ORANGE(1, 14, "orange", "orange", MaterialMapColor.q, EnumChatFormat.GOLD), MAGENTA(2, 13, "magenta", "magenta", MaterialMapColor.r, EnumChatFormat.AQUA), LIGHT_BLUE(3, 12, "light_blue", "lightBlue", MaterialMapColor.s, EnumChatFormat.BLUE), YELLOW(4, 11, "yellow", "yellow", MaterialMapColor.t, EnumChatFormat.YELLOW), LIME(5, 10, "lime", "lime", MaterialMapColor.u, EnumChatFormat.GREEN), PINK(6, 9, "pink", "pink", MaterialMapColor.v, EnumChatFormat.LIGHT_PURPLE), GRAY(7, 8, "gray", "gray", MaterialMapColor.w, EnumChatFormat.DARK_GRAY), SILVER(8, 7, "silver", "silver", MaterialMapColor.x, EnumChatFormat.GRAY), CYAN(9, 6, "cyan", "cyan", MaterialMapColor.y, EnumChatFormat.DARK_AQUA), PURPLE(10, 5, "purple", "purple", MaterialMapColor.z, EnumChatFormat.DARK_PURPLE), BLUE(11, 4, "blue", "blue", MaterialMapColor.A, EnumChatFormat.DARK_BLUE), BROWN(12, 3, "brown", "brown", MaterialMapColor.B, EnumChatFormat.GOLD), GREEN(13, 2, "green", "green", MaterialMapColor.C, EnumChatFormat.DARK_GREEN), RED(14, 1, "red", "red", MaterialMapColor.D, EnumChatFormat.DARK_RED), BLACK(15, 0, "black", "black", MaterialMapColor.E, EnumChatFormat.BLACK);

    private static final EnumColor[] q = new EnumColor[values().length];
    private static final EnumColor[] r = new EnumColor[values().length];
    private final int s;
    private final int t;
    private final String u;
    private final String v;
    private final MaterialMapColor w;
    private final EnumChatFormat x;

    private EnumColor(int i, int j, String s, String s1, MaterialMapColor materialmapcolor, EnumChatFormat enumchatformat) {
        this.s = i;
        this.t = j;
        this.u = s;
        this.v = s1;
        this.w = materialmapcolor;
        this.x = enumchatformat;
    }

    public int getColorIndex() {
        return this.s;
    }

    public int getInvColorIndex() {
        return this.t;
    }

    public String d() {
        return this.v;
    }

    public MaterialMapColor e() {
        return this.w;
    }

    public static EnumColor fromInvColorIndex(int i) {
        if (i < 0 || i >= EnumColor.r.length) {
            i = 0;
        }

        return EnumColor.r[i];
    }

    public static EnumColor fromColorIndex(int i) {
        if (i < 0 || i >= EnumColor.q.length) {
            i = 0;
        }

        return EnumColor.q[i];
    }

    public String toString() {
        return this.v;
    }

    public String getName() {
        return this.u;
    }

    static {
        EnumColor[] aenumcolor = values();
        int i = aenumcolor.length;

        for (int j = 0; j < i; ++j) {
            EnumColor enumcolor = aenumcolor[j];

            EnumColor.q[enumcolor.getColorIndex()] = enumcolor;
            EnumColor.r[enumcolor.getInvColorIndex()] = enumcolor;
        }

    }
}
