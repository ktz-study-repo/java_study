package com.example.ktz.algorithm.graph;

import java.util.*;
import java.util.stream.Collectors;

public class Ex11 {
    public static void main(String[] args) {
        BTree<Integer> root = new BTree<Integer>(1);
        BTree<Integer> item1_1 = new BTree<Integer>(11);
        BTree<Integer> item1_2 = new BTree<Integer>(12);
        BTree<Integer> item2_1 = new BTree<Integer>(22);
        root.left = item1_1;
        root.right = item1_2;
        item1_2.left = item2_1;
        Integer idx = getDepth(root, 0);
        Integer randomIdx = (new Random()).nextInt(idx + 1);
        BTree<Integer> result = getNode(root, randomIdx);
        System.out.println(result);
        Set<String> set = new HashSet<>(Arrays.asList("Hello World"));
        Map<Character, Integer> map = new HashMap<>();

    }

    public static BTree<Integer> getNode(BTree<Integer> root, Integer idx) {
        if(idx == 0) {
            return root;
        } else {
            Integer leftDepth = getDepth(root.left, idx - 1);
            if(leftDepth < idx)
                return getNode(root.right, idx - 1);
            else
                return getNode(root.left, idx - 1);
        }
    }

    public static Integer getDepth(BTree<Integer> root, Integer depth) {
        if(root == null) {
            return depth - 1;
        } else {
            Integer leftDepth = getDepth(root.left, depth + 1);
            Integer rightDepth = getDepth(root.right, leftDepth + 1);
            return rightDepth;
        }
    }
}
