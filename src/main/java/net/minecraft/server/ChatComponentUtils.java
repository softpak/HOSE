package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class ChatComponentUtils {

    public static IChatBaseComponent filterForDisplay(ICommandListener icommandlistener, IChatBaseComponent ichatbasecomponent, Entity entity) throws CommandException {
        Object object = null;

        if (ichatbasecomponent instanceof ChatComponentScore) {
            ChatComponentScore chatcomponentscore = (ChatComponentScore) ichatbasecomponent;
            String s = chatcomponentscore.g();

            if (PlayerSelector.isPattern(s)) {
                List list = PlayerSelector.getPlayers(icommandlistener, s, Entity.class);

                if (list.size() != 1) {
                    throw new ExceptionEntityNotFound();
                }

                s = ((Entity) list.get(0)).getName();
            }

            object = entity != null && s.equals("*") ? new ChatComponentScore(entity.getName(), chatcomponentscore.h()) : new ChatComponentScore(s, chatcomponentscore.h());
            ((ChatComponentScore) object).b(chatcomponentscore.getText());
        } else if (ichatbasecomponent instanceof ChatComponentSelector) {
            String s1 = ((ChatComponentSelector) ichatbasecomponent).g();

            object = PlayerSelector.getPlayerNames(icommandlistener, s1);
            if (object == null) {
                object = new ChatComponentText("");
            }
        } else if (ichatbasecomponent instanceof ChatComponentText) {
            object = new ChatComponentText(((ChatComponentText) ichatbasecomponent).g());
        } else {
            if (!(ichatbasecomponent instanceof ChatMessage)) {
                return ichatbasecomponent;
            }

            Object[] aobject = ((ChatMessage) ichatbasecomponent).j();

            for (int i = 0; i < aobject.length; ++i) {
                Object object1 = aobject[i];

                if (object1 instanceof IChatBaseComponent) {
                    aobject[i] = filterForDisplay(icommandlistener, (IChatBaseComponent) object1, entity);
                }
            }

            object = new ChatMessage(((ChatMessage) ichatbasecomponent).i(), aobject);
        }

        ChatModifier chatmodifier = ichatbasecomponent.getChatModifier();

        if (chatmodifier != null) {
            ((IChatBaseComponent) object).setChatModifier(chatmodifier.clone());
        }

        Iterator iterator = ichatbasecomponent.a().iterator();

        while (iterator.hasNext()) {
            IChatBaseComponent ichatbasecomponent1 = (IChatBaseComponent) iterator.next();

            ((IChatBaseComponent) object).addSibling(filterForDisplay(icommandlistener, ichatbasecomponent1, entity));
        }

        return (IChatBaseComponent) object;
    }
}
