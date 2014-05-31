package com.designpatterns.decorator.exercise1;

public abstract class CoffeeDecorator implements Coffee {

	protected Coffee decoratedCoffee;
	protected String separator = ", ";

	public CoffeeDecorator(Coffee decoratedCoffee) {
		this.decoratedCoffee = decoratedCoffee;
	}

	@Override
	public double getCost() {
		return decoratedCoffee.getCost();
	}

	@Override
	public String getIngredients() {
		return decoratedCoffee.getIngredients();
	}
}
