package net.minecraft.server;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class OpListEntry extends JsonListEntry<GameProfile> {

    private final int a;

    public OpListEntry(GameProfile gameprofile, int i) {
        super(gameprofile);
        this.a = i;
    }

    public OpListEntry(JsonObject jsonobject) {
        super(b(jsonobject), jsonobject);
        this.a = jsonobject.has("level") ? jsonobject.get("level").getAsInt() : 0;
    }

    public int a() {
        return this.a;
    }

    protected void a(JsonObject jsonobject) {
        if (this.getKey() != null) {
            jsonobject.addProperty("uuid", ((GameProfile) this.getKey()).getId() == null ? "" : ((GameProfile) this.getKey()).getId().toString());
            jsonobject.addProperty("name", ((GameProfile) this.getKey()).getName());
            super.a(jsonobject);
            jsonobject.addProperty("level", Integer.valueOf(this.a));
        }
    }

    private static GameProfile b(JsonObject jsonobject) {
        if (jsonobject.has("uuid") && jsonobject.has("name")) {
            String s = jsonobject.get("uuid").getAsString();

            UUID uuid;

            try {
                uuid = UUID.fromString(s);
            } catch (Throwable throwable) {
                return null;
            }

            return new GameProfile(uuid, jsonobject.get("name").getAsString());
        } else {
            return null;
        }
    }
}
