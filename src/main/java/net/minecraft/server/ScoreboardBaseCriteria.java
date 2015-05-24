package net.minecraft.server;

import java.util.List;

public class ScoreboardBaseCriteria implements IScoreboardCriteria {

    private final String j;

    public ScoreboardBaseCriteria(String s) {
        this.j = s;
        IScoreboardCriteria.criteria.put(s, this);
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
