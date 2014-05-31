package com.exams.frontend.exam2009.question3;

public class Examen {

	private final int AANTAL_VRAGEN;
	private int reeds_ingevuld;

	public Examen(int aantal_vragen) {
		AANTAL_VRAGEN = aantal_vragen;
	}

	public void vraagInvullen() {
		reeds_ingevuld++;
	}

	public boolean compleet() {
		return reeds_ingevuld == AANTAL_VRAGEN;
	}

	public int getReeds_Ingevuld() {
		return reeds_ingevuld;
	}
}
