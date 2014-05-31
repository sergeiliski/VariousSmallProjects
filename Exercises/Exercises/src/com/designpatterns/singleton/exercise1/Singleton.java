package com.designpatterns.singleton.exercise1;

public class Singleton {
	private static Singleton firstInstance = null;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (firstInstance == null) {
			firstInstance = new Singleton();
		}
		return firstInstance;
	}
}
