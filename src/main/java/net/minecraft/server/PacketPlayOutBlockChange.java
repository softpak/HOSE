package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutBlockChange implements Packet<PacketListenerPlayOut> {

    private BlockPosition a;
    public IBlockData block; // CraftBukkit - public

    public PacketPlayOutBlockChange() {}

    public PacketPlayOutBlockChange(World world, BlockPosition blockposition) {
        this.a = blockposition;
        this.block = world.getType(blockposition);
    }

    public void a(PacketDataSerializer packetdataserializer) throws IOException {
        this.a = packetdataserializer.c();
        this.block = (IBlockData) Block.d.a(packetdataserializer.e());
    }

    public void b(PacketDataSerializer packetdataserializer) throws IOException {
        packetdataserializer.a(this.a);
        packetdataserializer.b(Block.d.b(this.block));
    }

    public void a(PacketListenerPlayOut packetlistenerplayout) {
        packetlistenerplayout.a(this);
    }
}
