/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.HOSE;

import com.amd.aparapi.Kernel;
import java.util.concurrent.Callable;

/**
 *
 * @author softpak
 */

public class hosecalc_long extends Kernel implements Callable<Long>{//softpak   return anything

    long[] da = new long[5];
    
    private static hosecalc_long _instance;
    public static hosecalc_long getInstance(int tt, long ct, long lt, long cat){
        if (_instance == null){
            _instance = new hosecalc_long(tt, ct, lt, cat);
        }
        return _instance;
    }
    
    
    public hosecalc_long(int tt, long ct, long lt, long cat){
        this.da[0] = tt;
        this.da[1] = ct;
        this.da[2] = lt;
        this.da[3] = cat;
        setExecutionMode(EXECUTION_MODE.GPU);
        
    }
    
    //wait = TICK_TIME - (curTime - lastTick) - catchupTime;
    //@Override
    public void run() {
        //int gid = getGlobalId();
        da[4] = da[0] - (da[1] - da[2]) - da[3];
    }


    //@Override
    public Long call() throws Exception {
        //System.out.println(da[4]);
        execute(5);
        return da[4];
    }

    
}
