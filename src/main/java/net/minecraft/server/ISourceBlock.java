package net.minecraft.server;

public interface ISourceBlock extends ILocationSource {

    double getX();

    double getY();

    double getZ();

    BlockPosition getBlockPosition();

    Block e();

    int f();

    <T extends TileEntity> T getTileEntity();
}
