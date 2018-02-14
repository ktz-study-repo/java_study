package com.example.ktz.algorithm.linkedlist;

public class Ex04 {
    public static void main(String[] args) {
        Node<Integer> ints = new Node<Integer>( 5, 8, 5, 10, 2, 1);
        Node<Integer> lt = new Node<Integer>(3);
        Node<Integer> get = new Node<Integer>(5);
        Node<Integer> head = lt;
        lt.next = get;
        partitioning(ints, 5, head, lt, get);
        System.out.println(head);
    }

    public static Node<Integer> partitioning(Node<Integer> ints, Integer target, Node<Integer> head, Node<Integer> lt, Node<Integer> get) {
        if(ints == null) {
            return head;
        } else if(ints.value < target) {
            Node<Integer> newValue = new Node<Integer>(ints.value);
            newValue.next = lt.next;
            lt.next = newValue;
            lt = newValue;
            return partitioning(ints.next, target, head, lt, get);
        } else {
            Node<Integer> newValue = new Node<Integer>(ints.value);
            get.next = newValue;
            get = newValue;
            return partitioning(ints.next, target, head, lt, get);
        }
    }
}
