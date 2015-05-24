package net.minecraft.server;

public class RecipesDyes {

    public RecipesDyes() {}

    public void a(CraftingManager craftingmanager) {
        int i;

        for (i = 0; i < 16; ++i) {
            craftingmanager.registerShapelessRecipe(new ItemStack(Blocks.WOOL, 1, i), new Object[] { new ItemStack(Items.DYE, 1, 15 - i), new ItemStack(Item.getItemOf(Blocks.WOOL), 1, 0)});
            craftingmanager.registerShapedRecipe(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 8, 15 - i), new Object[] { "###", "#X#", "###", Character.valueOf('#'), new ItemStack(Blocks.HARDENED_CLAY), Character.valueOf('X'), new ItemStack(Items.DYE, 1, i)});
            craftingmanager.registerShapedRecipe(new ItemStack(Blocks.STAINED_GLASS, 8, 15 - i), new Object[] { "###", "#X#", "###", Character.valueOf('#'), new ItemStack(Blocks.GLASS), Character.valueOf('X'), new ItemStack(Items.DYE, 1, i)});
            craftingmanager.registerShapedRecipe(new ItemStack(Blocks.STAINED_GLASS_PANE, 16, i), new Object[] { "###", "###", Character.valueOf('#'), new ItemStack(Blocks.STAINED_GLASS, 1, i)});
        }

        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 1, EnumColor.YELLOW.getInvColorIndex()), new Object[] { new ItemStack(Blocks.YELLOW_FLOWER, 1, BlockFlowers.EnumFlowerVarient.DANDELION.b())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 1, EnumColor.RED.getInvColorIndex()), new Object[] { new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.POPPY.b())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 3, EnumColor.WHITE.getInvColorIndex()), new Object[] { Items.BONE});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.PINK.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.RED.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.WHITE.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.ORANGE.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.RED.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.YELLOW.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.LIME.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.GREEN.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.WHITE.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.GRAY.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.BLACK.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.WHITE.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.SILVER.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.GRAY.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.WHITE.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 3, EnumColor.SILVER.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.BLACK.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.WHITE.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.WHITE.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.LIGHT_BLUE.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.BLUE.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.WHITE.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.CYAN.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.BLUE.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.GREEN.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.PURPLE.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.BLUE.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.RED.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.MAGENTA.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.PURPLE.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.PINK.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 3, EnumColor.MAGENTA.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.BLUE.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.RED.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.PINK.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 4, EnumColor.MAGENTA.getInvColorIndex()), new Object[] { new ItemStack(Items.DYE, 1, EnumColor.BLUE.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.RED.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.RED.getInvColorIndex()), new ItemStack(Items.DYE, 1, EnumColor.WHITE.getInvColorIndex())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 1, EnumColor.LIGHT_BLUE.getInvColorIndex()), new Object[] { new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.BLUE_ORCHID.b())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 1, EnumColor.MAGENTA.getInvColorIndex()), new Object[] { new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.ALLIUM.b())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 1, EnumColor.SILVER.getInvColorIndex()), new Object[] { new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.HOUSTONIA.b())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 1, EnumColor.RED.getInvColorIndex()), new Object[] { new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.RED_TULIP.b())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 1, EnumColor.ORANGE.getInvColorIndex()), new Object[] { new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.ORANGE_TULIP.b())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 1, EnumColor.SILVER.getInvColorIndex()), new Object[] { new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.WHITE_TULIP.b())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 1, EnumColor.PINK.getInvColorIndex()), new Object[] { new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.PINK_TULIP.b())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 1, EnumColor.SILVER.getInvColorIndex()), new Object[] { new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.OXEYE_DAISY.b())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.YELLOW.getInvColorIndex()), new Object[] { new ItemStack(Blocks.DOUBLE_PLANT, 1, BlockTallPlant.EnumTallFlowerVariants.SUNFLOWER.a())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.MAGENTA.getInvColorIndex()), new Object[] { new ItemStack(Blocks.DOUBLE_PLANT, 1, BlockTallPlant.EnumTallFlowerVariants.SYRINGA.a())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.RED.getInvColorIndex()), new Object[] { new ItemStack(Blocks.DOUBLE_PLANT, 1, BlockTallPlant.EnumTallFlowerVariants.ROSE.a())});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.DYE, 2, EnumColor.PINK.getInvColorIndex()), new Object[] { new ItemStack(Blocks.DOUBLE_PLANT, 1, BlockTallPlant.EnumTallFlowerVariants.PAEONIA.a())});

        for (i = 0; i < 16; ++i) {
            craftingmanager.registerShapedRecipe(new ItemStack(Blocks.CARPET, 3, i), new Object[] { "##", Character.valueOf('#'), new ItemStack(Blocks.WOOL, 1, i)});
        }

    }
}
