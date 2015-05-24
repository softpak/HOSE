package net.minecraft.server;

public enum EnumWorldBorderState {

    GROWING(4259712), SHRINKING(16724016), STATIONARY(2138367);

    private final int d;

    private EnumWorldBorderState(int i) {
        this.d = i;
    }
}
