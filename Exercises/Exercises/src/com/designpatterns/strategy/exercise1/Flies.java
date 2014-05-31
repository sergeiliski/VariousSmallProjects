package com.designpatterns.strategy.exercise1;

public interface Flies {

	String fly();

}

class ItFlies implements Flies {

	@Override
	public String fly() {
		return "Flying high";
	}

}

class CantFly implements Flies {

	@Override
	public String fly() {
		return "I can't fly";
	}

}