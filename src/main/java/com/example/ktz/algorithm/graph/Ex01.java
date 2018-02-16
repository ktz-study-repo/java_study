package com.example.ktz.algorithm.graph;

public class Ex01 {

    public static void main(String[] args) {
        GNode<Integer> root = new GNode<Integer>(1);
        GNode<Integer> item2 = new GNode<Integer>(2);
        GNode<Integer> item3 = new GNode<Integer>(3);
        GNode<Integer> item4 = new GNode<Integer>(4);
        root.addNode(item2);
        item2.addNode(item3);
        System.out.println(hasRoutes(root, 3));
        System.out.println(hasRoutes(root, 4));
    }

    public static boolean hasRoutes(GNode<Integer> from, Integer target) {
        if(from == null) return false;
        else if(from.value == target) return true;
        else {
            return from.nodes.stream()
                    .reduce(false,
                            (acc, nextNode) -> acc || hasRoutes(nextNode, target),
                            (acc1, acc2) -> acc1 || acc2);
        }
    }
}
