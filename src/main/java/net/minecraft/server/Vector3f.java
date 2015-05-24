package net.minecraft.server;

public class Vector3f {

    protected final float x;
    protected final float y;
    protected final float z;

    public Vector3f(float f, float f1, float f2) {
        this.x = f;
        this.y = f1;
        this.z = f2;
    }

    public Vector3f(NBTTagList nbttaglist) {
        this.x = nbttaglist.e(0);
        this.y = nbttaglist.e(1);
        this.z = nbttaglist.e(2);
    }

    public NBTTagList a() {
        NBTTagList nbttaglist = new NBTTagList();

        nbttaglist.add(new NBTTagFloat(this.x));
        nbttaglist.add(new NBTTagFloat(this.y));
        nbttaglist.add(new NBTTagFloat(this.z));
        return nbttaglist;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Vector3f)) {
            return false;
        } else {
            Vector3f vector3f = (Vector3f) object;

            return this.x == vector3f.x && this.y == vector3f.y && this.z == vector3f.z;
        }
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public float getZ() {
        return this.z;
    }
}
