package com.vannevelj.designpatterns;

public class Adapter {

}

interface Duck {
    void quack();
    void fly();
}

interface Turkey {
    void gobble();
    void fly();
}

class BathtubDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("shit i can't fly nigga");
    }
}

class OrdinaryTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("i believe i can fly");
    }
}

class TurkeyAdapter implements Duck {
    private Turkey turkey;
    
    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
