package net.minecraft.server;

public class EntityGiantZombie extends EntityMonster {

    public EntityGiantZombie(World world) {
        super(world);
        this.setSize(this.width * 6.0F, this.length * 6.0F);
    }

    public float getHeadHeight() {
        return 10.440001F;
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(100.0D);
        this.getAttributeInstance(GenericAttributes.d).setValue(0.5D);
        this.getAttributeInstance(GenericAttributes.e).setValue(50.0D);
    }

    public float a(BlockPosition blockposition) {
        return this.world.o(blockposition) - 0.5F;
    }
}
