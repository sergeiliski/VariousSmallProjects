package com.designpatterns.singleton.exercise2;

public class SingletonEagerLoading {
	private static SingletonEagerLoading instance = new SingletonEagerLoading();

	private SingletonEagerLoading() {

	}

	public static SingletonEagerLoading getInstance() {
		if (instance == null) {
			instance = new SingletonEagerLoading();
		}

		return instance;
	}
}
