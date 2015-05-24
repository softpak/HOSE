package net.minecraft.server;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class AttributeMapBase {

    protected final Map<IAttribute, AttributeInstance> a = Maps.newHashMap();
    protected final Map<String, AttributeInstance> b = new InsensitiveStringMap();
    protected final Multimap<IAttribute, IAttribute> c = HashMultimap.create();

    public AttributeMapBase() {}

    public AttributeInstance a(IAttribute iattribute) {
        return (AttributeInstance) this.a.get(iattribute);
    }

    public AttributeInstance a(String s) {
        return (AttributeInstance) this.b.get(s);
    }

    public AttributeInstance b(IAttribute iattribute) {
        if (this.b.containsKey(iattribute.getName())) {
            throw new IllegalArgumentException("Attribute is already registered!");
        } else {
            AttributeInstance attributeinstance = this.c(iattribute);

            this.b.put(iattribute.getName(), attributeinstance);
            this.a.put(iattribute, attributeinstance);

            for (IAttribute iattribute1 = iattribute.d(); iattribute1 != null; iattribute1 = iattribute1.d()) {
                this.c.put(iattribute1, iattribute);
            }

            return attributeinstance;
        }
    }

    protected abstract AttributeInstance c(IAttribute iattribute);

    public Collection<AttributeInstance> a() {
        return this.b.values();
    }

    public void a(AttributeInstance attributeinstance) {}

    public void a(Multimap<String, AttributeModifier> multimap) {
        Iterator iterator = multimap.entries().iterator();

        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            AttributeInstance attributeinstance = this.a((String) entry.getKey());

            if (attributeinstance != null) {
                attributeinstance.c((AttributeModifier) entry.getValue());
            }
        }

    }

    public void b(Multimap<String, AttributeModifier> multimap) {
        Iterator iterator = multimap.entries().iterator();

        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            AttributeInstance attributeinstance = this.a((String) entry.getKey());

            if (attributeinstance != null) {
                attributeinstance.c((AttributeModifier) entry.getValue());
                attributeinstance.b((AttributeModifier) entry.getValue());
            }
        }

    }
}
