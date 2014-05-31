package com.designpatterns.abstractfactory;

public class Shark implements Animal {
	@Override
	public void breathe() {
		System.out.println("I breathe under water");
	}
}
