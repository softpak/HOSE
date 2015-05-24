package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class BlockRedstoneComparator extends BlockDiodeAbstract implements IContainer {

    public static final BlockStateBoolean POWERED = BlockStateBoolean.of("powered");
    public static final BlockStateEnum<BlockRedstoneComparator.EnumComparatorMode> MODE = BlockStateEnum.of("mode", BlockRedstoneComparator.EnumComparatorMode.class);

    public BlockRedstoneComparator(boolean flag) {
        super(flag);
        this.j(this.blockStateList.getBlockData().set(BlockRedstoneComparator.FACING, EnumDirection.NORTH).set(BlockRedstoneComparator.POWERED, Boolean.valueOf(false)).set(BlockRedstoneComparator.MODE, BlockRedstoneComparator.EnumComparatorMode.COMPARE));
        this.isTileEntity = true;
    }

    public String getName() {
        return LocaleI18n.get("item.comparator.name");
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Items.COMPARATOR;
    }

    protected int d(IBlockData iblockdata) {
        return 2;
    }

    protected IBlockData e(IBlockData iblockdata) {
        Boolean obool = (Boolean) iblockdata.get(BlockRedstoneComparator.POWERED);
        BlockRedstoneComparator.EnumComparatorMode blockredstonecomparator_enumcomparatormode = (BlockRedstoneComparator.EnumComparatorMode) iblockdata.get(BlockRedstoneComparator.MODE);
        EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockRedstoneComparator.FACING);

        return Blocks.POWERED_COMPARATOR.getBlockData().set(BlockRedstoneComparator.FACING, enumdirection).set(BlockRedstoneComparator.POWERED, obool).set(BlockRedstoneComparator.MODE, blockredstonecomparator_enumcomparatormode);
    }

    protected IBlockData k(IBlockData iblockdata) {
        Boolean obool = (Boolean) iblockdata.get(BlockRedstoneComparator.POWERED);
        BlockRedstoneComparator.EnumComparatorMode blockredstonecomparator_enumcomparatormode = (BlockRedstoneComparator.EnumComparatorMode) iblockdata.get(BlockRedstoneComparator.MODE);
        EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockRedstoneComparator.FACING);

        return Blocks.UNPOWERED_COMPARATOR.getBlockData().set(BlockRedstoneComparator.FACING, enumdirection).set(BlockRedstoneComparator.POWERED, obool).set(BlockRedstoneComparator.MODE, blockredstonecomparator_enumcomparatormode);
    }

    protected boolean l(IBlockData iblockdata) {
        return this.N || ((Boolean) iblockdata.get(BlockRedstoneComparator.POWERED)).booleanValue();
    }

    protected int a(IBlockAccess iblockaccess, BlockPosition blockposition, IBlockData iblockdata) {
        TileEntity tileentity = iblockaccess.getTileEntity(blockposition);

        return tileentity instanceof TileEntityComparator ? ((TileEntityComparator) tileentity).b() : 0;
    }

    private int j(World world, BlockPosition blockposition, IBlockData iblockdata) {
        return iblockdata.get(BlockRedstoneComparator.MODE) == BlockRedstoneComparator.EnumComparatorMode.SUBTRACT ? Math.max(this.f(world, blockposition, iblockdata) - this.c(world, blockposition, iblockdata), 0) : this.f(world, blockposition, iblockdata);
    }

    protected boolean e(World world, BlockPosition blockposition, IBlockData iblockdata) {
        int i = this.f(world, blockposition, iblockdata);

        if (i >= 15) {
            return true;
        } else if (i == 0) {
            return false;
        } else {
            int j = this.c(world, blockposition, iblockdata);

            return j == 0 ? true : i >= j;
        }
    }

    protected int f(World world, BlockPosition blockposition, IBlockData iblockdata) {
        int i = super.f(world, blockposition, iblockdata);
        EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockRedstoneComparator.FACING);
        BlockPosition blockposition1 = blockposition.shift(enumdirection);
        Block block = world.getType(blockposition1).getBlock();

        if (block.isComplexRedstone()) {
            i = block.l(world, blockposition1);
        } else if (i < 15 && block.isOccluding()) {
            blockposition1 = blockposition1.shift(enumdirection);
            block = world.getType(blockposition1).getBlock();
            if (block.isComplexRedstone()) {
                i = block.l(world, blockposition1);
            } else if (block.getMaterial() == Material.AIR) {
                EntityItemFrame entityitemframe = this.a(world, enumdirection, blockposition1);

                if (entityitemframe != null) {
                    i = entityitemframe.q();
                }
            }
        }

        return i;
    }

    private EntityItemFrame a(World world, final EnumDirection enumdirection, BlockPosition blockposition) {
        List list = world.a(EntityItemFrame.class, new AxisAlignedBB((double) blockposition.getX(), (double) blockposition.getY(), (double) blockposition.getZ(), (double) (blockposition.getX() + 1), (double) (blockposition.getY() + 1), (double) (blockposition.getZ() + 1)), new Predicate() {
            public boolean a(Entity entity) {
                return entity != null && entity.getDirection() == enumdirection;
            }

            public boolean apply(Object object) {
                return this.a((Entity) object);
            }
        });

        return list.size() == 1 ? (EntityItemFrame) list.get(0) : null;
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (!entityhuman.abilities.mayBuild) {
            return false;
        } else {
            iblockdata = iblockdata.a(BlockRedstoneComparator.MODE);
            world.makeSound((double) blockposition.getX() + 0.5D, (double) blockposition.getY() + 0.5D, (double) blockposition.getZ() + 0.5D, "random.click", 0.3F, iblockdata.get(BlockRedstoneComparator.MODE) == BlockRedstoneComparator.EnumComparatorMode.SUBTRACT ? 0.55F : 0.5F);
            world.setTypeAndData(blockposition, iblockdata, 2);
            this.k(world, blockposition, iblockdata);
            return true;
        }
    }

    protected void g(World world, BlockPosition blockposition, IBlockData iblockdata) {
        if (!world.a(blockposition, (Block) this)) {
            int i = this.j(world, blockposition, iblockdata);
            TileEntity tileentity = world.getTileEntity(blockposition);
            int j = tileentity instanceof TileEntityComparator ? ((TileEntityComparator) tileentity).b() : 0;

            if (i != j || this.l(iblockdata) != this.e(world, blockposition, iblockdata)) {
                if (this.i(world, blockposition, iblockdata)) {
                    world.a(blockposition, this, 2, -1);
                } else {
                    world.a(blockposition, this, 2, 0);
                }
            }

        }
    }

    private void k(World world, BlockPosition blockposition, IBlockData iblockdata) {
        int i = this.j(world, blockposition, iblockdata);
        TileEntity tileentity = world.getTileEntity(blockposition);
        int j = 0;

        if (tileentity instanceof TileEntityComparator) {
            TileEntityComparator tileentitycomparator = (TileEntityComparator) tileentity;

            j = tileentitycomparator.b();
            tileentitycomparator.a(i);
        }

        if (j != i || iblockdata.get(BlockRedstoneComparator.MODE) == BlockRedstoneComparator.EnumComparatorMode.COMPARE) {
            boolean flag = this.e(world, blockposition, iblockdata);
            boolean flag1 = this.l(iblockdata);

            if (flag1 && !flag) {
                world.setTypeAndData(blockposition, iblockdata.set(BlockRedstoneComparator.POWERED, Boolean.valueOf(false)), 2);
            } else if (!flag1 && flag) {
                world.setTypeAndData(blockposition, iblockdata.set(BlockRedstoneComparator.POWERED, Boolean.valueOf(true)), 2);
            }

            this.h(world, blockposition, iblockdata);
        }

    }

    public void b(World world, BlockPosition blockposition, IBlockData iblockdata, Random random) {
        if (this.N) {
            world.setTypeAndData(blockposition, this.k(iblockdata).set(BlockRedstoneComparator.POWERED, Boolean.valueOf(true)), 4);
        }

        this.k(world, blockposition, iblockdata);
    }

    public void onPlace(World world, BlockPosition blockposition, IBlockData iblockdata) {
        super.onPlace(world, blockposition, iblockdata);
        world.setTileEntity(blockposition, this.a(world, 0));
    }

    public void remove(World world, BlockPosition blockposition, IBlockData iblockdata) {
        super.remove(world, blockposition, iblockdata);
        world.t(blockposition);
        this.h(world, blockposition, iblockdata);
    }

    public boolean a(World world, BlockPosition blockposition, IBlockData iblockdata, int i, int j) {
        super.a(world, blockposition, iblockdata, i, j);
        TileEntity tileentity = world.getTileEntity(blockposition);

        return tileentity == null ? false : tileentity.c(i, j);
    }

    public TileEntity a(World world, int i) {
        return new TileEntityComparator();
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockRedstoneComparator.FACING, EnumDirection.fromType2(i)).set(BlockRedstoneComparator.POWERED, Boolean.valueOf((i & 8) > 0)).set(BlockRedstoneComparator.MODE, (i & 4) > 0 ? BlockRedstoneComparator.EnumComparatorMode.SUBTRACT : BlockRedstoneComparator.EnumComparatorMode.COMPARE);
    }

    public int toLegacyData(IBlockData iblockdata) {
        byte b0 = 0;
        int i = b0 | ((EnumDirection) iblockdata.get(BlockRedstoneComparator.FACING)).b();

        if (((Boolean) iblockdata.get(BlockRedstoneComparator.POWERED)).booleanValue()) {
            i |= 8;
        }

        if (iblockdata.get(BlockRedstoneComparator.MODE) == BlockRedstoneComparator.EnumComparatorMode.SUBTRACT) {
            i |= 4;
        }

        return i;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockRedstoneComparator.FACING, BlockRedstoneComparator.MODE, BlockRedstoneComparator.POWERED});
    }

    public IBlockData getPlacedState(World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving) {
        return this.getBlockData().set(BlockRedstoneComparator.FACING, entityliving.getDirection().opposite()).set(BlockRedstoneComparator.POWERED, Boolean.valueOf(false)).set(BlockRedstoneComparator.MODE, BlockRedstoneComparator.EnumComparatorMode.COMPARE);
    }

    public static enum EnumComparatorMode implements INamable {

        COMPARE("compare"), SUBTRACT("subtract");

        private final String c;

        private EnumComparatorMode(String s) {
            this.c = s;
        }

        public String toString() {
            return this.c;
        }

        public String getName() {
            return this.c;
        }
    }
}
