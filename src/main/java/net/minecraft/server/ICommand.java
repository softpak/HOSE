package net.minecraft.server;

import java.util.List;

public interface ICommand extends Comparable<ICommand> {

    String getCommand();

    String getUsage(ICommandListener icommandlistener);

    List<String> b();

    void execute(ICommandListener icommandlistener, String[] astring) throws CommandException;

    boolean canUse(ICommandListener icommandlistener);

    List<String> tabComplete(ICommandListener icommandlistener, String[] astring, BlockPosition blockposition);

    boolean isListStart(String[] astring, int i);
}
