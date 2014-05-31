package com.designpatterns.observer.exercise1;

public class StartUp {
	public static void main(String[] args) {
		Observer o = new ObserverImplementation();
		Subject s = new SubjectImplementation();
		AnotherObserver obs = new AnotherObserver();

		s.addObserver(o);
		s.addObserver(obs);
		s.setState("lol");
	}
}
