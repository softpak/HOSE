package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.List;

public class BlockNote extends BlockContainer {

    private static final List<String> a = Lists.newArrayList(new String[] { "harp", "bd", "snare", "hat", "bassattack"});

    public BlockNote() {
        super(Material.WOOD);
        this.a(CreativeModeTab.d);
    }

    public void doPhysics(World world, BlockPosition blockposition, IBlockData iblockdata, Block block) {
        boolean flag = world.isBlockIndirectlyPowered(blockposition);
        TileEntity tileentity = world.getTileEntity(blockposition);

        if (tileentity instanceof TileEntityNote) {
            TileEntityNote tileentitynote = (TileEntityNote) tileentity;

            if (tileentitynote.f != flag) {
                if (flag) {
                    tileentitynote.play(world, blockposition);
                }

                tileentitynote.f = flag;
            }
        }

    }

    public boolean interact(World world, BlockPosition blockposition, IBlockData iblockdata, EntityHuman entityhuman, EnumDirection enumdirection, float f, float f1, float f2) {
        if (world.isClientSide) {
            return true;
        } else {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityNote) {
                TileEntityNote tileentitynote = (TileEntityNote) tileentity;

                tileentitynote.b();
                tileentitynote.play(world, blockposition);
                entityhuman.b(StatisticList.S);
            }

            return true;
        }
    }

    public void attack(World world, BlockPosition blockposition, EntityHuman entityhuman) {
        if (!world.isClientSide) {
            TileEntity tileentity = world.getTileEntity(blockposition);

            if (tileentity instanceof TileEntityNote) {
                ((TileEntityNote) tileentity).play(world, blockposition);
                entityhuman.b(StatisticList.R);
            }

        }
    }

    public TileEntity a(World world, int i) {
        return new TileEntityNote();
    }

    private String b(int i) {
        if (i < 0 || i >= BlockNote.a.size()) {
            i = 0;
        }

        return (String) BlockNote.a.get(i);
    }

    public boolean a(World world, BlockPosition blockposition, IBlockData iblockdata, int i, int j) {
        float f = (float) Math.pow(2.0D, (double) (j - 12) / 12.0D);

        world.makeSound((double) blockposition.getX() + 0.5D, (double) blockposition.getY() + 0.5D, (double) blockposition.getZ() + 0.5D, "note." + this.b(i), 3.0F, f);
        world.addParticle(EnumParticle.NOTE, (double) blockposition.getX() + 0.5D, (double) blockposition.getY() + 1.2D, (double) blockposition.getZ() + 0.5D, (double) j / 24.0D, 0.0D, 0.0D, new int[0]);
        return true;
    }

    public int b() {
        return 3;
    }
}
