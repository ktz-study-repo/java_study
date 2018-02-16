package com.example.ktz.algorithm.graph;

import java.util.List;
import java.util.ArrayList;

public class GNode<T> {
    public List<GNode<T>> nodes;
    public T value;

    public GNode(T value) {
        this.nodes = new ArrayList<GNode<T>>();
        this.value = value;
    }

    public void addNode(GNode<T> nodeToAdd) {
        nodes.add(nodeToAdd);
    }

    public void addNode(GNode<T>... nodesToAdd) {
        for(GNode<T> item: nodesToAdd) {
            nodes.add(item);
        }
    }
}
