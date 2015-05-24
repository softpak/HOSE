package net.minecraft.server;

import java.util.Random;

public class WorldGenLightStone1 extends WorldGenerator {

    public WorldGenLightStone1() {}

    public boolean generate(World world, Random random, BlockPosition blockposition) {
        if (!world.isEmpty(blockposition)) {
            return false;
        } else if (world.getType(blockposition.up()).getBlock() != Blocks.NETHERRACK) {
            return false;
        } else {
            world.setTypeAndData(blockposition, Blocks.GLOWSTONE.getBlockData(), 2);

            for (int i = 0; i < 1500; ++i) {
                BlockPosition blockposition1 = blockposition.a(random.nextInt(8) - random.nextInt(8), -random.nextInt(12), random.nextInt(8) - random.nextInt(8));

                if (world.getType(blockposition1).getBlock().getMaterial() == Material.AIR) {
                    int j = 0;
                    EnumDirection[] aenumdirection = EnumDirection.values();
                    int k = aenumdirection.length;

                    for (int l = 0; l < k; ++l) {
                        EnumDirection enumdirection = aenumdirection[l];

                        if (world.getType(blockposition1.shift(enumdirection)).getBlock() == Blocks.GLOWSTONE) {
                            ++j;
                        }

                        if (j > 1) {
                            break;
                        }
                    }

                    if (j == 1) {
                        world.setTypeAndData(blockposition1, Blocks.GLOWSTONE.getBlockData(), 2);
                    }
                }
            }

            return true;
        }
    }
}
