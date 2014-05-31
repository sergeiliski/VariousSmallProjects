package com.designpatterns.strategy.exercise1;

public class Animal {

	private String name;
	private double height;
	private int weight;
	private String favFood;
	private double speed;
	private String sound;

	public Flies flyingType;

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void setHeight(double newHeight) {
		height = newHeight;
	}

	public double getHeight() {
		return height;
	}

	public void setWeight(int newWeight) {
		if (newWeight > 0) {
			weight = newWeight;
		} else {
			System.out.println("Weight must be bigger than 0");
		}
	}

	public double getWeight() {
		return weight;
	}

	public String getFavFood() {
		return favFood;
	}

	public void setFavFood(String favFood) {
		this.favFood = favFood;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String tryToFly() {
		return flyingType.fly();
	}

	public void setFlyingAbility(Flies newFlyType) {
		flyingType = newFlyType;
	}

}
