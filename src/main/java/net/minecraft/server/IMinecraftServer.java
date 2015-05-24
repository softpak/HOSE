package net.minecraft.server;

public interface IMinecraftServer {

    int a(String s, int i);

    String a(String s, String s1);

    void a(String s, Object object);

    void a();

    String b();

    String D();

    int E();

    String F();

    String getVersion();

    int H();

    int I();

    String[] getPlayers();

    String T();

    String getPlugins();

    String executeRemoteCommand(String s);

    boolean isDebugging();

    void info(String s);

    void warning(String s);

    void g(String s);

    void h(String s);
}
