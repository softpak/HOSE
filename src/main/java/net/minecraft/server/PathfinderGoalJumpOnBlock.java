package net.minecraft.server;

public class PathfinderGoalJumpOnBlock extends PathfinderGoalGotoTarget {

    private final EntityOcelot c;

    public PathfinderGoalJumpOnBlock(EntityOcelot entityocelot, double d0) {
        super(entityocelot, d0, 8);
        this.c = entityocelot;
    }

    public boolean a() {
        return this.c.isTamed() && !this.c.isSitting() && super.a();
    }

    public boolean b() {
        return super.b();
    }

    public void c() {
        super.c();
        this.c.getGoalSit().setSitting(false);
    }

    public void d() {
        super.d();
        this.c.setSitting(false);
    }

    public void e() {
        super.e();
        this.c.getGoalSit().setSitting(false);
        if (!this.f()) {
            this.c.setSitting(false);
        } else if (!this.c.isSitting()) {
            this.c.setSitting(true);
        }

    }

    protected boolean a(World world, BlockPosition blockposition) {
        if (!world.isEmpty(blockposition.up())) {
            return false;
        } else {
            IBlockData iblockdata = world.getType(blockposition);
            Block block = iblockdata.getBlock();

            if (block == Blocks.CHEST) {
                TileEntity tileentity = world.getTileEntity(blockposition);

                if (tileentity instanceof TileEntityChest && ((TileEntityChest) tileentity).l < 1) {
                    return true;
                }
            } else {
                if (block == Blocks.LIT_FURNACE) {
                    return true;
                }

                if (block == Blocks.BED && iblockdata.get(BlockBed.PART) != BlockBed.EnumBedPart.HEAD) {
                    return true;
                }
            }

            return false;
        }
    }
}
