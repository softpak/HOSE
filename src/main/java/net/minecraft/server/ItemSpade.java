package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;

public class ItemSpade extends ItemTool {

    private static final Set<Block> c = Sets.newHashSet(new Block[] { Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND});

    public ItemSpade(Item.EnumToolMaterial item_enumtoolmaterial) {
        super(1.0F, item_enumtoolmaterial, ItemSpade.c);
    }

    public boolean canDestroySpecialBlock(Block block) {
        return block == Blocks.SNOW_LAYER ? true : block == Blocks.SNOW;
    }
}
