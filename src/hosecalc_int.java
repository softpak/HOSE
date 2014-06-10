/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.HOSE;

import com.amd.aparapi.Kernel;

/**
 *
 * @author softpak
 */

public class hosecalc_int extends Kernel{//softpak   return anything

    int[] da;
    int func = 0;
    
    //int tt, long ct, long lt, long cat
    
    public hosecalc_int(){
        setExecutionMode(EXECUTION_MODE.GPU);
    }
    /*
    i2 = (l1 & 63) - 32 + i;
    j2 = (l1 >> 6 & 63) - 32 + j;
    k2 = (l1 >> 12 & 63) - 32 + k;
    l2 = l1 >> 18 & 15;
    */
    public int calc(int i1, int i2, int i3, int i4, int i5){//j2   f2
        func = 2;
        da = new int[6];
        this.da[0] = i1;
        this.da[1] = i2;
        this.da[2] = i3;
        this.da[3] = i4;
        this.da[4] = i5;
        execute(6);
        return da[5];
    }
    
    
    
    public int calc(int i1, int i2, int i3, int i4){//i2   f1
        func = 1;
        da = new int[5];
        this.da[0] = i1;
        this.da[1] = i2;
        this.da[2] = i3;
        this.da[3] = i4;
        execute(5);
        return da[4];
    }
    
    
    //wait = TICK_TIME - (curTime - lastTick) - catchupTime;
    //@Override
    public void run() {
        //int gid = getGlobalId();
        if (func == 1){
            //        (l1 & 63) - 32 + i;
            da[4] = (da[0] & (da[1]) - da[2]) + da[3];
        }else if (func == 2){
            //        (l1 >> 6 & 63) - 32 + j;
            da[5] = (da[0] >> da[1] & da[2]) - da[3] + da[4];
        }
        
    }
}
