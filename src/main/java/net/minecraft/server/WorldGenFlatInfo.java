package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WorldGenFlatInfo {

    private final List<WorldGenFlatLayerInfo> layers = Lists.newArrayList();
    private final Map<String, Map<String, String>> structures = Maps.newHashMap();
    private int c;

    public WorldGenFlatInfo() {}

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public Map<String, Map<String, String>> b() {
        return this.structures;
    }

    public List<WorldGenFlatLayerInfo> c() {
        return this.layers;
    }

    public void d() {
        int i = 0;

        WorldGenFlatLayerInfo worldgenflatlayerinfo;

        for (Iterator iterator = this.layers.iterator(); iterator.hasNext(); i += worldgenflatlayerinfo.b()) {
            worldgenflatlayerinfo = (WorldGenFlatLayerInfo) iterator.next();
            worldgenflatlayerinfo.b(i);
        }

    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();

        stringbuilder.append(3);
        stringbuilder.append(";");

        int i;

        for (i = 0; i < this.layers.size(); ++i) {
            if (i > 0) {
                stringbuilder.append(",");
            }

            stringbuilder.append(((WorldGenFlatLayerInfo) this.layers.get(i)).toString());
        }

        stringbuilder.append(";");
        stringbuilder.append(this.c);
        if (!this.structures.isEmpty()) {
            stringbuilder.append(";");
            i = 0;
            Iterator iterator = this.structures.entrySet().iterator();

            while (iterator.hasNext()) {
                Entry entry = (Entry) iterator.next();

                if (i++ > 0) {
                    stringbuilder.append(",");
                }

                stringbuilder.append(((String) entry.getKey()).toLowerCase());
                Map map = (Map) entry.getValue();

                if (!map.isEmpty()) {
                    stringbuilder.append("(");
                    int j = 0;
                    Iterator iterator1 = map.entrySet().iterator();

                    while (iterator1.hasNext()) {
                        Entry entry1 = (Entry) iterator1.next();

                        if (j++ > 0) {
                            stringbuilder.append(" ");
                        }

                        stringbuilder.append((String) entry1.getKey());
                        stringbuilder.append("=");
                        stringbuilder.append((String) entry1.getValue());
                    }

                    stringbuilder.append(")");
                }
            }
        } else {
            stringbuilder.append(";");
        }

        return stringbuilder.toString();
    }

    private static WorldGenFlatLayerInfo a(int i, String s, int j) {
        String[] astring = i >= 3 ? s.split("\\*", 2) : s.split("x", 2);
        int k = 1;
        int l = 0;

        if (astring.length == 2) {
            try {
                k = Integer.parseInt(astring[0]);
                if (j + k >= 256) {
                    k = 256 - j;
                }

                if (k < 0) {
                    k = 0;
                }
            } catch (Throwable throwable) {
                return null;
            }
        }

        Block block = null;

        try {
            String s1 = astring[astring.length - 1];

            if (i < 3) {
                astring = s1.split(":", 2);
                if (astring.length > 1) {
                    l = Integer.parseInt(astring[1]);
                }

                block = Block.getById(Integer.parseInt(astring[0]));
            } else {
                astring = s1.split(":", 3);
                block = astring.length > 1 ? Block.getByName(astring[0] + ":" + astring[1]) : null;
                if (block != null) {
                    l = astring.length > 2 ? Integer.parseInt(astring[2]) : 0;
                } else {
                    block = Block.getByName(astring[0]);
                    if (block != null) {
                        l = astring.length > 1 ? Integer.parseInt(astring[1]) : 0;
                    }
                }

                if (block == null) {
                    return null;
                }
            }

            if (block == Blocks.AIR) {
                l = 0;
            }

            if (l < 0 || l > 15) {
                l = 0;
            }
        } catch (Throwable throwable1) {
            return null;
        }

        WorldGenFlatLayerInfo worldgenflatlayerinfo = new WorldGenFlatLayerInfo(i, k, block, l);

        worldgenflatlayerinfo.b(j);
        return worldgenflatlayerinfo;
    }

    private static List<WorldGenFlatLayerInfo> a(int i, String s) {
        if (s != null && s.length() >= 1) {
            ArrayList arraylist = Lists.newArrayList();
            String[] astring = s.split(",");
            int j = 0;
            String[] astring1 = astring;
            int k = astring.length;

            for (int l = 0; l < k; ++l) {
                String s1 = astring1[l];
                WorldGenFlatLayerInfo worldgenflatlayerinfo = a(i, s1, j);

                if (worldgenflatlayerinfo == null) {
                    return null;
                }

                arraylist.add(worldgenflatlayerinfo);
                j += worldgenflatlayerinfo.b();
            }

            return arraylist;
        } else {
            return null;
        }
    }

    public static WorldGenFlatInfo a(String s) {
        if (s == null) {
            return e();
        } else {
            String[] astring = s.split(";", -1);
            int i = astring.length == 1 ? 0 : MathHelper.a(astring[0], 0);

            if (i >= 0 && i <= 3) {
                WorldGenFlatInfo worldgenflatinfo = new WorldGenFlatInfo();
                int j = astring.length == 1 ? 0 : 1;
                List list = a(i, astring[j++]);

                if (list != null && !list.isEmpty()) {
                    worldgenflatinfo.c().addAll(list);
                    worldgenflatinfo.d();
                    int k = BiomeBase.PLAINS.id;

                    if (i > 0 && astring.length > j) {
                        k = MathHelper.a(astring[j++], k);
                    }

                    worldgenflatinfo.a(k);
                    if (i > 0 && astring.length > j) {
                        String[] astring1 = astring[j++].toLowerCase().split(",");
                        String[] astring2 = astring1;
                        int l = astring1.length;

                        for (int i1 = 0; i1 < l; ++i1) {
                            String s1 = astring2[i1];
                            String[] astring3 = s1.split("\\(", 2);
                            HashMap hashmap = Maps.newHashMap();

                            if (astring3[0].length() > 0) {
                                worldgenflatinfo.b().put(astring3[0], hashmap);
                                if (astring3.length > 1 && astring3[1].endsWith(")") && astring3[1].length() > 1) {
                                    String[] astring4 = astring3[1].substring(0, astring3[1].length() - 1).split(" ");

                                    for (int j1 = 0; j1 < astring4.length; ++j1) {
                                        String[] astring5 = astring4[j1].split("=", 2);

                                        if (astring5.length == 2) {
                                            hashmap.put(astring5[0], astring5[1]);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        worldgenflatinfo.b().put("village", Maps.newHashMap());
                    }

                    return worldgenflatinfo;
                } else {
                    return e();
                }
            } else {
                return e();
            }
        }
    }

    public static WorldGenFlatInfo e() {
        WorldGenFlatInfo worldgenflatinfo = new WorldGenFlatInfo();

        worldgenflatinfo.a(BiomeBase.PLAINS.id);
        worldgenflatinfo.c().add(new WorldGenFlatLayerInfo(1, Blocks.BEDROCK));
        worldgenflatinfo.c().add(new WorldGenFlatLayerInfo(2, Blocks.DIRT));
        worldgenflatinfo.c().add(new WorldGenFlatLayerInfo(1, Blocks.GRASS));
        worldgenflatinfo.d();
        worldgenflatinfo.b().put("village", Maps.newHashMap());
        return worldgenflatinfo;
    }
}
