package com.designpatterns.strategy.exercise1;

public class Dog extends Animal {

	public Dog() {
		super();
		setSound("Bark");
		flyingType = new CantFly();
	}

	public void digHole() {
		System.out.println("Dug a hole");
	}
}
