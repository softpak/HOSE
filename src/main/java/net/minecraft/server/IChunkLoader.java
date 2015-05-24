package net.minecraft.server;

import java.io.IOException;

public interface IChunkLoader {

    Chunk a(World world, int i, int j) throws IOException;

    void a(World world, Chunk chunk) throws IOException, ExceptionWorldConflict;

    void b(World world, Chunk chunk) throws IOException;

    void a();

    void b();
}
