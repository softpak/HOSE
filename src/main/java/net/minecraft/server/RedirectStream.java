package net.minecraft.server;

import java.io.OutputStream;
import java.io.PrintStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RedirectStream extends PrintStream {

    private static final Logger a = LogManager.getLogger();
    private final String b;

    public RedirectStream(String s, OutputStream outputstream) {
        super(outputstream);
        this.b = s;
    }

    public void println(String s) {
        this.a(s);
    }

    public void println(Object object) {
        this.a(String.valueOf(object));
    }

    private void a(String s) {
        StackTraceElement[] astacktraceelement = Thread.currentThread().getStackTrace();
        StackTraceElement stacktraceelement = astacktraceelement[Math.min(3, astacktraceelement.length)];

        RedirectStream.a.info("[{}]@.({}:{}): {}", new Object[] { this.b, stacktraceelement.getFileName(), Integer.valueOf(stacktraceelement.getLineNumber()), s});
    }
}
