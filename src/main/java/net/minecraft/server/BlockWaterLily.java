package net.minecraft.server;

import java.util.List;

public class BlockWaterLily extends BlockPlant {

    protected BlockWaterLily() {
        float f = 0.5F;
        float f1 = 0.015625F;

        this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        this.a(CreativeModeTab.c);
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, AxisAlignedBB axisalignedbb, List<AxisAlignedBB> list, Entity entity) {
        if (entity == null || !(entity instanceof EntityBoat)) {
            super.a(world, blockposition, iblockdata, axisalignedbb, list, entity);
        }

    }

    public AxisAlignedBB a(World world, BlockPosition blockposition, IBlockData iblockdata) {
        return new AxisAlignedBB((double) blockposition.getX() + this.minX, (double) blockposition.getY() + this.minY, (double) blockposition.getZ() + this.minZ, (double) blockposition.getX() + this.maxX, (double) blockposition.getY() + this.maxY, (double) blockposition.getZ() + this.maxZ);
    }

    protected boolean c(Block block) {
        return block == Blocks.WATER;
    }

    public boolean f(World world, BlockPosition blockposition, IBlockData iblockdata) {
        if (blockposition.getY() >= 0 && blockposition.getY() < 256) {
            IBlockData iblockdata1 = world.getType(blockposition.down());

            return iblockdata1.getBlock().getMaterial() == Material.WATER && ((Integer) iblockdata1.get(BlockFluids.LEVEL)).intValue() == 0;
        } else {
            return false;
        }
    }

    public int toLegacyData(IBlockData iblockdata) {
        return 0;
    }
}
