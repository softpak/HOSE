package org.bukkit.craftbukkit;

import com.amd.aparapi.Aparapi;
import com.amd.aparapi.Device;
import java.lang.ref.WeakReference;
import java.util.stream.IntStream;

import net.minecraft.server.*;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.block.CraftBlock;
import org.bukkit.entity.Entity;
import org.bukkit.ChunkSnapshot;
import org.bukkit.craftbukkit.util.HSA_Arrays;

public class CraftChunk implements Chunk {
    private WeakReference<net.minecraft.server.Chunk> weakChunk;
    private final WorldServer worldServer;
    private final int x;
    private final int z;
    private static final byte[] emptyData = new byte[2048];
    private static final short[] emptyBlockIDs = new short[4096];
    private static final byte[] emptySkyLight = new byte[2048];

    public CraftChunk(net.minecraft.server.Chunk chunk) {
        if (!(chunk instanceof EmptyChunk)) {
            this.weakChunk = new WeakReference<net.minecraft.server.Chunk>(chunk);
        }

        worldServer = (WorldServer) getHandle().world;
        x = getHandle().locX;
        z = getHandle().locZ;
    }

    public World getWorld() {
        return worldServer.getWorld();
    }

    public CraftWorld getCraftWorld() {
        return (CraftWorld) getWorld();
    }

    public net.minecraft.server.Chunk getHandle() {
        net.minecraft.server.Chunk c = weakChunk.get();

        if (c == null) {
            c = worldServer.getChunkAt(x, z);

            if (!(c instanceof EmptyChunk)) {
                weakChunk = new WeakReference<net.minecraft.server.Chunk>(c);
            }
        }

        return c;
    }

    void breakLink() {
        weakChunk.clear();
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "CraftChunk{" + "x=" + getX() + "z=" + getZ() + '}';
    }

    public Block getBlock(int x, int y, int z) {
        return new CraftBlock(this, (getX() << 4) | (x & 0xF), y, (getZ() << 4) | (z & 0xF));
    }
    
    //HSA
    int hcount = 0;
    public Entity[] getEntities() {
        //int count = 0, index = 0;
        int index = 0;
        hcount = 0;
        net.minecraft.server.Chunk chunk = getHandle();
               
        
        Aparapi.range(16).forEach(gid_i -> {
            hcount += chunk.entitySlices[gid_i].size();
        });
        /*
        for (int i = 0; i < 16; i++) {
            count += chunk.entitySlices[i].size();
        }*/

        Entity[] entities = new Entity[hcount];

        for (int i = 0; i < 16; i++) {

            for (Object obj : chunk.entitySlices[i].toArray()) {
                if (!(obj instanceof net.minecraft.server.Entity)) {
                    continue;
                }

                entities[index++] = ((net.minecraft.server.Entity) obj).getBukkitEntity();
            }
        }

        return entities;
    }

    public BlockState[] getTileEntities() {
        int index = 0;
        net.minecraft.server.Chunk chunk = getHandle();

        BlockState[] entities = new BlockState[chunk.tileEntities.size()];

        for (Object obj : chunk.tileEntities.keySet().toArray()) {
            if (!(obj instanceof BlockPosition)) {
                continue;
            }

            BlockPosition position = (BlockPosition) obj;
            entities[index++] = worldServer.getWorld().getBlockAt(position.getX(), position.getY(), position.getZ()).getState();
        }

        return entities;
    }

    public boolean isLoaded() {
        return getWorld().isChunkLoaded(this);
    }

    public boolean load() {
        return getWorld().loadChunk(getX(), getZ(), true);
    }

    public boolean load(boolean generate) {
        return getWorld().loadChunk(getX(), getZ(), generate);
    }

    public boolean unload() {
        return getWorld().unloadChunk(getX(), getZ());
    }

    public boolean unload(boolean save) {
        return getWorld().unloadChunk(getX(), getZ(), save);
    }

    public boolean unload(boolean save, boolean safe) {
        return getWorld().unloadChunk(getX(), getZ(), save, safe);
    }

    public ChunkSnapshot getChunkSnapshot() {
        return getChunkSnapshot(true, false, false);
    }
    
