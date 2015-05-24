package net.minecraft.server;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class RemoteStatusReply {

    private ByteArrayOutputStream buffer;
    private DataOutputStream stream;

    public RemoteStatusReply(int i) {
        this.buffer = new ByteArrayOutputStream(i);
        this.stream = new DataOutputStream(this.buffer);
    }

    public void a(byte[] abyte) throws IOException {
        this.stream.write(abyte, 0, abyte.length);
    }

    public void a(String s) throws IOException {
        this.stream.writeBytes(s);
        this.stream.write(0);
    }

    public void a(int i) throws IOException {
        this.stream.write(i);
    }

    public void a(short short0) throws IOException {
        this.stream.writeShort(Short.reverseBytes(short0));
    }

    public byte[] a() {
        return this.buffer.toByteArray();
    }

    public void b() {
        this.buffer.reset();
    }
}
