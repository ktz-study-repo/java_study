package com.example.ktz.algorithm.linkedlist;

public class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T value) {
        this.value = value;
    }

    public Node(T... values) {
        this.value = values[0];
        this.next = mkLinkedList(values);
    }

    public Node<T> mkLinkedList(T... values) {
        Node<T> head = new Node<T>(values[1]);
        Node<T> pointer = head;
        for(int i = 2; i < values.length; i++ ) {
            pointer.next = new Node<T>(values[i]);
            pointer = pointer.next;
        }

        return head;
    }
}
