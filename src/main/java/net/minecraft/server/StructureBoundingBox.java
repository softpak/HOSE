package net.minecraft.server;

import com.google.common.base.Objects;

public class StructureBoundingBox {

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public StructureBoundingBox() {}

    public StructureBoundingBox(int[] aint) {
        if (aint.length == 6) {
            this.a = aint[0];
            this.b = aint[1];
            this.c = aint[2];
            this.d = aint[3];
            this.e = aint[4];
            this.f = aint[5];
        }

    }

    public static StructureBoundingBox a() {
        return new StructureBoundingBox(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static StructureBoundingBox a(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, EnumDirection enumdirection) {
        switch (StructureBoundingBox.SyntheticClass_1.a[enumdirection.ordinal()]) {
        case 1:
            return new StructureBoundingBox(i + l, j + i1, k - i2 + 1 + j1, i + k1 - 1 + l, j + l1 - 1 + i1, k + j1);

        case 2:
            return new StructureBoundingBox(i + l, j + i1, k + j1, i + k1 - 1 + l, j + l1 - 1 + i1, k + i2 - 1 + j1);

        case 3:
            return new StructureBoundingBox(i - i2 + 1 + j1, j + i1, k + l, i + j1, j + l1 - 1 + i1, k + k1 - 1 + l);

        case 4:
            return new StructureBoundingBox(i + j1, j + i1, k + l, i + i2 - 1 + j1, j + l1 - 1 + i1, k + k1 - 1 + l);

        default:
            return new StructureBoundingBox(i + l, j + i1, k + j1, i + k1 - 1 + l, j + l1 - 1 + i1, k + i2 - 1 + j1);
        }
    }

    public static StructureBoundingBox a(int i, int j, int k, int l, int i1, int j1) {
        return new StructureBoundingBox(Math.min(i, l), Math.min(j, i1), Math.min(k, j1), Math.max(i, l), Math.max(j, i1), Math.max(k, j1));
    }

    public StructureBoundingBox(StructureBoundingBox structureboundingbox) {
        this.a = structureboundingbox.a;
        this.b = structureboundingbox.b;
        this.c = structureboundingbox.c;
        this.d = structureboundingbox.d;
        this.e = structureboundingbox.e;
        this.f = structureboundingbox.f;
    }

    public StructureBoundingBox(int i, int j, int k, int l, int i1, int j1) {
        this.a = i;
        this.b = j;
        this.c = k;
        this.d = l;
        this.e = i1;
        this.f = j1;
    }

    public StructureBoundingBox(BaseBlockPosition baseblockposition, BaseBlockPosition baseblockposition1) {
        this.a = Math.min(baseblockposition.getX(), baseblockposition1.getX());
        this.b = Math.min(baseblockposition.getY(), baseblockposition1.getY());
        this.c = Math.min(baseblockposition.getZ(), baseblockposition1.getZ());
        this.d = Math.max(baseblockposition.getX(), baseblockposition1.getX());
        this.e = Math.max(baseblockposition.getY(), baseblockposition1.getY());
        this.f = Math.max(baseblockposition.getZ(), baseblockposition1.getZ());
    }

    public StructureBoundingBox(int i, int j, int k, int l) {
        this.a = i;
        this.c = j;
        this.d = k;
        this.f = l;
        this.b = 1;
        this.e = 512;
    }

    public boolean a(StructureBoundingBox structureboundingbox) {
        return this.d >= structureboundingbox.a && this.a <= structureboundingbox.d && this.f >= structureboundingbox.c && this.c <= structureboundingbox.f && this.e >= structureboundingbox.b && this.b <= structureboundingbox.e;
    }

    public boolean a(int i, int j, int k, int l) {
        return this.d >= i && this.a <= k && this.f >= j && this.c <= l;
    }

    public void b(StructureBoundingBox structureboundingbox) {
        this.a = Math.min(this.a, structureboundingbox.a);
        this.b = Math.min(this.b, structureboundingbox.b);
        this.c = Math.min(this.c, structureboundingbox.c);
        this.d = Math.max(this.d, structureboundingbox.d);
        this.e = Math.max(this.e, structureboundingbox.e);
        this.f = Math.max(this.f, structureboundingbox.f);
    }

    public void a(int i, int j, int k) {
        this.a += i;
        this.b += j;
        this.c += k;
        this.d += i;
        this.e += j;
        this.f += k;
    }

    public boolean b(BaseBlockPosition baseblockposition) {
        return baseblockposition.getX() >= this.a && baseblockposition.getX() <= this.d && baseblockposition.getZ() >= this.c && baseblockposition.getZ() <= this.f && baseblockposition.getY() >= this.b && baseblockposition.getY() <= this.e;
    }

    public BaseBlockPosition b() {
        return new BaseBlockPosition(this.d - this.a, this.e - this.b, this.f - this.c);
    }

    public int c() {
        return this.d - this.a + 1;
    }

    public int d() {
        return this.e - this.b + 1;
    }

    public int e() {
        return this.f - this.c + 1;
    }

    public BaseBlockPosition f() {
        return new BlockPosition(this.a + (this.d - this.a + 1) / 2, this.b + (this.e - this.b + 1) / 2, this.c + (this.f - this.c + 1) / 2);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("x0", this.a).add("y0", this.b).add("z0", this.c).add("x1", this.d).add("y1", this.e).add("z1", this.f).toString();
    }

    public NBTTagIntArray g() {
        return new NBTTagIntArray(new int[] { this.a, this.b, this.c, this.d, this.e, this.f});
    }

    static class SyntheticClass_1 {

        static final int[] a = new int[EnumDirection.values().length];

        static {
            try {
                StructureBoundingBox.SyntheticClass_1.a[EnumDirection.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
                StructureBoundingBox.SyntheticClass_1.a[EnumDirection.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

            try {
                StructureBoundingBox.SyntheticClass_1.a[EnumDirection.WEST.ordinal()] = 3;
            } catch (NoSuchFieldError nosuchfielderror2) {
                ;
            }

            try {
                StructureBoundingBox.SyntheticClass_1.a[EnumDirection.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError nosuchfielderror3) {
                ;
            }

        }
    }
}
