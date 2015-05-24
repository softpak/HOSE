package net.minecraft.server;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadWatchdog implements Runnable {

    private static final Logger a = LogManager.getLogger();
    private final DedicatedServer b;
    private final long c;

    public ThreadWatchdog(DedicatedServer dedicatedserver) {
        this.b = dedicatedserver;
        this.c = dedicatedserver.aR();
    }

    public void run() {
        while (this.b.isRunning()) {
            long i = this.b.aK();
            long j = MinecraftServer.ay();
            long k = j - i;

            if (k > this.c) {
                ThreadWatchdog.a.fatal("A single server tick took " + String.format("%.2f", new Object[] { Float.valueOf((float) k / 1000.0F)}) + " seconds (should be max " + String.format("%.2f", new Object[] { Float.valueOf(0.05F)}) + ")");
                ThreadWatchdog.a.fatal("Considering it to be crashed, server will forcibly shutdown.");
                ThreadMXBean threadmxbean = ManagementFactory.getThreadMXBean();
                ThreadInfo[] athreadinfo = threadmxbean.dumpAllThreads(true, true);
                StringBuilder stringbuilder = new StringBuilder();
                Error error = new Error();
                ThreadInfo[] athreadinfo1 = athreadinfo;
                int l = athreadinfo.length;

                for (int i1 = 0; i1 < l; ++i1) {
                    ThreadInfo threadinfo = athreadinfo1[i1];

                    if (threadinfo.getThreadId() == this.b.aL().getId()) {
                        error.setStackTrace(threadinfo.getStackTrace());
                    }

                    stringbuilder.append(threadinfo);
                    stringbuilder.append("\n");
                }

                CrashReport crashreport = new CrashReport("Watching Server", error);

                this.b.b(crashreport);
                CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Thread Dump");

                crashreportsystemdetails.a("Threads", (Object) stringbuilder);
                File file = new File(new File(this.b.x(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");

                if (crashreport.a(file)) {
                    ThreadWatchdog.a.error("This crash report has been saved to: " + file.getAbsolutePath());
                } else {
                    ThreadWatchdog.a.error("We were unable to save this crash report to disk.");
                }

                this.a();
            }

            try {
                Thread.sleep(i + this.c - j);
            } catch (InterruptedException interruptedexception) {
                ;
            }
        }

    }

    private void a() {
        try {
            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                public void run() {
                    Runtime.getRuntime().halt(1);
                }
            }, 10000L);
            System.exit(1);
        } catch (Throwable throwable) {
            Runtime.getRuntime().halt(1);
        }

    }
}
