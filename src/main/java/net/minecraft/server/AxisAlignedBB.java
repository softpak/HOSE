package net.minecraft.server;

import java.util.stream.IntStream;

public class AxisAlignedBB {

    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public AxisAlignedBB(double d0, double d1, double d2, double d3, double d4, double d5) {
        this.a = Math.min(d0, d3);
        this.b = Math.min(d1, d4);
        this.c = Math.min(d2, d5);
        this.d = Math.max(d0, d3);
        this.e = Math.max(d1, d4);
        this.f = Math.max(d2, d5);
    }

    public AxisAlignedBB(BlockPosition blockposition, BlockPosition blockposition1) {
        this.a = (double) blockposition.getX();
        this.b = (double) blockposition.getY();
        this.c = (double) blockposition.getZ();
        this.d = (double) blockposition1.getX();
        this.e = (double) blockposition1.getY();
        this.f = (double) blockposition1.getZ();
    }

    public AxisAlignedBB a(double d0, double d1, double d2) {
        double d3 = this.a;
        double d4 = this.b;
        double d5 = this.c;
        double d6 = this.d;
        double d7 = this.e;
        double d8 = this.f;

        if (d0 < 0.0D) {
            d3 += d0;
        } else if (d0 > 0.0D) {
            d6 += d0;
        }

        if (d1 < 0.0D) {
            d4 += d1;
        } else if (d1 > 0.0D) {
            d7 += d1;
        }

        if (d2 < 0.0D) {
            d5 += d2;
        } else if (d2 > 0.0D) {
            d8 += d2;
        }

        return new AxisAlignedBB(d3, d4, d5, d6, d7, d8);
    }

    public AxisAlignedBB grow(double d0, double d1, double d2) {
        double d3 = this.a - d0;
        double d4 = this.b - d1;
        double d5 = this.c - d2;
        double d6 = this.d + d0;
        double d7 = this.e + d1;
        double d8 = this.f + d2;

        return new AxisAlignedBB(d3, d4, d5, d6, d7, d8);
    }

    public AxisAlignedBB a(AxisAlignedBB axisalignedbb) {
        double d0 = Math.min(this.a, axisalignedbb.a);
        double d1 = Math.min(this.b, axisalignedbb.b);
        double d2 = Math.min(this.c, axisalignedbb.c);
        double d3 = Math.max(this.d, axisalignedbb.d);
        double d4 = Math.max(this.e, axisalignedbb.e);
        double d5 = Math.max(this.f, axisalignedbb.f);

        return new AxisAlignedBB(d0, d1, d2, d3, d4, d5);
    }

    public static AxisAlignedBB a(double d0, double d1, double d2, double d3, double d4, double d5) {
        double d6 = Math.min(d0, d3);
        double d7 = Math.min(d1, d4);
        double d8 = Math.min(d2, d5);
        double d9 = Math.max(d0, d3);
        double d10 = Math.max(d1, d4);
        double d11 = Math.max(d2, d5);

        return new AxisAlignedBB(d6, d7, d8, d9, d10, d11);
    }

    public AxisAlignedBB c(double d0, double d1, double d2) {
        return new AxisAlignedBB(this.a + d0, this.b + d1, this.c + d2, this.d + d0, this.e + d1, this.f + d2);
    }

    public double a(AxisAlignedBB axisalignedbb, double d0) {
        if (axisalignedbb.e > this.b && axisalignedbb.b < this.e && axisalignedbb.f > this.c && axisalignedbb.c < this.f) {
            double d1;

            if (d0 > 0.0D && axisalignedbb.d <= this.a) {
                d1 = this.a - axisalignedbb.d;
                if (d1 < d0) {
                    d0 = d1;
                }
            } else if (d0 < 0.0D && axisalignedbb.a >= this.d) {
                d1 = this.d - axisalignedbb.a;
                if (d1 > d0) {
                    d0 = d1;
                }
            }

            return d0;
        } else {
            return d0;
        }
    }

    public double b(AxisAlignedBB axisalignedbb, double d0) {
        if (axisalignedbb.d > this.a && axisalignedbb.a < this.d && axisalignedbb.f > this.c && axisalignedbb.c < this.f) {
            double d1;

            if (d0 > 0.0D && axisalignedbb.e <= this.b) {
                d1 = this.b - axisalignedbb.e;
                if (d1 < d0) {
                    d0 = d1;
                }
            } else if (d0 < 0.0D && axisalignedbb.b >= this.e) {
                d1 = this.e - axisalignedbb.b;
                if (d1 > d0) {
                    d0 = d1;
                }
            }

            return d0;
        } else {
            return d0;
        }
    }

