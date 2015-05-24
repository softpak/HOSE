package net.minecraft.server;

import java.util.Iterator;

public class ChatComponentScore extends ChatBaseComponent {

    private final String b;
    private final String c;
    private String d = "";

    public ChatComponentScore(String s, String s1) {
        this.b = s;
        this.c = s1;
    }

    public String g() {
        return this.b;
    }

    public String h() {
        return this.c;
    }

    public void b(String s) {
        this.d = s;
    }

    public String getText() {
        MinecraftServer minecraftserver = MinecraftServer.getServer();

        if (minecraftserver != null && minecraftserver.N() && UtilColor.b(this.d)) {
            Scoreboard scoreboard = minecraftserver.getWorldServer(0).getScoreboard();
            ScoreboardObjective scoreboardobjective = scoreboard.getObjective(this.c);

            if (scoreboard.b(this.b, scoreboardobjective)) {
                ScoreboardScore scoreboardscore = scoreboard.getPlayerScoreForObjective(this.b, scoreboardobjective);

                this.b(String.format("%d", new Object[] { Integer.valueOf(scoreboardscore.getScore())}));
            } else {
                this.d = "";
            }
        }

        return this.d;
    }

    public ChatComponentScore i() {
        ChatComponentScore chatcomponentscore = new ChatComponentScore(this.b, this.c);

        chatcomponentscore.b(this.d);
        chatcomponentscore.setChatModifier(this.getChatModifier().clone());
        Iterator iterator = this.a().iterator();

        while (iterator.hasNext()) {
            IChatBaseComponent ichatbasecomponent = (IChatBaseComponent) iterator.next();

            chatcomponentscore.addSibling(ichatbasecomponent.f());
        }

        return chatcomponentscore;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof ChatComponentScore)) {
            return false;
        } else {
            ChatComponentScore chatcomponentscore = (ChatComponentScore) object;

            return this.b.equals(chatcomponentscore.b) && this.c.equals(chatcomponentscore.c) && super.equals(object);
        }
    }

    public String toString() {
        return "ScoreComponent{name=\'" + this.b + '\'' + "objective=\'" + this.c + '\'' + ", siblings=" + this.a + ", style=" + this.getChatModifier() + '}';
    }

    public IChatBaseComponent f() {
        return this.i();
    }
}
