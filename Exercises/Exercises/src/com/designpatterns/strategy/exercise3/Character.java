package com.designpatterns.strategy.exercise3;

public abstract class Character {
	private Weapon weapon;
	private String name;

	public String printWeapon() {
		return weapon.returnWeapon();
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract String showInfo();
}
