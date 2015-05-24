package net.minecraft.server;

public class ControllerJump {

    private EntityInsentient b;
    protected boolean a;

    public ControllerJump(EntityInsentient entityinsentient) {
        this.b = entityinsentient;
    }

    public void a() {
        this.a = true;
    }

    public void b() {
        this.b.i(this.a);
        this.a = false;
    }
}
