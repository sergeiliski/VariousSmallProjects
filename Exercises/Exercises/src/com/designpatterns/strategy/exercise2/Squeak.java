package com.designpatterns.strategy.exercise2;

public class Squeak implements QuackBehavior {
	@Override
	public String quack() {
		return "Piep";
	}
}
