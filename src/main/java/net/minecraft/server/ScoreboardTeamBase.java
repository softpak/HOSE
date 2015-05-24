package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;

public abstract class ScoreboardTeamBase {

    public ScoreboardTeamBase() {}

    public boolean isAlly(ScoreboardTeamBase scoreboardteambase) {
        return scoreboardteambase == null ? false : this == scoreboardteambase;
    }

    public abstract String getName();

    public abstract String getFormattedName(String s);

    public abstract boolean allowFriendlyFire();

    public abstract Collection<String> getPlayerNameSet();

    public abstract ScoreboardTeamBase.EnumNameTagVisibility j();

    public static enum EnumNameTagVisibility {

        ALWAYS("always", 0), NEVER("never", 1), HIDE_FOR_OTHER_TEAMS("hideForOtherTeams", 2), HIDE_FOR_OWN_TEAM("hideForOwnTeam", 3);

        private static Map<String, ScoreboardTeamBase.EnumNameTagVisibility> g = Maps.newHashMap();
        public final String e;
        public final int f;

        public static String[] a() {
            return (String[]) ScoreboardTeamBase.EnumNameTagVisibility.g.keySet().toArray(new String[ScoreboardTeamBase.EnumNameTagVisibility.g.size()]);
        }

        public static ScoreboardTeamBase.EnumNameTagVisibility a(String s) {
            return (ScoreboardTeamBase.EnumNameTagVisibility) ScoreboardTeamBase.EnumNameTagVisibility.g.get(s);
        }

        private EnumNameTagVisibility(String s, int i) {
            this.e = s;
            this.f = i;
        }

        static {
            ScoreboardTeamBase.EnumNameTagVisibility[] ascoreboardteambase_enumnametagvisibility = values();
            int i = ascoreboardteambase_enumnametagvisibility.length;

            for (int j = 0; j < i; ++j) {
                ScoreboardTeamBase.EnumNameTagVisibility scoreboardteambase_enumnametagvisibility = ascoreboardteambase_enumnametagvisibility[j];

                ScoreboardTeamBase.EnumNameTagVisibility.g.put(scoreboardteambase_enumnametagvisibility.e, scoreboardteambase_enumnametagvisibility);
            }

        }
    }
}
