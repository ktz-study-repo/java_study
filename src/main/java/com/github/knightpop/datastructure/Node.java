package com.github.knightpop.datastructure;

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node(T value) {
        this.data = value;
    }
}
