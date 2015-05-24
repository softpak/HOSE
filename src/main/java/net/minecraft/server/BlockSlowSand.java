package net.minecraft.server;

public class BlockSlowSand extends Block {

    public BlockSlowSand() {
        super(Material.SAND, MaterialMapColor.B);
        this.a(CreativeModeTab.b);
    }

    public AxisAlignedBB a(World world, BlockPosition blockposition, IBlockData iblockdata) {
        float f = 0.125F;

        return new AxisAlignedBB((double) blockposition.getX(), (double) blockposition.getY(), (double) blockposition.getZ(), (double) (blockposition.getX() + 1), (double) ((float) (blockposition.getY() + 1) - f), (double) (blockposition.getZ() + 1));
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, Entity entity) {
        entity.motX *= 0.4D;
        entity.motZ *= 0.4D;
    }
}
