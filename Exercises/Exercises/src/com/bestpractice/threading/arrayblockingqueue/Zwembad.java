package com.bestpractice.threading.arrayblockingqueue;

public class Zwembad {
	private final int CAPACITEIT;
	private int inhoud;

	public Zwembad(int cap) {
		CAPACITEIT = cap;
	}

	public void gietEmmer() {
		inhoud++;
	}

	public void haalEmmer() {
		inhoud--;
	}

	public boolean isVol() {
		return inhoud == CAPACITEIT;
	}

	public boolean isLeeg() {
		return inhoud == 0;
	}

	public int getInhoud() {
		return inhoud;
	}
}
