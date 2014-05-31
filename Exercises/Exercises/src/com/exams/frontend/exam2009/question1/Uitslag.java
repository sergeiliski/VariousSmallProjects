package com.exams.frontend.exam2009.question1;

import java.util.Map;

public class Uitslag {
	private Map<String, Integer> partijen;
	private Verwerking verwerking;

	public static void main(String args[]) {
		new Uitslag();
	}

	public Uitslag() {
		partijen = verwerking.aanmakenStatistiek("bestand.dat");
		int totalVotes = 0;

		for (String key : partijen.keySet()) {
			totalVotes += partijen.get(key);
		}

		for (String key : partijen.keySet()) {
			String partijNaam = key;
			int partijAantal = partijen.get(key);
			double partijPercentage = ((double) partijAantal) / totalVotes * 100;

			System.out.printf("%s%s%s%d%s", "Partij ", partijNaam, " behaalt", partijPercentage, " % van de stemmen");
		}
	}
}
