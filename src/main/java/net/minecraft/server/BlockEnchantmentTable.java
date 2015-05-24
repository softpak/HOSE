package net.minecraft.server;

public class BlockEnchantmentTable extends BlockContainer {

    protected BlockEnchantmentTable() {
        super(Material.STONE, MaterialMapColor.D);
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        this.e(0);
        this.a(CreativeModeTab.c);
    }

    public boolean d() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public int b() {
        return 3;
    }

    public TileEntity a(World world, int i) {
        return new TileEntityEnchantTable();
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (world.isClientSide) {
            return true;
        } else {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityEnchantTable) {
                entityhuman.openTileEntity((TileEntityEnchantTable) tileentity);
            }

            return true;
        }
    }

    public void postPlace(World world, BlockPosition blockposition, IBlockData iblockdata, EntityLiving entityliving, ItemStack itemstack) {
        super.postPlace(world, blockposition, iblockdata, entityliving, itemstack);
        if (itemstack.hasName()) {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityEnchantTable) {
                ((TileEntityEnchantTable) tileentity).a(itemstack.getName());
            }
        }

    }
}
