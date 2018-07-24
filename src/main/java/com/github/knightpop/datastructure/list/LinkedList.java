package com.github.knightpop.datastructure.list;

import com.github.knightpop.datastructure.Node;

public class LinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;

    public LinkedList(T... values) {
        for(T elem: values) {
            append(elem);
        }
    }

    public void append(T value) {
        Node<T> elemToAppend = new Node<T>(value);
        if(isEmpty()) {
            head = elemToAppend;
            tail = elemToAppend;
        } {
            tail.next = elemToAppend;
            tail = tail.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> pointer = head;
        while(pointer != null) {
            stringBuilder.append(pointer.data);
            stringBuilder.append(',');
            pointer = pointer.next;
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }
}
