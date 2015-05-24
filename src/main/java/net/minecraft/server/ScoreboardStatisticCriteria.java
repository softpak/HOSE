package net.minecraft.server;

public class ScoreboardStatisticCriteria extends ScoreboardBaseCriteria {

    private final Statistic j;

    public ScoreboardStatisticCriteria(Statistic statistic) {
        super(statistic.name);
        this.j = statistic;
    }
}
