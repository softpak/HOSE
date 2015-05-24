package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenMineshaftStart extends StructureStart {

    public WorldGenMineshaftStart() {}

    public WorldGenMineshaftStart(World world, Random random, int i, int j) {
        super(i, j);
        WorldGenMineshaftPieces.WorldGenMineshaftRoom worldgenmineshaftpieces_worldgenmineshaftroom = new WorldGenMineshaftPieces.WorldGenMineshaftRoom(0, random, (i << 4) + 2, (j << 4) + 2);

        this.a.add(worldgenmineshaftpieces_worldgenmineshaftroom);
        worldgenmineshaftpieces_worldgenmineshaftroom.a((StructurePiece) worldgenmineshaftpieces_worldgenmineshaftroom, (List) this.a, random);
        this.c();
        this.a(world, random, 10);
    }
}
