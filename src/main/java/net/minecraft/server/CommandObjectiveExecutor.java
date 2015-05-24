package net.minecraft.server;

public class CommandObjectiveExecutor {

    private static final int a = CommandObjectiveExecutor.EnumCommandResult.values().length;
    private static final String[] b = new String[CommandObjectiveExecutor.a];
    private String[] c;
    private String[] d;

    public CommandObjectiveExecutor() {
        this.c = CommandObjectiveExecutor.b;
        this.d = CommandObjectiveExecutor.b;
    }

    public void a(final ICommandListener icommandlistener, CommandObjectiveExecutor.EnumCommandResult commandobjectiveexecutor_enumcommandresult, int i) {
        String s = this.c[commandobjectiveexecutor_enumcommandresult.a()];

        if (s != null) {
            ICommandListener icommandlistener1 = new ICommandListener() {
                public String getName() {
                    return icommandlistener.getName();
                }

                public IChatBaseComponent getScoreboardDisplayName() {
                    return icommandlistener.getScoreboardDisplayName();
                }

                public void sendMessage(IChatBaseComponent ichatbasecomponent) {
                    icommandlistener.sendMessage(ichatbasecomponent);
                }

                public boolean a(int i, String s) {
                    return true;
                }

                public BlockPosition getChunkCoordinates() {
                    return icommandlistener.getChunkCoordinates();
                }

                public Vec3D d() {
                    return icommandlistener.d();
                }

                public World getWorld() {
                    return icommandlistener.getWorld();
                }

                public Entity f() {
                    return icommandlistener.f();
                }

                public boolean getSendCommandFeedback() {
                    return icommandlistener.getSendCommandFeedback();
                }

                public void a(CommandObjectiveExecutor.EnumCommandResult commandobjectiveexecutor_enumcommandresult, int i) {
                    icommandlistener.a(commandobjectiveexecutor_enumcommandresult, i);
                }
            };

            String s1;

            try {
                s1 = CommandAbstract.e(icommandlistener1, s);
            } catch (ExceptionEntityNotFound exceptionentitynotfound) {
                return;
            }

            String s2 = this.d[commandobjectiveexecutor_enumcommandresult.a()];

            if (s2 != null) {
                Scoreboard scoreboard = icommandlistener.getWorld().getScoreboard();
                ScoreboardObjective scoreboardobjective = scoreboard.getObjective(s2);

                if (scoreboardobjective != null) {
                    if (scoreboard.b(s1, scoreboardobjective)) {
                        ScoreboardScore scoreboardscore = scoreboard.getPlayerScoreForObjective(s1, scoreboardobjective);

                        scoreboardscore.setScore(i);
                    }
                }
            }
        }
    }

    public void a(NBTTagCompound nbttagcompound) {
        if (nbttagcompound.hasKeyOfType("CommandStats", 10)) {
            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompound("CommandStats");
            CommandObjectiveExecutor.EnumCommandResult[] acommandobjectiveexecutor_enumcommandresult = CommandObjectiveExecutor.EnumCommandResult.values();
            int i = acommandobjectiveexecutor_enumcommandresult.length;

            for (int j = 0; j < i; ++j) {
                CommandObjectiveExecutor.EnumCommandResult commandobjectiveexecutor_enumcommandresult = acommandobjectiveexecutor_enumcommandresult[j];
                String s = commandobjectiveexecutor_enumcommandresult.b() + "Name";
                String s1 = commandobjectiveexecutor_enumcommandresult.b() + "Objective";

                if (nbttagcompound1.hasKeyOfType(s, 8) && nbttagcompound1.hasKeyOfType(s1, 8)) {
                    String s2 = nbttagcompound1.getString(s);
                    String s3 = nbttagcompound1.getString(s1);

                    a(this, commandobjectiveexecutor_enumcommandresult, s2, s3);
                }
            }

        }
    }

    public void b(NBTTagCompound nbttagcompound) {
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        CommandObjectiveExecutor.EnumCommandResult[] acommandobjectiveexecutor_enumcommandresult = CommandObjectiveExecutor.EnumCommandResult.values();
        int i = acommandobjectiveexecutor_enumcommandresult.length;

        for (int j = 0; j < i; ++j) {
            CommandObjectiveExecutor.EnumCommandResult commandobjectiveexecutor_enumcommandresult = acommandobjectiveexecutor_enumcommandresult[j];
            String s = this.c[commandobjectiveexecutor_enumcommandresult.a()];
            String s1 = this.d[commandobjectiveexecutor_enumcommandresult.a()];

            if (s != null && s1 != null) {
                nbttagcompound1.setString(commandobjectiveexecutor_enumcommandresult.b() + "Name", s);
                nbttagcompound1.setString(commandobjectiveexecutor_enumcommandresult.b() + "Objective", s1);
            }
        }

        if (!nbttagcompound1.isEmpty()) {
            nbttagcompound.set("CommandStats", nbttagcompound1);
        }

    }

