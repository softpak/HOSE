package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagFloat extends NBTBase.NBTNumber {

    private float data;

    NBTTagFloat() {}

    public NBTTagFloat(float f) {
        this.data = f;
    }

    void write(DataOutput dataoutput) throws IOException {
        dataoutput.writeFloat(this.data);
    }

    void load(DataInput datainput, int i, NBTReadLimiter nbtreadlimiter) throws IOException {
        nbtreadlimiter.a(32L);
        this.data = datainput.readFloat();
    }

    public byte getTypeId() {
        return (byte) 5;
    }

    public String toString() {
        return "" + this.data + "f";
    }

    public NBTBase clone() {
        return new NBTTagFloat(this.data);
    }

    public boolean equals(Object object) {
        if (super.equals(object)) {
            NBTTagFloat nbttagfloat = (NBTTagFloat) object;

            return this.data == nbttagfloat.data;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return super.hashCode() ^ Float.floatToIntBits(this.data);
    }

    public long c() {
        return (long) this.data;
    }

    public int d() {
        return MathHelper.d(this.data);
    }

    public short e() {
        return (short) (MathHelper.d(this.data) & '\uffff');
    }

    public byte f() {
        return (byte) (MathHelper.d(this.data) & 255);
    }

    public double g() {
        return (double) this.data;
    }

    public float h() {
        return this.data;
    }
}
