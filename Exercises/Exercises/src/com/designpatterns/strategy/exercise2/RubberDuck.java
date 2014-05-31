package com.designpatterns.strategy.exercise2;

public class RubberDuck extends Duck {

	public RubberDuck()
	{
		setQuackBehavior(new Squeak());
		setFlyBehavior(new FlyNoWay());
	}

	@Override
	public String display() {
		return "Ik ben een badeend";
	}

}
