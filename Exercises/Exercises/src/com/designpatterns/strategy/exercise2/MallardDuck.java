package com.designpatterns.strategy.exercise2;

public class MallardDuck extends Duck {
	public MallardDuck()
	{
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}

	@Override
	public String display()
	{
		return "Ik ben een echte wilde eend";
	}
}
