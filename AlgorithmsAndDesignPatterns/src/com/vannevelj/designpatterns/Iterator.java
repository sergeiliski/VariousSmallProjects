package com.vannevelj.designpatterns;

public class Iterator {

}

class Food {
    String name;

    public Food(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class FoodIterator implements java.util.Iterator<Food> {
    private final Food[] food;
    private int offset;
    
    public FoodIterator(Food[] food){
        this.food = food;
    }

    @Override
    public boolean hasNext() {
        return offset == food.length || food[offset] == null;
    }

    @Override
    public Food next() {
        if(hasNext()){
            return food[offset++];
        }
        return null;
    }    
}
