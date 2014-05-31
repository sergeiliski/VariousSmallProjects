package com.designpatterns.strategy.exercise3;

public class King extends Character {
	public King(String name) {
		setName(name);
		setWeapon(new Sword());
	}

	@Override
	public String showInfo() {
		return ("I am king " + getName() + ". Clean my toilet!");
	}
}
