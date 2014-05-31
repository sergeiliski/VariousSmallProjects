package com.designpatterns.decorator.exercise2;

public class WhippedCream extends Decorator {
	public WhippedCream(Icecream decoratedIcecream) {
		super(decoratedIcecream);
	}

	@Override
	public double getCost() {
		return decoratedIcecream.getCost() + 0.40;
	}

	@Override
	public String getDescription() {
		return decoratedIcecream.getDescription() + ", Whipped cream";
	}
}
