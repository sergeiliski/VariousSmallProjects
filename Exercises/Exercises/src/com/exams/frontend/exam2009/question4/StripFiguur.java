package com.exams.frontend.exam2009.question4;

public class StripFiguur {

	private String naam;
	private long grootte;

	public StripFiguur(String naam, int grootte) {
		setNaam(naam);
		setGrootte(grootte);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public long getGrootte() {
		return grootte;
	}

	public void setGrootte(long grootte) {
		this.grootte = grootte;
	}

	@Override
	public String toString() {
		return String.format("%s is %d cm groot", naam, grootte);
	}
}
