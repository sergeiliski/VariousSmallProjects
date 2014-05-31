package com.designpatterns.simplefactory.exercise2;

public class CheesePizza extends Pizza {
	public CheesePizza() {
		setMainIngredient("Cheese");
		System.out.println(getDescription());
	}

	@Override
	public String getDescription() {
		return ("You have chosen for a pizza consisting of " + getMainIngredient());
	}
}
