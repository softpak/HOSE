package net.minecraft.server;

import java.util.Random;

public class BlockWeb extends Block {

    public BlockWeb() {
        super(Material.WEB);
        this.a(CreativeModeTab.c);
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, Entity entity) {
        entity.aA();
    }

    public boolean c() {
        return false;
    }

    public AxisAlignedBB a(World world, BlockPosition blockposition, IBlockData iblockdata) {
        return null;
    }

    public boolean d() {
        return false;
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Items.STRING;
    }

    protected boolean I() {
        return true;
    }
}
