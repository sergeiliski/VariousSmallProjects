package com.designpatterns.template.exercise1;

public abstract class CaffeineBeverage {
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}

	protected abstract void brew();

	protected abstract void addCondiments();

	protected void boilWater() {
		System.out.println("Cooking water..");
	}

	protected void pourInCup() {
		System.out.println("Pooring in cup, enjoy!");
	}

	protected boolean customerWantsCondiments() {
		return true;
	}
}
