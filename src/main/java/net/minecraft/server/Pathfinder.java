package net.minecraft.server;

public class Pathfinder {

    private Path a = new Path();
    private PathPoint[] b = new PathPoint[32];
    private PathfinderAbstract c;

    public Pathfinder(PathfinderAbstract pathfinderabstract) {
        this.c = pathfinderabstract;
    }

    public PathEntity a(IBlockAccess iblockaccess, Entity entity, Entity entity1, float f) {
        return this.a(iblockaccess, entity, entity1.locX, entity1.getBoundingBox().b, entity1.locZ, f);
    }

    public PathEntity a(IBlockAccess iblockaccess, Entity entity, BlockPosition blockposition, float f) {
        return this.a(iblockaccess, entity, (double) ((float) blockposition.getX() + 0.5F), (double) ((float) blockposition.getY() + 0.5F), (double) ((float) blockposition.getZ() + 0.5F), f);
    }

    private PathEntity a(IBlockAccess iblockaccess, Entity entity, double d0, double d1, double d2, float f) {
        this.a.a();
        this.c.a(iblockaccess, entity);
        PathPoint pathpoint = this.c.a(entity);
        PathPoint pathpoint1 = this.c.a(entity, d0, d1, d2);
        PathEntity pathentity = this.a(entity, pathpoint, pathpoint1, f);

        this.c.a();
        return pathentity;
    }

    private PathEntity a(Entity entity, PathPoint pathpoint, PathPoint pathpoint1, float f) {
        pathpoint.e = 0.0F;
        pathpoint.f = pathpoint.b(pathpoint1);
        pathpoint.g = pathpoint.f;
        this.a.a();
        this.a.a(pathpoint);
        PathPoint pathpoint2 = pathpoint;

        while (!this.a.e()) {
            PathPoint pathpoint3 = this.a.c();

            if (pathpoint3.equals(pathpoint1)) {
                return this.a(pathpoint, pathpoint1);
            }

            if (pathpoint3.b(pathpoint1) < pathpoint2.b(pathpoint1)) {
                pathpoint2 = pathpoint3;
            }

            pathpoint3.i = true;
            int i = this.c.a(this.b, entity, pathpoint3, pathpoint1, f);

            for (int j = 0; j < i; ++j) {
                PathPoint pathpoint4 = this.b[j];
                float f1 = pathpoint3.e + pathpoint3.b(pathpoint4);

                if (f1 < f * 2.0F && (!pathpoint4.a() || f1 < pathpoint4.e)) {
                    pathpoint4.h = pathpoint3;
                    pathpoint4.e = f1;
                    pathpoint4.f = pathpoint4.b(pathpoint1);
                    if (pathpoint4.a()) {
                        this.a.a(pathpoint4, pathpoint4.e + pathpoint4.f);
                    } else {
                        pathpoint4.g = pathpoint4.e + pathpoint4.f;
                        this.a.a(pathpoint4);
                    }
                }
            }
        }

        if (pathpoint2 == pathpoint) {
            return null;
        } else {
            return this.a(pathpoint, pathpoint2);
        }
    }

    private PathEntity a(PathPoint pathpoint, PathPoint pathpoint1) {
        int i = 1;

        PathPoint pathpoint2;

        for (pathpoint2 = pathpoint1; pathpoint2.h != null; pathpoint2 = pathpoint2.h) {
            ++i;
        }

        PathPoint[] apathpoint = new PathPoint[i];

        pathpoint2 = pathpoint1;
        --i;

        for (apathpoint[i] = pathpoint1; pathpoint2.h != null; apathpoint[i] = pathpoint2) {
            pathpoint2 = pathpoint2.h;
            --i;
        }

        return new PathEntity(apathpoint);
    }
}
