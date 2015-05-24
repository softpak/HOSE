package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class EmptyChunk extends Chunk {

    public EmptyChunk(World world, int i, int j) {
        super(world, i, j);
    }

    public boolean a(int i, int j) {
        return i == this.locX && j == this.locZ;
    }

    public int b(int i, int j) {
        return 0;
    }

    public void initLighting() {}

    public Block getType(BlockPosition blockposition) {
        return Blocks.AIR;
    }

    public int b(BlockPosition blockposition) {
        return 255;
    }

    public int c(BlockPosition blockposition) {
        return 0;
    }

    public int getBrightness(EnumSkyBlock enumskyblock, BlockPosition blockposition) {
        return enumskyblock.c;
    }

    public void a(EnumSkyBlock enumskyblock, BlockPosition blockposition, int i) {}

    public int a(BlockPosition blockposition, int i) {
        return 0;
    }

    public void a(Entity entity) {}

    public void b(Entity entity) {}

    public void a(Entity entity, int i) {}

    public boolean d(BlockPosition blockposition) {
        return false;
    }

    public TileEntity a(BlockPosition blockposition, Chunk.EnumTileEntityState chunk_enumtileentitystate) {
        return null;
    }

    public void a(TileEntity tileentity) {}

    public void a(BlockPosition blockposition, TileEntity tileentity) {}

    public void e(BlockPosition blockposition) {}

    public void addEntities() {}

    public void removeEntities() {}

    public void e() {}

    public void a(Entity entity, AxisAlignedBB axisalignedbb, List<Entity> list, Predicate<? super Entity> predicate) {}

    public <T extends Entity> void a(Class<? extends T> oclass, AxisAlignedBB axisalignedbb, List<T> list, Predicate<? super T> predicate) {}

    public boolean a(boolean flag) {
        return false;
    }

    public Random a(long i) {
        return new Random(this.getWorld().getSeed() + (long) (this.locX * this.locX * 4987142) + (long) (this.locX * 5947611) + (long) (this.locZ * this.locZ) * 4392871L + (long) (this.locZ * 389711) ^ i);
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean c(int i, int j) {
        return true;
    }
}
