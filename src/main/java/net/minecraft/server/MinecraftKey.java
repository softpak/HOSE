package net.minecraft.server;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class MinecraftKey {

    protected final String a;
    protected final String b;

    protected MinecraftKey(int i, String... astring) {
        this.a = StringUtils.isEmpty(astring[0]) ? "minecraft" : astring[0].toLowerCase();
        this.b = astring[1];
        Validate.notNull(this.b);
    }

    public MinecraftKey(String s) {
        this(0, a(s));
    }

    protected static String[] a(String s) {
        String[] astring = new String[] { null, s};
        int i = s.indexOf(58);

        if (i >= 0) {
            astring[1] = s.substring(i + 1, s.length());
            if (i > 1) {
                astring[0] = s.substring(0, i);
            }
        }

        return astring;
    }

    public String a() {
        return this.b;
    }

    public String toString() {
        return this.a + ':' + this.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof MinecraftKey)) {
            return false;
        } else {
            MinecraftKey minecraftkey = (MinecraftKey) object;

            return this.a.equals(minecraftkey.a) && this.b.equals(minecraftkey.b);
        }
    }

    public int hashCode() {
        return 31 * this.a.hashCode() + this.b.hashCode();
    }
}
