package net.minecraft.server;

public abstract class EntityGolem extends EntityCreature implements IAnimal {

    public EntityGolem(World world) {
        super(world);
    }

    public void e(float f, float f1) {}

    protected String z() {
        return "none";
    }

    protected String bo() {
        return "none";
    }

    protected String bp() {
        return "none";
    }

    public int w() {
        return 120;
    }

    protected boolean isTypeNotPersistent() {
        return false;
    }
}
