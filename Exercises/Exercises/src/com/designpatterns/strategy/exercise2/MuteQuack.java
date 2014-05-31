package com.designpatterns.strategy.exercise2;

public class MuteQuack implements QuackBehavior {
	@Override
	public String quack() {
		return "<<Stilte>>";
	}
}
