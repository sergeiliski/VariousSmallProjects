package com.exams.frontend.exam2009.question3;

import java.util.Random;

public class Student implements Runnable {
	private ExamenMarathon examenMarathon;
	private Examen examen;
	private Random random = new Random();
	private String naam;

	public Student(String naam, Examen examen, ExamenMarathon examenMarathon) {
		this.naam = naam;
		this.examen = examen;
		this.examenMarathon = examenMarathon;
	}

	@Override
	public void run() {
		String vraag = null;
		while ((examen.getReeds_Ingevuld() < 5) && (!(examen.compleet()))) {
			try {
				Thread.sleep(random.nextInt(1000) + 3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if ((vraag = this.examenMarathon.geefVraag()) != null) {
				System.out.println(naam + " heeft reeds " + examen.getReeds_Ingevuld() + " vragen ingevuld");
			}
		}
		System.out.println(naam + " heeft alle vragen ingevuld");
	}
}
