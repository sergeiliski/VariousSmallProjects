package com.designpatterns.template.exercise1;

public class StartUp {
	public static void main(String[] args) {
		CaffeineBeverage drink1 = new Cola();
		CaffeineBeverage drink2 = new Coffee();
		System.out.println("Drink 1:");
		drink1.boilWater();
		drink1.brew();
		drink1.addCondiments();
		
		System.out.println("\nDrink 2:");
		drink2.boilWater();
		drink2.brew();
		drink2.addCondiments();
	}
}
