package com.designpatterns.abstractfactory;

public class SampleAbstractFactory {
	public static void main(String[] args) {
		new Wonderland(createAnimalFactory("Land"));
	}

	private static AnimalFactory createAnimalFactory(String type) {
		if (type.equalsIgnoreCase("Water")) {
			return new SeaFactory();
		} else if (type.equalsIgnoreCase("Land")) {
			return new LandFactory();
		} else {
			return null;
		}
	}
}
