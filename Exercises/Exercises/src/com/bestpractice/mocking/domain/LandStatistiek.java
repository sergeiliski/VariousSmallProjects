package com.bestpractice.mocking.domain;

public class LandStatistiek {

	private Land land;
	private double verhouding;

	public LandStatistiek(Land land, double verhouding) {
		this.land = land;
		this.verhouding = verhouding;
	}

	public Land getLand() {
		return land;
	}

	public double getVerhouding() {
		return verhouding;
	}
}
