package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.HashMap;

public class EntityPositionTypes {

    private static final HashMap<Class, EntityInsentient.EnumEntityPositionType> a = Maps.newHashMap();

    public static EntityInsentient.EnumEntityPositionType a(Class oclass) {
        return (EntityInsentient.EnumEntityPositionType) EntityPositionTypes.a.get(oclass);
    }

    static {
        EntityPositionTypes.a.put(EntityBat.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityChicken.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityCow.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityHorse.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityMushroomCow.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityOcelot.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityPig.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityRabbit.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntitySheep.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntitySnowman.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntitySquid.class, EntityInsentient.EnumEntityPositionType.IN_WATER);
        EntityPositionTypes.a.put(EntityIronGolem.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityWolf.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityVillager.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityEnderDragon.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityWither.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityBlaze.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityCaveSpider.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityCreeper.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityEnderman.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityEndermite.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityGhast.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityGiantZombie.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityGuardian.class, EntityInsentient.EnumEntityPositionType.IN_WATER);
        EntityPositionTypes.a.put(EntityMagmaCube.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityPigZombie.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntitySilverfish.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntitySkeleton.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntitySlime.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntitySpider.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityWitch.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
        EntityPositionTypes.a.put(EntityZombie.class, EntityInsentient.EnumEntityPositionType.ON_GROUND);
    }
}
