package com.designpatterns.decorator.exercise1;

public class Sprinkles extends CoffeeDecorator {
	public Sprinkles(Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}

	@Override
	public double getCost() {
		return decoratedCoffee.getCost() + 0.65;
	}

	@Override
	public String getIngredients() {
		return decoratedCoffee.getIngredients() + separator + "Sprinkles";
	}
}
