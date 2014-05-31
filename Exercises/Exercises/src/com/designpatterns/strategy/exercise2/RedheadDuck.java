package com.designpatterns.strategy.exercise2;

public class RedheadDuck extends Duck {
	public RedheadDuck()
	{
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}

	@Override
	public String display()
	{
		return "Ik lijk op eenroodkuifeend";
	}
}
