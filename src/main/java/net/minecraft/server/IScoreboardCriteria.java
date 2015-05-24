package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public interface IScoreboardCriteria {

    Map<String, IScoreboardCriteria> criteria = Maps.newHashMap();
    IScoreboardCriteria b = new ScoreboardBaseCriteria("dummy");
    IScoreboardCriteria c = new ScoreboardBaseCriteria("trigger");
    IScoreboardCriteria d = new ScoreboardBaseCriteria("deathCount");
    IScoreboardCriteria e = new ScoreboardBaseCriteria("playerKillCount");
    IScoreboardCriteria f = new ScoreboardBaseCriteria("totalKillCount");
    IScoreboardCriteria g = new ScoreboardHealthCriteria("health");
    IScoreboardCriteria[] h = new IScoreboardCriteria[] { new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.BLACK), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.DARK_BLUE), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.DARK_GREEN), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.DARK_AQUA), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.DARK_RED), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.DARK_PURPLE), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.GOLD), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.GRAY), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.DARK_GRAY), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.BLUE), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.GREEN), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.AQUA), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.RED), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.LIGHT_PURPLE), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.YELLOW), new ScoreboardCriteriaInteger("teamkill.", EnumChatFormat.WHITE)};
    IScoreboardCriteria[] i = new IScoreboardCriteria[] { new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.BLACK), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.DARK_BLUE), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.DARK_GREEN), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.DARK_AQUA), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.DARK_RED), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.DARK_PURPLE), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.GOLD), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.GRAY), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.DARK_GRAY), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.BLUE), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.GREEN), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.AQUA), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.RED), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.LIGHT_PURPLE), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.YELLOW), new ScoreboardCriteriaInteger("killedByTeam.", EnumChatFormat.WHITE)};

    String getName();

    int getScoreModifier(List<EntityHuman> list);

    boolean isReadOnly();

    IScoreboardCriteria.EnumScoreboardHealthDisplay c();

    public static enum EnumScoreboardHealthDisplay {

        INTEGER("integer"), HEARTS("hearts");

        private static final Map<String, IScoreboardCriteria.EnumScoreboardHealthDisplay> c = Maps.newHashMap();
        private final String d;

        private EnumScoreboardHealthDisplay(String s) {
            this.d = s;
        }

        public String a() {
            return this.d;
        }

        public static IScoreboardCriteria.EnumScoreboardHealthDisplay a(String s) {
            IScoreboardCriteria.EnumScoreboardHealthDisplay iscoreboardcriteria_enumscoreboardhealthdisplay = (IScoreboardCriteria.EnumScoreboardHealthDisplay) IScoreboardCriteria.EnumScoreboardHealthDisplay.c.get(s);

            return iscoreboardcriteria_enumscoreboardhealthdisplay == null ? IScoreboardCriteria.EnumScoreboardHealthDisplay.INTEGER : iscoreboardcriteria_enumscoreboardhealthdisplay;
        }

        static {
            IScoreboardCriteria.EnumScoreboardHealthDisplay[] aiscoreboardcriteria_enumscoreboardhealthdisplay = values();
            int i = aiscoreboardcriteria_enumscoreboardhealthdisplay.length;

            for (int j = 0; j < i; ++j) {
                IScoreboardCriteria.EnumScoreboardHealthDisplay iscoreboardcriteria_enumscoreboardhealthdisplay = aiscoreboardcriteria_enumscoreboardhealthdisplay[j];

                IScoreboardCriteria.EnumScoreboardHealthDisplay.c.put(iscoreboardcriteria_enumscoreboardhealthdisplay.a(), iscoreboardcriteria_enumscoreboardhealthdisplay);
            }

        }
    }
}
