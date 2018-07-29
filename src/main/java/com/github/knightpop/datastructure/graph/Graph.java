package com.github.knightpop.datastructure.graph;

import java.util.*;

public class Graph<T> {
    private final GNode<T> root;

    public Graph(GNode<T> root) {
        this.root = root;
    }

    public void insert(GNode<T> targetNode, GNode<T> child) {
        targetNode.addChild(child);
    }

    public List<GNode<T>> toListByDFS() {
        List<GNode<T>> acc = new ArrayList<>();
        Stack<GNode<T>> children = new Stack<>();
        acc.add(root);
        children.addAll(root.getChildrend());
        while(!children.isEmpty()) {
            GNode<T> nextNode = children.pop();
            acc.add(nextNode);
            children.addAll(nextNode.getChildrend());
        }

        return acc;
    }

    public List<GNode<T>> toListByBFS() {
        List<GNode<T>> acc = new ArrayList<>();
        Queue<GNode<T>> children = new LinkedList<>();
        acc.add(root);
        children.addAll(root.getChildrend());
        while(!children.isEmpty()) {
            GNode<T> nextNode = children.poll();
            acc.add(nextNode);
            children.addAll(nextNode.getChildrend());
        }

        return acc;
    }

    public static void main(String[] args) {
        List<GNode<Integer>> gNodes = mkGNodes(7);
        gNodes.get(0).addChild(gNodes.get(1));
        gNodes.get(0).addChild(gNodes.get(2));
        gNodes.get(1).addChild(gNodes.get(3));
        gNodes.get(1).addChild(gNodes.get(4));
        gNodes.get(1).addChild(gNodes.get(5));
        gNodes.get(2).addChild(gNodes.get(6));
        Graph<Integer> integerGraph = new Graph<>(gNodes.get(0));
        integerGraph.toListByDFS().forEach(gNode -> System.out.println(gNode.data));
        System.out.println("\n");
        integerGraph.toListByBFS().forEach(gNode -> System.out.println(gNode.data));
    }

    public static List<GNode<Integer>> mkGNodes(Integer size) {
        List<GNode<Integer>> arr = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            arr.add(new GNode<Integer>(i));
        }

        return arr;
    }
}
