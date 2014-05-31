package com.designpatterns.abstractfactory;

public class LandFactory implements AnimalFactory {
	@Override
	public Animal createAnimal() {
		return new Elephant();
	}
}
