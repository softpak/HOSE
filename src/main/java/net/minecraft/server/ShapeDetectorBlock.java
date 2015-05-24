package net.minecraft.server;

import com.google.common.base.Predicate;

public class ShapeDetectorBlock {

    private final World a;
    private final BlockPosition b;
    private final boolean c;
    private IBlockData d;
    private TileEntity e;
    private boolean f;

    public ShapeDetectorBlock(World world, BlockPosition blockposition, boolean flag) {
        this.a = world;
        this.b = blockposition;
        this.c = flag;
    }

    public IBlockData a() {
        if (this.d == null && (this.c || this.a.isLoaded(this.b))) {
            this.d = this.a.getType(this.b);
        }

        return this.d;
    }

    public TileEntity b() {
        if (this.e == null && !this.f) {
            this.e = this.a.getTileEntity(this.b);
            this.f = true;
        }

        return this.e;
    }

    public BlockPosition d() {
        return this.b;
    }

    public static Predicate<ShapeDetectorBlock> a(final Predicate<IBlockData> predicate) {
        return new Predicate() {
            public boolean a(ShapeDetectorBlock shapedetectorblock) {
                return shapedetectorblock != null && predicate.apply(shapedetectorblock.a());
            }

            public boolean apply(Object object) {
                return this.a((ShapeDetectorBlock) object);
            }
        };
    }
}
