package org.bukkit.craftbukkit.chunkio;

import java.util.concurrent.Callable;
import net.minecraft.server.Chunk;
import net.minecraft.server.ChunkProviderServer;
import net.minecraft.server.ChunkRegionLoader;
import net.minecraft.server.World;
import org.bukkit.craftbukkit.util.AsynchronousExecutor;

public class ChunkIOExecutor {
    static final int BASE_THREADS = Runtime.getRuntime().availableProcessors();//Runtime.getRuntime().availableProcessors();//1
    static final int PLAYERS_PER_THREAD = 50;

    //private static final AsynchronousExecutor<QueuedChunk, Chunk, Runnable, RuntimeException> instance = new AsynchronousExecutor<QueuedChunk, Chunk, Runnable, RuntimeException>(new ChunkIOProvider(), BASE_THREADS);
    private static final AsynchronousExecutor<QueuedChunk, Chunk, Callable, RuntimeException> instance = new AsynchronousExecutor<QueuedChunk, Chunk, Callable, RuntimeException>(new ChunkIOProvider(), BASE_THREADS);

    public static Chunk syncChunkLoad(World world, ChunkRegionLoader loader, ChunkProviderServer provider, int x, int z) {
        return instance.getSkipQueue(new QueuedChunk(x, z, loader, world, provider));
    }

    public static void queueChunkLoad(World world, ChunkRegionLoader loader, ChunkProviderServer provider, int x, int z, Callable callable) {
        instance.add(new QueuedChunk(x, z, loader, world, provider), callable);
    }
    /*public static void queueChunkLoad(World world, ChunkRegionLoader loader, ChunkProviderServer provider, int x, int z, Runnable runnable) {
        instance.add(new QueuedChunk(x, z, loader, world, provider), runnable);
    }*/

    // Abuses the fact that hashCode and equals for QueuedChunk only use world and coords
    //public static void dropQueuedChunkLoad(World world, int x, int z, Runnable runnable) {
    public static void dropQueuedChunkLoad(World world, int x, int z, Callable callable) {
        //instance.drop(new QueuedChunk(x, z, null, world, null), runnable);
        instance.drop(new QueuedChunk(x, z, null, world, null), callable);
    }

    public static void adjustPoolSize(int players) {
        int size = Math.max(BASE_THREADS, (int) Math.ceil(players / PLAYERS_PER_THREAD));
        instance.setActiveThreads(size);
    }

    public static void tick() {
        instance.finishActive();
    }
}
