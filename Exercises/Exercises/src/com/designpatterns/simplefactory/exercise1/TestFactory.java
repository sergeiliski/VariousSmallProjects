package com.designpatterns.simplefactory.exercise1;

import java.util.Scanner;

public class TestFactory {
	private Scanner input = new Scanner(System.in);
	private Display display = null;

	public TestFactory() {
		String choice = input.nextLine();
		if (choice.equals("CSV")) {
			display = new CSVfile();
		} else if (choice.equals("XML")) {
			display = new XMLfile();
		} else if (choice.equals("DB")) {
			display = new DBfile();
		}
		display.load("");
		display.formatConsistency();
	}

}
