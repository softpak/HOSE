package net.minecraft.server;

public abstract class BlockContainer extends Block implements IContainer {

    protected BlockContainer(Material material) {
        this(material, material.r());
    }

    protected BlockContainer(Material material, MaterialMapColor materialmapcolor) {
        super(material, materialmapcolor);
        this.isTileEntity = true;
    }

    protected boolean a(World world, BlockPosition blockposition, EnumDirection enumdirection) {
        return world.getType(blockposition.shift(enumdirection)).getBlock().getMaterial() == Material.CACTUS;
    }

    protected boolean e(World world, BlockPosition blockposition) {
        return this.a(world, blockposition, EnumDirection.NORTH) || this.a(world, blockposition, EnumDirection.SOUTH) || this.a(world, blockposition, EnumDirection.WEST) || this.a(world, blockposition, EnumDirection.EAST);
    }

    public int b() {
        return -1;
    }

    public void remove(World world, BlockPosition blockposition, IBlockData iblockdata) {
        super.remove(world, blockposition, iblockdata);
        world.t(blockposition);
    }

    public boolean a(World world, BlockPosition blockposition, IBlockData iblockdata, int i, int j) {
        super.a(world, blockposition, iblockdata, i, j);
        TileEntity tileentity = world.getTileEntity(blockposition);

        return tileentity == null ? false : tileentity.c(i, j);
    }
}
