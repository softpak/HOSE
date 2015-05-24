package net.minecraft.server;

public class EntityAIBodyControl {

    private EntityLiving a;
    private int b;
    private float c;

    public EntityAIBodyControl(EntityLiving entityliving) {
        this.a = entityliving;
    }

    //HSA
    public void a() {
        double d0 = this.a.locX - this.a.lastX;
        double d1 = this.a.locZ - this.a.lastZ;

        if (d0 * d0 + d1 * d1 > 2.500000277905201E-7D) {
            this.a.aI = this.a.yaw;
            this.a.aK = this.a(this.a.aI, this.a.aK, 75.0F);
            this.c = this.a.aK;
            this.b = 0;
        } else {
            float f = 75.0F;

            if (Math.abs(this.a.aK - this.c) > 15.0F) {
                this.b = 0;
                this.c = this.a.aK;
            } else {
                ++this.b;
                boolean flag = true;

                if (this.b > 10) {
                    f = Math.max(1.0F - (float) (this.b - 10) / 10.0F, 0.0F) * 75.0F;
                }
            }

            this.a.aI = this.a(this.a.aK, this.a.aI, f);
        }
    }

    private float a(float f, float f1, float f2) {
        float f3 = MathHelper.g(f - f1);

        if (f3 < -f2) {
            f3 = -f2;
        }

        if (f3 >= f2) {
            f3 = f2;
        }

        return f - f3;
    }
}
