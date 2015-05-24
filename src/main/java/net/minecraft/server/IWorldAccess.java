package net.minecraft.server;

public interface IWorldAccess {

    void a(BlockPosition blockposition);

    void b(BlockPosition blockposition);

    void a(int i, int j, int k, int l, int i1, int j1);

    void a(String s, double d0, double d1, double d2, float f, float f1);

    void a(EntityHuman entityhuman, String s, double d0, double d1, double d2, float f, float f1);

    void a(int i, boolean flag, double d0, double d1, double d2, double d3, double d4, double d5, int... aint);

    void a(Entity entity);

    void b(Entity entity);

    void a(String s, BlockPosition blockposition);

    void a(int i, BlockPosition blockposition, int j);

    void a(EntityHuman entityhuman, int i, BlockPosition blockposition, int j);

    void b(int i, BlockPosition blockposition, int j);
}
