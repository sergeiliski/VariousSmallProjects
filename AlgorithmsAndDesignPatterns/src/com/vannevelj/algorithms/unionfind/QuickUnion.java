package com.vannevelj.algorithms.unionfind;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class QuickUnion<T> {
    private final Map<T, T> components = new HashMap<>();

    public QuickUnion(T[] components) {
        for (T component : components) {
            this.components.put(component, component);
        }
    }

    public void connect(T leftComponent, T rightComponent) {
        Objects.requireNonNull(leftComponent, "leftComponent");
        Objects.requireNonNull(rightComponent, "rightComponent");

        if (areConnected(leftComponent, rightComponent)) {
            return;
        }

        T leftComponentTree = find(leftComponent);
        T rightComponentTree = find(rightComponent);

        components.put(leftComponentTree, rightComponentTree);
    }

    private T find(T component) {
        while (!component.equals(components.get(component))) {
            component = components.get(component);
        }
        return component;
    }

    public boolean areConnected(T leftComponent, T rightComponent) {
        Objects.requireNonNull(leftComponent, "leftComponent");
        Objects.requireNonNull(rightComponent, "rightComponent");
        return find(leftComponent).equals(find(rightComponent));
    }
}
