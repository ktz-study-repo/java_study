package com.github.knightpop.datastructure.stack;

import com.github.knightpop.datastructure.Node;

public class LinkedStack<T> {
    Node<T> head = null;
    public LinkedStack(T... values) {
        for(T ele: values) {
            push(ele);
        }
    }

    public void push(T value) {
        Node<T> newHead = new Node<T>(value);
        newHead.next = head;
        head = newHead;
    }

    public T pop() {
        Node<T> valueToReturn = head;
        head = head.next;
        return valueToReturn.data;
    }
}
