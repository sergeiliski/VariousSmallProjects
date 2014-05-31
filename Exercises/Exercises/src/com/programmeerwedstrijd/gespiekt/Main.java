package com.programmeerwedstrijd.gespiekt;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static boolean found = false;
	private int min = 101;

	public static void main(String[] args) {
		int aantalExamens = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < aantalExamens; i++) {
			String[] examen = scanner.nextLine().split(" ");

			if (examen[0].equals("0") || examen[0].equals("1")) {
				System.out.println("spieken kon niet");
			} else {
				for (int k = 0; k < Integer.parseInt(examen[0]); k++) {
					if (k != Integer.parseInt(examen[examen.length - 1])) {
						if (Integer.parseInt(examen[k]) - Integer.parseInt(examen[k + 1]) == 0) {
							System.out.println((k) + " en " + (k + 1) + " zijn zwaar verdacht");
							found = true;
						}
					}
				}

				if (!found) {
					int min = 101;
					int s1 = 0, s2 = 0;
					for (int x = 0; x < examen.length - 1; x++) {
						int sol = Integer.parseInt(examen[x]) - Integer.parseInt(examen[x + 1]);
						if (sol < min) {
							min = sol;
							s1 = x + 1;
							s2 = x + 2;
						}
					}

					System.out.println(s1 + " en " + s2 + " zijn verdacht");
				}
			}
			found = false;
		}
	}
}
