package net.minecraft.server;

public class TileEntityMobSpawner extends TileEntity implements IUpdatePlayerListBox {

    private final MobSpawnerAbstract a = new MobSpawnerAbstract() {
        public void a(int i) {
            TileEntityMobSpawner.this.world.playBlockAction(TileEntityMobSpawner.this.position, Blocks.MOB_SPAWNER, i, 0);
        }

        public World a() {
            return TileEntityMobSpawner.this.world;
        }

        public BlockPosition b() {
            return TileEntityMobSpawner.this.position;
        }

        public void a(MobSpawnerAbstract.a mobspawnerabstract_a) {
            super.a(mobspawnerabstract_a);
            if (this.a() != null) {
                this.a().notify(TileEntityMobSpawner.this.position);
            }

        }
    };

    public TileEntityMobSpawner() {}

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.a.a(nbttagcompound);
    }

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        this.a.b(nbttagcompound);
    }

    public void c() {
        this.a.c();
    }

    public Packet getUpdatePacket() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();

        this.b(nbttagcompound);
        nbttagcompound.remove("SpawnPotentials");
        return new PacketPlayOutTileEntityData(this.position, 1, nbttagcompound);
    }

    public boolean c(int i, int j) {
        return this.a.b(i) ? true : super.c(i, j);
    }

    public MobSpawnerAbstract getSpawner() {
        return this.a;
    }
}
