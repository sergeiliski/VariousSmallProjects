package com.designpatterns.strategy.exercise1;

public class StartUp {

	public static void main(String[] args) {

		Animal sparky = new Dog();
		Animal tweety = new Bird();

		System.out.println("Dog: " + sparky.tryToFly());
		System.out.println("Bird: " + tweety.tryToFly());

		sparky.setFlyingAbility(new ItFlies());

		System.out.println("Dog: " + sparky.tryToFly());
		System.out.println(sparky.getSound());
	}

}
