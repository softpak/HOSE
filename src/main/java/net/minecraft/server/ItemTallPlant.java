package net.minecraft.server;

import com.google.common.base.Function;

public class ItemTallPlant extends ItemMultiTexture {

    public ItemTallPlant(Block block, Block block1, Function<ItemStack, String> function) {
        super(block, block1, function);
    }
}
