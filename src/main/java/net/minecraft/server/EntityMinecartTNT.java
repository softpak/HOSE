package net.minecraft.server;

public class EntityMinecartTNT extends EntityMinecartAbstract {

    private int a = -1;

    public EntityMinecartTNT(World world) {
        super(world);
    }

    public EntityMinecartTNT(World world, double d0, double d1, double d2) {
        super(world, d0, d1, d2);
    }

    public EntityMinecartAbstract.EnumMinecartType s() {
        return EntityMinecartAbstract.EnumMinecartType.TNT;
    }

    public IBlockData u() {
        return Blocks.TNT.getBlockData();
    }

    public void t_() {
        super.t_();
        if (this.a > 0) {
            --this.a;
            this.world.addParticle(EnumParticle.SMOKE_NORMAL, this.locX, this.locY + 0.5D, this.locZ, 0.0D, 0.0D, 0.0D, new int[0]);
        } else if (this.a == 0) {
            this.b(this.motX * this.motX + this.motZ * this.motZ);
        }

        if (this.positionChanged) {
            double d0 = this.motX * this.motX + this.motZ * this.motZ;

            if (d0 >= 0.009999999776482582D) {
                this.b(d0);
            }
        }

    }

    public boolean damageEntity(DamageSource damagesource, float f) {
        Entity entity = damagesource.i();

        if (entity instanceof EntityArrow) {
            EntityArrow entityarrow = (EntityArrow) entity;

            if (entityarrow.isBurning()) {
                this.b(entityarrow.motX * entityarrow.motX + entityarrow.motY * entityarrow.motY + entityarrow.motZ * entityarrow.motZ);
            }
        }

        return super.damageEntity(damagesource, f);
    }

    public void a(DamageSource damagesource) {
        super.a(damagesource);
        double d0 = this.motX * this.motX + this.motZ * this.motZ;

        if (!damagesource.isExplosion() && this.world.getGameRules().getBoolean("doEntityDrops")) {
            this.a(new ItemStack(Blocks.TNT, 1), 0.0F);
        }

        if (damagesource.o() || damagesource.isExplosion() || d0 >= 0.009999999776482582D) {
            this.b(d0);
        }

    }

    protected void b(double d0) {
        if (!this.world.isClientSide) {
            double d1 = Math.sqrt(d0);

            if (d1 > 5.0D) {
                d1 = 5.0D;
            }

            this.world.explode(this, this.locX, this.locY, this.locZ, (float) (4.0D + this.random.nextDouble() * 1.5D * d1), true);
            this.die();
        }

    }

    public void e(float f, float f1) {
        if (f >= 3.0F) {
            float f2 = f / 10.0F;

            this.b((double) (f2 * f2));
        }

        super.e(f, f1);
    }

    public void a(int i, int j, int k, boolean flag) {
        if (flag && this.a < 0) {
            this.j();
        }

    }

    public void j() {
        this.a = 80;
        if (!this.world.isClientSide) {
            this.world.broadcastEntityEffect(this, (byte) 10);
            if (!this.R()) {
                this.world.makeSound(this, "game.tnt.primed", 1.0F, 1.0F);
            }
        }

    }

    public boolean y() {
        return this.a > -1;
    }

    public float a(Explosion explosion, World world, BlockPosition blockposition, IBlockData iblockdata) {
        return this.y() && (BlockMinecartTrackAbstract.d(iblockdata) || BlockMinecartTrackAbstract.e(world, blockposition.up())) ? 0.0F : super.a(explosion, world, blockposition, iblockdata);
    }

    public boolean a(Explosion explosion, World world, BlockPosition blockposition, IBlockData iblockdata, float f) {
        return this.y() && (BlockMinecartTrackAbstract.d(iblockdata) || BlockMinecartTrackAbstract.e(world, blockposition.up())) ? false : super.a(explosion, world, blockposition, iblockdata, f);
    }

    protected void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        if (nbttagcompound.hasKeyOfType("TNTFuse", 99)) {
            this.a = nbttagcompound.getInt("TNTFuse");
        }

    }

    protected void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setInt("TNTFuse", this.a);
    }
}
