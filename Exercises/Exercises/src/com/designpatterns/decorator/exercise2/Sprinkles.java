package com.designpatterns.decorator.exercise2;

public class Sprinkles extends Decorator {
	public Sprinkles(Icecream decoratedIcecream) {
		super(decoratedIcecream);
	}

	@Override
	public double getCost() {
		return decoratedIcecream.getCost() + 0.30;
	}

	@Override
	public String getDescription() {
		return decoratedIcecream.getDescription() + ", Sprinkles";
	}
}
