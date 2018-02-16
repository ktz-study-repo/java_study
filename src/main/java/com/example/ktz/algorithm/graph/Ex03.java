package com.example.ktz.algorithm.graph;

import java.util.List;
import java.util.LinkedList;

public class Ex03 {
    public static void main(String[] args) {
        BTree<Integer> root = new BTree<Integer>(1);
        BTree<Integer> item1_1 = new BTree<Integer>(11);
        BTree<Integer> item1_2 = new BTree<Integer>(12);
        BTree<Integer> item2_1 = new BTree<Integer>(22);
        root.left = item1_1;
        root.right = item1_2;
        item1_2.left = item2_1;
        List<List<BTree<Integer>>> result = mkLinkedList(root, 0, new LinkedList<List<BTree<Integer>>>());
        System.out.println(result);
    }

    public static List<List<BTree<Integer>>> mkLinkedList(BTree<Integer> root, Integer index, List<List<BTree<Integer>>> acc) {
        if(root == null) return acc;
        else {
            addBTree(acc, root, index);
            mkLinkedList(root.left, index + 1, acc);
            mkLinkedList(root.right, index + 1, acc);
            return acc;
        }
    }

    public static void addBTree(List<List<BTree<Integer>>> acc, BTree<Integer> valueToAdd, Integer index) {
        while(acc.size() < index +1) {
            acc.add(new LinkedList<BTree<Integer>>());
        }
        acc.get(index).add(valueToAdd);
    }
}
