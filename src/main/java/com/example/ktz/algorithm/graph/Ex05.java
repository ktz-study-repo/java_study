package com.example.ktz.algorithm.graph;

public class Ex05 {
    public static void main(String[] args) {
        BTree<Integer> root = new BTree<Integer>(10);
        BTree<Integer> item1_1 = new BTree<Integer>(1);
        BTree<Integer> item1_2 = new BTree<Integer>(12);
        BTree<Integer> item2_1 = new BTree<Integer>(11);
        root.left = item1_1;
        root.right = item1_2;
        item1_2.left = item2_1;
        System.out.println(checkBST(root));
    }

    public static boolean checkBST(BTree<Integer> root) {
        if(root == null)
            return true;
        else if ((root.left == null || root.left.value < root.value) && (root.right == null || root.right.value > root.value)){
            return checkBST(root.left) && checkBST(root.right);
        } else
            return false;
    }
}
