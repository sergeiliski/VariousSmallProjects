package com.vannevelj.algorithms.unionfind;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WeightedQuickUnionWithPathCompression<T> {
    private final Map<T, T> components = new HashMap<>();
    private final Map<T, Integer> treeSizes = new HashMap<>();

    public WeightedQuickUnionWithPathCompression(T[] components) {
        for (T component : components) {
            this.components.put(component, component);
            this.treeSizes.put(component, 1);
        }
    }

    public void connect(T leftComponent, T rightComponent) {
        Objects.requireNonNull(leftComponent, "leftComponent");
        Objects.requireNonNull(rightComponent, "rightComponent");

        T leftComponentTree = find(leftComponent);
        T rightComponentTree = find(rightComponent);
        
        if(leftComponentTree == rightComponentTree){
            return;
        }

        int leftTreeSize = getTreeSize(leftComponentTree);
        int rightTreeSize = getTreeSize(rightComponentTree);
        if (leftTreeSize < rightTreeSize) {
            components.put(leftComponentTree, rightComponentTree);
            treeSizes.put(rightComponentTree, leftTreeSize + rightTreeSize);
        } else {
            components.put(rightComponentTree, leftComponentTree);
            treeSizes.put(leftComponentTree, leftTreeSize + rightTreeSize);
        }
    }

    private T find(T component) {
        T parent;
        T grandparent;
        while (component != (parent = components.get(component))) {
            components.put(component, (grandparent = components.get(parent))); // Path compression
            component = grandparent;
        }
        return component;
    }

    private int getTreeSize(T component) {
        return treeSizes.get(component);
    }

    public boolean areConnected(T leftComponent, T rightComponent) {
        Objects.requireNonNull(leftComponent, "leftComponent");
        Objects.requireNonNull(rightComponent, "rightComponent");
        return find(leftComponent)== find(rightComponent);
    }
}
