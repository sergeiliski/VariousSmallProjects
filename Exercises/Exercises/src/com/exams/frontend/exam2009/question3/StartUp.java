package com.exams.frontend.exam2009.question3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartUp {
	public static void main(String[] args) {
		new StartUp();
	}

	public StartUp() {
		final int AANTAL_EXAMENVRAGEN = 10;
		final int AANTAL_STUDENTEN = 5;
		final int AANTAL_DOCENTEN = 2;
		final int AANTAL_IN_TE_VULLEN_VRAGEN = 5;
		final int GROOTTE_BUFFER = 5;

		ExamenMarathon examenMarathon = new ExamenMarathon(GROOTTE_BUFFER);

		Docent[] docenten = new Docent[AANTAL_DOCENTEN];
		Student[] studenten = new Student[AANTAL_STUDENTEN];

		for (int i = 0; i < studenten.length; i++) {
			studenten[i] = new Student("Student " + i, new Examen(AANTAL_IN_TE_VULLEN_VRAGEN), examenMarathon);
		}

		for (int i = 0; i < docenten.length; i++) {
			docenten[i] = new Docent("Docent " + i, AANTAL_EXAMENVRAGEN, examenMarathon);
		}

		ExecutorService application = Executors.newFixedThreadPool(docenten.length + studenten.length);

		try {
			for (Student student : studenten) {
				application.execute(student);
			}

			for (Docent docent : docenten) {
				application.execute(docent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		application.shutdown();
	}
}
