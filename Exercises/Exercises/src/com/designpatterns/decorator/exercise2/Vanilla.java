package com.designpatterns.decorator.exercise2;

public class Vanilla implements Icecream {
	@Override
	public double getCost() {
		return 1.00;
	}

	@Override
	public String getDescription() {
		return "Vanilla ice";
	}
}
