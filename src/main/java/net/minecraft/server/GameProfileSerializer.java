package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.Iterator;
import java.util.UUID;

public final class GameProfileSerializer {

    public static GameProfile deserialize(NBTTagCompound nbttagcompound) {
        String s = null;
        String s1 = null;

        if (nbttagcompound.hasKeyOfType("Name", 8)) {
            s = nbttagcompound.getString("Name");
        }

        if (nbttagcompound.hasKeyOfType("Id", 8)) {
            s1 = nbttagcompound.getString("Id");
        }

        if (UtilColor.b(s) && UtilColor.b(s1)) {
            return null;
        } else {
            UUID uuid;

            try {
                uuid = UUID.fromString(s1);
            } catch (Throwable throwable) {
                uuid = null;
            }

            GameProfile gameprofile = new GameProfile(uuid, s);

            if (nbttagcompound.hasKeyOfType("Properties", 10)) {
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompound("Properties");
                Iterator iterator = nbttagcompound1.c().iterator();

                while (iterator.hasNext()) {
                    String s2 = (String) iterator.next();
                    NBTTagList nbttaglist = nbttagcompound1.getList(s2, 10);

                    for (int i = 0; i < nbttaglist.size(); ++i) {
                        NBTTagCompound nbttagcompound2 = nbttaglist.get(i);
                        String s3 = nbttagcompound2.getString("Value");

                        if (nbttagcompound2.hasKeyOfType("Signature", 8)) {
                            gameprofile.getProperties().put(s2, new Property(s2, s3, nbttagcompound2.getString("Signature")));
                        } else {
                            gameprofile.getProperties().put(s2, new Property(s2, s3));
                        }
                    }
                }
            }

            return gameprofile;
        }
    }

    public static NBTTagCompound serialize(NBTTagCompound nbttagcompound, GameProfile gameprofile) {
        if (!UtilColor.b(gameprofile.getName())) {
            nbttagcompound.setString("Name", gameprofile.getName());
        }

        if (gameprofile.getId() != null) {
            nbttagcompound.setString("Id", gameprofile.getId().toString());
        }

        if (!gameprofile.getProperties().isEmpty()) {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            Iterator iterator = gameprofile.getProperties().keySet().iterator();

            while (iterator.hasNext()) {
                String s = (String) iterator.next();
                NBTTagList nbttaglist = new NBTTagList();

                NBTTagCompound nbttagcompound2;

                for (Iterator iterator1 = gameprofile.getProperties().get(s).iterator(); iterator1.hasNext(); nbttaglist.add(nbttagcompound2)) {
                    Property property = (Property) iterator1.next();

                    nbttagcompound2 = new NBTTagCompound();
                    nbttagcompound2.setString("Value", property.getValue());
                    if (property.hasSignature()) {
                        nbttagcompound2.setString("Signature", property.getSignature());
                    }
                }

                nbttagcompound1.set(s, nbttaglist);
            }

            nbttagcompound.set("Properties", nbttagcompound1);
        }

        return nbttagcompound;
    }

    public static boolean a(NBTBase nbtbase, NBTBase nbtbase1, boolean flag) {
        if (nbtbase == nbtbase1) {
            return true;
        } else if (nbtbase == null) {
            return true;
        } else if (nbtbase1 == null) {
            return false;
        } else if (!nbtbase.getClass().equals(nbtbase1.getClass())) {
            return false;
        } else if (nbtbase instanceof NBTTagCompound) {
            NBTTagCompound nbttagcompound = (NBTTagCompound) nbtbase;
            NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbtbase1;
            Iterator iterator = nbttagcompound.c().iterator();

            String s;
            NBTBase nbtbase2;

            do {
                if (!iterator.hasNext()) {
                    return true;
                }

                s = (String) iterator.next();
                nbtbase2 = nbttagcompound.get(s);
            } while (a(nbtbase2, nbttagcompound1.get(s), flag));

            return false;
        } else if (nbtbase instanceof NBTTagList && flag) {
            NBTTagList nbttaglist = (NBTTagList) nbtbase;
            NBTTagList nbttaglist1 = (NBTTagList) nbtbase1;

            if (nbttaglist.size() == 0) {
                return nbttaglist1.size() == 0;
            } else {
                int i = 0;

                while (i < nbttaglist.size()) {
                    NBTBase nbtbase3 = nbttaglist.g(i);
                    boolean flag1 = false;
                    int j = 0;

                    while (true) {
                        if (j < nbttaglist1.size()) {
                            if (!a(nbtbase3, nbttaglist1.g(j), flag)) {
                                ++j;
                                continue;
                            }

                            flag1 = true;
                        }

                        if (!flag1) {
                            return false;
                        }

                        ++i;
                        break;
                    }
                }

                return true;
            }
        } else {
            return nbtbase.equals(nbtbase1);
        }
    }
}
