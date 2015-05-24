package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StructurePieceTreasure extends WeightedRandom.WeightedRandomChoice {

    private ItemStack b;
    private int c;
    private int d;

    public StructurePieceTreasure(Item item, int i, int j, int k, int l) {
        super(l);
        this.b = new ItemStack(item, 1, i);
        this.c = j;
        this.d = k;
    }

    public StructurePieceTreasure(ItemStack itemstack, int i, int j, int k) {
        super(k);
        this.b = itemstack;
        this.c = i;
        this.d = j;
    }

    public static void a(Random random, List<StructurePieceTreasure> list, IInventory iinventory, int i) {
        for (int j = 0; j < i; ++j) {
            StructurePieceTreasure structurepiecetreasure = (StructurePieceTreasure) WeightedRandom.a(random, list);
            int k = structurepiecetreasure.c + random.nextInt(structurepiecetreasure.d - structurepiecetreasure.c + 1);

            if (structurepiecetreasure.b.getMaxStackSize() >= k) {
                ItemStack itemstack = structurepiecetreasure.b.cloneItemStack();

                itemstack.count = k;
                iinventory.setItem(random.nextInt(iinventory.getSize()), itemstack);
            } else {
                for (int l = 0; l < k; ++l) {
                    ItemStack itemstack1 = structurepiecetreasure.b.cloneItemStack();

                    itemstack1.count = 1;
                    iinventory.setItem(random.nextInt(iinventory.getSize()), itemstack1);
                }
            }
        }

    }

    public static void a(Random random, List<StructurePieceTreasure> list, TileEntityDispenser tileentitydispenser, int i) {
        for (int j = 0; j < i; ++j) {
            StructurePieceTreasure structurepiecetreasure = (StructurePieceTreasure) WeightedRandom.a(random, list);
            int k = structurepiecetreasure.c + random.nextInt(structurepiecetreasure.d - structurepiecetreasure.c + 1);

            if (structurepiecetreasure.b.getMaxStackSize() >= k) {
                ItemStack itemstack = structurepiecetreasure.b.cloneItemStack();

                itemstack.count = k;
                tileentitydispenser.setItem(random.nextInt(tileentitydispenser.getSize()), itemstack);
            } else {
                for (int l = 0; l < k; ++l) {
                    ItemStack itemstack1 = structurepiecetreasure.b.cloneItemStack();

                    itemstack1.count = 1;
                    tileentitydispenser.setItem(random.nextInt(tileentitydispenser.getSize()), itemstack1);
                }
            }
        }

    }

    public static List<StructurePieceTreasure> a(List<StructurePieceTreasure> list, StructurePieceTreasure... astructurepiecetreasure) {
        ArrayList arraylist = Lists.newArrayList(list);

        Collections.addAll(arraylist, astructurepiecetreasure);
        return arraylist;
    }
}