    BiomeBase[] hbiome;
    double[] hbiomeTemp;
    double[] hbiomeRain;
    float[] hdat = null;
    public ChunkSnapshot getChunkSnapshot(boolean includeMaxBlockY, boolean includeBiome, boolean includeBiomeTempRain) {
        net.minecraft.server.Chunk chunk = getHandle();
        ChunkSection[] cs = chunk.getSections();
        short[][] sectionBlockIDs = new short[cs.length][];
        byte[][] sectionBlockData = new byte[cs.length][];
        byte[][] sectionSkyLights = new byte[cs.length][];
        byte[][] sectionEmitLights = new byte[cs.length][];
        boolean[] sectionEmpty = new boolean[cs.length];
        
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == null) { // Section is empty?
                sectionBlockIDs[i] = emptyBlockIDs;
                sectionBlockData[i] = emptyData;
                sectionSkyLights[i] = emptySkyLight;
                sectionEmitLights[i] = emptyData;
                sectionEmpty[i] = true;
            } else { // Not empty
                short[] blockids = new short[4096];
                char[] baseids = cs[i].getIdArray();
                byte[] dataValues = sectionBlockData[i] = new byte[2048];

                // Copy base IDs
                //lambda
                for (int j = 0; j < 4096; j++) {
                    if (baseids[j] == 0) continue;
                    IBlockData blockData = (IBlockData) net.minecraft.server.Block.d.a(baseids[j]);
                    if (blockData == null) continue;
                    blockids[j] = (short) net.minecraft.server.Block.getId(blockData.getBlock());
                    int data = blockData.getBlock().toLegacyData(blockData);
                    int jj = j >> 1;
                    if ((j & 1) == 0) {
                        dataValues[jj] = (byte) ((dataValues[jj] & 0xF0) | (data & 0xF));
                    } else {
                        dataValues[jj] = (byte) ((dataValues[jj] & 0xF) | ((data & 0xF) << 4));
                    }
                }               

                sectionBlockIDs[i] = blockids;
                
                if (cs[i].getSkyLightArray() == null) {
                    sectionSkyLights[i] = emptyData;
                } else {
                    sectionSkyLights[i] = new byte[2048];
                    System.arraycopy(cs[i].getSkyLightArray().a(), 0, sectionSkyLights[i], 0, 2048);
                }
                sectionEmitLights[i] = new byte[2048];
                System.arraycopy(cs[i].getEmittedLightArray().a(), 0, sectionEmitLights[i], 0, 2048);
            }
        }

        int[] hmap = null;

        if (includeMaxBlockY) {
            hmap = new int[256]; // Get copy of height map
            System.arraycopy(chunk.heightMap, 0, hmap, 0, 256);
        }

        //BiomeBase[] biome = null;
        //double[] biomeTemp = null;
        //double[] biomeRain = null;
        hbiome = null;
        hbiomeTemp = null;
        hbiomeRain = null;
        hdat = null;
        if (includeBiome || includeBiomeTempRain) {
            WorldChunkManager wcm = chunk.world.getWorldChunkManager();
            
            if (includeBiome) {
                hbiome = new BiomeBase[256];
                //HSA
                
                Aparapi.range(256).forEach(gid_i -> {
                    hbiome[gid_i] = chunk.getBiome(new BlockPosition(gid_i & 0xF, 0, gid_i >> 4), wcm);
                });
                /*
                for (int i = 0; i < 256; i++) {
                    biome[i] = chunk.getBiome(new BlockPosition(i & 0xF, 0, i >> 4), wcm);
                }*/
            }
            
            if (includeBiomeTempRain) {
                hbiomeTemp = new double[256];
                hbiomeRain = new double[256];
                hdat = getTemperatures(wcm, getX() << 4, getZ() << 4);

                Device.hsa().forEach(0,256, gid_i -> {
                    hbiomeTemp[gid_i] = hdat[gid_i];
                });
                
                /*for (int i = 0; i < 256; i++) {
                    biomeTemp[i] = dat[i];
                }*/

                hdat = wcm.getWetness(null, getX() << 4, getZ() << 4, 16, 16);

                Device.hsa().forEach(0,256, gid_i -> {
                    hbiomeRain[gid_i] = hdat[gid_i];
                });
                /*
                for (int i = 0; i < 256; i++) {
                    biomeRain[i] = dat[i];
                }*/
            }
        }

        World world = getWorld();
        return new CraftChunkSnapshot(getX(), getZ(), world.getName(), world.getFullTime(), sectionBlockIDs, sectionBlockData, sectionSkyLights, sectionEmitLights, sectionEmpty, hmap, hbiome, hbiomeTemp, hbiomeRain);
    }
    
    static BiomeBase[] hebiome;
    static double[] hebiomeTemp;
    static double[] hebiomeRain;
    static float[] hedat;
    public static ChunkSnapshot getEmptyChunkSnapshot(int x, int z, CraftWorld world, boolean includeBiome, boolean includeBiomeTempRain) {
        /*BiomeBase[] biome = null;
        double[] biomeTemp = null;
        double[] biomeRain = null;*/
        hebiome = null;
        hebiomeTemp = null;
        hebiomeRain = null;
        hedat = null;
        
        if (includeBiome || includeBiomeTempRain) {
            WorldChunkManager wcm = world.getHandle().getWorldChunkManager();

            if (includeBiome) {
                hebiome = new BiomeBase[256];
                Aparapi.range(256).forEach(gid_i -> {
                    hebiome[gid_i] = world.getHandle().getBiome(new BlockPosition(x << 4 + (gid_i & 0xF), 0, z << 4 + (gid_i >> 4)));
                });
                /*
                for (int i = 0; i < 256; i++) {
                    hebiome[i] = world.getHandle().getBiome(new BlockPosition((x << 4) + (i & 0xF), 0, (z << 4) + (i >> 4)));
                }*/
            }

            if (includeBiomeTempRain) {
                hebiomeTemp = new double[256];
                hebiomeRain = new double[256];
                //float[] dat = getTemperatures(wcm, x << 4, z << 4);
                hedat = getTemperatures(wcm, x << 4, z << 4);
                
                Device.hsa().forEach(0, 256, gid_i -> {
                    hebiomeTemp[gid_i] = hedat[gid_i];
                });
                /*
                for (int i = 0; i < 256; i++) {
                    biomeTemp[i] = dat[i];
                }*/

                hedat = wcm.getWetness(null, x << 4, z << 4, 16, 16);
                
                Device.hsa().forEach(0, 256, gid_i -> {
                    hebiomeRain[gid_i] = hedat[gid_i];
                });
                /*
                for (int i = 0; i < 256; i++) {
                    hebiomeRain[i] = hedat[i];
                }*/
            }
        }

        /* Fill with empty data */
        int hSection = world.getMaxHeight() >> 4;
        short[][] blockIDs = new short[hSection][];
        byte[][] skyLight = new byte[hSection][];
        byte[][] emitLight = new byte[hSection][];
        byte[][] blockData = new byte[hSection][];
        boolean[] empty = new boolean[hSection];
        
        Device.hsa().forEach(0, hSection, gid_i -> {
            blockIDs[gid_i] = emptyBlockIDs;
            skyLight[gid_i] = emptySkyLight;
            emitLight[gid_i] = emptyData;
            blockData[gid_i] = emptyData;
            empty[gid_i] = true;
        });
        /*
        Aparapi.range(hSection).forEach(gid_i -> {
            blockIDs[gid_i] = emptyBlockIDs;
            skyLight[gid_i] = emptySkyLight;
            emitLight[gid_i] = emptyData;
            blockData[gid_i] = emptyData;
            empty[gid_i] = true;
        });*/
        /*
        for (int i = 0; i < hSection; i++) {
            blockIDs[i] = emptyBlockIDs;
            skyLight[i] = emptySkyLight;
            emitLight[i] = emptyData;
            blockData[i] = emptyData;
            empty[i] = true;
        }*/
        return new CraftChunkSnapshot(x, z, world.getName(), world.getFullTime(), blockIDs, blockData, skyLight, emitLight, empty, new int[256], hebiome, hebiomeTemp, hebiomeRain);
    }

    //HSA
    private static float[] getTemperatures(WorldChunkManager chunkmanager, int chunkX, int chunkZ) {
        BiomeBase[] biomes = chunkmanager.getBiomes(null, chunkX, chunkZ, 16, 16);
        float[] temps = new float[biomes.length];
        
        IntStream.range(0, biomes.length).forEach(gid_i -> {
            float temp = biomes[gid_i].temperature; // Vanilla of olde: ((int) biomes[i].temperature * 65536.0F) / 65536.0F
            if (temp > 1F) {
                temp = 1F;
            }
            temps[gid_i] = temp;
        });
        /*
        for (int i = 0; i < biomes.length; i++) {
            float temp = biomes[i].temperature; // Vanilla of olde: ((int) biomes[i].temperature * 65536.0F) / 65536.0F

            if (temp > 1F) {
                temp = 1F;
            }

            temps[i] = temp;
        }*/

        return temps;
    }

    //HSA
    static {
        //Arrays.fill(emptySkyLight, (byte) 0xFF);
        HSA_Arrays.fill(emptySkyLight, (byte) 0xFF);
    }
}