    public double c(AxisAlignedBB axisalignedbb, double d0) {
        if (axisalignedbb.d > this.a && axisalignedbb.a < this.d && axisalignedbb.e > this.b && axisalignedbb.b < this.e) {
            double d1;

            if (d0 > 0.0D && axisalignedbb.f <= this.c) {
                d1 = this.c - axisalignedbb.f;
                if (d1 < d0) {
                    d0 = d1;
                }
            } else if (d0 < 0.0D && axisalignedbb.c >= this.f) {
                d1 = this.f - axisalignedbb.c;
                if (d1 > d0) {
                    d0 = d1;
                }
            }

            return d0;
        } else {
            return d0;
        }
    }

    public boolean b(AxisAlignedBB axisalignedbb) {
        return axisalignedbb.d > this.a && axisalignedbb.a < this.d ? (axisalignedbb.e > this.b && axisalignedbb.b < this.e ? axisalignedbb.f > this.c && axisalignedbb.c < this.f : false) : false;
    }

    public boolean a(Vec3D vec3d) {
        return vec3d.a > this.a && vec3d.a < this.d ? (vec3d.b > this.b && vec3d.b < this.e ? vec3d.c > this.c && vec3d.c < this.f : false) : false;
    }

    public double a() {
        double d0 = this.d - this.a;
        double d1 = this.e - this.b;
        double d2 = this.f - this.c;

        return (d0 + d1 + d2) / 3.0D;
    }

    public AxisAlignedBB shrink(double d0, double d1, double d2) {
        double d3 = this.a + d0;
        double d4 = this.b + d1;
        double d5 = this.c + d2;
        double d6 = this.d - d0;
        double d7 = this.e - d1;
        double d8 = this.f - d2;

        return new AxisAlignedBB(d3, d4, d5, d6, d7, d8);
    }

    public MovingObjectPosition a(Vec3D vec3d, Vec3D vec3d1) {
        Vec3D vec3d2 = vec3d.a(vec3d1, this.a);
        Vec3D vec3d3 = vec3d.a(vec3d1, this.d);
        Vec3D vec3d4 = vec3d.b(vec3d1, this.b);
        Vec3D vec3d5 = vec3d.b(vec3d1, this.e);
        Vec3D vec3d6 = vec3d.c(vec3d1, this.c);
        Vec3D vec3d7 = vec3d.c(vec3d1, this.f);

        if (!this.b(vec3d2)) {
            vec3d2 = null;
        }

        if (!this.b(vec3d3)) {
            vec3d3 = null;
        }

        if (!this.c(vec3d4)) {
            vec3d4 = null;
        }

        if (!this.c(vec3d5)) {
            vec3d5 = null;
        }

        if (!this.d(vec3d6)) {
            vec3d6 = null;
        }

        if (!this.d(vec3d7)) {
            vec3d7 = null;
        }

        Vec3D vec3d8 = null;

        if (vec3d2 != null) {
            vec3d8 = vec3d2;
        }

        if (vec3d3 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d3) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d3;
        }

        if (vec3d4 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d4) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d4;
        }

        if (vec3d5 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d5) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d5;
        }

        if (vec3d6 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d6) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d6;
        }

        if (vec3d7 != null && (vec3d8 == null || vec3d.distanceSquared(vec3d7) < vec3d.distanceSquared(vec3d8))) {
            vec3d8 = vec3d7;
        }

        if (vec3d8 == null) {
            return null;
        } else {
            EnumDirection enumdirection = null;

            if (vec3d8 == vec3d2) {
                enumdirection = EnumDirection.WEST;
            } else if (vec3d8 == vec3d3) {
                enumdirection = EnumDirection.EAST;
            } else if (vec3d8 == vec3d4) {
                enumdirection = EnumDirection.DOWN;
            } else if (vec3d8 == vec3d5) {
                enumdirection = EnumDirection.UP;
            } else if (vec3d8 == vec3d6) {
                enumdirection = EnumDirection.NORTH;
            } else {
                enumdirection = EnumDirection.SOUTH;
            }

            return new MovingObjectPosition(vec3d8, enumdirection);
        }
    }

    private boolean b(Vec3D vec3d) {
        return vec3d == null ? false : vec3d.b >= this.b && vec3d.b <= this.e && vec3d.c >= this.c && vec3d.c <= this.f;
    }

    private boolean c(Vec3D vec3d) {
        return vec3d == null ? false : vec3d.a >= this.a && vec3d.a <= this.d && vec3d.c >= this.c && vec3d.c <= this.f;
    }

    private boolean d(Vec3D vec3d) {
        return vec3d == null ? false : vec3d.a >= this.a && vec3d.a <= this.d && vec3d.b >= this.b && vec3d.b <= this.e;
    }

    public String toString() {
        return "box[" + this.a + ", " + this.b + ", " + this.c + " -> " + this.d + ", " + this.e + ", " + this.f + "]";
    }
}
