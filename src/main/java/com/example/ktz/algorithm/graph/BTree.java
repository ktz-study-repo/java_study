package com.example.ktz.algorithm.graph;

public class BTree<T> {
    public T value;
    public BTree<T> left;
    public BTree<T> right;

    public BTree(T value) {
        this.value = value;
    }
}
