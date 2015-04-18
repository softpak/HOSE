package net.minecraft.server;

public class BlockTNT extends Block {

    public static final BlockStateBoolean EXPLODE = BlockStateBoolean.of("explode");

    public BlockTNT() {
        super(Material.TNT);
        this.j(this.blockStateList.getBlockData().set(BlockTNT.EXPLODE, Boolean.valueOf(false)));
        this.a(CreativeModeTab.d);
    }

    public void onPlace(World world, BlockPosition blockposition, IBlockData iblockdata) {
        super.onPlace(world, blockposition, iblockdata);
        if (world.isBlockIndirectlyPowered(blockposition)) {
            this.postBreak(world, blockposition, iblockdata.set(BlockTNT.EXPLODE, Boolean.valueOf(true)));
            world.setAir(blockposition);
        }

    }

    public void doPhysics(World world, BlockPosition blockposition, IBlockData iblockdata, Block block) {
        if (world.isBlockIndirectlyPowered(blockposition)) {
            this.postBreak(world, blockposition, iblockdata.set(BlockTNT.EXPLODE, Boolean.valueOf(true)));
            world.setAir(blockposition);
        }

    }

    public void wasExploded(World world, BlockPosition blockposition, Explosion explosion) {
        if (!world.isClientSide) {
            EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (double) ((float) blockposition.getX() + 0.5F), (double) blockposition.getY(), (double) ((float) blockposition.getZ() + 0.5F), explosion.c());

            entitytntprimed.fuseTicks = world.random.nextInt(entitytntprimed.fuseTicks / 4) + entitytntprimed.fuseTicks / 8;
            world.addEntity(entitytntprimed);
        }
    }

    public void postBreak(World world, BlockPosition blockposition, IBlockData iblockdata) {
        this.a(world, blockposition, iblockdata, (EntityLiving) null);
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, EntityLiving entityliving) {
        if (!world.isClientSide) {
            if (((Boolean) iblockdata.get(BlockTNT.EXPLODE)).booleanValue()) {
                EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (double) ((float) blockposition.getX() + 0.5F), (double) blockposition.getY(), (double) ((float) blockposition.getZ() + 0.5F), entityliving);

                world.addEntity(entitytntprimed);
                world.makeSound(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
            }

        }
    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (entityhuman.bZ() != null) {
            Item item = entityhuman.bZ().getItem();

            if (item == Items.FLINT_AND_STEEL || item == Items.FIRE_CHARGE) {
                this.a(world, blockposition, iblockdata.set(BlockTNT.EXPLODE, Boolean.valueOf(true)), (EntityLiving) entityhuman);
                world.setAir(blockposition);
                if (item == Items.FLINT_AND_STEEL) {
                    entityhuman.bZ().damage(1, entityhuman);
                } else if (!entityhuman.abilities.canInstantlyBuild) {
                    --entityhuman.bZ().count;
                }

                return true;
            }
        }

        return super.interact(world, blockposition, iblockdata, entityhuman, enumdirection, f, f1, f2);
    }

    public void a(World world, BlockPosition blockposition, IBlockData iblockdata, Entity entity) {
        if (!world.isClientSide && entity instanceof EntityArrow) {
            EntityArrow entityarrow = (EntityArrow) entity;

            if (entityarrow.isBurning()) {
                // CraftBukkit start
                if (org.bukkit.craftbukkit.event.CraftEventFactory.callEntityChangeBlockEvent(entityarrow, blockposition.getX(), blockposition.getY(), blockposition.getZ(), Blocks.AIR, 0).isCancelled()) {
                    return;
                }
                // CraftBukkit end
                this.a(world, blockposition, world.getType(blockposition).set(BlockTNT.EXPLODE, Boolean.valueOf(true)), entityarrow.shooter instanceof EntityLiving ? (EntityLiving) entityarrow.shooter : null);
                world.setAir(blockposition);
            }
        }

    }

    public boolean a(Explosion explosion) {
        return false;
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(BlockTNT.EXPLODE, Boolean.valueOf((i & 1) > 0));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((Boolean) iblockdata.get(BlockTNT.EXPLODE)).booleanValue() ? 1 : 0;
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[] { BlockTNT.EXPLODE});
    }
}
