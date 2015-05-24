package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class WorldGenTaigaStructure extends WorldGenerator {

    private final Block a;
    private final int b;

    public WorldGenTaigaStructure(Block block, int i) {
        super(false);
        this.a = block;
        this.b = i;
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        while (true) {
            if (blockposition.getY() > 3) {
                label47: {
                    if (!world.isEmpty(blockposition.down())) {
                        Block block = world.getType(blockposition.down()).getBlock();

                        if (block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.STONE) {
                            break label47;
                        }
                    }

                    blockposition = blockposition.down();
                    continue;
                }
            }

            if (blockposition.getY() <= 3) {
                return false;
            }

            int i = this.b;

            for (int j = 0; i >= 0 && j < 3; ++j) {
                int k = i + random.nextInt(2);
                int l = i + random.nextInt(2);
                int i1 = i + random.nextInt(2);
                float f = (float) (k + l + i1) * 0.333F + 0.5F;
                Iterator iterator = BlockPosition.a(blockposition.a(-k, -l, -i1), blockposition.a(k, l, i1)).iterator();

                while (iterator.hasNext()) {
                    BlockPosition blockposition1 = (BlockPosition) iterator.next();

                    if (blockposition1.i(blockposition) <= (double) (f * f)) {
                        world.setTypeAndData(blockposition1, this.a.getBlockData(), 4);
                    }
                }

                blockposition = blockposition.a(-(i + 1) + random.nextInt(2 + i * 2), 0 - random.nextInt(2), -(i + 1) + random.nextInt(2 + i * 2));
            }

            return true;
        }
    }
}
