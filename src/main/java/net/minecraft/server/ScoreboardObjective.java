package net.minecraft.server;

public class ScoreboardObjective {

    private final Scoreboard a;
    private final String b;
    private final IScoreboardCriteria c;
    private IScoreboardCriteria.EnumScoreboardHealthDisplay d;
    private String e;

    public ScoreboardObjective(Scoreboard scoreboard, String s, IScoreboardCriteria iscoreboardcriteria) {
        this.a = scoreboard;
        this.b = s;
        this.c = iscoreboardcriteria;
        this.e = s;
        this.d = iscoreboardcriteria.c();
    }

    public String getName() {
        return this.b;
    }

    public IScoreboardCriteria getCriteria() {
        return this.c;
    }

    public String getDisplayName() {
        return this.e;
    }

    public void setDisplayName(String s) {
        this.e = s;
        this.a.handleObjectiveChanged(this);
    }

    public IScoreboardCriteria.EnumScoreboardHealthDisplay e() {
        return this.d;
    }

    public void a(IScoreboardCriteria.EnumScoreboardHealthDisplay iscoreboardcriteria_enumscoreboardhealthdisplay) {
        this.d = iscoreboardcriteria_enumscoreboardhealthdisplay;
        this.a.handleObjectiveChanged(this);
    }
}
