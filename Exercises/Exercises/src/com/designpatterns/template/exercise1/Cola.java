package com.designpatterns.template.exercise1;

public class Cola extends CaffeineBeverage{

	@Override
	protected void brew() {
		System.out.println("Nobody knows this part..");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Add Speed. No hasj! Wait.. Cocaine?");
	}

}
