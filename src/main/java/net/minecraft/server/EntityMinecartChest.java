package net.minecraft.server;

public class EntityMinecartChest extends EntityMinecartContainer {

    public EntityMinecartChest(World world) {
        super(world);
    }

    public EntityMinecartChest(World world, double d0, double d1, double d2) {
        super(world, d0, d1, d2);
    }

    public void a(DamageSource damagesource) {
        super.a(damagesource);
        if (this.world.getGameRules().getBoolean("doEntityDrops")) {
            this.a(Item.getItemOf(Blocks.CHEST), 1, 0.0F);
        }

    }

    public int getSize() {
        return 27;
    }

    public EntityMinecartAbstract.EnumMinecartType s() {
        return EntityMinecartAbstract.EnumMinecartType.CHEST;
    }

    public IBlockData u() {
        return Blocks.CHEST.getBlockData().set(BlockChest.FACING, EnumDirection.NORTH);
    }

    public int w() {
        return 8;
    }

    public String getContainerName() {
        return "minecraft:chest";
    }

    public Container createContainer(PlayerInventory playerinventory, EntityHuman entityhuman) {
        return new ContainerChest(playerinventory, this, entityhuman);
    }
}
