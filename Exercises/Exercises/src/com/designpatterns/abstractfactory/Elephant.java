package com.designpatterns.abstractfactory;

public class Elephant implements Animal {
	@Override
	public void breathe() {
		System.out.println("I breathe with my lungs!");
	}
}
