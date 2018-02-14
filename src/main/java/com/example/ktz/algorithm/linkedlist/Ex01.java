package com.example.ktz.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class Ex01 {
    public static boolean isDuplicated(List<Integer> ints, List<Integer> accs)  {
        if(ints.isEmpty()) {
            return false;
        } else {
            if(accs.contains(ints.get(0))) return true;
            else {
                accs.add(ints.get(0));
                return isDuplicated(ints.subList(1, ints.size()), accs);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> ints = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(isDuplicated(ints, new LinkedList<Integer>()));

        Node<Integer> a = new Node<Integer>(1);
        Node<Integer> b = new Node<Integer>(2);
        a.next = b;
        System.out.println(a.value);
        System.out.println(a.next.value);
    }
}

