package net.minecraft.server;

public class Tuple<A, B> {

    private A a;
    private B b;

    public Tuple(A a0, B b0) {
        this.a = a0;
        this.b = b0;
    }

    public A a() {
        return this.a;
    }

    public B b() {
        return this.b;
    }
}
