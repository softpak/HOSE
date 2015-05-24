package net.minecraft.server;

import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.Random;

public class WorldGenDesertWell extends WorldGenerator {

    private static final BlockStatePredicate a = BlockStatePredicate.a((Block) Blocks.SAND).a(BlockSand.VARIANT, Predicates.equalTo(BlockSand.EnumSandVariant.SAND));
    private final IBlockData b;
    private final IBlockData c;
    private final IBlockData d;

    public WorldGenDesertWell() {
        this.b = Blocks.STONE_SLAB.getBlockData().set(BlockDoubleStepAbstract.VARIANT, BlockDoubleStepAbstract.EnumStoneSlabVariant.SAND).set(BlockStepAbstract.HALF, BlockStepAbstract.EnumSlabHalf.BOTTOM);
        this.c = Blocks.SANDSTONE.getBlockData();
        this.d = Blocks.FLOWING_WATER.getBlockData();
    }

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        while (world.isEmpty(blockposition) && blockposition.getY() > 2) {
            blockposition = blockposition.down();
        }

        if (!WorldGenDesertWell.a.a(world.getType(blockposition))) {
            return false;
        } else {
            int i;
            int j;

            for (i = -2; i <= 2; ++i) {
                for (j = -2; j <= 2; ++j) {
                    if (world.isEmpty(blockposition.a(i, -1, j)) && world.isEmpty(blockposition.a(i, -2, j))) {
                        return false;
                    }
                }
            }

            for (i = -1; i <= 0; ++i) {
                for (j = -2; j <= 2; ++j) {
                    for (int k = -2; k <= 2; ++k) {
                        world.setTypeAndData(blockposition.a(j, i, k), this.c, 2);
                    }
                }
            }

            world.setTypeAndData(blockposition, this.d, 2);
            Iterator iterator = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

            while (iterator.hasNext()) {
                EnumDirection enumdirection = (EnumDirection) iterator.next();

                world.setTypeAndData(blockposition.shift(enumdirection), this.d, 2);
            }

            for (i = -2; i <= 2; ++i) {
                for (j = -2; j <= 2; ++j) {
                    if (i == -2 || i == 2 || j == -2 || j == 2) {
                        world.setTypeAndData(blockposition.a(i, 1, j), this.c, 2);
                    }
                }
            }

            world.setTypeAndData(blockposition.a(2, 1, 0), this.b, 2);
            world.setTypeAndData(blockposition.a(-2, 1, 0), this.b, 2);
            world.setTypeAndData(blockposition.a(0, 1, 2), this.b, 2);
            world.setTypeAndData(blockposition.a(0, 1, -2), this.b, 2);

            for (i = -1; i <= 1; ++i) {
                for (j = -1; j <= 1; ++j) {
                    if (i == 0 && j == 0) {
                        world.setTypeAndData(blockposition.a(i, 4, j), this.c, 2);
                    } else {
                        world.setTypeAndData(blockposition.a(i, 4, j), this.b, 2);
                    }
                }
            }

            for (i = 1; i <= 3; ++i) {
                world.setTypeAndData(blockposition.a(-1, i, -1), this.c, 2);
                world.setTypeAndData(blockposition.a(-1, i, 1), this.c, 2);
                world.setTypeAndData(blockposition.a(1, i, -1), this.c, 2);
                world.setTypeAndData(blockposition.a(1, i, 1), this.c, 2);
            }

            return true;
        }
    }
}
