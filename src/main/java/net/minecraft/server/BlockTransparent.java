package net.minecraft.server;

public class BlockTransparent extends Block {

    protected boolean R;

    protected BlockTransparent(Material material, boolean flag) {
        super(material);
        this.R = flag;
    }

    public boolean c() {
        return false;
    }
}
