package net.minecraft.server;

public interface ITileEntityContainer extends INamableTileEntity {

    Container createContainer(PlayerInventory playerinventory, EntityHuman entityhuman);

    String getContainerName();
}
