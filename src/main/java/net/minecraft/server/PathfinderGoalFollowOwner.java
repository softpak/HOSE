package net.minecraft.server;

public class PathfinderGoalFollowOwner extends PathfinderGoal {

    private EntityTameableAnimal d;
    private EntityLiving e;
    World a;
    private double f;
    private NavigationAbstract g;
    private int h;
    float b;
    float c;
    private boolean i;

    public PathfinderGoalFollowOwner(EntityTameableAnimal entitytameableanimal, double d0, float f, float f1) {
        this.d = entitytameableanimal;
        this.a = entitytameableanimal.world;
        this.f = d0;
        this.g = entitytameableanimal.getNavigation();
        this.c = f;
        this.b = f1;
        this.a(3);
        if (!(entitytameableanimal.getNavigation() instanceof Navigation)) {
            throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
        }
    }

    public boolean a() {
        EntityLiving entityliving = this.d.getOwner();

        if (entityliving == null) {
            return false;
        } else if (this.d.isSitting()) {
            return false;
        } else if (this.d.h(entityliving) < (double) (this.c * this.c)) {
            return false;
        } else {
            this.e = entityliving;
            return true;
        }
    }

    public boolean b() {
        return !this.g.m() && this.d.h(this.e) > (double) (this.b * this.b) && !this.d.isSitting();
    }

    public void c() {
        this.h = 0;
        this.i = ((Navigation) this.d.getNavigation()).e();
        ((Navigation) this.d.getNavigation()).a(false);
    }

    public void d() {
        this.e = null;
        this.g.n();
        ((Navigation) this.d.getNavigation()).a(true);
    }

    private boolean a(BlockPosition blockposition) {
        IBlockData iblockdata = this.a.getType(blockposition);
        Block block = iblockdata.getBlock();

        return block == Blocks.AIR ? true : !block.d();
    }

    public void e() {
        this.d.getControllerLook().a(this.e, 10.0F, (float) this.d.bQ());
        if (!this.d.isSitting()) {
            if (--this.h <= 0) {
                this.h = 10;
                if (!this.g.a((Entity) this.e, this.f)) {
                    if (!this.d.cc()) {
                        if (this.d.h(this.e) >= 144.0D) {
                            int i = MathHelper.floor(this.e.locX) - 2;
                            int j = MathHelper.floor(this.e.locZ) - 2;
                            int k = MathHelper.floor(this.e.getBoundingBox().b);

                            for (int l = 0; l <= 4; ++l) {
                                for (int i1 = 0; i1 <= 4; ++i1) {
                                    if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && World.a((IBlockAccess) this.a, new BlockPosition(i + l, k - 1, j + i1)) && this.a(new BlockPosition(i + l, k, j + i1)) && this.a(new BlockPosition(i + l, k + 1, j + i1))) {
                                        this.d.setPositionRotation((double) ((float) (i + l) + 0.5F), (double) k, (double) ((float) (j + i1) + 0.5F), this.d.yaw, this.d.pitch);
                                        this.g.n();
                                        return;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}
