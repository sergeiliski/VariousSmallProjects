package com.designpatterns.strategy.exercise2;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		setQuackBehavior(new MuteQuack());
		setFlyBehavior(new FlyNoWay());
	}

	@Override
	public String display() {
		return "Ik ben een lokeend";
	}
}
