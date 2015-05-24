package net.minecraft.server;

public class PathfinderGoalMoveIndoors extends PathfinderGoal {

    private EntityCreature a;
    private VillageDoor b;
    private int c = -1;
    private int d = -1;

    public PathfinderGoalMoveIndoors(EntityCreature entitycreature) {
        this.a = entitycreature;
        this.a(1);
    }

    public boolean a() {
        BlockPosition blockposition = new BlockPosition(this.a);

        if ((!this.a.world.w() || this.a.world.S() && !this.a.world.getBiome(blockposition).e()) && !this.a.world.worldProvider.o()) {
            if (this.a.bc().nextInt(50) != 0) {
                return false;
            } else if (this.c != -1 && this.a.e((double) this.c, this.a.locY, (double) this.d) < 4.0D) {
                return false;
            } else {
                Village village = this.a.world.ae().getClosestVillage(blockposition, 14);

                if (village == null) {
                    return false;
                } else {
                    this.b = village.c(blockposition);
                    return this.b != null;
                }
            }
        } else {
            return false;
        }
    }

    public boolean b() {
        return !this.a.getNavigation().m();
    }

    public void c() {
        this.c = -1;
        BlockPosition blockposition = this.b.e();
        int i = blockposition.getX();
        int j = blockposition.getY();
        int k = blockposition.getZ();

        if (this.a.b(blockposition) > 256.0D) {
            Vec3D vec3d = RandomPositionGenerator.a(this.a, 14, 3, new Vec3D((double) i + 0.5D, (double) j, (double) k + 0.5D));

            if (vec3d != null) {
                this.a.getNavigation().a(vec3d.a, vec3d.b, vec3d.c, 1.0D);
            }
        } else {
            this.a.getNavigation().a((double) i + 0.5D, (double) j, (double) k + 0.5D, 1.0D);
        }

    }

    public void d() {
        this.c = this.b.e().getX();
        this.d = this.b.e().getZ();
        this.b = null;
    }
}
