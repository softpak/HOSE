package net.minecraft.server;

public class BlockPowered extends Block {

    public BlockPowered(Material material, MaterialMapColor materialmapcolor) {
        super(material, materialmapcolor);
    }

    public boolean isPowerSource() {
        return true;
    }

    public int a(IBlockAccess iblockaccess, BlockPosition blockposition, IBlockData iblockdata, EnumDirection enumdirection) {
        return 15;
    }
}
