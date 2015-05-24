package net.minecraft.server;

public class RecipesCrafting {

    public RecipesCrafting() {}

    public void a(CraftingManager craftingmanager) {
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.CHEST), new Object[] { "###", "# #", "###", Character.valueOf('#'), Blocks.PLANKS});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.TRAPPED_CHEST), new Object[] { "#-", Character.valueOf('#'), Blocks.CHEST, Character.valueOf('-'), Blocks.TRIPWIRE_HOOK});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.ENDER_CHEST), new Object[] { "###", "#E#", "###", Character.valueOf('#'), Blocks.OBSIDIAN, Character.valueOf('E'), Items.ENDER_EYE});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.FURNACE), new Object[] { "###", "# #", "###", Character.valueOf('#'), Blocks.COBBLESTONE});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.CRAFTING_TABLE), new Object[] { "##", "##", Character.valueOf('#'), Blocks.PLANKS});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE), new Object[] { "##", "##", Character.valueOf('#'), new ItemStack(Blocks.SAND, 1, BlockSand.EnumSandVariant.SAND.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.RED_SANDSTONE), new Object[] { "##", "##", Character.valueOf('#'), new ItemStack(Blocks.SAND, 1, BlockSand.EnumSandVariant.RED_SAND.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE, 4, BlockSandStone.EnumSandstoneVariant.SMOOTH.a()), new Object[] { "##", "##", Character.valueOf('#'), new ItemStack(Blocks.SANDSTONE, 1, BlockSandStone.EnumSandstoneVariant.DEFAULT.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.RED_SANDSTONE, 4, BlockRedSandstone.EnumRedSandstoneVariant.SMOOTH.a()), new Object[] { "##", "##", Character.valueOf('#'), new ItemStack(Blocks.RED_SANDSTONE, 1, BlockRedSandstone.EnumRedSandstoneVariant.DEFAULT.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE, 1, BlockSandStone.EnumSandstoneVariant.CHISELED.a()), new Object[] { "#", "#", Character.valueOf('#'), new ItemStack(Blocks.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.SAND.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.RED_SANDSTONE, 1, BlockRedSandstone.EnumRedSandstoneVariant.CHISELED.a()), new Object[] { "#", "#", Character.valueOf('#'), new ItemStack(Blocks.STONE_SLAB2, 1, BlockDoubleStoneStepAbstract.EnumStoneSlab2Variant.RED_SANDSTONE.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.QUARTZ_BLOCK, 1, BlockQuartz.EnumQuartzVariant.CHISELED.a()), new Object[] { "#", "#", Character.valueOf('#'), new ItemStack(Blocks.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.QUARTZ.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.QUARTZ_BLOCK, 2, BlockQuartz.EnumQuartzVariant.LINES_Y.a()), new Object[] { "#", "#", Character.valueOf('#'), new ItemStack(Blocks.QUARTZ_BLOCK, 1, BlockQuartz.EnumQuartzVariant.DEFAULT.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.STONEBRICK, 4), new Object[] { "##", "##", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.P), new Object[] { "#", "#", Character.valueOf('#'), new ItemStack(Blocks.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.a())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.N), new Object[] { Blocks.STONEBRICK, Blocks.VINE});
        craftingmanager.registerShapelessRecipe(new ItemStack(Blocks.MOSSY_COBBLESTONE, 1), new Object[] { Blocks.COBBLESTONE, Blocks.VINE});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.IRON_BARS, 16), new Object[] { "###", "###", Character.valueOf('#'), Items.IRON_INGOT});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.GLASS_PANE, 16), new Object[] { "###", "###", Character.valueOf('#'), Blocks.GLASS});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.REDSTONE_LAMP, 1), new Object[] { " R ", "RGR", " R ", Character.valueOf('R'), Items.REDSTONE, Character.valueOf('G'), Blocks.GLOWSTONE});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.BEACON, 1), new Object[] { "GGG", "GSG", "OOO", Character.valueOf('G'), Blocks.GLASS, Character.valueOf('S'), Items.NETHER_STAR, Character.valueOf('O'), Blocks.OBSIDIAN});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.NETHER_BRICK, 1), new Object[] { "NN", "NN", Character.valueOf('N'), Items.NETHERBRICK});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.STONE, 2, BlockStone.EnumStoneVariant.DIORITE.a()), new Object[] { "CQ", "QC", Character.valueOf('C'), Blocks.COBBLESTONE, Character.valueOf('Q'), Items.QUARTZ});
        craftingmanager.registerShapelessRecipe(new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.GRANITE.a()), new Object[] { new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.a()), Items.QUARTZ});
        craftingmanager.registerShapelessRecipe(new ItemStack(Blocks.STONE, 2, BlockStone.EnumStoneVariant.ANDESITE.a()), new Object[] { new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.a()), Blocks.COBBLESTONE});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.DIRT, 4, BlockDirt.EnumDirtVariant.COARSE_DIRT.a()), new Object[] { "DG", "GD", Character.valueOf('D'), new ItemStack(Blocks.DIRT, 1, BlockDirt.EnumDirtVariant.DIRT.a()), Character.valueOf('G'), Blocks.GRAVEL});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.STONE, 4, BlockStone.EnumStoneVariant.DIORITE_SMOOTH.a()), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.STONE, 4, BlockStone.EnumStoneVariant.GRANITE_SMOOTH.a()), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.GRANITE.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.STONE, 4, BlockStone.EnumStoneVariant.ANDESITE_SMOOTH.a()), new Object[] { "SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.ANDESITE.a())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.b), new Object[] { "SS", "SS", Character.valueOf('S'), Items.PRISMARINE_SHARD});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.N), new Object[] { "SSS", "SSS", "SSS", Character.valueOf('S'), Items.PRISMARINE_SHARD});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.PRISMARINE, 1, BlockPrismarine.O), new Object[] { "SSS", "SIS", "SSS", Character.valueOf('S'), Items.PRISMARINE_SHARD, Character.valueOf('I'), new ItemStack(Items.DYE, 1, EnumColor.BLACK.getInvColorIndex())});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.SEA_LANTERN, 1, 0), new Object[] { "SCS", "CCC", "SCS", Character.valueOf('S'), Items.PRISMARINE_SHARD, Character.valueOf('C'), Items.PRISMARINE_CRYSTALS});
    }
}
