package net.minecraft.server;

public abstract class PathfinderAbstract {

    protected IBlockAccess a;
    protected IntHashMap<PathPoint> b = new IntHashMap();
    protected int c;
    protected int d;
    protected int e;

    public PathfinderAbstract() {}

    public void a(IBlockAccess iblockaccess, Entity entity) {
        this.a = iblockaccess;
        this.b.c();
        this.c = MathHelper.d(entity.width + 1.0F);
        this.d = MathHelper.d(entity.length + 1.0F);
        this.e = MathHelper.d(entity.width + 1.0F);
    }

    public void a() {}

    protected PathPoint a(int i, int j, int k) {
        int l = PathPoint.a(i, j, k);
        PathPoint pathpoint = (PathPoint) this.b.get(l);

        if (pathpoint == null) {
            pathpoint = new PathPoint(i, j, k);
            this.b.a(l, pathpoint);
        }

        return pathpoint;
    }

    public abstract PathPoint a(Entity entity);

    public abstract PathPoint a(Entity entity, double d0, double d1, double d2);

    public abstract int a(PathPoint[] apathpoint, Entity entity, PathPoint pathpoint, PathPoint pathpoint1, float f);
}
