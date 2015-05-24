package net.minecraft.server;

public class BlockAir extends Block {

    protected BlockAir() {
        super(Material.AIR);
    }

    public int b() {
        return -1;
    }

    public AxisAlignedBB a(World world, BlockPosition blockposition, IBlockData iblockdata) {
        return null;
    }

    public boolean c() {
        return false;
    }

    public boolean a(IBlockData iblockdata, boolean flag) {
        return false;
    }

    public void dropNaturally(World world, BlockPosition blockposition, IBlockData iblockdata, float f, int i) {}

    public boolean a(World world, BlockPosition blockposition) {
        return true;
    }
}
