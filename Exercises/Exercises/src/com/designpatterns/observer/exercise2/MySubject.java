package com.designpatterns.observer.exercise2;

public interface MySubject {
	public void addObserver(MyObserver obs);

	public void removeObserver(MyObserver obs);
}
