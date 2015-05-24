package net.minecraft.server;

import com.google.common.collect.Multimap;

public class ItemSword extends Item {

    private float a;
    private final Item.EnumToolMaterial b;

    public ItemSword(Item.EnumToolMaterial item_enumtoolmaterial) {
        this.b = item_enumtoolmaterial;
        this.maxStackSize = 1;
        this.setMaxDurability(item_enumtoolmaterial.a());
        this.a(CreativeModeTab.j);
        this.a = 4.0F + item_enumtoolmaterial.c();
    }

    public float g() {
        return this.b.c();
    }

    public float getDestroySpeed(ItemStack itemstack, Block block) {
        if (block == Blocks.WEB) {
            return 15.0F;
        } else {
            Material material = block.getMaterial();

            return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && material != Material.CORAL && material != Material.LEAVES && material != Material.PUMPKIN ? 1.0F : 1.5F;
        }
    }

    public boolean a(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1) {
        itemstack.damage(1, entityliving1);
        return true;
    }

    public boolean a(ItemStack itemstack, World world, Block block, BlockPosition blockposition, EntityLiving entityliving) {
        if ((double) block.g(world, blockposition) != 0.0D) {
            itemstack.damage(2, entityliving);
        }

        return true;
    }

    public EnumAnimation e(ItemStack itemstack) {
        return EnumAnimation.BLOCK;
    }

    public int d(ItemStack itemstack) {
        return 72000;
    }

    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        entityhuman.a(itemstack, this.d(itemstack));
        return itemstack;
    }

    public boolean canDestroySpecialBlock(Block block) {
        return block == Blocks.WEB;
    }

    public int b() {
        return this.b.e();
    }

    public String h() {
        return this.b.toString();
    }

    public boolean a(ItemStack itemstack, ItemStack itemstack1) {
        return this.b.f() == itemstack1.getItem() ? true : super.a(itemstack, itemstack1);
    }

    public Multimap<String, AttributeModifier> i() {
        Multimap multimap = super.i();

        multimap.put(GenericAttributes.e.getName(), new AttributeModifier(ItemSword.f, "Weapon modifier", (double) this.a, 0));
        return multimap;
    }
}
