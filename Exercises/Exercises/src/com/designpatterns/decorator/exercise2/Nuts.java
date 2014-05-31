package com.designpatterns.decorator.exercise2;

public class Nuts extends Decorator {
	public Nuts(Icecream decoratedIcecream) {
		super(decoratedIcecream);
	}

	@Override
	public double getCost() {
		return decoratedIcecream.getCost() + 0.35;
	}

	@Override
	public String getDescription() {
		return decoratedIcecream.getDescription() + ", Nuts";
	}
}
