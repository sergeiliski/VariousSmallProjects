package com.exams.frontend.test20102011;

import java.util.ArrayList;
import java.util.List;

public class KlantenkantoorUtilities {
	public static List<Klantenkantoor> kantorenMetZelfdeBegincijferPostcode(List<Klantenkantoor> klantenkantoren, int postcode) {
		ArrayList<Klantenkantoor> kantoren = new ArrayList<Klantenkantoor>();
		for (Klantenkantoor kantoor : klantenkantoren) {
			String postcodeChosen = Integer.toString(postcode);
			String postcodeKantoor = Integer.toString(kantoor.getPostcode());
			if (postcodeKantoor.startsWith(postcodeChosen.substring(0, 1))) {
				kantoren.add(kantoor);
			}
		}
		return kantoren;
	}
}
