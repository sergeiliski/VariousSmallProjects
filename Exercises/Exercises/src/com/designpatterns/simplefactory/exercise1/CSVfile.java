package com.designpatterns.simplefactory.exercise1;

public class CSVfile implements Display {

	@Override
	public void load(String fileName) {
		System.out.println("Loading CSV file");
	}

	@Override
	public void formatConsistency() {
		System.out.println("Formatting CSV file");
	}

}
