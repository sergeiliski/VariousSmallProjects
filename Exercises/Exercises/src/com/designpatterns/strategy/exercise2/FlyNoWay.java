package com.designpatterns.strategy.exercise2;

public class FlyNoWay implements FlyBehavior {
	@Override
	public String fly() {
		return "Ik kan niet vliegen";
	}
}
