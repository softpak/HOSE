package net.minecraft.server;

import java.util.Random;

public class BlockRepeater extends BlockDiodeAbstract {

    public static final BlockStateBoolean LOCKED = BlockStateBoolean.of("locked");
    public static final BlockStateInteger DELAY = BlockStateInteger.of("delay", 1, 4);

    protected BlockRepeater(boolean flag) {
        super(flag);
        this.j(this.blockStateList.getBlockData().set(BlockRepeater.FACING, EnumDirection.NORTH).set(BlockRepeater.DELAY, Integer.valueOf(1)).set(BlockRepeater.LOCKED, Boolean.valueOf(false)));
    }

    public String getName() {
        return LocaleI18n.get("item.diode.name");
    }

    public IBlockData updateState(IBlockData iblockdata, IBlockAccess iblockaccess, BlockPosition blockposition) {
        return iblockdata.set(BlockRepeater.LOCKED, Boolean.valueOf(this.b(iblockaccess, blockposition, iblockdata)));
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (!entityhuman.abilities.mayBuild) {
            return false;
        } else {
            world.setTypeAndData(blockposition, iblockdata.a(BlockRepeater.DELAY), 3);
            return true;
        }
    }

    protected int d(IBlockData iblockdata) {
        return ((Integer) iblockdata.get(BlockRepeater.DELAY)).intValue() * 2;
    }

    protected IBlockData e(IBlockData iblockdata) {
        Integer integer = (Integer) iblockdata.get(BlockRepeater.DELAY);
        Boolean obool = (Boolean) iblockdata.get(BlockRepeater.LOCKED);
        EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockRepeater.FACING);

        return Blocks.POWERED_REPEATER.getBlockData().set(BlockRepeater.FACING, enumdirection).set(BlockRepeater.DELAY, integer).set(BlockRepeater.LOCKED, obool);
    }

    protected IBlockData k(IBlockData iblockdata) {
        Integer integer = (Integer) iblockdata.get(BlockRepeater.DELAY);
        Boolean obool = (Boolean) iblockdata.get(BlockRepeater.LOCKED);
        EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockRepeater.FACING);

        return Blocks.UNPOWERED_REPEATER.getBlockData().set(BlockRepeater.FACING, enumdirection).set(BlockRepeater.DELAY, integer).set(BlockRepeater.LOCKED, obool);
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Items.REPEATER;
    }

    public boolean b(IBlockAccess iblockaccess, BlockPosition blockposition, IBlockData iblockdata) {
        return this.c(iblockaccess, blockposition, iblockdata) > 0;
    }

    protected boolean c(Block block) {
        return d(block);
    }

    public void remove(World world, BlockPosition blockposition, IBlockData iblockdata) {
        super.remove(world, blockposition, iblockdata);
        this.h(world, blockposition, iblockdata);
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockRepeater.FACING, EnumDirection.fromType2(i)).set(BlockRepeater.LOCKED, Boolean.valueOf(false)).set(BlockRepeater.DELAY, Integer.valueOf(1 + (i >> 2)));
    }

    public int toLegacyData(IBlockData iblockdata) {
        byte b0 = 0;
        int i = b0 | ((EnumDirection) iblockdata.get(BlockRepeater.FACING)).b();

        i |= ((Integer) iblockdata.get(BlockRepeater.DELAY)).intValue() - 1 << 2;
        return i;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockRepeater.FACING, BlockRepeater.DELAY, BlockRepeater.LOCKED});
    }
}
