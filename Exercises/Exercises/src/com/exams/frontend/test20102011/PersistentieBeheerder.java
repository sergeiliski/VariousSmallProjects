package com.exams.frontend.test20102011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistentieBeheerder {
	private BufferedReader reader;
	private BufferedWriter writer;

	public List<Klantenkantoor> uitlezenKantoren(String bestand) throws IOException {
		String input;
		ArrayList<Klantenkantoor> kantoren = new ArrayList<Klantenkantoor>();
		reader = new BufferedReader(new FileReader(bestand));

		while ((input = reader.readLine()) != null) {
			int postcodePointer = input.indexOf(" ");
			int gemeentePointer = input.indexOf(" ", input.indexOf(" ") + 1);
			int postcode = Integer.parseInt(input.substring(0, postcodePointer));
			String gemeente = input.substring(postcodePointer, gemeentePointer);
			String adres = input.substring(gemeentePointer, input.length());
			kantoren.add(new Klantenkantoor(postcode, gemeente, adres));
		}

		return kantoren;
	}

	public void wegschrijvenNaarBestand(List<Klantenkantoor> kantorenlijst, String bestand) throws IOException {
		writer = new BufferedWriter(new FileWriter(bestand));

		for (Klantenkantoor kantoor : kantorenlijst) {
			String output = kantoor.getPostcode() + "\t" + kantoor.getGemeente() + "\t" + kantoor.getAdres();
			writer.write(output);
			writer.newLine();
		}

		if (writer != null) {
			writer.flush();
			writer.close();
		}
	}
}
