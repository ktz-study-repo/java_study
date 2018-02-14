package com.example.ktz.algorithm.linkedlist;

public class Ex02 {
    public static void main(String[] args) {
        Node<Integer> ints = new Node<Integer>(1,2,3,4,5);
        System.out.println(kth(ints, 2));
    }

    public static Integer kth(Node<Integer> ints, Integer k) {
        if(ints.next == null) {
            return null;
        } else if(k == 0) {
            return ints.value;
        } else {
            return kth(ints.next, k - 1);
        }
    }
}
