package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class CrashReportSystemDetails {

    private final CrashReport a;
    private final String b;
    private final List<CrashReportSystemDetails.CrashReportDetail> c = Lists.newArrayList();
    private StackTraceElement[] d = new StackTraceElement[0];

    public CrashReportSystemDetails(CrashReport crashreport, String s) {
        this.a = crashreport;
        this.b = s;
    }

    public static String a(double d0, double d1, double d2) {
        return String.format("%.2f,%.2f,%.2f - %s", new Object[] { Double.valueOf(d0), Double.valueOf(d1), Double.valueOf(d2), a(new BlockPosition(d0, d1, d2))});
    }

    public static String a(BlockPosition blockposition) {
        int i = blockposition.getX();
        int j = blockposition.getY();
        int k = blockposition.getZ();
        StringBuilder stringbuilder = new StringBuilder();

        try {
            stringbuilder.append(String.format("World: (%d,%d,%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)}));
        } catch (Throwable throwable) {
            stringbuilder.append("(Error finding world loc)");
        }

        stringbuilder.append(", ");

        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;

        try {
            l = i >> 4;
            i1 = k >> 4;
            j1 = i & 15;
            k1 = j >> 4;
            l1 = k & 15;
            i2 = l << 4;
            j2 = i1 << 4;
            k2 = (l + 1 << 4) - 1;
            l2 = (i1 + 1 << 4) - 1;
            stringbuilder.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", new Object[] { Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf(l1), Integer.valueOf(l), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j2), Integer.valueOf(k2), Integer.valueOf(l2)}));
        } catch (Throwable throwable1) {
            stringbuilder.append("(Error finding chunk loc)");
        }

        stringbuilder.append(", ");

        try {
            l = i >> 9;
            i1 = k >> 9;
            j1 = l << 5;
            k1 = i1 << 5;
            l1 = (l + 1 << 5) - 1;
            i2 = (i1 + 1 << 5) - 1;
            j2 = l << 9;
            k2 = i1 << 9;
            l2 = (l + 1 << 9) - 1;
            int i3 = (i1 + 1 << 9) - 1;

            stringbuilder.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", new Object[] { Integer.valueOf(l), Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf(l1), Integer.valueOf(i2), Integer.valueOf(j2), Integer.valueOf(k2), Integer.valueOf(l2), Integer.valueOf(i3)}));
        } catch (Throwable throwable2) {
            stringbuilder.append("(Error finding world loc)");
        }

        return stringbuilder.toString();
    }

    public void a(String s, Callable<String> callable) {
        try {
            this.a(s, callable.call());
        } catch (Throwable throwable) {
            this.a(s, throwable);
        }

    }

    public void a(String s, Object object) {
        this.c.add(new CrashReportSystemDetails.CrashReportDetail(s, object));
    }

    public void a(String s, Throwable throwable) {
        this.a(s, (Object) throwable);
    }

    public int a(int i) {
        StackTraceElement[] astacktraceelement = Thread.currentThread().getStackTrace();

        if (astacktraceelement.length <= 0) {
            return 0;
        } else {
            this.d = new StackTraceElement[astacktraceelement.length - 3 - i];
            System.arraycopy(astacktraceelement, 3 + i, this.d, 0, this.d.length);
            return this.d.length;
        }
    }

    public boolean a(StackTraceElement stacktraceelement, StackTraceElement stacktraceelement1) {
        if (this.d.length != 0 && stacktraceelement != null) {
            StackTraceElement stacktraceelement2 = this.d[0];

            if (stacktraceelement2.isNativeMethod() == stacktraceelement.isNativeMethod() && stacktraceelement2.getClassName().equals(stacktraceelement.getClassName()) && stacktraceelement2.getFileName().equals(stacktraceelement.getFileName()) && stacktraceelement2.getMethodName().equals(stacktraceelement.getMethodName())) {
                if (stacktraceelement1 != null != this.d.length > 1) {
                    return false;
                } else if (stacktraceelement1 != null && !this.d[1].equals(stacktraceelement1)) {
                    return false;
                } else {
                    this.d[0] = stacktraceelement;
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void b(int i) {
        StackTraceElement[] astacktraceelement = new StackTraceElement[this.d.length - i];

        System.arraycopy(this.d, 0, astacktraceelement, 0, astacktraceelement.length);
        this.d = astacktraceelement;
    }

    public void a(StringBuilder stringbuilder) {
        stringbuilder.append("-- ").append(this.b).append(" --\n");
        stringbuilder.append("Details:");
        Iterator iterator = this.c.iterator();

        while (iterator.hasNext()) {
            CrashReportSystemDetails.CrashReportDetail crashreportsystemdetails_crashreportdetail = (CrashReportSystemDetails.CrashReportDetail) iterator.next();

            stringbuilder.append("\n\t");
            stringbuilder.append(crashreportsystemdetails_crashreportdetail.a());
            stringbuilder.append(": ");
            stringbuilder.append(crashreportsystemdetails_crashreportdetail.b());
        }

        if (this.d != null && this.d.length > 0) {
            stringbuilder.append("\nStacktrace:");
            StackTraceElement[] astacktraceelement = this.d;
            int i = astacktraceelement.length;

            for (int j = 0; j < i; ++j) {
                StackTraceElement stacktraceelement = astacktraceelement[j];

                stringbuilder.append("\n\tat ");
                stringbuilder.append(stacktraceelement.toString());
            }
        }

    }

    public StackTraceElement[] a() {
        return this.d;
    }

    public static void a(CrashReportSystemDetails crashreportsystemdetails, final BlockPosition blockposition, final Block block, final int i) {
        final int j = Block.getId(block);

        crashreportsystemdetails.a("Block type", new Callable() {
            public String a() throws Exception {
                try {
                    return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(i), block.a(), block.getClass().getCanonicalName()});
                } catch (Throwable throwable) {
                    return "ID #" + i;
                }
            }

            public Object call() throws Exception {
                return this.a();
            }
        });
        crashreportsystemdetails.a("Block data value", new Callable() {
            public String a() throws Exception {
                if (i < 0) {
                    return "Unknown? (Got " + i + ")";
                } else {
                    String s = String.format("%4s", new Object[] { Integer.toBinaryString(i)}).replace(" ", "0");

                    return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[] { Integer.valueOf(i), s});
                }
            }

            public Object call() throws Exception {
                return this.a();
            }
        });
        crashreportsystemdetails.a("Block location", new Callable() {
            public String a() throws Exception {
                return CrashReportSystemDetails.a(blockposition);
            }

            public Object call() throws Exception {
                return this.a();
            }
        });
    }

    public static void a(CrashReportSystemDetails crashreportsystemdetails, final BlockPosition blockposition, final IBlockData iblockdata) {
        crashreportsystemdetails.a("Block", new Callable() {
            public String a() throws Exception {
                return iblockdata.toString();
            }

            public Object call() throws Exception {
                return this.a();
            }
        });
        crashreportsystemdetails.a("Block location", new Callable() {
            public String a() throws Exception {
                return CrashReportSystemDetails.a(blockposition);
            }

            public Object call() throws Exception {
                return this.a();
            }
        });
    }

    static class CrashReportDetail {

        private final String a;
        private final String b;

        public CrashReportDetail(String s, Object object) {
            this.a = s;
            if (object == null) {
                this.b = "~~NULL~~";
            } else if (object instanceof Throwable) {
                Throwable throwable = (Throwable) object;

                this.b = "~~ERROR~~ " + throwable.getClass().getSimpleName() + ": " + throwable.getMessage();
            } else {
                this.b = object.toString();
            }

        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }
    }
}