    public static void a(CommandObjectiveExecutor commandobjectiveexecutor, CommandObjectiveExecutor.EnumCommandResult commandobjectiveexecutor_enumcommandresult, String s, String s1) {
        if (s != null && s.length() != 0 && s1 != null && s1.length() != 0) {
            if (commandobjectiveexecutor.c == CommandObjectiveExecutor.b || commandobjectiveexecutor.d == CommandObjectiveExecutor.b) {
                commandobjectiveexecutor.c = new String[CommandObjectiveExecutor.a];
                commandobjectiveexecutor.d = new String[CommandObjectiveExecutor.a];
            }

            commandobjectiveexecutor.c[commandobjectiveexecutor_enumcommandresult.a()] = s;
            commandobjectiveexecutor.d[commandobjectiveexecutor_enumcommandresult.a()] = s1;
        } else {
            a(commandobjectiveexecutor, commandobjectiveexecutor_enumcommandresult);
        }
    }

    private static void a(CommandObjectiveExecutor commandobjectiveexecutor, CommandObjectiveExecutor.EnumCommandResult commandobjectiveexecutor_enumcommandresult) {
        if (commandobjectiveexecutor.c != CommandObjectiveExecutor.b && commandobjectiveexecutor.d != CommandObjectiveExecutor.b) {
            commandobjectiveexecutor.c[commandobjectiveexecutor_enumcommandresult.a()] = null;
            commandobjectiveexecutor.d[commandobjectiveexecutor_enumcommandresult.a()] = null;
            boolean flag = true;
            CommandObjectiveExecutor.EnumCommandResult[] acommandobjectiveexecutor_enumcommandresult = CommandObjectiveExecutor.EnumCommandResult.values();
            int i = acommandobjectiveexecutor_enumcommandresult.length;

            for (int j = 0; j < i; ++j) {
                CommandObjectiveExecutor.EnumCommandResult commandobjectiveexecutor_enumcommandresult1 = acommandobjectiveexecutor_enumcommandresult[j];

                if (commandobjectiveexecutor.c[commandobjectiveexecutor_enumcommandresult1.a()] != null && commandobjectiveexecutor.d[commandobjectiveexecutor_enumcommandresult1.a()] != null) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                commandobjectiveexecutor.c = CommandObjectiveExecutor.b;
                commandobjectiveexecutor.d = CommandObjectiveExecutor.b;
            }

        }
    }

    public void a(CommandObjectiveExecutor commandobjectiveexecutor) {
        CommandObjectiveExecutor.EnumCommandResult[] acommandobjectiveexecutor_enumcommandresult = CommandObjectiveExecutor.EnumCommandResult.values();
        int i = acommandobjectiveexecutor_enumcommandresult.length;

        for (int j = 0; j < i; ++j) {
            CommandObjectiveExecutor.EnumCommandResult commandobjectiveexecutor_enumcommandresult = acommandobjectiveexecutor_enumcommandresult[j];

            a(this, commandobjectiveexecutor_enumcommandresult, commandobjectiveexecutor.c[commandobjectiveexecutor_enumcommandresult.a()], commandobjectiveexecutor.d[commandobjectiveexecutor_enumcommandresult.a()]);
        }

    }

    public static enum EnumCommandResult {

        SUCCESS_COUNT(0, "SuccessCount"), AFFECTED_BLOCKS(1, "AffectedBlocks"), AFFECTED_ENTITIES(2, "AffectedEntities"), AFFECTED_ITEMS(3, "AffectedItems"), QUERY_RESULT(4, "QueryResult");

        final int f;
        final String g;

        private EnumCommandResult(int i, String s) {
            this.f = i;
            this.g = s;
        }

        public int a() {
            return this.f;
        }

        public String b() {
            return this.g;
        }

        public static String[] c() {
            String[] astring = new String[values().length];
            int i = 0;
            CommandObjectiveExecutor.EnumCommandResult[] acommandobjectiveexecutor_enumcommandresult = values();
            int j = acommandobjectiveexecutor_enumcommandresult.length;

            for (int k = 0; k < j; ++k) {
                CommandObjectiveExecutor.EnumCommandResult commandobjectiveexecutor_enumcommandresult = acommandobjectiveexecutor_enumcommandresult[k];

                astring[i++] = commandobjectiveexecutor_enumcommandresult.b();
            }

            return astring;
        }

        public static CommandObjectiveExecutor.EnumCommandResult a(String s) {
            CommandObjectiveExecutor.EnumCommandResult[] acommandobjectiveexecutor_enumcommandresult = values();
            int i = acommandobjectiveexecutor_enumcommandresult.length;

            for (int j = 0; j < i; ++j) {
                CommandObjectiveExecutor.EnumCommandResult commandobjectiveexecutor_enumcommandresult = acommandobjectiveexecutor_enumcommandresult[j];

                if (commandobjectiveexecutor_enumcommandresult.b().equals(s)) {
                    return commandobjectiveexecutor_enumcommandresult;
                }
            }

            return null;
        }
    }
}
