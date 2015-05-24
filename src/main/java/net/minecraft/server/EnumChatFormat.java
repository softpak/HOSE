package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public enum EnumChatFormat {

    BLACK("BLACK", '0', 0), DARK_BLUE("DARK_BLUE", '1', 1), DARK_GREEN("DARK_GREEN", '2', 2), DARK_AQUA("DARK_AQUA", '3', 3), DARK_RED("DARK_RED", '4', 4), DARK_PURPLE("DARK_PURPLE", '5', 5), GOLD("GOLD", '6', 6), GRAY("GRAY", '7', 7), DARK_GRAY("DARK_GRAY", '8', 8), BLUE("BLUE", '9', 9), GREEN("GREEN", 'a', 10), AQUA("AQUA", 'b', 11), RED("RED", 'c', 12), LIGHT_PURPLE("LIGHT_PURPLE", 'd', 13), YELLOW("YELLOW", 'e', 14), WHITE("WHITE", 'f', 15), OBFUSCATED("OBFUSCATED", 'k', true), BOLD("BOLD", 'l', true), STRIKETHROUGH("STRIKETHROUGH", 'm', true), UNDERLINE("UNDERLINE", 'n', true), ITALIC("ITALIC", 'o', true), RESET("RESET", 'r', -1);

    private static final Map<String, EnumChatFormat> w = Maps.newHashMap();
    private static final Pattern x = Pattern.compile("(?i)" + String.valueOf('\u00a7') + "[0-9A-FK-OR]");
    private final String y;
    private final char z;
    private final boolean A;
    private final String B;
    private final int C;

    private static String c(String s) {
        return s.toLowerCase().replaceAll("[^a-z]", "");
    }

    private EnumChatFormat(String s, char c0, int i) {
        this(s, c0, false, i);
    }

    private EnumChatFormat(String s, char c0, boolean flag) {
        this(s, c0, flag, -1);
    }

    private EnumChatFormat(String s, char c0, boolean flag, int i) {
        this.y = s;
        this.z = c0;
        this.A = flag;
        this.C = i;
        this.B = "\u00a7" + c0;
    }

    public int b() {
        return this.C;
    }

    public boolean isFormat() {
        return this.A;
    }

    public boolean d() {
        return !this.A && this != EnumChatFormat.RESET;
    }

    public String e() {
        return this.name().toLowerCase();
    }

    public String toString() {
        return this.B;
    }

    public static EnumChatFormat b(String s) {
        return s == null ? null : (EnumChatFormat) EnumChatFormat.w.get(c(s));
    }

    public static EnumChatFormat a(int i) {
        if (i < 0) {
            return EnumChatFormat.RESET;
        } else {
            EnumChatFormat[] aenumchatformat = values();
            int j = aenumchatformat.length;

            for (int k = 0; k < j; ++k) {
                EnumChatFormat enumchatformat = aenumchatformat[k];

                if (enumchatformat.b() == i) {
                    return enumchatformat;
                }
            }

            return null;
        }
    }

    public static Collection<String> a(boolean flag, boolean flag1) {
        ArrayList arraylist = Lists.newArrayList();
        EnumChatFormat[] aenumchatformat = values();
        int i = aenumchatformat.length;

        for (int j = 0; j < i; ++j) {
            EnumChatFormat enumchatformat = aenumchatformat[j];

            if ((!enumchatformat.d() || flag) && (!enumchatformat.isFormat() || flag1)) {
                arraylist.add(enumchatformat.e());
            }
        }

        return arraylist;
    }

    static {
        EnumChatFormat[] aenumchatformat = values();
        int i = aenumchatformat.length;

        for (int j = 0; j < i; ++j) {
            EnumChatFormat enumchatformat = aenumchatformat[j];

            EnumChatFormat.w.put(c(enumchatformat.y), enumchatformat);
        }

    }
}
