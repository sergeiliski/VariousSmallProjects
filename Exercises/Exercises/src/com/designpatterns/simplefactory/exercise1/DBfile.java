package com.designpatterns.simplefactory.exercise1;

public class DBfile implements Display {

	@Override
	public void load(String fileName) {
		System.out.println("Loading DB file");
	}

	@Override
	public void formatConsistency() {
		System.out.println("Formatting DB file");
	}

}
