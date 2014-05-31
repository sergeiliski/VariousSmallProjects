package com.vannevelj.designpatterns;

import com.vannevelj.designpatterns.SandwichBuilder.Sandwich;

public class Builder {
    Sandwich njammie = new SandwichBuilder()
                            .withCheese()
                            .withHam()
                            .withMayonaisse()
                            .build();
    
    //Sandwich s = new SandwichBuilder().new Sandwich();
}

class SandwichBuilder {
    private Sandwich sandwich;
    
    public SandwichBuilder(){
        this.sandwich = new Sandwich();
    }
    
    class Sandwich {
        private boolean salad;
        private boolean mayonaisse;
        private boolean ham;
        private boolean cheese;
        
        private Sandwich(){}
    }

    public SandwichBuilder withSalad() {
        sandwich.salad = true;
        return this;
    }

    public SandwichBuilder withMayonaisse() {
        sandwich.mayonaisse = true;
        return this;
    }

    public SandwichBuilder withHam() {
        sandwich.ham = true;
        return this;
    }

    public SandwichBuilder withCheese() {
        sandwich.cheese = true;
        return this;
    }
      
    public Sandwich build(){
        return sandwich;
    }
}
