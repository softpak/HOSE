package net.minecraft.server;

public class PathfinderGoalVillagerFarm extends PathfinderGoalGotoTarget {

    private final EntityVillager c;
    private boolean d;
    private boolean e;
    private int f;

    public PathfinderGoalVillagerFarm(EntityVillager entityvillager, double d0) {
        super(entityvillager, d0, 16);
        this.c = entityvillager;
    }

    public boolean a() {
        if (this.a <= 0) {
            if (!this.c.world.getGameRules().getBoolean("mobGriefing")) {
                return false;
            }

            this.f = -1;
            this.d = this.c.cu();
            this.e = this.c.ct();
        }

        return super.a();
    }

    public boolean b() {
        return this.f >= 0 && super.b();
    }

    public void c() {
        super.c();
    }

    public void d() {
        super.d();
    }

    public void e() {
        super.e();
        this.c.getControllerLook().a((double) this.b.getX() + 0.5D, (double) (this.b.getY() + 1), (double) this.b.getZ() + 0.5D, 10.0F, (float) this.c.bQ());
        if (this.f()) {
            World world = this.c.world;
            BlockPosition blockposition = this.b.up();
            IBlockData iblockdata = world.getType(blockposition);
            Block block = iblockdata.getBlock();

            if (this.f == 0 && block instanceof BlockCrops && ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() == 7) {
                world.setAir(blockposition, true);
            } else if (this.f == 1 && block == Blocks.AIR) {
                InventorySubcontainer inventorysubcontainer = this.c.cq();

                for (int i = 0; i < inventorysubcontainer.getSize(); ++i) {
                    ItemStack itemstack = inventorysubcontainer.getItem(i);
                    boolean flag = false;

                    if (itemstack != null) {
                        if (itemstack.getItem() == Items.WHEAT_SEEDS) {
                            world.setTypeAndData(blockposition, Blocks.WHEAT.getBlockData(), 3);
                            flag = true;
                        } else if (itemstack.getItem() == Items.POTATO) {
                            world.setTypeAndData(blockposition, Blocks.POTATOES.getBlockData(), 3);
                            flag = true;
                        } else if (itemstack.getItem() == Items.CARROT) {
                            world.setTypeAndData(blockposition, Blocks.CARROTS.getBlockData(), 3);
                            flag = true;
                        }
                    }

                    if (flag) {
                        --itemstack.count;
                        if (itemstack.count <= 0) {
                            inventorysubcontainer.setItem(i, (ItemStack) null);
                        }
                        break;
                    }
                }
            }

            this.f = -1;
            this.a = 10;
        }

    }

    protected boolean a(World world, BlockPosition blockposition) {
        Block block = world.getType(blockposition).getBlock();

        if (block == Blocks.FARMLAND) {
            blockposition = blockposition.up();
            IBlockData iblockdata = world.getType(blockposition);

            block = iblockdata.getBlock();
            if (block instanceof BlockCrops && ((Integer) iblockdata.get(BlockCrops.AGE)).intValue() == 7 && this.e && (this.f == 0 || this.f < 0)) {
                this.f = 0;
                return true;
            }

            if (block == Blocks.AIR && this.d && (this.f == 1 || this.f < 0)) {
                this.f = 1;
                return true;
            }
        }

        return false;
    }
}
