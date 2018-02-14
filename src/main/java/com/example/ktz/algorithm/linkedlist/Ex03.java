package com.example.ktz.algorithm.linkedlist;

public class Ex03 {
    public static void main(String[] args) {
        Node<Integer> nodes = new Node<Integer>(1,2,3,4,5,6);
        delete(nodes, 19);
        System.out.println(nodes);
    }

    public static void delete(Node<Integer> nodes, Integer target) {
        if (nodes.next != null) {
            if(nodes.next.value == target) {
                nodes.next = nodes.next.next;
            } else {
                delete(nodes.next, target);
            }
        }
    }
}
