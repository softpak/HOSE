package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Random;

public class BlockEnderChest extends BlockContainer {

    public static final BlockStateDirection FACING = BlockStateDirection.of("facing", (Predicate) EnumDirection.EnumDirectionLimit.HORIZONTAL);

    protected BlockEnderChest() {
        super(Material.STONE);
        this.j(this.blockStateList.getBlockData().set(BlockEnderChest.FACING, EnumDirection.NORTH));
        this.a(CreativeModeTab.c);
        this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public int b() {
        return 2;
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Item.getItemOf(Blocks.OBSIDIAN);
    }

    public int a(Random random) {
        return 8;
    }

    protected boolean I() {
        return true;
    }

    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        return this.getBlockData().set(BlockEnderChest.FACING, entityliving.getDirection().opposite());
    }

    public void postPlace(World world, BlockPosition blockposition, IBlockData iblockdata, EntityLiving entityliving, ItemStack itemstack) {
        world.setTypeAndData(blockposition, iblockdata.set(BlockEnderChest.FACING, entityliving.getDirection().opposite()), 2);
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        InventoryEnderChest inventoryenderchest = entityhuman.getEnderChest();
        TileEntity tileentity = world.getTileEntity(blockposition);

        if (inventoryenderchest != null && tileentity instanceof TileEntityEnderChest) {
            if (world.getType(blockposition.up()).getBlock().isOccluding()) {
                return true;
            } else if (world.isClientSide) {
                return true;
            } else {
                inventoryenderchest.a((TileEntityEnderChest) tileentity);
                entityhuman.openContainer(inventoryenderchest);
                entityhuman.b(StatisticList.V);
                return true;
            }
        } else {
            return true;
        }
    }

    public TileEntity a(World world, int i) {
        return new TileEntityEnderChest();
    }

    public IBlockData fromLegacyData(int i) {
        EnumDirection enumdirection = EnumDirection.fromType1(i);

        if (enumdirection.k() == EnumDirection.EnumAxis.Y) {
            enumdirection = EnumDirection.NORTH;
        }

        return this.getBlockData().set(BlockEnderChest.FACING, enumdirection);
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((EnumDirection) iblockdata.get(BlockEnderChest.FACING)).a();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockEnderChest.FACING});
    }
}
