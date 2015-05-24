package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StatisticList {

    protected static Map<String, Statistic> a = Maps.newHashMap();
    public static List<Statistic> stats = Lists.newArrayList();
    public static List<Statistic> c = Lists.newArrayList();
    public static List<CraftingStatistic> d = Lists.newArrayList();
    public static List<CraftingStatistic> e = Lists.newArrayList();
    public static Statistic f = (new CounterStatistic("stat.leaveGame", new ChatMessage("stat.leaveGame", new Object[0]))).i().h();
    public static Statistic g = (new CounterStatistic("stat.playOneMinute", new ChatMessage("stat.playOneMinute", new Object[0]), Statistic.h)).i().h();
    public static Statistic h = (new CounterStatistic("stat.timeSinceDeath", new ChatMessage("stat.timeSinceDeath", new Object[0]), Statistic.h)).i().h();
    public static Statistic i = (new CounterStatistic("stat.walkOneCm", new ChatMessage("stat.walkOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic j = (new CounterStatistic("stat.crouchOneCm", new ChatMessage("stat.crouchOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic k = (new CounterStatistic("stat.sprintOneCm", new ChatMessage("stat.sprintOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic l = (new CounterStatistic("stat.swimOneCm", new ChatMessage("stat.swimOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic m = (new CounterStatistic("stat.fallOneCm", new ChatMessage("stat.fallOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic n = (new CounterStatistic("stat.climbOneCm", new ChatMessage("stat.climbOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic o = (new CounterStatistic("stat.flyOneCm", new ChatMessage("stat.flyOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic p = (new CounterStatistic("stat.diveOneCm", new ChatMessage("stat.diveOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic q = (new CounterStatistic("stat.minecartOneCm", new ChatMessage("stat.minecartOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic r = (new CounterStatistic("stat.boatOneCm", new ChatMessage("stat.boatOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic s = (new CounterStatistic("stat.pigOneCm", new ChatMessage("stat.pigOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic t = (new CounterStatistic("stat.horseOneCm", new ChatMessage("stat.horseOneCm", new Object[0]), Statistic.i)).i().h();
    public static Statistic u = (new CounterStatistic("stat.jump", new ChatMessage("stat.jump", new Object[0]))).i().h();
    public static Statistic v = (new CounterStatistic("stat.drop", new ChatMessage("stat.drop", new Object[0]))).i().h();
    public static Statistic w = (new CounterStatistic("stat.damageDealt", new ChatMessage("stat.damageDealt", new Object[0]), Statistic.j)).h();
    public static Statistic x = (new CounterStatistic("stat.damageTaken", new ChatMessage("stat.damageTaken", new Object[0]), Statistic.j)).h();
    public static Statistic y = (new CounterStatistic("stat.deaths", new ChatMessage("stat.deaths", new Object[0]))).h();
    public static Statistic z = (new CounterStatistic("stat.mobKills", new ChatMessage("stat.mobKills", new Object[0]))).h();
    public static Statistic A = (new CounterStatistic("stat.animalsBred", new ChatMessage("stat.animalsBred", new Object[0]))).h();
    public static Statistic B = (new CounterStatistic("stat.playerKills", new ChatMessage("stat.playerKills", new Object[0]))).h();
    public static Statistic C = (new CounterStatistic("stat.fishCaught", new ChatMessage("stat.fishCaught", new Object[0]))).h();
    public static Statistic D = (new CounterStatistic("stat.junkFished", new ChatMessage("stat.junkFished", new Object[0]))).h();
    public static Statistic E = (new CounterStatistic("stat.treasureFished", new ChatMessage("stat.treasureFished", new Object[0]))).h();
    public static Statistic F = (new CounterStatistic("stat.talkedToVillager", new ChatMessage("stat.talkedToVillager", new Object[0]))).h();
    public static Statistic G = (new CounterStatistic("stat.tradedWithVillager", new ChatMessage("stat.tradedWithVillager", new Object[0]))).h();
    public static Statistic H = (new CounterStatistic("stat.cakeSlicesEaten", new ChatMessage("stat.cakeSlicesEaten", new Object[0]))).h();
    public static Statistic I = (new CounterStatistic("stat.cauldronFilled", new ChatMessage("stat.cauldronFilled", new Object[0]))).h();
    public static Statistic J = (new CounterStatistic("stat.cauldronUsed", new ChatMessage("stat.cauldronUsed", new Object[0]))).h();
    public static Statistic K = (new CounterStatistic("stat.armorCleaned", new ChatMessage("stat.armorCleaned", new Object[0]))).h();
    public static Statistic L = (new CounterStatistic("stat.bannerCleaned", new ChatMessage("stat.bannerCleaned", new Object[0]))).h();
    public static Statistic M = (new CounterStatistic("stat.brewingstandInteraction", new ChatMessage("stat.brewingstandInteraction", new Object[0]))).h();
    public static Statistic N = (new CounterStatistic("stat.beaconInteraction", new ChatMessage("stat.beaconInteraction", new Object[0]))).h();
    public static Statistic O = (new CounterStatistic("stat.dropperInspected", new ChatMessage("stat.dropperInspected", new Object[0]))).h();
    public static Statistic P = (new CounterStatistic("stat.hopperInspected", new ChatMessage("stat.hopperInspected", new Object[0]))).h();
    public static Statistic Q = (new CounterStatistic("stat.dispenserInspected", new ChatMessage("stat.dispenserInspected", new Object[0]))).h();
    public static Statistic R = (new CounterStatistic("stat.noteblockPlayed", new ChatMessage("stat.noteblockPlayed", new Object[0]))).h();
    public static Statistic S = (new CounterStatistic("stat.noteblockTuned", new ChatMessage("stat.noteblockTuned", new Object[0]))).h();
    public static Statistic T = (new CounterStatistic("stat.flowerPotted", new ChatMessage("stat.flowerPotted", new Object[0]))).h();
    public static Statistic U = (new CounterStatistic("stat.trappedChestTriggered", new ChatMessage("stat.trappedChestTriggered", new Object[0]))).h();
    public static Statistic V = (new CounterStatistic("stat.enderchestOpened", new ChatMessage("stat.enderchestOpened", new Object[0]))).h();
    public static Statistic W = (new CounterStatistic("stat.itemEnchanted", new ChatMessage("stat.itemEnchanted", new Object[0]))).h();
    public static Statistic X = (new CounterStatistic("stat.recordPlayed", new ChatMessage("stat.recordPlayed", new Object[0]))).h();
    public static Statistic Y = (new CounterStatistic("stat.furnaceInteraction", new ChatMessage("stat.furnaceInteraction", new Object[0]))).h();
    public static Statistic Z = (new CounterStatistic("stat.craftingTableInteraction", new ChatMessage("stat.workbenchInteraction", new Object[0]))).h();
    public static Statistic aa = (new CounterStatistic("stat.chestOpened", new ChatMessage("stat.chestOpened", new Object[0]))).h();
    public static final Statistic[] MINE_BLOCK_COUNT = new Statistic[4096];
    public static final Statistic[] CRAFT_BLOCK_COUNT = new Statistic[32000];
    public static final Statistic[] USE_ITEM_COUNT = new Statistic[32000];
    public static final Statistic[] BREAK_ITEM_COUNT = new Statistic[32000];

    public static void a() {
        c();
        d();
        e();
        b();
        AchievementList.a();
        EntityTypes.a();
    }

    private static void b() {
        HashSet hashset = Sets.newHashSet();
        Iterator iterator = CraftingManager.getInstance().getRecipes().iterator();

        while (iterator.hasNext()) {
            IRecipe irecipe = (IRecipe) iterator.next();

            if (irecipe.b() != null) {
                hashset.add(irecipe.b().getItem());
            }
        }

        iterator = RecipesFurnace.getInstance().getRecipes().values().iterator();

        while (iterator.hasNext()) {
            ItemStack itemstack = (ItemStack) iterator.next();

            hashset.add(itemstack.getItem());
        }

        iterator = hashset.iterator();

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();

            if (item != null) {
                int i = Item.getId(item);
                String s = a(item);

                if (s != null) {
                    StatisticList.CRAFT_BLOCK_COUNT[i] = (new CraftingStatistic("stat.craftItem.", s, new ChatMessage("stat.craftItem", new Object[] { (new ItemStack(item)).C()}), item)).h();
                }
            }
        }

        a(StatisticList.CRAFT_BLOCK_COUNT);
    }

    private static void c() {
        Iterator iterator = Block.REGISTRY.iterator();

        while (iterator.hasNext()) {
            Block block = (Block) iterator.next();
            Item item = Item.getItemOf(block);

            if (item != null) {
                int i = Block.getId(block);
                String s = a(item);

                if (s != null && block.J()) {
                    StatisticList.MINE_BLOCK_COUNT[i] = (new CraftingStatistic("stat.mineBlock.", s, new ChatMessage("stat.mineBlock", new Object[] { (new ItemStack(block)).C()}), item)).h();
                    StatisticList.e.add((CraftingStatistic) StatisticList.MINE_BLOCK_COUNT[i]);
                }
            }
        }

        a(StatisticList.MINE_BLOCK_COUNT);
    }

    private static void d() {
        Iterator iterator = Item.REGISTRY.iterator();

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();

            if (item != null) {
                int i = Item.getId(item);
                String s = a(item);

                if (s != null) {
                    StatisticList.USE_ITEM_COUNT[i] = (new CraftingStatistic("stat.useItem.", s, new ChatMessage("stat.useItem", new Object[] { (new ItemStack(item)).C()}), item)).h();
                    if (!(item instanceof ItemBlock)) {
                        StatisticList.d.add((CraftingStatistic) StatisticList.USE_ITEM_COUNT[i]);
                    }
                }
            }
        }

        a(StatisticList.USE_ITEM_COUNT);
    }

    private static void e() {
        Iterator iterator = Item.REGISTRY.iterator();

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();

            if (item != null) {
                int i = Item.getId(item);
                String s = a(item);

                if (s != null && item.usesDurability()) {
                    StatisticList.BREAK_ITEM_COUNT[i] = (new CraftingStatistic("stat.breakItem.", s, new ChatMessage("stat.breakItem", new Object[] { (new ItemStack(item)).C()}), item)).h();
                }
            }
        }

        a(StatisticList.BREAK_ITEM_COUNT);
    }

    private static String a(Item item) {
        MinecraftKey minecraftkey = (MinecraftKey) Item.REGISTRY.c(item);

        return minecraftkey != null ? minecraftkey.toString().replace(':', '.') : null;
    }

    private static void a(Statistic[] astatistic) {
        a(astatistic, Blocks.WATER, Blocks.FLOWING_WATER);
        a(astatistic, Blocks.LAVA, Blocks.FLOWING_LAVA);
        a(astatistic, Blocks.LIT_PUMPKIN, Blocks.PUMPKIN);
        a(astatistic, Blocks.LIT_FURNACE, Blocks.FURNACE);
        a(astatistic, Blocks.LIT_REDSTONE_ORE, Blocks.REDSTONE_ORE);
        a(astatistic, Blocks.POWERED_REPEATER, Blocks.UNPOWERED_REPEATER);
        a(astatistic, Blocks.POWERED_COMPARATOR, Blocks.UNPOWERED_COMPARATOR);
        a(astatistic, Blocks.REDSTONE_TORCH, Blocks.UNLIT_REDSTONE_TORCH);
        a(astatistic, Blocks.LIT_REDSTONE_LAMP, Blocks.REDSTONE_LAMP);
        a(astatistic, Blocks.DOUBLE_STONE_SLAB, Blocks.STONE_SLAB);
        a(astatistic, Blocks.DOUBLE_WOODEN_SLAB, Blocks.WOODEN_SLAB);
        a(astatistic, Blocks.DOUBLE_STONE_SLAB2, Blocks.STONE_SLAB2);
        a(astatistic, Blocks.GRASS, Blocks.DIRT);
        a(astatistic, Blocks.FARMLAND, Blocks.DIRT);
    }

    private static void a(Statistic[] astatistic, Block block, Block block1) {
        int i = Block.getId(block);
        int j = Block.getId(block1);

        if (astatistic[i] != null && astatistic[j] == null) {
            astatistic[j] = astatistic[i];
        } else {
            StatisticList.stats.remove(astatistic[i]);
            StatisticList.e.remove(astatistic[i]);
            StatisticList.c.remove(astatistic[i]);
            astatistic[i] = astatistic[j];
        }
    }

    public static Statistic a(EntityTypes.MonsterEggInfo entitytypes_monsteregginfo) {
        String s = EntityTypes.b(entitytypes_monsteregginfo.a);

        return s == null ? null : (new Statistic("stat.killEntity." + s, new ChatMessage("stat.entityKill", new Object[] { new ChatMessage("entity." + s + ".name", new Object[0])}))).h();
    }

    public static Statistic b(EntityTypes.MonsterEggInfo entitytypes_monsteregginfo) {
        String s = EntityTypes.b(entitytypes_monsteregginfo.a);

        return s == null ? null : (new Statistic("stat.entityKilledBy." + s, new ChatMessage("stat.entityKilledBy", new Object[] { new ChatMessage("entity." + s + ".name", new Object[0])}))).h();
    }

    public static Statistic getStatistic(String s) {
        return (Statistic) StatisticList.a.get(s);
    }
}
