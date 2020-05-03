package com.khlin.structure;

public interface Heap <T>{

    T root();

    T extractRoot();

    void insert(T node);

    void print();
}
