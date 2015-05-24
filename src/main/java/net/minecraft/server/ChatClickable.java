package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Map;

public class ChatClickable {

    private final ChatClickable.EnumClickAction a;
    private final String b;

    public ChatClickable(ChatClickable.EnumClickAction chatclickable_enumclickaction, String s) {
        this.a = chatclickable_enumclickaction;
        this.b = s;
    }

    public ChatClickable.EnumClickAction a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object != null && this.getClass() == object.getClass()) {
            ChatClickable chatclickable = (ChatClickable) object;

            if (this.a != chatclickable.a) {
                return false;
            } else {
                if (this.b != null) {
                    if (!this.b.equals(chatclickable.b)) {
                        return false;
                    }
                } else if (chatclickable.b != null) {
                    return false;
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public String toString() {
        return "ClickEvent{action=" + this.a + ", value=\'" + this.b + '\'' + '}';
    }

    public int hashCode() {
        int i = this.a.hashCode();

        i = 31 * i + (this.b != null ? this.b.hashCode() : 0);
        return i;
    }

    public static enum EnumClickAction {

        OPEN_URL("open_url", true), OPEN_FILE("open_file", false), RUN_COMMAND("run_command", true), TWITCH_USER_INFO("twitch_user_info", false), SUGGEST_COMMAND("suggest_command", true), CHANGE_PAGE("change_page", true);

        private static final Map<String, ChatClickable.EnumClickAction> g = Maps.newHashMap();
        private final boolean h;
        private final String i;

        private EnumClickAction(String s, boolean flag) {
            this.i = s;
            this.h = flag;
        }

        public boolean a() {
            return this.h;
        }

        public String b() {
            return this.i;
        }

        public static ChatClickable.EnumClickAction a(String s) {
            return (ChatClickable.EnumClickAction) ChatClickable.EnumClickAction.g.get(s);
        }

        static {
            ChatClickable.EnumClickAction[] achatclickable_enumclickaction = values();
            int i = achatclickable_enumclickaction.length;

            for (int j = 0; j < i; ++j) {
                ChatClickable.EnumClickAction chatclickable_enumclickaction = achatclickable_enumclickaction[j];

                ChatClickable.EnumClickAction.g.put(chatclickable_enumclickaction.b(), chatclickable_enumclickaction);
            }

        }
    }
}
