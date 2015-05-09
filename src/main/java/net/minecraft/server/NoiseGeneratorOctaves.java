package net.minecraft.server;

import com.amd.aparapi.Aparapi;
import java.util.Random;

public class NoiseGeneratorOctaves extends NoiseGenerator {

    private NoiseGeneratorPerlin[] a;
    private int b;

    public NoiseGeneratorOctaves(Random random, int i) {
        this.b = i;
        this.a = new NoiseGeneratorPerlin[i];

        Aparapi.range(i).forEach(gid_j -> this.a[gid_j] = new NoiseGeneratorPerlin(random));
        /*
        for (int j = 0; j < i; ++j) {
            this.a[j] = new NoiseGeneratorPerlin(random);
        }*/

    }

    double[] hadouble;
    double d3;
    public double[] a(double[] adouble, int i, int j, int k, int l, int i1, int j1, double d0, double d1, double d2) {
        if (adouble == null) {
            //adouble = new double[l * i1 * j1];
            hadouble = new double[l * i1 * j1];
        } else {
            hadouble = new double[adouble.length];
            Aparapi.range(hadouble.length).forEach(gid_k1 -> hadouble[gid_k1] = 0.0D);
            /*
            for (int k1 = 0; k1 < adouble.length; ++k1) {
                adouble[k1] = 0.0D;
            }*/
        }

        //double d3 = 1.0D;
        d3 = 1.0D;

        Aparapi.range(this.b).forEach(gid_l1 -> {
            double d4 = (double) i * d3 * d0;
            double d5 = (double) j * d3 * d1;
            double d6 = (double) k * d3 * d2;
            long i2 = MathHelper.d(d4);
            long j2 = MathHelper.d(d6);

            d4 -= (double) i2;
            d6 -= (double) j2;
            i2 %= 16777216L;
            j2 %= 16777216L;
            d4 += (double) i2;
            d6 += (double) j2;
            this.a[gid_l1].a(hadouble, d4, d5, d6, l, i1, j1, d0 * d3, d1 * d3, d2 * d3, d3);
            d3 /= 2.0D;
        });
        /*
        for (int l1 = 0; l1 < this.b; ++l1) {
            double d4 = (double) i * d3 * d0;
            double d5 = (double) j * d3 * d1;
            double d6 = (double) k * d3 * d2;
            long i2 = MathHelper.d(d4);
            long j2 = MathHelper.d(d6);

            d4 -= (double) i2;
            d6 -= (double) j2;
            i2 %= 16777216L;
            j2 %= 16777216L;
            d4 += (double) i2;
            d6 += (double) j2;
            this.a[l1].a(adouble, d4, d5, d6, l, i1, j1, d0 * d3, d1 * d3, d2 * d3, d3);
            d3 /= 2.0D;
        }

        return adouble;*/
        return hadouble;
    }

    public double[] a(double[] adouble, int i, int j, int k, int l, double d0, double d1, double d2) {
        return this.a(adouble, i, 10, j, k, 1, l, d0, 1.0D, d1);
    }
}
