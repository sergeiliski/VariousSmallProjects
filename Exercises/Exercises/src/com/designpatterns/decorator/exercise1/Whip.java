package com.designpatterns.decorator.exercise1;

public class Whip extends CoffeeDecorator {
	public Whip(Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}

	@Override
	public double getCost() {
		return decoratedCoffee.getCost() + 0.25;
	}

	@Override
	public String getIngredients() {
		return decoratedCoffee.getIngredients() + separator + "Whip";
	}
}
