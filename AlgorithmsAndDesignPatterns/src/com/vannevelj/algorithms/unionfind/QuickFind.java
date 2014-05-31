package com.vannevelj.algorithms.unionfind;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class QuickFind<T> {
    private final Map<T, T> components = new HashMap<>();

    public QuickFind(T[] components) {
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

        T leftComponentSet = find(leftComponent);

        Iterator<Entry<T, T>> it = components.entrySet().iterator();
        while (it.hasNext()) {
            Entry<T, T> pair = it.next();
            if (pair.getValue().equals(leftComponentSet)) {
                pair.setValue(rightComponent);
            }
        }
    }

    private T find(T component) {
        return components.get(component);
    }

    public boolean areConnected(T leftComponent, T rightComponent) {
        Objects.requireNonNull(leftComponent, "leftComponent");
        Objects.requireNonNull(rightComponent, "rightComponent");
        return components.get(leftComponent).equals(components.get(rightComponent));
    }
}
