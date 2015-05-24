package net.minecraft.server;

import java.io.File;

public class ServerNBTManager extends WorldNBTStorage {

    public ServerNBTManager(File file, String s, boolean flag) {
        super(file, s, flag);
    }

    public IChunkLoader createChunkLoader(WorldProvider worldprovider) {
        File file = this.getDirectory();
        File file1;

        if (worldprovider instanceof WorldProviderHell) {
            file1 = new File(file, "DIM-1");
            file1.mkdirs();
            return new ChunkRegionLoader(file1);
        } else if (worldprovider instanceof WorldProviderTheEnd) {
            file1 = new File(file, "DIM1");
            file1.mkdirs();
            return new ChunkRegionLoader(file1);
        } else {
            return new ChunkRegionLoader(file);
        }
    }

    public void saveWorldData(WorldData worlddata, NBTTagCompound nbttagcompound) {
        worlddata.e(19133);
        super.saveWorldData(worlddata, nbttagcompound);
    }

    public void a() {
        try {
            FileIOThread.a().b();
        } catch (InterruptedException interruptedexception) {
            interruptedexception.printStackTrace();
        }

        RegionFileCache.a();
    }
}
