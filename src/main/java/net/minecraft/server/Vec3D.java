package net.minecraft.server;

import com.amd.aparapi.Device;

public class Vec3D {

    public final double a;
    public final double b;
    public final double c;
    
    public Vec3D(double d0, double d1, double d2) {
        if (d0 == -0.0D) {
            d0 = 0.0D;
        }

        if (d1 == -0.0D) {
            d1 = 0.0D;
        }

        if (d2 == -0.0D) {
            d2 = 0.0D;
        }
        
        this.a = d0;
        this.b = d1;
        this.c = d2;
    }

    public Vec3D(BaseBlockPosition baseblockposition) {
        this((double) baseblockposition.getX(), (double) baseblockposition.getY(), (double) baseblockposition.getZ());
    }

    //HSA
    //double[] hd0 = new double[1];
    public Vec3D a() {
        
        double d0 = (double) MathHelper.sqrt(this.a * this.a + this.b * this.b + this.c * this.c);
        //double d0 = (double) MathHelper.sqrt(hd0[0]);

        return d0 < 1.0E-4D ? new Vec3D(0.0D, 0.0D, 0.0D) : new Vec3D(this.a / d0, this.b / d0, this.c / d0);
    }

    //HSA
    public double b(Vec3D vec3d) {
        //Device.hsa().forEach(0, 1 , i -> hhb[i] = ha[i] * vec3d.a + hb[i] * vec3d.b + hc[i] * vec3d.c);
        //Device.hsa().forEach(0, 1 , i -> hhb[i] = this.a * vec3d.a + this.b * vec3d.b + this.c * vec3d.c);
        return this.a * vec3d.a + this.b * vec3d.b + this.c * vec3d.c;
        //return hhb[0];
    }

    public Vec3D d(Vec3D vec3d) {
        return this.a(vec3d.a, vec3d.b, vec3d.c);
    }

    public Vec3D a(double d0, double d1, double d2) {
        return this.add(-d0, -d1, -d2);
    }

    public Vec3D e(Vec3D vec3d) {
        return this.add(vec3d.a, vec3d.b, vec3d.c);
    }

    public Vec3D add(double d0, double d1, double d2) {
        return new Vec3D(this.a + d0, this.b + d1, this.c + d2);
    }

    //HSA
    public double distanceSquared(Vec3D vec3d) {
        double d0 = vec3d.a - this.a;
        double d1 = vec3d.b - this.b;
        double d2 = vec3d.c - this.c;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public double b() {
        return (double) MathHelper.sqrt(this.a * this.a + this.b * this.b + this.c * this.c);
    }

    public Vec3D a(Vec3D vec3d, double d0) {
        double d1 = vec3d.a - this.a;
        double d2 = vec3d.b - this.b;
        double d3 = vec3d.c - this.c;

        if (d1 * d1 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double d4 = (d0 - this.a) / d1;

            return d4 >= 0.0D && d4 <= 1.0D ? new Vec3D(this.a + d1 * d4, this.b + d2 * d4, this.c + d3 * d4) : null;
        }
    }

    public Vec3D b(Vec3D vec3d, double d0) {
        double d1 = vec3d.a - this.a;
        double d2 = vec3d.b - this.b;
        double d3 = vec3d.c - this.c;

        if (d2 * d2 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double d4 = (d0 - this.b) / d2;

            return d4 >= 0.0D && d4 <= 1.0D ? new Vec3D(this.a + d1 * d4, this.b + d2 * d4, this.c + d3 * d4) : null;
        }
    }

    public Vec3D c(Vec3D vec3d, double d0) {
        double d1 = vec3d.a - this.a;
        double d2 = vec3d.b - this.b;
        double d3 = vec3d.c - this.c;

        if (d3 * d3 < 1.0000000116860974E-7D) {
            return null;
        } else {
            double d4 = (d0 - this.c) / d3;

            return d4 >= 0.0D && d4 <= 1.0D ? new Vec3D(this.a + d1 * d4, this.b + d2 * d4, this.c + d3 * d4) : null;
        }
    }

    public String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + ")";
    }

    public Vec3D a(float f) {
        float f1 = MathHelper.cos(f);
        float f2 = MathHelper.sin(f);
        double d0 = this.a;
        double d1 = this.b * (double) f1 + this.c * (double) f2;
        double d2 = this.c * (double) f1 - this.b * (double) f2;
        //Device.hsa().forEach(0, 1, i -> d1[i] = this.b * (double) f1 + this.c * (double) f2);
        //Device.hsa().forEach(0, 1, i -> d2[i] = this.c * (double) f1 - this.b * (double) f2);

        return new Vec3D(d0, d1, d2);
    }

    public Vec3D b(float f) {
        float f1 = MathHelper.cos(f);
        float f2 = MathHelper.sin(f);
        double d0 = this.a * (double) f1 + this.c * (double) f2;
        //Device.hsa().forEach(0, 1, i -> d0[i] = this.a * (double) f1 + this.c * (double) f2);
        double d1 = this.b;
        double d2 = this.c * (double) f1 - this.a * (double) f2;
        //Device.hsa().forEach(0, 1, i -> d2[i] = this.c * (double) f1 - this.a * (double) f2);

        return new Vec3D(d0, d1, d2);
    }
}
