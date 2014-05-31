package com.designpatterns.simplefactory.exercise2;

public class MozarellaPizza extends Pizza {
	public MozarellaPizza() {
		setMainIngredient("Mozarella");
		System.out.println(getDescription());
	}

	@Override
	public String getDescription() {
		return ("You have chosen for a pizza with " + getMainIngredient().toLowerCase() + ". Yummy!");
	}
}
