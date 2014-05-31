package com.exams.frontend.exam2009.question1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class Verwerking {
	private Map<String, Integer> partijen = new HashMap<String, Integer>();
	private ObjectInputStream input;

	public Map<String, Integer> aanmakenStatistiek(String bestandsNaam) {
		try {
			input = new ObjectInputStream(new FileInputStream(bestandsNaam));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		PartijUitslag uitslag;

		try {
			while (true) {
				int stemmen = 0;
				uitslag = (PartijUitslag) input.readObject();
				if (partijen.containsKey(uitslag.getPartijNaam())) {
					stemmen = partijen.get(uitslag.getPartijNaam());
				}
				stemmen += uitslag.getBehaaldAantalStemmen();
				partijen.put(uitslag.getPartijNaam(), stemmen);
			}
		} catch (EOFException e) {
			System.err.println("End of file reached");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (input != null) {
				input.close();
			}
		} catch (Exception e) {
			System.err.println("Error closing file");
		}
		return partijen;
	}
}
