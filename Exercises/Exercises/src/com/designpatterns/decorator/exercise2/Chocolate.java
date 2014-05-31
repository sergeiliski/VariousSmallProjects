package com.designpatterns.decorator.exercise2;

public class Chocolate implements Icecream {
	@Override
	public double getCost() {
		return 1.10;
	}

	@Override
	public String getDescription() {
		return "Chocolate ice";
	}
}
