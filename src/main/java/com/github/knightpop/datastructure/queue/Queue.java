package com.github.knightpop.datastructure.queue;

import com.github.knightpop.datastructure.Node;

public class Queue<T> {
    private Node<T> head = null;
    private Node<T> tail = null;

    public Queue(T... values) {
        for(T elem: values) {
            enqueue(elem);
        }
    }

    public void enqueue(T value) {
        Node<T> newTail = new Node<T>(value);
        if(isEmpty()) {
            this.head = newTail;
            this.tail = newTail;
        } else {
            this.tail.next = newTail;
            newTail.prev = this.tail;
            this.tail = newTail;
        }
    }

    public T dequeue() {
        if(isEmpty()) {
            return null;
        } else {
            Node<T> tailToReturn = this.tail;
            this.tail = tailToReturn.prev;
            this.tail.next = null;
            return tailToReturn.data;
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}
