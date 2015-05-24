package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;

public class PacketEncryptionHandler {

    private final Cipher a;
    private byte[] b = new byte[0];
    private byte[] c = new byte[0];

    protected PacketEncryptionHandler(Cipher cipher) {
        this.a = cipher;
    }

    private byte[] a(ByteBuf bytebuf) {
        int i = bytebuf.readableBytes();

        if (this.b.length < i) {
            this.b = new byte[i];
        }

        bytebuf.readBytes(this.b, 0, i);
        return this.b;
    }

    protected ByteBuf a(ChannelHandlerContext channelhandlercontext, ByteBuf bytebuf) throws ShortBufferException {
        int i = bytebuf.readableBytes();
        byte[] abyte = this.a(bytebuf);
        ByteBuf bytebuf1 = channelhandlercontext.alloc().heapBuffer(this.a.getOutputSize(i));

        bytebuf1.writerIndex(this.a.update(abyte, 0, i, bytebuf1.array(), bytebuf1.arrayOffset()));
        return bytebuf1;
    }

    protected void a(ByteBuf bytebuf, ByteBuf bytebuf1) throws ShortBufferException {
        int i = bytebuf.readableBytes();
        byte[] abyte = this.a(bytebuf);
        int j = this.a.getOutputSize(i);

        if (this.c.length < j) {
            this.c = new byte[j];
        }

        bytebuf1.writeBytes(this.c, 0, this.a.update(abyte, 0, i, this.c));
    }
}
