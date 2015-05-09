/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bukkit.craftbukkit.util;

import com.amd.aparapi.Aparapi;

/**
 *
 * @author softpak
 */
public class HSA_Arrays {
    
    public static void fill(Object[] a, Object val) {
        Aparapi.range(a.length).forEach(gid_i -> a[gid_i] = val);
    }
    
    
    public static void fill(byte[] a, byte val) {
        Aparapi.range(a.length).forEach(gid_i -> a[gid_i] = val);
    }
    
    
    public static void fill(int[] a, int val) {
        Aparapi.range(a.length).forEach(gid_i -> a[gid_i] = val);
    }
    
    public static void fill(double[] a, double val) {
        Aparapi.range(a.length).forEach(gid_i -> a[gid_i] = val);
    }
    
    public static void fill(long[] a, long val) {
        Aparapi.range(a.length).forEach(gid_i -> a[gid_i] = val);
    }
    
    //Aparapi.range(size).parallel().forEach(gid -> squares[gid] = values[gid]*values[gid]);
    
    public static void fill(long[] a, int fromIndex, int toIndex, long val) {
        rangeCheck(a.length, fromIndex, toIndex);

        Aparapi.range(toIndex-fromIndex).forEach(gid_i -> a[gid_i+fromIndex] = val);
        /*for (int i = fromIndex; i < toIndex; i++)
            a[i] = val;*/
    }
    
    
    private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(
                    "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }

    
    
}
