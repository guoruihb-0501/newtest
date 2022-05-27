package com.future.test;

public interface GenericInterfaceDemo<T> {
    void add(T t);
    void update(T t);
    T query(String s);
}
