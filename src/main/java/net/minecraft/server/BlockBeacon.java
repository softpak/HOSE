package net.minecraft.server;

public class BlockBeacon extends BlockContainer {

    public BlockBeacon() {
        super(Material.SHATTERABLE, MaterialMapColor.G);
        this.c(3.0F);
        this.a(CreativeModeTab.f);
    }

    public TileEntity a(World world, int i) {
        return new TileEntityBeacon();
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (world.isClientSide) {
            return true;
        } else {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityBeacon) {
                entityhuman.openContainer((TileEntityBeacon) tileentity);
                entityhuman.b(StatisticList.N);
            }

            return true;
        }
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public int b() {
        return 3;
    }

    public void postPlace(World world, BlockPosition blockposition, IBlockData iblockdata, EntityLiving entityliving, ItemStack itemstack) {
        super.postPlace(world, blockposition, iblockdata, entityliving, itemstack);
        if (itemstack.hasName()) {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityBeacon) {
                ((TileEntityBeacon) tileentity).a(itemstack.getName());
            }
        }

    }

    public void doPhysics(World world, BlockPosition blockposition, IBlockData iblockdata, Block block) {
        TileEntity tileentity = world.getTileEntity(blockposition);

        if (tileentity instanceof TileEntityBeacon) {
            ((TileEntityBeacon) tileentity).m();
            world.playBlockAction(blockposition, this, 1, 0);
        }

    }

    public static void f(final World world, final BlockPosition blockposition) {
        HttpUtilities.a.submit(new Runnable() {
            public void run() {
                Chunk chunk = world.getChunkAtWorldCoords(blockposition);

                for (int i = blockposition.getY() - 1; i >= 0; --i) {
                    final BlockPosition blockposition1 = new BlockPosition(blockposition.getX(), i, blockposition.getZ());

                    if (!chunk.d(blockposition1)) {
                        break;
                    }

                    IBlockData iblockdata = world.getType(blockposition1);

                    if (iblockdata.getBlock() == Blocks.BEACON) {
                        ((WorldServer) world).postToMainThread(new Runnable() {
                            public void run() {
                                TileEntity tileentity = world.getTileEntity(blockposition);

                                if (tileentity instanceof TileEntityBeacon) {
                                    ((TileEntityBeacon) tileentity).m();
                                    world.playBlockAction(blockposition, Blocks.BEACON, 1, 0);
                                }

                            }
                        });
                    }
                }

            }
        });
    }
}
