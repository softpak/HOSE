package net.minecraft.server;

import java.util.List;

public class ScoreboardCriteriaInteger implements IScoreboardCriteria {

    private final String j;

    public ScoreboardCriteriaInteger(String s, EnumChatFormat enumchatformat) {
        this.j = s + enumchatformat.e();
        IScoreboardCriteria.criteria.put(this.j, this);
    }

    public String getName() {
        return this.j;
    }

    public int getScoreModifier(List<EntityHuman> list) {
        return 0;
    }

    public boolean isReadOnly() {
        return false;
    }

    public IScoreboardCriteria.EnumScoreboardHealthDisplay c() {
        return IScoreboardCriteria.EnumScoreboardHealthDisplay.INTEGER;
    }
}
