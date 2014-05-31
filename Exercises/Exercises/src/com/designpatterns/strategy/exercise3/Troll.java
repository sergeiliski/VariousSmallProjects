package com.designpatterns.strategy.exercise3;

public class Troll extends Character {
	public Troll(String name) {
		setName(name);
		setWeapon(new Sword());
	}

	@Override
	public String showInfo() {
		return ("\"GRAAAARGHGH GRONK \"\t~" + getName());
	}
}
