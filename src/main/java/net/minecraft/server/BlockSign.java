package net.minecraft.server;

import java.util.Random;

public class BlockSign extends BlockContainer {

    protected BlockSign() {
        super(Material.WOOD);
        float f = 0.25F;
        float f1 = 1.0F;

        this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public AxisAlignedBB a(World world, BlockPosition blockposition, IBlockData iblockdata) {
        return null;
    }

    public boolean d() {
        return false;
    }

    public boolean b(IBlockAccess iblockaccess, BlockPosition blockposition) {
        return true;
    }

    public boolean c() {
        return false;
    }

    public boolean g() {
        return true;
    }

    public TileEntity a(World world, int i) {
        return new TileEntitySign();
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Items.SIGN;
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (world.isClientSide) {
            return true;
        } else {
            TileEntity tileentity = world.getTileEntity(blockposition);

            return tileentity instanceof TileEntitySign ? ((TileEntitySign) tileentity).b(entityhuman) : false;
        }
    }

    public boolean canPlace(World world, BlockPosition blockposition) {
        return !this.e(world, blockposition) && super.canPlace(world, blockposition);
    }
}
