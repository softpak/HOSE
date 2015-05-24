package net.minecraft.server;

public class PathfinderWater extends PathfinderAbstract {

    public PathfinderWater() {}

    public void a(IBlockAccess iblockaccess, Entity entity) {
        super.a(iblockaccess, entity);
    }

    public void a() {
        super.a();
    }

    public PathPoint a(Entity entity) {
        return this.a(MathHelper.floor(entity.getBoundingBox().a), MathHelper.floor(entity.getBoundingBox().b + 0.5D), MathHelper.floor(entity.getBoundingBox().c));
    }

    public PathPoint a(Entity entity, double d0, double d1, double d2) {
        return this.a(MathHelper.floor(d0 - (double) (entity.width / 2.0F)), MathHelper.floor(d1 + 0.5D), MathHelper.floor(d2 - (double) (entity.width / 2.0F)));
    }

    public int a(PathPoint[] apathpoint, Entity entity, PathPoint pathpoint, PathPoint pathpoint1, float f) {
        int i = 0;
        EnumDirection[] aenumdirection = EnumDirection.values();
        int j = aenumdirection.length;

        for (int k = 0; k < j; ++k) {
            EnumDirection enumdirection = aenumdirection[k];
            PathPoint pathpoint2 = this.a(entity, pathpoint.a + enumdirection.getAdjacentX(), pathpoint.b + enumdirection.getAdjacentY(), pathpoint.c + enumdirection.getAdjacentZ());

            if (pathpoint2 != null && !pathpoint2.i && pathpoint2.a(pathpoint1) < f) {
                apathpoint[i++] = pathpoint2;
            }
        }

        return i;
    }

    private PathPoint a(Entity entity, int i, int j, int k) {
        int l = this.b(entity, i, j, k);

        return l == -1 ? this.a(i, j, k) : null;
    }

    private int b(Entity entity, int i, int j, int k) {
        BlockPosition.MutableBlockPosition blockposition_mutableblockposition = new BlockPosition.MutableBlockPosition();

        for (int l = i; l < i + this.c; ++l) {
            for (int i1 = j; i1 < j + this.d; ++i1) {
                for (int j1 = k; j1 < k + this.e; ++j1) {
                    Block block = this.a.getType(blockposition_mutableblockposition.c(l, i1, j1)).getBlock();

                    if (block.getMaterial() != Material.WATER) {
                        return 0;
                    }
                }
            }
        }

        return -1;
    }
}
