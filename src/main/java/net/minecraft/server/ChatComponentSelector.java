package net.minecraft.server;

import java.util.Iterator;

public class ChatComponentSelector extends ChatBaseComponent {

    private final String b;

    public ChatComponentSelector(String s) {
        this.b = s;
    }

    public String g() {
        return this.b;
    }

    public String getText() {
        return this.b;
    }

    public ChatComponentSelector h() {
        ChatComponentSelector chatcomponentselector = new ChatComponentSelector(this.b);

        chatcomponentselector.setChatModifier(this.getChatModifier().clone());
        Iterator iterator = this.a().iterator();

        while (iterator.hasNext()) {
            IChatBaseComponent ichatbasecomponent = (IChatBaseComponent) iterator.next();

            chatcomponentselector.addSibling(ichatbasecomponent.f());
        }

        return chatcomponentselector;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof ChatComponentSelector)) {
            return false;
        } else {
            ChatComponentSelector chatcomponentselector = (ChatComponentSelector) object;

            return this.b.equals(chatcomponentselector.b) && super.equals(object);
        }
    }

    public String toString() {
        return "SelectorComponent{pattern=\'" + this.b + '\'' + ", siblings=" + this.a + ", style=" + this.getChatModifier() + '}';
    }

    public IChatBaseComponent f() {
        return this.h();
    }
}
