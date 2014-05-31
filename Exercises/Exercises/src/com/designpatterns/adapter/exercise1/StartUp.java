package com.designpatterns.adapter.exercise1;

public class StartUp {

	public static void main(String[] args) {
		EnemyTank tank = new EnemyTank();
		EnemyRobot fredTheRobot = new EnemyRobot();
		EnemyAttacker robotAdapter = new EnemyRobotAdapter(fredTheRobot);

		System.out.println("The Robot: ");
		fredTheRobot.reactToHuman("Paul");
		fredTheRobot.walkForward();
		fredTheRobot.smashWithHands();

		System.out.println("The enemy tank: ");
		tank.assignDriver("Frank");
		tank.driveForward();
		tank.fireWeapon();

		System.out.println("The robot with adapter: ");
		robotAdapter.assignDriver("Mark");
		robotAdapter.driveForward();
		robotAdapter.fireWeapon();
	}

}
