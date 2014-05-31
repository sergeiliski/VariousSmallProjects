package com.designpatterns.singleton.exercise2;

public class SingletonLazyLoading {
	private static SingletonLazyLoading instance;

	private SingletonLazyLoading() {

	}

	public static synchronized SingletonLazyLoading getInstance() {
		if (instance == null) {
			instance = new SingletonLazyLoading();
		}

		return instance;
	}
}
