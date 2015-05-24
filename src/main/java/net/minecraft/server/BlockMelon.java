package net.minecraft.server;

import java.util.Random;

public class BlockMelon extends Block {

    protected BlockMelon() {
        super(Material.PUMPKIN, MaterialMapColor.u);
        this.a(CreativeModeTab.b);
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Items.MELON;
    }

    public int a(Random random) {
        return 3 + random.nextInt(5);
    }

    public int getDropCount(int i, Random random) {
        return Math.min(9, this.a(random) + random.nextInt(1 + i));
    }
}
