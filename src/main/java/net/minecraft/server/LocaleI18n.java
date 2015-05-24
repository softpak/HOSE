package net.minecraft.server;

public class LocaleI18n {

    private static LocaleLanguage a = LocaleLanguage.a();
    private static LocaleLanguage b = new LocaleLanguage();

    public static String get(String s) {
        return LocaleI18n.a.a(s);
    }

    public static String a(String s, Object... aobject) {
        return LocaleI18n.a.a(s, aobject);
    }

    public static String b(String s) {
        return LocaleI18n.b.a(s);
    }

    public static boolean c(String s) {
        return LocaleI18n.a.b(s);
    }

    public static long a() {
        return LocaleI18n.a.c();
    }
}
