package com.designpatterns.simplefactory.exercise1;

public class XMLfile implements Display {

	@Override
	public void load(String fileName) {
		System.out.println("Loading XML file");
	}

	@Override
	public void formatConsistency() {
		System.out.println("Formatting XML file");
	}

}
