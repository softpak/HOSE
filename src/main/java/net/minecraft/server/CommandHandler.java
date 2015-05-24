package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandHandler implements ICommandHandler {

    private static final Logger a = LogManager.getLogger();
    private final Map<String, ICommand> b = Maps.newHashMap();
    private final Set<ICommand> c = Sets.newHashSet();

    public CommandHandler() {}

    public int a(ICommandListener icommandlistener, String s) {
        s = s.trim();
        if (s.startsWith("/")) {
            s = s.substring(1);
        }

        String[] astring = s.split(" ");
        String s1 = astring[0];

        astring = a(astring);
        ICommand icommand = (ICommand) this.b.get(s1);
        int i = this.a(icommand, astring);
        int j = 0;
        ChatMessage chatmessage;

        if (icommand == null) {
            chatmessage = new ChatMessage("commands.generic.notFound", new Object[0]);
            chatmessage.getChatModifier().setColor(EnumChatFormat.RED);
            icommandlistener.sendMessage(chatmessage);
        } else if (icommand.canUse(icommandlistener)) {
            if (i > -1) {
                List list = PlayerSelector.getPlayers(icommandlistener, astring[i], Entity.class);
                String s2 = astring[i];

                icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.AFFECTED_ENTITIES, list.size());
                Iterator iterator = list.iterator();

                while (iterator.hasNext()) {
                    Entity entity = (Entity) iterator.next();

                    astring[i] = entity.getUniqueID().toString();
                    if (this.a(icommandlistener, astring, icommand, s)) {
                        ++j;
                    }
                }

                astring[i] = s2;
            } else {
                icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.AFFECTED_ENTITIES, 1);
                if (this.a(icommandlistener, astring, icommand, s)) {
                    ++j;
                }
            }
        } else {
            chatmessage = new ChatMessage("commands.generic.permission", new Object[0]);
            chatmessage.getChatModifier().setColor(EnumChatFormat.RED);
            icommandlistener.sendMessage(chatmessage);
        }

        icommandlistener.a(CommandObjectiveExecutor.EnumCommandResult.SUCCESS_COUNT, j);
        return j;
    }

    protected boolean a(ICommandListener icommandlistener, String[] astring, ICommand icommand, String s) {
        ChatMessage chatmessage;

        try {
            icommand.execute(icommandlistener, astring);
            return true;
        } catch (ExceptionUsage exceptionusage) {
            chatmessage = new ChatMessage("commands.generic.usage", new Object[] { new ChatMessage(exceptionusage.getMessage(), exceptionusage.getArgs())});
            chatmessage.getChatModifier().setColor(EnumChatFormat.RED);
            icommandlistener.sendMessage(chatmessage);
        } catch (CommandException commandexception) {
            chatmessage = new ChatMessage(commandexception.getMessage(), commandexception.getArgs());
            chatmessage.getChatModifier().setColor(EnumChatFormat.RED);
            icommandlistener.sendMessage(chatmessage);
        } catch (Throwable throwable) {
            chatmessage = new ChatMessage("commands.generic.exception", new Object[0]);
            chatmessage.getChatModifier().setColor(EnumChatFormat.RED);
            icommandlistener.sendMessage(chatmessage);
            CommandHandler.a.warn("Couldn\'t process command: \'" + s + "\'");
        }

        return false;
    }

    public ICommand a(ICommand icommand) {
        this.b.put(icommand.getCommand(), icommand);
        this.c.add(icommand);
        Iterator iterator = icommand.b().iterator();

        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            ICommand icommand1 = (ICommand) this.b.get(s);

            if (icommand1 == null || !icommand1.getCommand().equals(s)) {
                this.b.put(s, icommand);
            }
        }

        return icommand;
    }

    private static String[] a(String[] astring) {
        String[] astring1 = new String[astring.length - 1];

        System.arraycopy(astring, 1, astring1, 0, astring.length - 1);
        return astring1;
    }

    public List<String> a(ICommandListener icommandlistener, String s, BlockPosition blockposition) {
        String[] astring = s.split(" ", -1);
        String s1 = astring[0];

        if (astring.length == 1) {
            ArrayList arraylist = Lists.newArrayList();
            Iterator iterator = this.b.entrySet().iterator();

            while (iterator.hasNext()) {
                Entry entry = (Entry) iterator.next();

                if (CommandAbstract.a(s1, (String) entry.getKey()) && ((ICommand) entry.getValue()).canUse(icommandlistener)) {
                    arraylist.add(entry.getKey());
                }
            }

            return arraylist;
        } else {
            if (astring.length > 1) {
                ICommand icommand = (ICommand) this.b.get(s1);

                if (icommand != null && icommand.canUse(icommandlistener)) {
                    return icommand.tabComplete(icommandlistener, a(astring), blockposition);
                }
            }

            return null;
        }
    }

    public List<ICommand> a(ICommandListener icommandlistener) {
        ArrayList arraylist = Lists.newArrayList();
        Iterator iterator = this.c.iterator();

        while (iterator.hasNext()) {
            ICommand icommand = (ICommand) iterator.next();

            if (icommand.canUse(icommandlistener)) {
                arraylist.add(icommand);
            }
        }

        return arraylist;
    }

    public Map<String, ICommand> getCommands() {
        return this.b;
    }

    private int a(ICommand icommand, String[] astring) {
        if (icommand == null) {
            return -1;
        } else {
            for (int i = 0; i < astring.length; ++i) {
                if (icommand.isListStart(astring, i) && PlayerSelector.isList(astring[i])) {
                    return i;
                }
            }

            return -1;
        }
    }
}
