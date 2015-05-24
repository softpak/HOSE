package net.minecraft.server;

public interface INamableTileEntity {

    String getName();

    boolean hasCustomName();

    IChatBaseComponent getScoreboardDisplayName();
}
