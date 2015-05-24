package net.minecraft.server;

public class BlockWorkbench extends Block {

    protected BlockWorkbench() {
        super(Material.WOOD);
        this.a(CreativeModeTab.c);
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (world.isClientSide) {
            return true;
        } else {
            entityhuman.openTileEntity(new BlockWorkbench.TileEntityContainerWorkbench(world, blockposition));
            entityhuman.b(StatisticList.Z);
            return true;
        }
    }

    public static class TileEntityContainerWorkbench implements ITileEntityContainer {

        private final World a;
        private final BlockPosition b;

        public TileEntityContainerWorkbench(World world, BlockPosition blockposition) {
            this.a = world;
            this.b = blockposition;
        }

        public String getName() {
            return null;
        }

        public boolean hasCustomName() {
            return false;
        }

        public IChatBaseComponent getScoreboardDisplayName() {
            return new ChatMessage(Blocks.CRAFTING_TABLE.a() + ".name", new Object[0]);
        }

        public Container createContainer(PlayerInventory playerinventory, EntityHuman entityhuman) {
            return new ContainerWorkbench(playerinventory, this.a, this.b);
        }

        public String getContainerName() {
            return "minecraft:crafting_table";
        }
    }
}
