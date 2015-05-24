package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Random;

public class BlockBanner extends BlockContainer {

    public static final BlockStateDirection FACING = BlockStateDirection.of("facing", (Predicate) EnumDirection.EnumDirectionLimit.HORIZONTAL);
    public static final BlockStateInteger ROTATION = BlockStateInteger.of("rotation", 0, 15);

    protected BlockBanner() {
        super(Material.WOOD);
        float f = 0.25F;
        float f1 = 1.0F;

        this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public String getName() {
        return LocaleI18n.get("item.banner.white.name");
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
        return new TileEntityBanner();
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Items.BANNER;
    }

    public void dropNaturally(World world, BlockPosition blockposition, IBlockData iblockdata, float f, int i) {
        TileEntity tileentity = world.getTileEntity(blockposition);

        if (tileentity instanceof TileEntityBanner) {
            ItemStack itemstack = new ItemStack(Items.BANNER, 1, ((TileEntityBanner) tileentity).b());
            NBTTagCompound nbttagcompound = new NBTTagCompound();

            tileentity.b(nbttagcompound);
            nbttagcompound.remove("x");
            nbttagcompound.remove("y");
            nbttagcompound.remove("z");
            nbttagcompound.remove("id");
            itemstack.a("BlockEntityTag", (NBTBase) nbttagcompound);
            a(world, blockposition, itemstack);
        } else {
            super.dropNaturally(world, blockposition, iblockdata, f, i);
        }

    }

    public boolean canPlace(World world, BlockPosition blockposition) {
        return !this.e(world, blockposition) && super.canPlace(world, blockposition);
    }

    public void a(World world, EntityHuman entityhuman, BlockPosition blockposition, IBlockData iblockdata, TileEntity tileentity) {
        if (tileentity instanceof TileEntityBanner) {
            TileEntityBanner tileentitybanner = (TileEntityBanner) tileentity;
            ItemStack itemstack = new ItemStack(Items.BANNER, 1, ((TileEntityBanner) tileentity).b());
            NBTTagCompound nbttagcompound = new NBTTagCompound();

            TileEntityBanner.a(nbttagcompound, tileentitybanner.b(), tileentitybanner.d());
            itemstack.a("BlockEntityTag", (NBTBase) nbttagcompound);
            a(world, blockposition, itemstack);
        } else {
            super.a(world, entityhuman, blockposition, iblockdata, (TileEntity) null);
        }

    }

    static class SyntheticClass_1 {

        static final int[] a = new int[EnumDirection.values().length];

        static {
            try {
                BlockBanner.SyntheticClass_1.a[EnumDirection.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError nosuchfielderror) {
                ;
            }

            try {
                BlockBanner.SyntheticClass_1.a[EnumDirection.SOUTH.ordinal()] = 2;
            } catch (NoSuchFieldError nosuchfielderror1) {
                ;
            }

            try {
                BlockBanner.SyntheticClass_1.a[EnumDirection.WEST.ordinal()] = 3;
            } catch (NoSuchFieldError nosuchfielderror2) {
                ;
            }

            try {
                BlockBanner.SyntheticClass_1.a[EnumDirection.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError nosuchfielderror3) {
                ;
            }

        }
    }

    public static class BlockStandingBanner extends BlockBanner {

        public BlockStandingBanner() {
            this.j(this.blockStateList.getBlockData().set(BlockBanner.BlockStandingBanner.ROTATION, Integer.valueOf(0)));
        }

        public void doPhysics(World world, BlockPosition blockposition, IBlockData iblockdata, Block block) {
            if (!world.getType(blockposition.down()).getBlock().getMaterial().isBuildable()) {
                this.b(world, blockposition, iblockdata, 0);
                world.setAir(blockposition);
            }

            super.doPhysics(world, blockposition, iblockdata, block);
        }

        public IBlockData fromLegacyData(int i) {
            return this.getBlockData().set(BlockBanner.BlockStandingBanner.ROTATION, Integer.valueOf(i));
        }

        public int toLegacyData(IBlockData iblockdata) {
            return ((Integer) iblockdata.get(BlockBanner.BlockStandingBanner.ROTATION)).intValue();
        }

        protected BlockStateList getStateList() {
            return new BlockStateList(this, new IBlockState[] { BlockBanner.BlockStandingBanner.ROTATION});
        }
    }

    public static class BlockWallBanner extends BlockBanner {

        public BlockWallBanner() {
            this.j(this.blockStateList.getBlockData().set(BlockBanner.BlockWallBanner.FACING, EnumDirection.NORTH));
        }

        public void updateShape(IBlockAccess iblockaccess, BlockPosition blockposition) {
            EnumDirection enumdirection = (EnumDirection) iblockaccess.getType(blockposition).get(BlockBanner.BlockWallBanner.FACING);
            float f = 0.0F;
            float f1 = 0.78125F;
            float f2 = 0.0F;
            float f3 = 1.0F;
            float f4 = 0.125F;

            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            switch (BlockBanner.SyntheticClass_1.a[enumdirection.ordinal()]) {
            case 1:
            default:
                this.a(f2, f, 1.0F - f4, f3, f1, 1.0F);
                break;

            case 2:
                this.a(f2, f, 0.0F, f3, f1, f4);
                break;

            case 3:
                this.a(1.0F - f4, f, f2, 1.0F, f1, f3);
                break;

            case 4:
                this.a(0.0F, f, f2, f4, f1, f3);
            }

        }

        public void doPhysics(World world, BlockPosition blockposition, IBlockData iblockdata, Block block) {
            EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockBanner.BlockWallBanner.FACING);

            if (!world.getType(blockposition.shift(enumdirection.opposite())).getBlock().getMaterial().isBuildable()) {
                this.b(world, blockposition, iblockdata, 0);
                world.setAir(blockposition);
            }

            super.doPhysics(world, blockposition, iblockdata, block);
        }

        public IBlockData fromLegacyData(int i) {
            EnumDirection enumdirection = EnumDirection.fromType1(i);

            if (enumdirection.k() == EnumDirection.EnumAxis.Y) {
                enumdirection = EnumDirection.NORTH;
            }

            return this.getBlockData().set(BlockBanner.BlockWallBanner.FACING, enumdirection);
        }

        public int toLegacyData(IBlockData iblockdata) {
            return ((EnumDirection) iblockdata.get(BlockBanner.BlockWallBanner.FACING)).a();
        }

        protected BlockStateList getStateList() {
            return new BlockStateList(this, new IBlockState[] { BlockBanner.BlockWallBanner.FACING});
        }
    }
}
