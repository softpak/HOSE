package net.minecraft.server;

import java.util.Random;

public class BlockSeaLantern extends Block {

    public BlockSeaLantern(Material material) {
        super(material);
        this.a(CreativeModeTab.b);
    }

    public int a(Random random) {
        return 2 + random.nextInt(2);
    }

    public int getDropCount(int i, Random random) {
        return MathHelper.clamp(this.a(random) + random.nextInt(i + 1), 1, 5);
    }

    public Item getDropType(IBlockData iblockdata, Random random, int i) {
        return Items.PRISMARINE_CRYSTALS;
    }

    public MaterialMapColor g(IBlockData iblockdata) {
        return MaterialMapColor.p;
    }

    protected boolean I() {
        return true;
    }
}
