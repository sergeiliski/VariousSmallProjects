package com.exams.frontend.exam2009.question3;

public class Docent implements Runnable {
	private String naam;
	private int aantal_vragen;
	private ExamenMarathon examenMarathon;

	public Docent(String naam, int aantal_vragen, ExamenMarathon examenMarathon) {
		this.naam = naam;
		this.aantal_vragen = aantal_vragen;
		this.examenMarathon = examenMarathon;
	}

	@Override
	public void run() {
		while (aantal_vragen > 0) {
			aantal_vragen--;
			examenMarathon.deelVraagUit("Vraag " + aantal_vragen);
		}

		examenMarathon.vragenZijnOp();
		System.out.println(naam + " heeft alle vragen uitgedeeld.");
	}
}
