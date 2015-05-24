package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;

public class ScoreboardTeam extends ScoreboardTeamBase {

    private final Scoreboard a;
    private final String b;
    private final Set<String> c = Sets.newHashSet();
    private String d;
    private String e = "";
    private String f = "";
    private boolean g = true;
    private boolean h = true;
    private ScoreboardTeamBase.EnumNameTagVisibility i;
    private ScoreboardTeamBase.EnumNameTagVisibility j;
    private EnumChatFormat k;

    public ScoreboardTeam(Scoreboard scoreboard, String s) {
        this.i = ScoreboardTeamBase.EnumNameTagVisibility.ALWAYS;
        this.j = ScoreboardTeamBase.EnumNameTagVisibility.ALWAYS;
        this.k = EnumChatFormat.RESET;
        this.a = scoreboard;
        this.b = s;
        this.d = s;
    }

    public String getName() {
        return this.b;
    }

    public String getDisplayName() {
        return this.d;
    }

    public void setDisplayName(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Name cannot be null");
        } else {
            this.d = s;
            this.a.handleTeamChanged(this);
        }
    }

    public Collection<String> getPlayerNameSet() {
        return this.c;
    }

    public String getPrefix() {
        return this.e;
    }

    public void setPrefix(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        } else {
            this.e = s;
            this.a.handleTeamChanged(this);
        }
    }

    public String getSuffix() {
        return this.f;
    }

    public void setSuffix(String s) {
        this.f = s;
        this.a.handleTeamChanged(this);
    }

    public String getFormattedName(String s) {
        return this.getPrefix() + s + this.getSuffix();
    }

    public static String getPlayerDisplayName(ScoreboardTeamBase scoreboardteambase, String s) {
        return scoreboardteambase == null ? s : scoreboardteambase.getFormattedName(s);
    }

    public boolean allowFriendlyFire() {
        return this.g;
    }

    public void setAllowFriendlyFire(boolean flag) {
        this.g = flag;
        this.a.handleTeamChanged(this);
    }

    public boolean canSeeFriendlyInvisibles() {
        return this.h;
    }

    public void setCanSeeFriendlyInvisibles(boolean flag) {
        this.h = flag;
        this.a.handleTeamChanged(this);
    }

    public ScoreboardTeamBase.EnumNameTagVisibility getNameTagVisibility() {
        return this.i;
    }

    public ScoreboardTeamBase.EnumNameTagVisibility j() {
        return this.j;
    }

    public void setNameTagVisibility(ScoreboardTeamBase.EnumNameTagVisibility scoreboardteambase_enumnametagvisibility) {
        this.i = scoreboardteambase_enumnametagvisibility;
        this.a.handleTeamChanged(this);
    }

    public void b(ScoreboardTeamBase.EnumNameTagVisibility scoreboardteambase_enumnametagvisibility) {
        this.j = scoreboardteambase_enumnametagvisibility;
        this.a.handleTeamChanged(this);
    }

    public int packOptionData() {
        int i = 0;

        if (this.allowFriendlyFire()) {
            i |= 1;
        }

        if (this.canSeeFriendlyInvisibles()) {
            i |= 2;
        }

        return i;
    }

    public void a(EnumChatFormat enumchatformat) {
        this.k = enumchatformat;
    }

    public EnumChatFormat l() {
        return this.k;
    }
}
