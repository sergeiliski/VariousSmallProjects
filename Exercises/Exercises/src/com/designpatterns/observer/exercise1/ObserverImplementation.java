package com.designpatterns.observer.exercise1;

public class ObserverImplementation implements Observer {
	@Override
	public void update(Subject s) {
		String state = s.getState();
		System.out.println("Change received, changing to " + state);
	}
}
