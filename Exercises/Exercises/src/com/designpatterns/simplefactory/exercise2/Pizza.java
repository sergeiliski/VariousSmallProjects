package com.designpatterns.simplefactory.exercise2;

public abstract class Pizza {
	private String mainIngredient;

	public String getMainIngredient() {
		return mainIngredient;
	}

	public void setMainIngredient(String mainIngredient) {
		this.mainIngredient = mainIngredient;
	}

	public abstract String getDescription();
}
