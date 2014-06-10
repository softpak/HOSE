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

public class hosecalc_long extends Kernel{//softpak   return anything

    long[] da = new long[5];
    
    
    //int tt, long ct, long lt, long cat
    
    public hosecalc_long(){
        setExecutionMode(EXECUTION_MODE.GPU);
    }
    public long calc(int tt, long ct, long lt, long cat){
        this.da[0] = tt;
        this.da[1] = ct;
        this.da[2] = lt;
        this.da[3] = cat;
        execute(5);
        return da[4];
    }
    
    
    //wait = TICK_TIME - (curTime - lastTick) - catchupTime;
    //@Override
    public void run() {
        //int gid = getGlobalId();
        da[4] = da[0] - (da[1] - da[2]) - da[3];
    }
}
