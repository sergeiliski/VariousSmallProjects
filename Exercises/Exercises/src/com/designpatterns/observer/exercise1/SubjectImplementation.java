package com.designpatterns.observer.exercise1;

import java.util.ArrayList;
import java.util.Iterator;

public class SubjectImplementation implements Subject {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String state;

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public void setState(String state) {
		this.state = state;
		notifyObservers();
	}

	public void notifyObservers() {
		Iterator<Observer> i = observers.iterator();

		while (i.hasNext()) {
			Observer currentObserver = i.next();
			currentObserver.update(this);
		}
	}
}
