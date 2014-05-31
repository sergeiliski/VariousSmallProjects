package com.designpatterns.strategy.exercise2;

public class Quack implements QuackBehavior {
	@Override
	public String quack() {
		return "Ik kwaak";
	}
}
