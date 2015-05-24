package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class BlockEnderPortalFrame extends Block {

    public static final BlockStateDirection FACING = BlockStateDirection.of("facing", (Predicate) EnumDirection.EnumDirectionLimit.HORIZONTAL);
    public static final BlockStateBoolean EYE = BlockStateBoolean.of("eye");

    public BlockEnderPortalFrame() {
        super(Material.STONE, MaterialMapColor.C);
        this.j(this.blockStateList.getBlockData().set(BlockEnderPortalFrame.FACING, EnumDirection.NORTH).set(BlockEnderPortalFrame.EYE, Boolean.valueOf(false)));
    }

    public boolean c() {
        return false;
    }

    public void j() {
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, AxisAlignedBB axisalignedbb, List<AxisAlignedBB> list, Entity entity) {
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
        super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        if (((Boolean) world.getType(blockposition).get(BlockEnderPortalFrame.EYE)).booleanValue()) {
            this.a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
            super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        }

        this.j();
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return null;
    }

    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        return this.getBlockData().set(BlockEnderPortalFrame.FACING, entityliving.getDirection().opposite()).set(BlockEnderPortalFrame.EYE, Boolean.valueOf(false));
    }

    public boolean isComplexRedstone() {
        return true;
    }

    public int l(World world, BlockPosition blockposition) {
        return ((Boolean) world.getType(blockposition).get(BlockEnderPortalFrame.EYE)).booleanValue() ? 15 : 0;
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockEnderPortalFrame.EYE, Boolean.valueOf((i & 4) != 0)).set(BlockEnderPortalFrame.FACING, EnumDirection.fromType2(i & 3));
    }

    public int toLegacyData(IBlockData iblockdata) {
        byte b0 = 0;
        int i = b0 | ((EnumDirection) iblockdata.get(BlockEnderPortalFrame.FACING)).b();

        if (((Boolean) iblockdata.get(BlockEnderPortalFrame.EYE)).booleanValue()) {
            i |= 4;
        }

        return i;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockEnderPortalFrame.FACING, BlockEnderPortalFrame.EYE});
    }
}
