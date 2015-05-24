package net.minecraft.server;

import com.google.common.collect.Maps;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RemoteControlListener extends RemoteConnectionThread {

    private int h;
    private int i;
    private String j;
    private ServerSocket k;
    private String l;
    private Map<SocketAddress, RemoteControlSession> m;

    public RemoteControlListener(IMinecraftServer iminecraftserver) {
        super(iminecraftserver, "RCON Listener");
        this.h = iminecraftserver.a("rcon.port", 0);
        this.l = iminecraftserver.a("rcon.password", "");
        this.j = iminecraftserver.D();
        this.i = iminecraftserver.E();
        if (0 == this.h) {
            this.h = this.i + 10;
            this.b("Setting default rcon port to " + this.h);
            iminecraftserver.a("rcon.port", (Object) Integer.valueOf(this.h));
            if (0 == this.l.length()) {
                iminecraftserver.a("rcon.password", (Object) "");
            }

            iminecraftserver.a();
        }

        if (0 == this.j.length()) {
            this.j = "0.0.0.0";
        }

        this.f();
        this.k = null;
    }

    private void f() {
        this.m = Maps.newHashMap();
    }

    private void g() {
        Iterator iterator = this.m.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();

            if (!((RemoteControlSession) entry.getValue()).c()) {
                iterator.remove();
            }
        }

    }

    public void run() {
        this.b("RCON running on " + this.j + ":" + this.h);

        try {
            while (this.a) {
                try {
                    Socket socket = this.k.accept();

                    socket.setSoTimeout(500);
                    RemoteControlSession remotecontrolsession = new RemoteControlSession(this.b, socket);

                    remotecontrolsession.a();
                    this.m.put(socket.getRemoteSocketAddress(), remotecontrolsession);
                    this.g();
                } catch (SocketTimeoutException sockettimeoutexception) {
                    this.g();
                } catch (IOException ioexception) {
                    if (this.a) {
                        this.b("IO: " + ioexception.getMessage());
                    }
                }
            }
        } finally {
            this.b(this.k);
        }

    }

    public void a() {
        if (0 == this.l.length()) {
            this.c("No rcon password set in \'" + this.b.b() + "\', rcon disabled!");
        } else if (0 < this.h && '\uffff' >= this.h) {
            if (!this.a) {
                try {
                    this.k = new ServerSocket(this.h, 0, InetAddress.getByName(this.j));
                    this.k.setSoTimeout(500);
                    super.a();
                } catch (IOException ioexception) {
                    this.c("Unable to initialise rcon on " + this.j + ":" + this.h + " : " + ioexception.getMessage());
                }

            }
        } else {
            this.c("Invalid rcon port " + this.h + " found in \'" + this.b.b() + "\', rcon disabled!");
        }
    }
}
