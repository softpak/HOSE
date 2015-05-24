package net.minecraft.server;

public class RecipesFood {

    public RecipesFood() {}

    public void a(CraftingManager craftingmanager) {
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.MUSHROOM_STEW), new Object[] { Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Items.BOWL});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.COOKIE, 8), new Object[] { "#X#", Character.valueOf('X'), new ItemStack(Items.DYE, 1, EnumColor.BROWN.getInvColorIndex()), Character.valueOf('#'), Items.WHEAT});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.RABBIT_STEW), new Object[] { " R ", "CPM", " B ", Character.valueOf('R'), new ItemStack(Items.COOKED_RABBIT), Character.valueOf('C'), Items.CARROT, Character.valueOf('P'), Items.BAKED_POTATO, Character.valueOf('M'), Blocks.BROWN_MUSHROOM, Character.valueOf('B'), Items.BOWL});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.RABBIT_STEW), new Object[] { " R ", "CPD", " B ", Character.valueOf('R'), new ItemStack(Items.COOKED_RABBIT), Character.valueOf('C'), Items.CARROT, Character.valueOf('P'), Items.BAKED_POTATO, Character.valueOf('D'), Blocks.RED_MUSHROOM, Character.valueOf('B'), Items.BOWL});
        craftingmanager.registerShapedRecipe(new ItemStack(Blocks.MELON_BLOCK), new Object[] { "MMM", "MMM", "MMM", Character.valueOf('M'), Items.MELON});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.MELON_SEEDS), new Object[] { "M", Character.valueOf('M'), Items.MELON});
        craftingmanager.registerShapedRecipe(new ItemStack(Items.PUMPKIN_SEEDS, 4), new Object[] { "M", Character.valueOf('M'), Blocks.PUMPKIN});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.PUMPKIN_PIE), new Object[] { Blocks.PUMPKIN, Items.SUGAR, Items.EGG});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.FERMENTED_SPIDER_EYE), new Object[] { Items.SPIDER_EYE, Blocks.BROWN_MUSHROOM, Items.SUGAR});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.BLAZE_POWDER, 2), new Object[] { Items.BLAZE_ROD});
        craftingmanager.registerShapelessRecipe(new ItemStack(Items.MAGMA_CREAM), new Object[] { Items.BLAZE_POWDER, Items.SLIME});
    }
}
