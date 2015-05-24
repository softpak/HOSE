/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.HOSE;

import com.amd.aparapi.Device;

import java.util.concurrent.atomic.AtomicLong;


/**
 *
 * @author softpak
 */
public class HRandom implements java.io.Serializable{
    static final long serialVersionUID = 3905348978240129619L;

    /**
     * The internal state associated with this pseudorandom number generator.
     * (The specs for the methods in this class describe the ongoing
     * computation of this value.)
     */
    private final AtomicLong seed;

    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;
    private static Device dev = Device.hsa();
    private static final double DOUBLE_UNIT = 0x1.0p-53; // 1.0 / (1L << 53)

    // IllegalArgumentException messages
    static final String BadBound = "bound must be positive";
    static final String BadRange = "bound must be greater than origin";
    static final String BadSize  = "size must be non-negative";
    
    
    public HRandom(long seed) {
        if (getClass() == HRandom.class)
            this.seed = new AtomicLong(initialScramble(seed));
        else {
            // subclass might have overriden setSeed
            this.seed = new AtomicLong();
            setSeed(seed);
        }
    }
    
    private static long initialScramble(long seed) {
        return (seed ^ multiplier) & mask;
    }

    public HRandom() {
        this(seedUniquifier() ^ System.nanoTime());
    }
    
    private static long seedUniquifier() {
        // L'Ecuyer, "Tables of Linear Congruential Generators of
        // Different Sizes and Good Lattice Structure", 1999
        for (;;) {
            long current = seedUniquifier.get();
            long next = current * 181783497276652981L;
            if (seedUniquifier.compareAndSet(current, next))
                return next;
        }
    }
    
    private static final AtomicLong seedUniquifier
        = new AtomicLong(8682522807148012L);
    
    
    synchronized public void setSeed(long seed) {
        this.seed.set(initialScramble(seed));
        haveNextNextGaussian = false;
    }
    
    long oldseed, nextseed;
    protected int next(int bits) {
        //long oldseed, nextseed;
        AtomicLong seed = this.seed;
        dev.forEach(100, i -> {
            oldseed = seed.get();
            nextseed = (oldseed * multiplier + addend) & mask;
            
        });
        seed.compareAndSet(oldseed, nextseed);
        
        /*do {
            oldseed = seed.get();
            nextseed = (oldseed * multiplier + addend) & mask;
            seed.compareAndSet(oldseed, nextseed);
        } while (!seed.compareAndSet(oldseed, nextseed));*/
        return (int)(nextseed >>> (48 - bits));
    }
    
    public boolean nextBoolean() {
        return next(1) != 0;
    }
    
    public int nextInt() {
        return next(32);
    }
    
    public int nextInt(int bound) {
        if (bound <= 0)
            throw new IllegalArgumentException(BadBound);

        int r = next(31);
        int m = bound - 1;
        if ((bound & m) == 0)  // i.e., bound is a power of 2
            r = (int)((bound * (long)r) >> 31);
        else {
            for (int u = r;
                 u - (r = u % bound) + m < 0;
                 u = next(31))
                ;
        }
        return r;
    }
    
    public float nextFloat() {
        return next(24) / ((float)(1 << 24));
    }
    
    public double nextDouble() {
        return (((long)(next(26)) << 27) + next(27)) * DOUBLE_UNIT;
    }
    
    public long nextLong() {
        // it's okay that the bottom word remains signed.
        return ((long)(next(32)) << 32) + next(32);
    }
    
    private double nextNextGaussian;
    private boolean haveNextNextGaussian = false;
    
    synchronized public double nextGaussian() {
        // See Knuth, ACP, Section 3.4.1 Algorithm C.
        double v1, v2, s;
        v1 = 2 * nextDouble() - 1; // between -1 and 1
        v2 = 2 * nextDouble() - 1; // between -1 and 1
        s = v1 * v1 + v2 * v2;
        double multiplier = StrictMath.sqrt(-2 * StrictMath.log(s)/s);
        nextNextGaussian = v2 * multiplier;
        haveNextNextGaussian = true;
        return v1 * multiplier;
    }


}
