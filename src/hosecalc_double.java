/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.HOSE;

import com.amd.aparapi.Kernel;
import net.minecraft.server.MathHelper;

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
        //int gid = getGlobalId();
            //        (l1 & 63) - 32 + i;
        //MathHelper.floor((axisalignedbb.a - 2.0D) / 16.0D)
        da[3] = floor((da[0] - da[1]) / da[2]);
    }
}
