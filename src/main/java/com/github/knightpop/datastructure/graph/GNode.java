package com.github.knightpop.datastructure.graph;

import java.util.*;

public class GNode<T> {
    public final T data;
    private List<GNode<T>> friend = new ArrayList<GNode<T>>();

    public GNode(T data) {
        this.data = data;
    }

    public void addChild(T value) {
        this.addChild(new GNode<T>(value));
    }

    public void addChild(GNode<T> child) {
        friend.add(child);
    }

    public List<GNode<T>> getChildrend() {
        return friend;
    }

    public GNode<T> getChildByIdx(Integer idx) {
        return friend.get(idx);
    }

    public T getChildDataByIdx(Integer idx) {
        return getChildByIdx(idx).data;
    }
}
