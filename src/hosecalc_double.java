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

public class hosecalc_double extends Kernel{//softpak   return anything

    double[] da = new double[4];
    int func = 0;
    
    //int tt, long ct, long lt, long cat
    
    public hosecalc_double(){
        setExecutionMode(EXECUTION_MODE.GPU);
    }

    /*
    val[0] = (val[0] + 1.0D) * 0.01D;
    val[1] = val[1] * 12398.0D;
    val[2] = (val[2] * 3.1415927410125732 * 2.0D);
    */
    public double[] calcEntityLiving(){//
        func = 2;
        //da = new double[4];
        this.da[0] = Math.random();
        this.da[1] = Math.random();
        this.da[2] = Math.random();
        execute(3);
        return da;
    }
    
    
    public int calc(double i1, double i2, double i3){//
        func = 1;
        //da = new double[4];
        this.da[0] = i1;
        this.da[1] = i2;
        this.da[2] = i3;
        execute(4);
        return (int)da[3];
    }
    //wait = TICK_TIME - (curTime - lastTick) - catchupTime;
    //@Override
    public void run() {
        if (func == 1){
            da[3] = floor((da[0] - da[1]) / da[2]);
        }else if (func == 2 ){
            da[0] = (da[0] + 1.0D) * 0.01D;
            da[1] = da[1] * 12398.0D;
            da[2] = (da[2] * 3.1415927410125732 * 2.0D);
        }
        
    }
}
