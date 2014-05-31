package com.designpatterns.adapter.exercise1;

import java.util.Random;

public class EnemyTank implements EnemyAttacker {

	Random generator = new Random();

	@Override
	public void fireWeapon() {
		int attackDamage = generator.nextInt(10) + 1;
		System.out.println("Enemy tank does " + attackDamage + " damage.");
	}

	@Override
	public void driveForward() {
		int movement = generator.nextInt(5) + 1;
		System.out.println("Enemy tank moves " + movement + " meter.");
	}

	@Override
	public void assignDriver(String name) {
		System.out.println("The driver is: " + name);
	}

}
