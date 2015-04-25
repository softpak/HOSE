package net.minecraft.server;

import com.amd.aparapi.Aparapi;
import com.google.common.collect.Lists;
import java.util.ArrayList;

public class RecipeFireworks extends ShapelessRecipes implements IRecipe { // CraftBukkit - added extends

    private ItemStack a;

    // CraftBukkit start - Delegate to new parent class with bogus info
    public RecipeFireworks() {
        super(new ItemStack(Items.FIREWORKS, 0, 0), java.util.Arrays.asList(new ItemStack(Items.GUNPOWDER, 0, 5)));
    }
    // CraftBukkit end
    
    
    byte hb0;
    public boolean a(InventoryCrafting inventorycrafting, World world) {
        this.a = null;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;

        for (int k1 = 0; k1 < inventorycrafting.getSize(); ++k1) {
            ItemStack itemstack = inventorycrafting.getItem(k1);

            if (itemstack != null) {
                if (itemstack.getItem() == Items.GUNPOWDER) {
                    ++j;
                } else if (itemstack.getItem() == Items.FIREWORK_CHARGE) {
                    ++l;
                } else if (itemstack.getItem() == Items.DYE) {
                    ++k;
                } else if (itemstack.getItem() == Items.PAPER) {
                    ++i;
                } else if (itemstack.getItem() == Items.GLOWSTONE_DUST) {
                    ++i1;
                } else if (itemstack.getItem() == Items.DIAMOND) {
                    ++i1;
                } else if (itemstack.getItem() == Items.FIRE_CHARGE) {
                    ++j1;
                } else if (itemstack.getItem() == Items.FEATHER) {
                    ++j1;
                } else if (itemstack.getItem() == Items.GOLD_NUGGET) {
                    ++j1;
                } else {
                    if (itemstack.getItem() != Items.SKULL) {
                        return false;
                    }

                    ++j1;
                }
            }
        }

        i1 += k + j1;
        if (j <= 3 && i <= 1) {
            NBTTagCompound nbttagcompound;
            NBTTagCompound nbttagcompound1;

            if (j >= 1 && i == 1 && i1 == 0) {
                this.a = new ItemStack(Items.FIREWORKS);
                if (l > 0) {
                    nbttagcompound = new NBTTagCompound();
                    nbttagcompound1 = new NBTTagCompound();
                    NBTTagList nbttaglist = new NBTTagList();
                    
                    Aparapi.range(inventorycrafting.getSize()).forEach(gid_l1 -> {
                        ItemStack itemstack1 = inventorycrafting.getItem(gid_l1);

                        if (itemstack1 != null && itemstack1.getItem() == Items.FIREWORK_CHARGE && itemstack1.hasTag() && itemstack1.getTag().hasKeyOfType("Explosion", 10)) {
                            nbttaglist.add(itemstack1.getTag().getCompound("Explosion"));
                        }
                    });
                    /*
                    for (int l1 = 0; l1 < inventorycrafting.getSize(); ++l1) {
                        ItemStack itemstack1 = inventorycrafting.getItem(l1);

                        if (itemstack1 != null && itemstack1.getItem() == Items.FIREWORK_CHARGE && itemstack1.hasTag() && itemstack1.getTag().hasKeyOfType("Explosion", 10)) {
                            nbttaglist.add(itemstack1.getTag().getCompound("Explosion"));
                        }
                    }*/

                    nbttagcompound1.set("Explosions", nbttaglist);
                    nbttagcompound1.setByte("Flight", (byte) j);
                    nbttagcompound.set("Fireworks", nbttagcompound1);
                    this.a.setTag(nbttagcompound);
                }

                return true;
            } else if (j == 1 && i == 0 && l == 0 && k > 0 && j1 <= 1) {
                this.a = new ItemStack(Items.FIREWORK_CHARGE);
                nbttagcompound = new NBTTagCompound();
                nbttagcompound1 = new NBTTagCompound();
                //byte b0 = 0;
                hb0 = 0;
                ArrayList arraylist = Lists.newArrayList();
                
                Aparapi.range(inventorycrafting.getSize()).forEach(gid_i2 -> {
                    ItemStack itemstack2 = inventorycrafting.getItem(gid_i2);

                    if (itemstack2 != null) {
                        if (itemstack2.getItem() == Items.DYE) {
                            arraylist.add(Integer.valueOf(ItemDye.a[itemstack2.getData() & 15]));
                        } else if (itemstack2.getItem() == Items.GLOWSTONE_DUST) {
                            nbttagcompound1.setBoolean("Flicker", true);
                        } else if (itemstack2.getItem() == Items.DIAMOND) {
                            nbttagcompound1.setBoolean("Trail", true);
                        } else if (itemstack2.getItem() == Items.FIRE_CHARGE) {
                            hb0 = 1;
                        } else if (itemstack2.getItem() == Items.FEATHER) {
                            hb0 = 4;
                        } else if (itemstack2.getItem() == Items.GOLD_NUGGET) {
                            hb0 = 2;
                        } else if (itemstack2.getItem() == Items.SKULL) {
                            hb0 = 3;
                        }
                    }
                });
                
                /*
                for (int i2 = 0; i2 < inventorycrafting.getSize(); ++i2) {
                    ItemStack itemstack2 = inventorycrafting.getItem(i2);

                    if (itemstack2 != null) {
                        if (itemstack2.getItem() == Items.DYE) {
                            arraylist.add(Integer.valueOf(ItemDye.a[itemstack2.getData() & 15]));
                        } else if (itemstack2.getItem() == Items.GLOWSTONE_DUST) {
                            nbttagcompound1.setBoolean("Flicker", true);
                        } else if (itemstack2.getItem() == Items.DIAMOND) {
                            nbttagcompound1.setBoolean("Trail", true);
                        } else if (itemstack2.getItem() == Items.FIRE_CHARGE) {
                            b0 = 1;
                        } else if (itemstack2.getItem() == Items.FEATHER) {
                            b0 = 4;
                        } else if (itemstack2.getItem() == Items.GOLD_NUGGET) {
                            b0 = 2;
                        } else if (itemstack2.getItem() == Items.SKULL) {
                            b0 = 3;
                        }
                    }
                }*/

                int[] aint = new int[arraylist.size()];

                Aparapi.range(aint.length).forEach(gid_j2 -> {
                    aint[gid_j2] = ((Integer) arraylist.get(gid_j2)).intValue();
                });
                /*
                for (int j2 = 0; j2 < aint.length; ++j2) {
                    aint[j2] = ((Integer) arraylist.get(j2)).intValue();
                }*/

                nbttagcompound1.setIntArray("Colors", aint);
                nbttagcompound1.setByte("Type", hb0);
                nbttagcompound.set("Explosion", nbttagcompound1);
                this.a.setTag(nbttagcompound);
                return true;
            } else if (j == 0 && i == 0 && l == 1 && k > 0 && k == i1) {
                ArrayList arraylist1 = Lists.newArrayList();

                Aparapi.range(inventorycrafting.getSize()).forEach(gid_k2 -> {
                    ItemStack itemstack3 = inventorycrafting.getItem(gid_k2);

                    if (itemstack3 != null) {
                        if (itemstack3.getItem() == Items.DYE) {
                            arraylist1.add(Integer.valueOf(ItemDye.a[itemstack3.getData() & 15]));
                        } else if (itemstack3.getItem() == Items.FIREWORK_CHARGE) {
                            this.a = itemstack3.cloneItemStack();
                            this.a.count = 1;
                        }
                    }
                });
                
                /*
                for (int k2 = 0; k2 < inventorycrafting.getSize(); ++k2) {
                    ItemStack itemstack3 = inventorycrafting.getItem(k2);

                    if (itemstack3 != null) {
                        if (itemstack3.getItem() == Items.DYE) {
                            arraylist1.add(Integer.valueOf(ItemDye.a[itemstack3.getData() & 15]));
                        } else if (itemstack3.getItem() == Items.FIREWORK_CHARGE) {
                            this.a = itemstack3.cloneItemStack();
                            this.a.count = 1;
                        }
                    }
                }*/

                int[] aint1 = new int[arraylist1.size()];
                
                Aparapi.range(aint1.length).forEach(gid_l2 -> {
                    aint1[gid_l2] = ((Integer) arraylist1.get(gid_l2)).intValue();
                });
                /*
                for (int l2 = 0; l2 < aint1.length; ++l2) {
                    aint1[l2] = ((Integer) arraylist1.get(l2)).intValue();
                }*/

                if (this.a != null && this.a.hasTag()) {
                    NBTTagCompound nbttagcompound2 = this.a.getTag().getCompound("Explosion");

                    if (nbttagcompound2 == null) {
                        return false;
                    } else {
                        nbttagcompound2.setIntArray("FadeColors", aint1);
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public ItemStack a(InventoryCrafting inventorycrafting) {
        return this.a.cloneItemStack();
    }

    public int a() {
        return 10;
    }

    public ItemStack b() {
        return this.a;
    }
    
    //HSA
    public ItemStack[] b(InventoryCrafting inventorycrafting) {
        ItemStack[] aitemstack = new ItemStack[inventorycrafting.getSize()];
        
        Aparapi.range(aitemstack.length).forEach(gid_i -> {
            ItemStack itemstack = inventorycrafting.getItem(gid_i);

            if (itemstack != null && itemstack.getItem().r()) {
                aitemstack[gid_i] = new ItemStack(itemstack.getItem().q());
            }
        });
        /*
        for (int i = 0; i < aitemstack.length; ++i) {
            ItemStack itemstack = inventorycrafting.getItem(i);

            if (itemstack != null && itemstack.getItem().r()) {
                aitemstack[i] = new ItemStack(itemstack.getItem().q());
            }
        }*/

        return aitemstack;
    }
}
