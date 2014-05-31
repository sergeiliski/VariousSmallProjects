package com.vannevelj.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Composite {

}

interface Element {
    void print();
}

class Proton implements Element {
    @Override
    public void print() {
        System.out.println("Proton");
    } 
}

class Atom implements Element {
    private List<Element> subElements = new ArrayList<>();

    @Override
    public void print() {
        for(Element e : subElements){
            e.print();
        }
    }
    
    public void add(Element e){
        subElements.add(e);
    }
}
