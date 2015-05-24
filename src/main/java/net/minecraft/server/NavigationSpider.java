package net.minecraft.server;

public class NavigationSpider extends Navigation {

    private BlockPosition f;

    public NavigationSpider(EntityInsentient entityinsentient, World world) {
        super(entityinsentient, world);
    }

    public PathEntity a(BlockPosition blockposition) {
        this.f = blockposition;
        return super.a(blockposition);
    }

    public PathEntity a(Entity entity) {
        this.f = new BlockPosition(entity);
        return super.a(entity);
    }

    public boolean a(Entity entity, double d0) {
        PathEntity pathentity = this.a(entity);

        if (pathentity != null) {
            return this.a(pathentity, d0);
        } else {
            this.f = new BlockPosition(entity);
            this.e = d0;
            return true;
        }
    }

    public void k() {
        if (!this.m()) {
            super.k();
        } else {
            if (this.f != null) {
                double d0 = (double) (this.b.width * this.b.width);

                if (this.b.c(this.f) >= d0 && (this.b.locY <= (double) this.f.getY() || this.b.c(new BlockPosition(this.f.getX(), MathHelper.floor(this.b.locY), this.f.getZ())) >= d0)) {
                    this.b.getControllerMove().a((double) this.f.getX(), (double) this.f.getY(), (double) this.f.getZ(), this.e);
                } else {
                    this.f = null;
                }
            }

        }
    }
}
