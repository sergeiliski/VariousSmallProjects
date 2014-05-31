package com.designpatterns.simplefactory.exercise2;

public class PizzaFactory {
	public static Pizza orderPizza(String type) {
		switch (type.toLowerCase()) {
		case "cheese":
			return new CheesePizza();
		case "hawai":
			return new HawaiPizza();
		case "mozarella":
			return new MozarellaPizza();
		default:
			return null;
		}
	}
}
