package net.minecraft.server;

public class MapIcon {

    private byte type;
    private byte x;
    private byte y;
    private byte rotation;

    public MapIcon(byte b0, byte b1, byte b2, byte b3) {
        this.type = b0;
        this.x = b1;
        this.y = b2;
        this.rotation = b3;
    }

    public MapIcon(MapIcon mapicon) {
        this.type = mapicon.type;
        this.x = mapicon.x;
        this.y = mapicon.y;
        this.rotation = mapicon.rotation;
    }

    public byte getType() {
        return this.type;
    }

    public byte getX() {
        return this.x;
    }

    public byte getY() {
        return this.y;
    }

    public byte getRotation() {
        return this.rotation;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof MapIcon)) {
            return false;
        } else {
            MapIcon mapicon = (MapIcon) object;

            return this.type != mapicon.type ? false : (this.rotation != mapicon.rotation ? false : (this.x != mapicon.x ? false : this.y == mapicon.y));
        }
    }

    public int hashCode() {
        byte b0 = this.type;
        int i = 31 * b0 + this.x;

        i = 31 * i + this.y;
        i = 31 * i + this.rotation;
        return i;
    }
}
