package net.minecraft.server;

public interface ITileInventory extends IInventory, ITileEntityContainer {

    boolean r_();

    void a(ChestLock chestlock);

    ChestLock i();
}
