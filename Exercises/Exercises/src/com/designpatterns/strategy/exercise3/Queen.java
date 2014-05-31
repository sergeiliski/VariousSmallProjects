package com.designpatterns.strategy.exercise3;

public class Queen extends Character {
	public Queen(String name) {
		setName(name);
		setWeapon(new Bow());
	}

	@Override
	public String showInfo() {
		return ("I am queen " + getName() + ". Bow for me.");
	}
}
