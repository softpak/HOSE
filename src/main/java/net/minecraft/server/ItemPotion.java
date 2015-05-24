package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ItemPotion extends Item {

    private Map<Integer, List<MobEffect>> a = Maps.newHashMap();
    private static final Map<List<MobEffect>, Integer> b = Maps.newLinkedHashMap();

    public ItemPotion() {
        this.c(1);
        this.a(true);
        this.setMaxDurability(0);
        this.a(CreativeModeTab.k);
    }

    public List<MobEffect> h(ItemStack itemstack) {
        if (itemstack.hasTag() && itemstack.getTag().hasKeyOfType("CustomPotionEffects", 9)) {
            ArrayList arraylist = Lists.newArrayList();
            NBTTagList nbttaglist = itemstack.getTag().getList("CustomPotionEffects", 10);

            for (int i = 0; i < nbttaglist.size(); ++i) {
                NBTTagCompound nbttagcompound = nbttaglist.get(i);
                MobEffect mobeffect = MobEffect.b(nbttagcompound);

                if (mobeffect != null) {
                    arraylist.add(mobeffect);
                }
            }

            return arraylist;
        } else {
            List list = (List) this.a.get(Integer.valueOf(itemstack.getData()));

            if (list == null) {
                list = PotionBrewer.getEffects(itemstack.getData(), false);
                this.a.put(Integer.valueOf(itemstack.getData()), list);
            }

            return list;
        }
    }

    public List<MobEffect> e(int i) {
        List list = (List) this.a.get(Integer.valueOf(i));

        if (list == null) {
            list = PotionBrewer.getEffects(i, false);
            this.a.put(Integer.valueOf(i), list);
        }

        return list;
    }

    public ItemStack b(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }

        if (!world.isClientSide) {
            List list = this.h(itemstack);

            if (list != null) {
                Iterator iterator = list.iterator();

                while (iterator.hasNext()) {
                    MobEffect mobeffect = (MobEffect) iterator.next();

                    entityhuman.addEffect(new MobEffect(mobeffect));
                }
            }
        }

        entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
        if (!entityhuman.abilities.canInstantlyBuild) {
            if (itemstack.count <= 0) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            entityhuman.inventory.pickup(new ItemStack(Items.GLASS_BOTTLE));
        }

        return itemstack;
    }

    public int d(ItemStack itemstack) {
        return 32;
    }

    public EnumAnimation e(ItemStack itemstack) {
        return EnumAnimation.DRINK;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (f(itemstack.getData())) {
            if (!entityhuman.abilities.canInstantlyBuild) {
                --itemstack.count;
            }

            world.makeSound(entityhuman, "random.bow", 0.5F, 0.4F / (ItemPotion.g.nextFloat() * 0.4F + 0.8F));
            if (!world.isClientSide) {
                world.addEntity(new EntityPotion(world, entityhuman, itemstack));
            }

            entityhuman.b(StatisticList.USE_ITEM_COUNT[Item.getId(this)]);
            return itemstack;
        } else {
            entityhuman.a(itemstack, this.d(itemstack));
            return itemstack;
        }
    }

    public static boolean f(int i) {
        return (i & 16384) != 0;
    }

    public String a(ItemStack itemstack) {
        if (itemstack.getData() == 0) {
            return LocaleI18n.get("item.emptyPotion.name").trim();
        } else {
            String s = "";

            if (f(itemstack.getData())) {
                s = LocaleI18n.get("potion.prefix.grenade").trim() + " ";
            }

            List list = Items.POTION.h(itemstack);
            String s1;

            if (list != null && !list.isEmpty()) {
                s1 = ((MobEffect) list.get(0)).g();
                s1 = s1 + ".postfix";
                return s + LocaleI18n.get(s1).trim();
            } else {
                s1 = PotionBrewer.c(itemstack.getData());
                return LocaleI18n.get(s1).trim() + " " + super.a(itemstack);
            }
        }
    }
}
