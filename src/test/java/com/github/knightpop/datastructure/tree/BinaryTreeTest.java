package com.github.knightpop.datastructure.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void InsertTest() {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>(1, 2, 3, 4, 5);

        integerBinaryTree.printByDepth();

    }

}