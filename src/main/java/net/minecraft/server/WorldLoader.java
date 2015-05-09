package net.minecraft.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldLoader implements Convertable {

    private static final Logger b = LogManager.getLogger();
    protected final File a;

    public WorldLoader(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }

        this.a = file;
    }

    public void d() {}

    public WorldData c(String s) {
        File file = new File(this.a, s);

        if (!file.exists()) {
            return null;
        } else {
            File file1 = new File(file, "level.dat");
            NBTTagCompound nbttagcompound;
            NBTTagCompound nbttagcompound1;

            if (file1.exists()) {
                try {
                    nbttagcompound = NBTCompressedStreamTools.a((InputStream) (new FileInputStream(file1)));
                    nbttagcompound1 = nbttagcompound.getCompound("Data");
                    return new WorldData(nbttagcompound1);
                } catch (Exception exception) {
                    WorldLoader.b.error("Exception reading " + file1, exception);
                }
            }

            file1 = new File(file, "level.dat_old");
            if (file1.exists()) {
                try {
                    nbttagcompound = NBTCompressedStreamTools.a((InputStream) (new FileInputStream(file1)));
                    nbttagcompound1 = nbttagcompound.getCompound("Data");
                    return new WorldData(nbttagcompound1);
                } catch (Exception exception1) {
                    WorldLoader.b.error("Exception reading " + file1, exception1);
                }
            }

            return null;
        }
    }

    public boolean e(String s) {
        File file = new File(this.a, s);

        if (!file.exists()) {
            return true;
        } else {
            WorldLoader.b.info("Deleting level " + s);

            for (int i = 1; i <= 5; ++i) {
                WorldLoader.b.info("Attempt " + i + "...");
                if (a(file.listFiles())) {
                    break;
                }

                WorldLoader.b.warn("Unsuccessful in deleting contents.");
                if (i < 5) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException interruptedexception) {
                        ;
                    }
                }
            }

            return file.delete();
        }
    }

    protected static boolean a(File[] afile) {
        for (int i = 0; i < afile.length; ++i) {
            File file = afile[i];

            WorldLoader.b.debug("Deleting " + file);
            if (file.isDirectory() && !a(file.listFiles())) {
                WorldLoader.b.warn("Couldn\'t delete directory " + file);
                return false;
            }

            if (!file.delete()) {
                WorldLoader.b.warn("Couldn\'t delete file " + file);
                return false;
            }
        }

        return true;
    }

    public IDataManager a(String s, boolean flag) {
        return new WorldNBTStorage(this.a, s, flag);
    }

    public boolean isConvertable(String s) {
        return false;
    }

    public boolean convert(String s, IProgressUpdate iprogressupdate) {
        return false;
    }
}
