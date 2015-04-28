package net.minecraft.server;

import com.amd.aparapi.Aparapi;
import java.io.IOException;
import java.util.List;

public class PacketPlayOutMapChunkBulk implements Packet<PacketListenerPlayOut> {

    private int[] a;
    private int[] b;
    private PacketPlayOutMapChunk.ChunkMap[] c;
    private boolean d;
    private World world; // Spigot

    public PacketPlayOutMapChunkBulk() {}

    public PacketPlayOutMapChunkBulk(List<Chunk> list) {
        int i = list.size();

        this.a = new int[i];
        this.b = new int[i];
        this.c = new PacketPlayOutMapChunk.ChunkMap[i];
        this.d = !((Chunk) list.get(0)).getWorld().worldProvider.o();
        
        Aparapi.range(i).forEach(gid_j -> {
            Chunk chunk = (Chunk) list.get(gid_j);
            PacketPlayOutMapChunk.ChunkMap packetplayoutmapchunk_chunkmap = PacketPlayOutMapChunk.a(chunk, true, this.d, '\uffff');

            this.a[gid_j] = chunk.locX;
            this.b[gid_j] = chunk.locZ;
            this.c[gid_j] = packetplayoutmapchunk_chunkmap;
        });
        /*
        for (int j = 0; j < i; ++j) {
            Chunk chunk = (Chunk) list.get(j);
            PacketPlayOutMapChunk.ChunkMap packetplayoutmapchunk_chunkmap = PacketPlayOutMapChunk.a(chunk, true, this.d, '\uffff');

            this.a[j] = chunk.locX;
            this.b[j] = chunk.locZ;
            this.c[j] = packetplayoutmapchunk_chunkmap;
        }*/
        
        world = ((Chunk) list.get(0)).getWorld(); // Spigot
    }

    public void a(PacketDataSerializer packetdataserializer) throws IOException {
        this.d = packetdataserializer.readBoolean();
        int i = packetdataserializer.e();

        this.a = new int[i];
        this.b = new int[i];
        this.c = new PacketPlayOutMapChunk.ChunkMap[i];

        //int j;
        Aparapi.range(i).forEach(gid_j -> {
            this.a[gid_j] = packetdataserializer.readInt();
            this.b[gid_j] = packetdataserializer.readInt();
            this.c[gid_j] = new PacketPlayOutMapChunk.ChunkMap();
            this.c[gid_j].b = packetdataserializer.readShort() & '\uffff';
            this.c[gid_j].a = new byte[PacketPlayOutMapChunk.a(Integer.bitCount(this.c[gid_j].b), this.d, true)];
        });
        
        Aparapi.range(i).forEach(gid_j -> {
            packetdataserializer.readBytes(this.c[gid_j].a);
        });
        /*
        for (j = 0; j < i; ++j) {
            this.a[j] = packetdataserializer.readInt();
            this.b[j] = packetdataserializer.readInt();
            this.c[j] = new PacketPlayOutMapChunk.ChunkMap();
            this.c[j].b = packetdataserializer.readShort() & '\uffff';
            this.c[j].a = new byte[PacketPlayOutMapChunk.a(Integer.bitCount(this.c[j].b), this.d, true)];
        }

        for (j = 0; j < i; ++j) {
            packetdataserializer.readBytes(this.c[j].a);
        }*/

    }

    public void b(PacketDataSerializer packetdataserializer) throws IOException {
        packetdataserializer.writeBoolean(this.d);
        packetdataserializer.b(this.c.length);

        //int i;
        Aparapi.range(this.a.length).forEach(gid_i -> {
            packetdataserializer.writeInt(this.a[gid_i]);
            packetdataserializer.writeInt(this.b[gid_i]);
            packetdataserializer.writeShort((short) (this.c[gid_i].b & '\uffff'));
        });
        
        Aparapi.range(this.a.length).forEach(gid_i -> {
            world.spigotConfig.antiXrayInstance.obfuscate(this.a[gid_i], this.b[gid_i], this.c[gid_i].b, this.c[gid_i].a, world); // Spigot
            packetdataserializer.writeBytes(this.c[gid_i].a);
        });
        /*
        for (i = 0; i < this.a.length; ++i) {
            packetdataserializer.writeInt(this.a[i]);
            packetdataserializer.writeInt(this.b[i]);
            packetdataserializer.writeShort((short) (this.c[i].b & '\uffff'));
        }

        for (i = 0; i < this.a.length; ++i) {
            world.spigotConfig.antiXrayInstance.obfuscate(this.a[i], this.b[i], this.c[i].b, this.c[i].a, world); // Spigot
            packetdataserializer.writeBytes(this.c[i].a);
        }*/

    }

    public void a(PacketListenerPlayOut packetlistenerplayout) {
        packetlistenerplayout.a(this);
    }
}
