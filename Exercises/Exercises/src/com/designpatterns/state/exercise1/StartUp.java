package com.designpatterns.state.exercise1;

import java.util.Scanner;

public class StartUp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Controller controller = new Controller();

		System.out.println("Enter departement: ");
		String choice = input.nextLine();
		if (choice.equalsIgnoreCase("Accounting")) {
			controller.createAccountingConnection();
		} else if (choice.equalsIgnoreCase("Sales")) {
			controller.createSalesConnection();
		} else if (choice.equalsIgnoreCase("Management")) {
			controller.CreateManagementConnection();
		}

		controller.open();
		controller.close();
		controller.log();
	}
}
