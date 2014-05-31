package com.designpatterns.simplefactory.exercise2;

import java.util.Scanner;

public class PizzaStore {
	public PizzaStore() {
		Scanner input = new Scanner(System.in);
		String message;
		while (!(message = input.nextLine()).equals("end")) {
			PizzaFactory.orderPizza(message);
		}
	}
}
