package com.designpatterns.template.exercise1;

public class Coffee extends CaffeineBeverage{

	@Override
	protected void brew() {
		System.out.println("Mix, mix, swirl, mix.");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Here's a little sugar from daddy!");
	}

}
