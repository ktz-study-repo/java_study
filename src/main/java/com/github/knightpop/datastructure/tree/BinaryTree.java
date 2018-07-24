package com.github.knightpop.datastructure.tree;

import com.github.knightpop.datastructure.Node;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root = null;

    public BinaryTree(T... values) {
        for(T ele: values) {
            append(ele);
        }
    }

    public void append(T value) {
        this.root = appendRec(value, this.root);
    }

    private Node<T> appendRec(T value, Node<T> root) {
        if(root == null) {
            root = new Node<T>(value);
        } else if(value.compareTo(root.data) < 0) {
            root.prev = appendRec(value, root.prev);
        } else if(value.compareTo(root.data) > 0) {
            root.next = appendRec(value, root.next);
        }

        return root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void printByDepth() {
        printByDepthRec(this.root);
    }

    private void printByDepthRec(Node<T> root) {
        if(root != null) {
            System.out.println(root.data);
            printByDepthRec(root.prev);
            printByDepthRec(root.next);
        }
    }
}
