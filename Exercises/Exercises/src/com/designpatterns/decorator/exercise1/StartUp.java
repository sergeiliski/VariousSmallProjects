package com.designpatterns.decorator.exercise1;

public class StartUp {
	public static void main(String[] args) {
		Coffee coffee = new SimpleCoffee();
		System.out.println("Cost: " + coffee.getCost() + "\t" + "Ingredients: " + coffee.getIngredients());

		coffee = new Milk(coffee);
		System.out.println("Cost: " + coffee.getCost() + "\t" + "Ingredients: " + coffee.getIngredients());

		coffee = new Whip(coffee);
		System.out.println("Cost: " + coffee.getCost() + "\t" + "Ingredients: " + coffee.getIngredients());

		coffee = new Sprinkles(coffee);
		System.out.println("Cost: " + coffee.getCost() + "\t" + "Ingredients: " + coffee.getIngredients());

		coffee = new Whip(coffee);
		System.out.println("Cost: " + coffee.getCost() + "\t" + "Ingredients: " + coffee.getIngredients());
	}
}
