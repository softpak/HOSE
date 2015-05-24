package net.minecraft.server;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class GameRules {

    private TreeMap<String, GameRules.GameRuleValue> a = new TreeMap();

    public GameRules() {
        this.a("doFireTick", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("mobGriefing", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("keepInventory", "false", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("doMobSpawning", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("doMobLoot", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("doTileDrops", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("doEntityDrops", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("commandBlockOutput", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("naturalRegeneration", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("doDaylightCycle", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("logAdminCommands", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("showDeathMessages", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("randomTickSpeed", "3", GameRules.EnumGameRuleType.NUMERICAL_VALUE);
        this.a("sendCommandFeedback", "true", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
        this.a("reducedDebugInfo", "false", GameRules.EnumGameRuleType.BOOLEAN_VALUE);
    }

    public void a(String s, String s1, GameRules.EnumGameRuleType gamerules_enumgameruletype) {
        this.a.put(s, new GameRules.GameRuleValue(s1, gamerules_enumgameruletype));
    }

    public void set(String s, String s1) {
        GameRules.GameRuleValue gamerules_gamerulevalue = (GameRules.GameRuleValue) this.a.get(s);

        if (gamerules_gamerulevalue != null) {
            gamerules_gamerulevalue.a(s1);
        } else {
            this.a(s, s1, GameRules.EnumGameRuleType.ANY_VALUE);
        }

    }

    public String get(String s) {
        GameRules.GameRuleValue gamerules_gamerulevalue = (GameRules.GameRuleValue) this.a.get(s);

        return gamerules_gamerulevalue != null ? gamerules_gamerulevalue.a() : "";
    }

    public boolean getBoolean(String s) {
        GameRules.GameRuleValue gamerules_gamerulevalue = (GameRules.GameRuleValue) this.a.get(s);

        return gamerules_gamerulevalue != null ? gamerules_gamerulevalue.b() : false;
    }

    public int c(String s) {
        GameRules.GameRuleValue gamerules_gamerulevalue = (GameRules.GameRuleValue) this.a.get(s);

        return gamerules_gamerulevalue != null ? gamerules_gamerulevalue.c() : 0;
    }

    public NBTTagCompound a() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        Iterator iterator = this.a.keySet().iterator();

        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            GameRules.GameRuleValue gamerules_gamerulevalue = (GameRules.GameRuleValue) this.a.get(s);

            nbttagcompound.setString(s, gamerules_gamerulevalue.a());
        }

        return nbttagcompound;
    }

    public void a(NBTTagCompound nbttagcompound) {
        Set set = nbttagcompound.c();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            String s1 = nbttagcompound.getString(s);

            this.set(s, s1);
        }

    }

    public String[] getGameRules() {
        Set set = this.a.keySet();

        return (String[]) set.toArray(new String[set.size()]);
    }

    public boolean contains(String s) {
        return this.a.containsKey(s);
    }

    public boolean a(String s, GameRules.EnumGameRuleType gamerules_enumgameruletype) {
        GameRules.GameRuleValue gamerules_gamerulevalue = (GameRules.GameRuleValue) this.a.get(s);

        return gamerules_gamerulevalue != null && (gamerules_gamerulevalue.e() == gamerules_enumgameruletype || gamerules_enumgameruletype == GameRules.EnumGameRuleType.ANY_VALUE);
    }

    public static enum EnumGameRuleType {

        ANY_VALUE, BOOLEAN_VALUE, NUMERICAL_VALUE;

        private EnumGameRuleType() {}
    }

    static class GameRuleValue {

        private String a;
        private boolean b;
        private int c;
        private double d;
        private final GameRules.EnumGameRuleType e;

        public GameRuleValue(String s, GameRules.EnumGameRuleType gamerules_enumgameruletype) {
            this.e = gamerules_enumgameruletype;
            this.a(s);
        }

        public void a(String s) {
            this.a = s;
            this.b = Boolean.parseBoolean(s);
            this.c = this.b ? 1 : 0;

            try {
                this.c = Integer.parseInt(s);
            } catch (NumberFormatException numberformatexception) {
                ;
            }

            try {
                this.d = Double.parseDouble(s);
            } catch (NumberFormatException numberformatexception1) {
                ;
            }

        }

        public String a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public GameRules.EnumGameRuleType e() {
            return this.e;
        }
    }
}
