package net.minecraft.server;

import com.google.gson.JsonObject;

public class JsonListEntry<T> {

    private final T a;

    public JsonListEntry(T t0) {
        this.a = t0;
    }

    protected JsonListEntry(T t0, JsonObject jsonobject) {
        this.a = t0;
    }

    public T getKey() { // CraftBukkit - public
        return this.a;
    }

    boolean hasExpired() {
        return false;
    }

    protected void a(JsonObject jsonobject) {}
}
