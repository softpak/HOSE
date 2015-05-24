package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;

public class ItemPickaxe extends ItemTool {

    private static final Set<Block> c = Sets.newHashSet(new Block[] { Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB});

    protected ItemPickaxe(Item.EnumToolMaterial item_enumtoolmaterial) {
        super(2.0F, item_enumtoolmaterial, ItemPickaxe.c);
    }

    public boolean canDestroySpecialBlock(Block block) {
        return block == Blocks.OBSIDIAN ? this.b.d() == 3 : (block != Blocks.DIAMOND_BLOCK && block != Blocks.DIAMOND_ORE ? (block != Blocks.EMERALD_ORE && block != Blocks.EMERALD_BLOCK ? (block != Blocks.GOLD_BLOCK && block != Blocks.GOLD_ORE ? (block != Blocks.IRON_BLOCK && block != Blocks.IRON_ORE ? (block != Blocks.LAPIS_BLOCK && block != Blocks.LAPIS_ORE ? (block != Blocks.REDSTONE_ORE && block != Blocks.LIT_REDSTONE_ORE ? (block.getMaterial() == Material.STONE ? true : (block.getMaterial() == Material.ORE ? true : block.getMaterial() == Material.HEAVY)) : this.b.d() >= 2) : this.b.d() >= 1) : this.b.d() >= 1) : this.b.d() >= 2) : this.b.d() >= 2) : this.b.d() >= 2);
    }

    public float getDestroySpeed(ItemStack itemstack, Block block) {
        return block.getMaterial() != Material.ORE && block.getMaterial() != Material.HEAVY && block.getMaterial() != Material.STONE ? super.getDestroySpeed(itemstack, block) : this.a;
    }
}
