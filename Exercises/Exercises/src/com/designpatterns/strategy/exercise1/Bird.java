package com.designpatterns.strategy.exercise1;

public class Bird extends Animal {

	public Bird() {
		super();
		setSound("Tweet");
		flyingType = new ItFlies();
	}

}
