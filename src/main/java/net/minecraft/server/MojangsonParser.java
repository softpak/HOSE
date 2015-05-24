package net.minecraft.server;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MojangsonParser {

    private static final Logger a = LogManager.getLogger();
    private static final Pattern b = Pattern.compile("\\[[-+\\d|,\\s]+\\]");

    public static NBTTagCompound parse(String s) throws MojangsonParseException {
        s = s.trim();
        if (!s.startsWith("{")) {
            throw new MojangsonParseException("Invalid tag encountered, expected \'{\' as first char.");
        } else if (b(s) != 1) {
            throw new MojangsonParseException("Encountered multiple top tags, only one expected");
        } else {
            return (NBTTagCompound) a("tag", s).a();
        }
    }

    static int b(String s) throws MojangsonParseException {
        int i = 0;
        boolean flag = false;
        Stack stack = new Stack();

        for (int j = 0; j < s.length(); ++j) {
            char c0 = s.charAt(j);

            if (c0 == 34) {
                if (b(s, j)) {
                    if (!flag) {
                        throw new MojangsonParseException("Illegal use of \\\": " + s);
                    }
                } else {
                    flag = !flag;
                }
            } else if (!flag) {
                if (c0 != 123 && c0 != 91) {
                    if (c0 == 125 && (stack.isEmpty() || ((Character) stack.pop()).charValue() != 123)) {
                        throw new MojangsonParseException("Unbalanced curly brackets {}: " + s);
                    }

                    if (c0 == 93 && (stack.isEmpty() || ((Character) stack.pop()).charValue() != 91)) {
                        throw new MojangsonParseException("Unbalanced square brackets []: " + s);
                    }
                } else {
                    if (stack.isEmpty()) {
                        ++i;
                    }

                    stack.push(Character.valueOf(c0));
                }
            }
        }

        if (flag) {
            throw new MojangsonParseException("Unbalanced quotation: " + s);
        } else if (!stack.isEmpty()) {
            throw new MojangsonParseException("Unbalanced brackets: " + s);
        } else {
            if (i == 0 && !s.isEmpty()) {
                i = 1;
            }

            return i;
        }
    }

    static MojangsonParser.MojangsonTypeParser a(String... astring) throws MojangsonParseException {
        return a(astring[0], astring[1]);
    }

    static MojangsonParser.MojangsonTypeParser a(String s, String s1) throws MojangsonParseException {
        s1 = s1.trim();
        String s2;
        boolean flag;
        char c0;

        if (s1.startsWith("{")) {
            s1 = s1.substring(1, s1.length() - 1);

            MojangsonParser.MojangsonCompoundParser mojangsonparser_mojangsoncompoundparser;

            for (mojangsonparser_mojangsoncompoundparser = new MojangsonParser.MojangsonCompoundParser(s); s1.length() > 0; s1 = s1.substring(s2.length() + 1)) {
                s2 = b(s1, true);
                if (s2.length() > 0) {
                    flag = false;
                    mojangsonparser_mojangsoncompoundparser.b.add(a(s2, flag));
                }

                if (s1.length() < s2.length() + 1) {
                    break;
                }

                c0 = s1.charAt(s2.length());
                if (c0 != 44 && c0 != 123 && c0 != 125 && c0 != 91 && c0 != 93) {
                    throw new MojangsonParseException("Unexpected token \'" + c0 + "\' at: " + s1.substring(s2.length()));
                }
            }

            return mojangsonparser_mojangsoncompoundparser;
        } else if (s1.startsWith("[") && !MojangsonParser.b.matcher(s1).matches()) {
            s1 = s1.substring(1, s1.length() - 1);

            MojangsonParser.MojangsonListParser mojangsonparser_mojangsonlistparser;

            for (mojangsonparser_mojangsonlistparser = new MojangsonParser.MojangsonListParser(s); s1.length() > 0; s1 = s1.substring(s2.length() + 1)) {
                s2 = b(s1, false);
                if (s2.length() > 0) {
                    flag = true;
                    mojangsonparser_mojangsonlistparser.b.add(a(s2, flag));
                }

                if (s1.length() < s2.length() + 1) {
                    break;
                }

                c0 = s1.charAt(s2.length());
                if (c0 != 44 && c0 != 123 && c0 != 125 && c0 != 91 && c0 != 93) {
                    throw new MojangsonParseException("Unexpected token \'" + c0 + "\' at: " + s1.substring(s2.length()));
                }
            }

            return mojangsonparser_mojangsonlistparser;
        } else {
            return new MojangsonParser.MojangsonPrimitiveParser(s, s1);
        }
    }

    private static MojangsonParser.MojangsonTypeParser a(String s, boolean flag) throws MojangsonParseException {
        String s1 = c(s, flag);
        String s2 = d(s, flag);

        return a(new String[] { s1, s2});
    }

    private static String b(String s, boolean flag) throws MojangsonParseException {
        int i = a(s, ':');
        int j = a(s, ',');

        if (flag) {
            if (i == -1) {
                throw new MojangsonParseException("Unable to locate name/value separator for string: " + s);
            }

            if (j != -1 && j < i) {
                throw new MojangsonParseException("Name error at: " + s);
            }
        } else if (i == -1 || i > j) {
            i = -1;
        }

        return a(s, i);
    }

    private static String a(String s, int i) throws MojangsonParseException {
        Stack stack = new Stack();
        int j = i + 1;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;

        for (int k = 0; j < s.length(); ++j) {
            char c0 = s.charAt(j);

            if (c0 == 34) {
                if (b(s, j)) {
                    if (!flag) {
                        throw new MojangsonParseException("Illegal use of \\\": " + s);
                    }
                } else {
                    flag = !flag;
                    if (flag && !flag2) {
                        flag1 = true;
                    }

                    if (!flag) {
                        k = j;
                    }
                }
            } else if (!flag) {
                if (c0 != 123 && c0 != 91) {
                    if (c0 == 125 && (stack.isEmpty() || ((Character) stack.pop()).charValue() != 123)) {
                        throw new MojangsonParseException("Unbalanced curly brackets {}: " + s);
                    }

                    if (c0 == 93 && (stack.isEmpty() || ((Character) stack.pop()).charValue() != 91)) {
                        throw new MojangsonParseException("Unbalanced square brackets []: " + s);
                    }

                    if (c0 == 44 && stack.isEmpty()) {
                        return s.substring(0, j);
                    }
                } else {
                    stack.push(Character.valueOf(c0));
                }
            }

            if (!Character.isWhitespace(c0)) {
                if (!flag && flag1 && k != j) {
                    return s.substring(0, k + 1);
                }

                flag2 = true;
            }
        }

        return s.substring(0, j);
    }

    private static String c(String s, boolean flag) throws MojangsonParseException {
        if (flag) {
            s = s.trim();
            if (s.startsWith("{") || s.startsWith("[")) {
                return "";
            }
        }

        int i = a(s, ':');

        if (i == -1) {
            if (flag) {
                return "";
            } else {
                throw new MojangsonParseException("Unable to locate name/value separator for string: " + s);
            }
        } else {
            return s.substring(0, i).trim();
        }
    }

    private static String d(String s, boolean flag) throws MojangsonParseException {
        if (flag) {
            s = s.trim();
            if (s.startsWith("{") || s.startsWith("[")) {
                return s;
            }
        }

        int i = a(s, ':');

        if (i == -1) {
            if (flag) {
                return s;
            } else {
                throw new MojangsonParseException("Unable to locate name/value separator for string: " + s);
            }
        } else {
            return s.substring(i + 1).trim();
        }
    }

    private static int a(String s, char c0) {
        int i = 0;

        for (boolean flag = true; i < s.length(); ++i) {
            char c1 = s.charAt(i);

            if (c1 == 34) {
                if (!b(s, i)) {
                    flag = !flag;
                }
            } else if (flag) {
                if (c1 == c0) {
                    return i;
                }

                if (c1 == 123 || c1 == 91) {
                    return -1;
                }
            }
        }

        return -1;
    }

    private static boolean b(String s, int i) {
        return i > 0 && s.charAt(i - 1) == 92 && !b(s, i - 1);
    }

    static class MojangsonPrimitiveParser extends MojangsonParser.MojangsonTypeParser {

        private static final Pattern c = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[d|D]");
        private static final Pattern d = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[f|F]");
        private static final Pattern e = Pattern.compile("[-+]?[0-9]+[b|B]");
        private static final Pattern f = Pattern.compile("[-+]?[0-9]+[l|L]");
        private static final Pattern g = Pattern.compile("[-+]?[0-9]+[s|S]");
        private static final Pattern h = Pattern.compile("[-+]?[0-9]+");
        private static final Pattern i = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
        private static final Splitter j = Splitter.on(',').omitEmptyStrings();
        protected String b;

        public MojangsonPrimitiveParser(String s, String s1) {
            this.a = s;
            this.b = s1;
        }

        public NBTBase a() throws MojangsonParseException {
            try {
                if (MojangsonParser.MojangsonPrimitiveParser.c.matcher(this.b).matches()) {
                    return new NBTTagDouble(Double.parseDouble(this.b.substring(0, this.b.length() - 1)));
                }

                if (MojangsonParser.MojangsonPrimitiveParser.d.matcher(this.b).matches()) {
                    return new NBTTagFloat(Float.parseFloat(this.b.substring(0, this.b.length() - 1)));
                }

                if (MojangsonParser.MojangsonPrimitiveParser.e.matcher(this.b).matches()) {
                    return new NBTTagByte(Byte.parseByte(this.b.substring(0, this.b.length() - 1)));
                }

                if (MojangsonParser.MojangsonPrimitiveParser.f.matcher(this.b).matches()) {
                    return new NBTTagLong(Long.parseLong(this.b.substring(0, this.b.length() - 1)));
                }

                if (MojangsonParser.MojangsonPrimitiveParser.g.matcher(this.b).matches()) {
                    return new NBTTagShort(Short.parseShort(this.b.substring(0, this.b.length() - 1)));
                }

                if (MojangsonParser.MojangsonPrimitiveParser.h.matcher(this.b).matches()) {
                    return new NBTTagInt(Integer.parseInt(this.b));
                }

                if (MojangsonParser.MojangsonPrimitiveParser.i.matcher(this.b).matches()) {
                    return new NBTTagDouble(Double.parseDouble(this.b));
                }

                if (this.b.equalsIgnoreCase("true") || this.b.equalsIgnoreCase("false")) {
                    return new NBTTagByte((byte) (Boolean.parseBoolean(this.b) ? 1 : 0));
                }
            } catch (NumberFormatException numberformatexception) {
                this.b = this.b.replaceAll("\\\\\"", "\"");
                return new NBTTagString(this.b);
            }

            if (this.b.startsWith("[") && this.b.endsWith("]")) {
                String s = this.b.substring(1, this.b.length() - 1);
                String[] astring = (String[]) Iterables.toArray(MojangsonParser.MojangsonPrimitiveParser.j.split(s), String.class);

                try {
                    int[] aint = new int[astring.length];

                    for (int i = 0; i < astring.length; ++i) {
                        aint[i] = Integer.parseInt(astring[i].trim());
                    }

                    return new NBTTagIntArray(aint);
                } catch (NumberFormatException numberformatexception1) {
                    return new NBTTagString(this.b);
                }
            } else {
                if (this.b.startsWith("\"") && this.b.endsWith("\"")) {
                    this.b = this.b.substring(1, this.b.length() - 1);
                }

                this.b = this.b.replaceAll("\\\\\"", "\"");
                StringBuilder stringbuilder = new StringBuilder();

                for (int j = 0; j < this.b.length(); ++j) {
                    if (j < this.b.length() - 1 && this.b.charAt(j) == 92 && this.b.charAt(j + 1) == 92) {
                        stringbuilder.append('\\');
                        ++j;
                    } else {
                        stringbuilder.append(this.b.charAt(j));
                    }
                }

                return new NBTTagString(stringbuilder.toString());
            }
        }
    }

    static class MojangsonListParser extends MojangsonParser.MojangsonTypeParser {

        protected List<MojangsonParser.MojangsonTypeParser> b = Lists.newArrayList();

        public MojangsonListParser(String s) {
            this.a = s;
        }

        public NBTBase a() throws MojangsonParseException {
            NBTTagList nbttaglist = new NBTTagList();
            Iterator iterator = this.b.iterator();

            while (iterator.hasNext()) {
                MojangsonParser.MojangsonTypeParser mojangsonparser_mojangsontypeparser = (MojangsonParser.MojangsonTypeParser) iterator.next();

                nbttaglist.add(mojangsonparser_mojangsontypeparser.a());
            }

            return nbttaglist;
        }
    }

    static class MojangsonCompoundParser extends MojangsonParser.MojangsonTypeParser {

        protected List<MojangsonParser.MojangsonTypeParser> b = Lists.newArrayList();

        public MojangsonCompoundParser(String s) {
            this.a = s;
        }

        public NBTBase a() throws MojangsonParseException {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            Iterator iterator = this.b.iterator();

            while (iterator.hasNext()) {
                MojangsonParser.MojangsonTypeParser mojangsonparser_mojangsontypeparser = (MojangsonParser.MojangsonTypeParser) iterator.next();

                nbttagcompound.set(mojangsonparser_mojangsontypeparser.a, mojangsonparser_mojangsontypeparser.a());
            }

            return nbttagcompound;
        }
    }

    abstract static class MojangsonTypeParser {

        protected String a;

        MojangsonTypeParser() {}

        public abstract NBTBase a() throws MojangsonParseException;
    }
}
