package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.jppf.node.protocol.Task;

public class NoiseGeneratorOctaves extends NoiseGenerator {

    private NoiseGeneratorPerlin[] a;
    private int b;

    public NoiseGeneratorOctaves(Random random, int i) {
        System.out.println("NoiseGeneratorOctaves");
        this.b = i;
        this.a = new NoiseGeneratorPerlin[i];

        for (int j = 0; j < i; ++j) {
            this.a[j] = new NoiseGeneratorPerlin(random);
        }

    }
    

    //public double[] a(final double[] adouble, final int i, final int j, final int k, final int l, final int i1, final int j1, final double d0, final double d1, final double d2) {
    public double[] a(double[] adouble, final int i, final int j, final int k, final int l, final int i1, final int j1, final double d0, final double d1, final double d2) {
        if (adouble == null) {
            adouble = new double[l * i1 * j1];
        } else {
            for (int k1 = 0; k1 < adouble.length; ++k1) {
                adouble[k1] = 0.0D;
            }
        }

        double d3 = 1.0D;
        d3 = 1.0D;
        //jppf
        //for (int l1 = 0; l1 < this.b; ++l1) {
       
        /*       
        List<Task<?>> tasks = new ArrayList<>(this.b);
        for (int i=0; i< this.b; i++){
            tasks.add(new NBodyTask(bodies));
        }*/
        
        for (int l1 = 0; l1 < this.b; ++l1) {
            double d4 = (double) i * d3 * d0;
            double d5 = (double) j * d3 * d1;
            double d6 = (double) k * d3 * d2;
            d4 = (double) i * d3 * d0;
            d5 = (double) j * d3 * d1;
            d6 = (double) k * d3 * d2;
            long i2 = MathHelper.d(d4);
            long j2 = MathHelper.d(d6);

            d4 -= (double) i2;
            d6 -= (double) j2;
            i2 %= 16777216L;
            j2 %= 16777216L;
            d4 += (double) i2;
            d6 += (double) j2;
            //parallel
            this.a[l1].a(adouble, d4, d5, d6, l, i1, j1, d0 * d3, d1 * d3, d2 * d3, d3);
            d3 /= 2.0D;
        }
        return adouble;
    }
    Callable<double[]> ca;
    public double[] a(final double[] adouble,final int i,final int j,final int k,final int l,final double d0,final double d1,final double d2) throws InterruptedException, ExecutionException {
        //return this.a(adouble, i, 10, j, k, 1, l, d0, 1.0D, d1);
        ca = new Callable<double[]>() {                             
            public double[] call() throws Exception {
                //System.out.println("double[] a");
                return a(adouble, i, 10, j, k, 1, l, d0, 1.0D, d1);
            }
            
        };
        FutureTask<double[]> future = new FutureTask<double[]>(ca);  
        new Thread(future).start();  
        return future.get();
    }
}
