package net.minecraft.server;

import java.util.Collection;

public interface IBlockState<T extends Comparable<T>> {

    String a();

    Collection<T> c();

    Class<T> b();

    String a(T t0);
}
