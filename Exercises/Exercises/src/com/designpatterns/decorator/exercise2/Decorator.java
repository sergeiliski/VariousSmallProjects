package com.designpatterns.decorator.exercise2;

public abstract class Decorator implements Icecream {
	protected Icecream decoratedIcecream;

	public Decorator(Icecream decoratedIcecream) {
		this.decoratedIcecream = decoratedIcecream;
	}

	@Override
	public abstract double getCost();

	@Override
	public abstract String getDescription();
}
