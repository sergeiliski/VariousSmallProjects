package com.designpatterns.state.exercise1;

public class Controller {
	public Accounting accounting;
	public Sales sales;
	public Management management;
	private Connection current;

	public Controller() {
		accounting = new Accounting();
		sales = new Sales();
		management = new Management();
	}

	public void createAccountingConnection() {
		current = accounting;
	}

	public void createSalesConnection() {
		current = sales;
	}

	public void CreateManagementConnection() {
		current = management;
	}

	public void open() {
		current.open();
	}

	public void close() {
		current.close();
	}

	public void log() {
		current.log();
	}
}
