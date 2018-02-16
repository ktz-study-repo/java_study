package com.example.ktz.algorithm.queue;

import com.example.ktz.algorithm.linkedlist.Node;

public class Ex05 {
    public static Node<Integer> top = null;
    public static void main(String[] args) {
        push(4, top);
        push(5, top);
        push(3, top);
        push(1, top);
        push(2, top);
        System.out.println(pop());
    }

    public static void push(Integer valueToAdd, Node<Integer> pointer) {
        if(pointer == null) {
            top = mkNode(valueToAdd);
        } else if(valueToAdd < pointer.value){
            Node<Integer> valueToAddNode = mkNode(valueToAdd);
            valueToAddNode.next = top;
            top = valueToAddNode;
        } else if(valueToAdd > pointer.value && pointer.next == null){
            Node<Integer> valueToAddNode = mkNode(valueToAdd);
            pointer.next = valueToAddNode;
        } else if(valueToAdd > pointer.value && valueToAdd < pointer.next.value) {
            Node<Integer> valueToAddNode = new Node<Integer>(valueToAdd);
            valueToAddNode.next = pointer.next;
            pointer.next = valueToAddNode;
        } else {
            push(valueToAdd, pointer.next);
        }
    }

    public static Integer pop() {
        if(isEmpty()) return null;
        else {
            Integer result = top.value;
            top = top.next;
            return result;
        }
    }

    public static Integer peek() {
        return top.value;
    }

    public static boolean isEmpty() {
        return top == null;
    }

    private static Node<Integer> mkNode(Integer value) {
        return new Node<Integer>(value);
    }
}

