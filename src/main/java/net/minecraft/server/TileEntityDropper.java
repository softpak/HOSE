package net.minecraft.server;

public class TileEntityDropper extends TileEntityDispenser {

    public TileEntityDropper() {}

    public String getName() {
        return this.hasCustomName() ? this.a : "container.dropper";
    }

    public String getContainerName() {
        return "minecraft:dropper";
    }
}
