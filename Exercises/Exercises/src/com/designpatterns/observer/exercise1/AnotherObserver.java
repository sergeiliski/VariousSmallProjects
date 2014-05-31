package com.designpatterns.observer.exercise1;

public class AnotherObserver implements Observer {
	@Override
	public void update(Subject s) {
		System.out.println("Another observer says:" + s.getState());
	}
}
