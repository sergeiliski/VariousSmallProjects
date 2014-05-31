package com.designpatterns.decorator.exercise1;

public class Milk extends CoffeeDecorator {
	public Milk(Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}

	@Override
	public double getCost() {
		return decoratedCoffee.getCost() + 0.5;
	}

	@Override
	public String getIngredients() {
		return super.getIngredients() + separator + "Milk";
	}
}
