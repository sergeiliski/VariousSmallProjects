package com.exams.frontend.test20102011;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class StartUp {
	public static void main(String[] args) {
		new StartUp().run();
	}

	public void run() {
		PersistentieBeheerder pb = new PersistentieBeheerder();
		List<Klantenkantoor> klantenkantoren = null;
		try {
			klantenkantoren = pb.uitlezenKantoren("C:\\Users\\Jeroen\\Documents\\GitHub\\Exercises\\Exercises\\src\\com\\exams\\test20102011\\adressen.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		int postcode;
		do {
			postcode = Integer.parseInt(JOptionPane.showInputDialog("Geef eigen postcode:"));
		} while (postcode > 10000 || postcode < 1000);

		List<Klantenkantoor> kantoren = KlantenkantoorUtilities.kantorenMetZelfdeBegincijferPostcode(klantenkantoren, postcode);
		Collections.sort(kantoren, new PostcodeComparator());

		for (Klantenkantoor kantoor : kantoren) {
			System.out.println(kantoor.getPostcode());
			System.out.println(kantoor.getGemeente());
			System.out.println(kantoor.getAdres());
		}

		try {
			pb.wegschrijvenNaarBestand(kantoren, "adressen2.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
