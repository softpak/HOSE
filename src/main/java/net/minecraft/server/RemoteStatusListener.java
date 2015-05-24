package net.minecraft.server;

import com.google.common.collect.Maps;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class RemoteStatusListener extends RemoteConnectionThread {

    private long h;
    private int i;
    private int j;
    private int k;
    private String l;
    private String m;
    private DatagramSocket n;
    private byte[] o = new byte[1460];
    private DatagramPacket p;
    private Map<SocketAddress, String> q;
    private String r;
    private String s;
    private Map<SocketAddress, RemoteStatusListener.RemoteStatusChallenge> t;
    private long u;
    private RemoteStatusReply v;
    private long w;

    public RemoteStatusListener(IMinecraftServer iminecraftserver) {
        super(iminecraftserver, "Query Listener");
        this.i = iminecraftserver.a("query.port", 0);
        this.s = iminecraftserver.D();
        this.j = iminecraftserver.E();
        this.l = iminecraftserver.F();
        this.k = iminecraftserver.I();
        this.m = iminecraftserver.T();
        this.w = 0L;
        this.r = "0.0.0.0";
        if (0 != this.s.length() && !this.r.equals(this.s)) {
            this.r = this.s;
        } else {
            this.s = "0.0.0.0";

            try {
                InetAddress inetaddress = InetAddress.getLocalHost();

                this.r = inetaddress.getHostAddress();
            } catch (UnknownHostException unknownhostexception) {
                this.c("Unable to determine local host IP, please set server-ip in \'" + iminecraftserver.b() + "\' : " + unknownhostexception.getMessage());
            }
        }

        if (0 == this.i) {
            this.i = this.j;
            this.b("Setting default query port to " + this.i);
            iminecraftserver.a("query.port", (Object) Integer.valueOf(this.i));
            iminecraftserver.a("debug", (Object) Boolean.valueOf(false));
            iminecraftserver.a();
        }

        this.q = Maps.newHashMap();
        this.v = new RemoteStatusReply(1460);
        this.t = Maps.newHashMap();
        this.u = (new Date()).getTime();
    }

    private void a(byte[] abyte, DatagramPacket datagrampacket) throws IOException {
        this.n.send(new DatagramPacket(abyte, abyte.length, datagrampacket.getSocketAddress()));
    }

    private boolean a(DatagramPacket datagrampacket) throws IOException {
        byte[] abyte = datagrampacket.getData();
        int i = datagrampacket.getLength();
        SocketAddress socketaddress = datagrampacket.getSocketAddress();

        this.a("Packet len " + i + " [" + socketaddress + "]");
        if (3 <= i && -2 == abyte[0] && -3 == abyte[1]) {
            this.a("Packet \'" + StatusChallengeUtils.a(abyte[2]) + "\' [" + socketaddress + "]");
            switch (abyte[2]) {
            case 0:
                if (!this.c(datagrampacket).booleanValue()) {
                    this.a("Invalid challenge [" + socketaddress + "]");
                    return false;
                } else if (15 == i) {
                    this.a(this.b(datagrampacket), datagrampacket);
                    this.a("Rules [" + socketaddress + "]");
                } else {
                    RemoteStatusReply remotestatusreply = new RemoteStatusReply(1460);

                    remotestatusreply.a((int) 0);
                    remotestatusreply.a(this.a(datagrampacket.getSocketAddress()));
                    remotestatusreply.a(this.l);
                    remotestatusreply.a("SMP");
                    remotestatusreply.a(this.m);
                    remotestatusreply.a(Integer.toString(this.d()));
                    remotestatusreply.a(Integer.toString(this.k));
                    remotestatusreply.a((short) this.j);
                    remotestatusreply.a(this.r);
                    this.a(remotestatusreply.a(), datagrampacket);
                    this.a("Status [" + socketaddress + "]");
                }

            default:
                return true;

            case 9:
                this.d(datagrampacket);
                this.a("Challenge [" + socketaddress + "]");
                return true;
            }
        } else {
            this.a("Invalid packet [" + socketaddress + "]");
            return false;
        }
    }

    private byte[] b(DatagramPacket datagrampacket) throws IOException {
        long i = MinecraftServer.ay();

        if (i < this.w + 5000L) {
            byte[] abyte = this.v.a();
            byte[] abyte1 = this.a(datagrampacket.getSocketAddress());

            abyte[1] = abyte1[0];
            abyte[2] = abyte1[1];
            abyte[3] = abyte1[2];
            abyte[4] = abyte1[3];
            return abyte;
        } else {
            this.w = i;
            this.v.b();
            this.v.a((int) 0);
            this.v.a(this.a(datagrampacket.getSocketAddress()));
            this.v.a("splitnum");
            this.v.a((int) 128);
            this.v.a((int) 0);
            this.v.a("hostname");
            this.v.a(this.l);
            this.v.a("gametype");
            this.v.a("SMP");
            this.v.a("game_id");
            this.v.a("MINECRAFT");
            this.v.a("version");
            this.v.a(this.b.getVersion());
            this.v.a("plugins");
            this.v.a(this.b.getPlugins());
            this.v.a("map");
            this.v.a(this.m);
            this.v.a("numplayers");
            this.v.a("" + this.d());
            this.v.a("maxplayers");
            this.v.a("" + this.k);
            this.v.a("hostport");
            this.v.a("" + this.j);
            this.v.a("hostip");
            this.v.a(this.r);
            this.v.a((int) 0);
            this.v.a((int) 1);
            this.v.a("player_");
            this.v.a((int) 0);
            String[] astring = this.b.getPlayers();
            String[] astring1 = astring;
            int j = astring.length;

            for (int k = 0; k < j; ++k) {
                String s = astring1[k];

                this.v.a(s);
            }

            this.v.a((int) 0);
            return this.v.a();
        }
    }

    private byte[] a(SocketAddress socketaddress) {
        return ((RemoteStatusListener.RemoteStatusChallenge) this.t.get(socketaddress)).c();
    }

    private Boolean c(DatagramPacket datagrampacket) {
        SocketAddress socketaddress = datagrampacket.getSocketAddress();

        if (!this.t.containsKey(socketaddress)) {
            return Boolean.valueOf(false);
        } else {
            byte[] abyte = datagrampacket.getData();

            return ((RemoteStatusListener.RemoteStatusChallenge) this.t.get(socketaddress)).a() != StatusChallengeUtils.c(abyte, 7, datagrampacket.getLength()) ? Boolean.valueOf(false) : Boolean.valueOf(true);
        }
    }

    private void d(DatagramPacket datagrampacket) throws IOException {
        RemoteStatusListener.RemoteStatusChallenge remotestatuslistener_remotestatuschallenge = new RemoteStatusListener.RemoteStatusChallenge(datagrampacket);

        this.t.put(datagrampacket.getSocketAddress(), remotestatuslistener_remotestatuschallenge);
        this.a(remotestatuslistener_remotestatuschallenge.b(), datagrampacket);
    }

    private void f() {
        if (this.a) {
            long i = MinecraftServer.ay();

            if (i >= this.h + 30000L) {
                this.h = i;
                Iterator iterator = this.t.entrySet().iterator();

                while (iterator.hasNext()) {
                    Entry entry = (Entry) iterator.next();

                    if (((RemoteStatusListener.RemoteStatusChallenge) entry.getValue()).a(i).booleanValue()) {
                        iterator.remove();
                    }
                }

            }
        }
    }

    public void run() {
        this.b("Query running on " + this.s + ":" + this.i);
        this.h = MinecraftServer.ay();
        this.p = new DatagramPacket(this.o, this.o.length);

        try {
            while (this.a) {
                try {
                    this.n.receive(this.p);
                    this.f();
                    this.a(this.p);
                } catch (SocketTimeoutException sockettimeoutexception) {
                    this.f();
                } catch (PortUnreachableException portunreachableexception) {
                    ;
                } catch (IOException ioexception) {
                    this.a((Exception) ioexception);
                }
            }
        } finally {
            this.e();
        }

    }

    public void a() {
        if (!this.a) {
            if (0 < this.i && '\uffff' >= this.i) {
                if (this.g()) {
                    super.a();
                }

            } else {
                this.c("Invalid query port " + this.i + " found in \'" + this.b.b() + "\' (queries disabled)");
            }
        }
    }

    private void a(Exception exception) {
        if (this.a) {
            this.c("Unexpected exception, buggy JRE? (" + exception.toString() + ")");
            if (!this.g()) {
                this.d("Failed to recover from buggy JRE, shutting down!");
                this.a = false;
            }

        }
    }

    private boolean g() {
        try {
            this.n = new DatagramSocket(this.i, InetAddress.getByName(this.s));
            this.a(this.n);
            this.n.setSoTimeout(500);
            return true;
        } catch (SocketException socketexception) {
            this.c("Unable to initialise query system on " + this.s + ":" + this.i + " (Socket): " + socketexception.getMessage());
        } catch (UnknownHostException unknownhostexception) {
            this.c("Unable to initialise query system on " + this.s + ":" + this.i + " (Unknown Host): " + unknownhostexception.getMessage());
        } catch (Exception exception) {
            this.c("Unable to initialise query system on " + this.s + ":" + this.i + " (E): " + exception.getMessage());
        }

        return false;
    }

    class RemoteStatusChallenge {

        private long time = (new Date()).getTime();
        private int token;
        private byte[] identity;
        private byte[] response;
        private String f;

        public RemoteStatusChallenge(DatagramPacket datagrampacket) {
            byte[] abyte = datagrampacket.getData();

            this.identity = new byte[4];
            this.identity[0] = abyte[3];
            this.identity[1] = abyte[4];
            this.identity[2] = abyte[5];
            this.identity[3] = abyte[6];
            this.f = new String(this.identity);
            this.token = (new Random()).nextInt(16777216);
            this.response = String.format("\t%s%d\u0000", new Object[] { this.f, Integer.valueOf(this.token)}).getBytes();
        }

        public Boolean a(long i) {
            return Boolean.valueOf(this.time < i);
        }

        public int a() {
            return this.token;
        }

        public byte[] b() {
            return this.response;
        }

        public byte[] c() {
            return this.identity;
        }
    }
}
