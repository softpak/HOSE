package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class BlockThin extends Block {

    public static final BlockStateBoolean NORTH = BlockStateBoolean.of("north");
    public static final BlockStateBoolean EAST = BlockStateBoolean.of("east");
    public static final BlockStateBoolean SOUTH = BlockStateBoolean.of("south");
    public static final BlockStateBoolean WEST = BlockStateBoolean.of("west");
    private final boolean a;

    protected BlockThin(Material material, boolean flag) {
        super(material);
        this.j(this.blockStateList.getBlockData().set(BlockThin.NORTH, Boolean.valueOf(false)).set(BlockThin.EAST, Boolean.valueOf(false)).set(BlockThin.SOUTH, Boolean.valueOf(false)).set(BlockThin.WEST, Boolean.valueOf(false)));
        this.a = flag;
        this.a(CreativeModeTab.c);
    }

    public IBlockData updateState(IBlockData iblockdata, IBlockAccess iblockaccess, BlockPosition blockposition) {
        return iblockdata.set(BlockThin.NORTH, Boolean.valueOf(this.c(iblockaccess.getType(blockposition.north()).getBlock()))).set(BlockThin.SOUTH, Boolean.valueOf(this.c(iblockaccess.getType(blockposition.south()).getBlock()))).set(BlockThin.WEST, Boolean.valueOf(this.c(iblockaccess.getType(blockposition.west()).getBlock()))).set(BlockThin.EAST, Boolean.valueOf(this.c(iblockaccess.getType(blockposition.east()).getBlock())));
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return !this.a ? null : super.getDropType(iblockdata, random, i);
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, AxisAlignedBB axisalignedbb, List<AxisAlignedBB> list, Entity entity) {
        boolean flag = this.c(world.getType(blockposition.north()).getBlock());
        boolean flag1 = this.c(world.getType(blockposition.south()).getBlock());
        boolean flag2 = this.c(world.getType(blockposition.west()).getBlock());
        boolean flag3 = this.c(world.getType(blockposition.east()).getBlock());

        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
            if (flag2) {
                this.a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
                super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
            } else if (flag3) {
                this.a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
                super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
            }
        } else {
            this.a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        }

        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
            if (flag) {
                this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
                super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
            } else if (flag1) {
                this.a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
                super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
            }
        } else {
            this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
            super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        }

    }

    public void j() {
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void updateShape(IBlockAccess iblockaccess, BlockPosition blockposition) {
        float f = 0.4375F;
        float f1 = 0.5625F;
        float f2 = 0.4375F;
        float f3 = 0.5625F;
        boolean flag = this.c(iblockaccess.getType(blockposition.north()).getBlock());
        boolean flag1 = this.c(iblockaccess.getType(blockposition.south()).getBlock());
        boolean flag2 = this.c(iblockaccess.getType(blockposition.west()).getBlock());
        boolean flag3 = this.c(iblockaccess.getType(blockposition.east()).getBlock());

        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
            if (flag2) {
                f = 0.0F;
            } else if (flag3) {
                f1 = 1.0F;
            }
        } else {
            f = 0.0F;
            f1 = 1.0F;
        }

        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
            if (flag) {
                f2 = 0.0F;
            } else if (flag1) {
                f3 = 1.0F;
            }
        } else {
            f2 = 0.0F;
            f3 = 1.0F;
        }

        this.a(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public final boolean c(Block block) {
        return block.o() || block == this || block == Blocks.GLASS || block == Blocks.STAINED_GLASS || block == Blocks.STAINED_GLASS_PANE || block instanceof BlockThin;
    }

    protected boolean I() {
        return true;
    }

    public int toLegacyData(IBlockData iblockdata) {
        return 0;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockThin.NORTH, BlockThin.EAST, BlockThin.WEST, BlockThin.SOUTH});
    }
}
