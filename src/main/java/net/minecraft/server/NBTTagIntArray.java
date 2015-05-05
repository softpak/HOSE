package net.minecraft.server;

import com.amd.aparapi.Aparapi;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class NBTTagIntArray extends NBTBase {

    private int[] data;

    NBTTagIntArray() {}

    public NBTTagIntArray(int[] aint) {
        this.data = aint;
    }
    //HSA
    void write(DataOutput dataoutput) throws IOException {
        dataoutput.writeInt(this.data.length);
        /*
        Aparapi.range(this.data.length).forEach(gid_i -> {
            try {
                dataoutput.writeInt(this.data[gid_i]);
            } catch (IOException ex) {
                Logger.getLogger(NBTTagIntArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        });*/
        IntStream.range(0, this.data.length).forEach(
            i -> {
            try {
                dataoutput.writeInt(this.data[i]);
            } catch (IOException ex) {
                Logger.getLogger(NBTTagIntArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        /*
        for (int i = 0; i < this.data.length; ++i) {
            dataoutput.writeInt(this.data[i]);
        }*/

    }

    void load(DataInput datainput, int i, NBTReadLimiter nbtreadlimiter) throws IOException {
        int j = datainput.readInt();
       com.google.common.base.Preconditions.checkArgument( j < 1 << 24);

        nbtreadlimiter.a((long) (32 * j));
        this.data = new int[j];
        
        Aparapi.range(j).forEach(gid_k -> {
            try {
                this.data[gid_k] = datainput.readInt();
            } catch (IOException ex) {
                Logger.getLogger(NBTTagIntArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        /*
        for (int k = 0; k < j; ++k) {
            this.data[k] = datainput.readInt();
        }*/

    }

    public byte getTypeId() {
        return (byte) 11;
    }
    
    //HSA
    String hs;
    public String toString() {
        //String s = "[";
        hs = "[";
        int[] aint = this.data;
        int i = aint.length;
        
        Aparapi.range(i).forEach(gid_j -> {
            int k = aint[gid_j];

            hs = hs + k + ",";
        });
        /*
        for (int j = 0; j < i; ++j) {
            int k = aint[j];

            s = s + k + ",";
        }*/

        return hs + "]";
    }

    public NBTBase clone() {
        int[] aint = new int[this.data.length];

        System.arraycopy(this.data, 0, aint, 0, this.data.length);
        return new NBTTagIntArray(aint);
    }

    public boolean equals(Object object) {
        return super.equals(object) ? Arrays.equals(this.data, ((NBTTagIntArray) object).data) : false;
    }

    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.data);
    }

    public int[] c() {
        return this.data;
    }
}
