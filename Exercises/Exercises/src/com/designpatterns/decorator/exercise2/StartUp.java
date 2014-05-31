package com.designpatterns.decorator.exercise2;

import java.text.DecimalFormat;

public class StartUp {
	public static void main(String[] args) {
		Icecream icecream = new Vanilla();
		showDetails(icecream);

		icecream = new Sprinkles(icecream);
		showDetails(icecream);

		icecream = new WhippedCream(icecream);
		showDetails(icecream);

		Icecream icecream2 = new Nuts(new Chocolate());
		showDetails(icecream2);

		icecream2 = new Sprinkles(icecream2);
		showDetails(icecream2);

		Icecream icecream3 = new Vanilla();
		showDetails(icecream3);

		icecream3 = new Nuts(icecream3);
		showDetails(icecream3);

		icecream3 = new Sprinkles(icecream3);
		showDetails(icecream3);
	}

	private static void showDetails(Icecream icecream) {
		String dblOutput = new DecimalFormat("#.00").format(icecream.getCost());
		System.out.println("Cost: " + dblOutput + "\t" + "Description: " + icecream.getDescription());
	}
}
