package com.designpatterns.adapter.exercise1;

import java.util.Random;

public class EnemyRobot {

	Random generator = new Random();

	public void smashWithHands() {
		int attackDamage = generator.nextInt(5) + 1;
		System.out.println("Enemy robot does " + attackDamage + " damage.");
	}

	public void walkForward() {
		int movement = generator.nextInt(15) + 1;
		System.out.println("Enemy robot moves " + movement + " distance.");
	}

	public void reactToHuman(String name) {
		System.out.println("Enemy robot tramps on " + name);
	}

}
