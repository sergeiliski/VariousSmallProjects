package com.designpatterns.simplefactory.exercise2;

public class HawaiPizza extends Pizza {
	public HawaiPizza() {
		setMainIngredient("Ananas");
		System.out.println(getDescription());
	}

	@Override
	public String getDescription() {
		return ("You have chosen for a pizza with " + getMainIngredient());
	}
}
