package net.minecraft.server;

public class BlockHalfTransparent extends Block {

    private boolean a;

    protected BlockHalfTransparent(Material material, boolean flag) {
        this(material, flag, material.r());
    }

    protected BlockHalfTransparent(Material material, boolean flag, MaterialMapColor materialmapcolor) {
        super(material, materialmapcolor);
        this.a = flag;
    }

    public boolean c() {
        return false;
    }
}
