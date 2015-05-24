package net.minecraft.server;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.apache.logging.log4j.Logger;
import oshi.SystemInfo;
import oshi.hardware.Processor;

public class SystemUtils {

    private static String a;

    public static String a() {
        return SystemUtils.a == null ? "<unknown>" : SystemUtils.a;
    }

    public static <V> V a(FutureTask<V> futuretask, Logger logger) {
        try {
            futuretask.run();
            return futuretask.get();
        } catch (ExecutionException executionexception) {
            logger.fatal("Error executing task", executionexception);
        } catch (InterruptedException interruptedexception) {
            logger.fatal("Error executing task", interruptedexception);
        }

        return null;
    }

    static {
        try {
            Processor[] aprocessor = (new SystemInfo()).getHardware().getProcessors();

            SystemUtils.a = String.format("%dx %s", new Object[] { Integer.valueOf(aprocessor.length), aprocessor[0]}).replaceAll("\\s+", " ");
        } catch (Exception exception) {
            ;
        }

    }
}
