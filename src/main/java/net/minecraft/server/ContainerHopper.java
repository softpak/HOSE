package net.minecraft.server;

// CraftBukkit start
import com.amd.aparapi.Aparapi;
import org.bukkit.craftbukkit.inventory.CraftInventory;
import org.bukkit.craftbukkit.inventory.CraftInventoryView;
// CraftBukkit end

public class ContainerHopper extends Container {

    private final IInventory hopper;

    // CraftBukkit start
    private CraftInventoryView bukkitEntity = null;
    private PlayerInventory player;

    @Override
    public CraftInventoryView getBukkitView() {
        if (bukkitEntity != null) {
            return bukkitEntity;
        }

        CraftInventory inventory = new CraftInventory(this.hopper);
        bukkitEntity = new CraftInventoryView(this.player.player.getBukkitEntity(), inventory, this);
        return bukkitEntity;
    }
    // CraftBukkit end
    //HSA
    public ContainerHopper(PlayerInventory playerinventory, IInventory iinventory, EntityHuman entityhuman) {
        this.hopper = iinventory;
        this.player = playerinventory; // CraftBukkit - save player
        iinventory.startOpen(entityhuman);
        byte b0 = 51;

        //int i;
        Aparapi.range(iinventory.getSize()).forEach(gid_i -> {
            this.a(new Slot(iinventory, gid_i, 44 + gid_i * 18, 20));
        });
        
        Aparapi.range(3).forEach(gid_i -> {
            Aparapi.range(9).forEach(gid_j -> {
                this.a(new Slot(playerinventory, gid_j + gid_i * 9 + 9, 8 + gid_j * 18, gid_i * 18 + b0));
            });
        });
        
        Aparapi.range(9).forEach(gid_i -> {
            this.a(new Slot(playerinventory, gid_i, 8 + gid_i * 18, 58 + b0));
        });
        /*
        for (i = 0; i < iinventory.getSize(); ++i) {
            this.a(new Slot(iinventory, i, 44 + i * 18, 20));
        }

        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.a(new Slot(playerinventory, j + i * 9 + 9, 8 + j * 18, i * 18 + b0));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.a(new Slot(playerinventory, i, 8 + i * 18, 58 + b0));
        }*/

    }

    public boolean a(EntityHuman entityhuman) {
        if (!this.checkReachable) return true; // CraftBukkit
        return this.hopper.a(entityhuman);
    }

    public ItemStack b(EntityHuman entityhuman, int i) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.c.get(i);

        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();

            itemstack = itemstack1.cloneItemStack();
            if (i < this.hopper.getSize()) {
                if (!this.a(itemstack1, this.hopper.getSize(), this.c.size(), true)) {
                    return null;
                }
            } else if (!this.a(itemstack1, 0, this.hopper.getSize(), false)) {
                return null;
            }

            if (itemstack1.count == 0) {
                slot.set((ItemStack) null);
            } else {
                slot.f();
            }
        }

        return itemstack;
    }

    public void b(EntityHuman entityhuman) {
        super.b(entityhuman);
        this.hopper.closeContainer(entityhuman);
    }
}
