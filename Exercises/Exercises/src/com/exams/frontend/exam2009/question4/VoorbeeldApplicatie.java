package com.exams.frontend.exam2009.question4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VoorbeeldApplicatie {
	public static void main(String[] args) {
		StripFiguur joe = new StripFiguur("Joe", 150);
		StripFiguur jack = new StripFiguur("Jack", 160);
		StripFiguur william = new StripFiguur("William", 165);
		StripFiguur averall = new StripFiguur("Averall", 190);
		StripFiguur theDaltons[] = { joe, william, jack, averall, joe };

		List<StripFiguur> theDaltonsAlsLijst = new ArrayList<StripFiguur>(Arrays.asList(theDaltons));

		HulpKlasse hulpKlasseObject = new HulpKlasse();
		hulpKlasseObject.afbeelden("De daltons als lijst:", theDaltonsAlsLijst);

		Collections.sort(theDaltonsAlsLijst, new HeightComparator());
		hulpKlasseObject.afbeelden("De daltons op grootte gesorteerd (van groot naar klein)", theDaltonsAlsLijst);

		StripFiguur ma = new StripFiguur("Ma Dalton", 150);
		StripFiguur pa = new StripFiguur("Pa Dalton", 180);
		StripFiguur oomMarcel = new StripFiguur("Oom Marcel", 170);
		StripFiguur oomHenry = new StripFiguur("Oom Henry", 170);
		StripFiguur familieLeden[] = { ma, pa, oomMarcel, oomHenry };

		Collections.addAll(theDaltonsAlsLijst, familieLeden);
		hulpKlasseObject.afbeelden("De Daltonfamilie: ", theDaltonsAlsLijst);

		Set<StripFiguur> uniqueSet = new HashSet<StripFiguur>(theDaltonsAlsLijst);
		hulpKlasseObject.afbeelden("Unieke waarden:", uniqueSet);

		hulpKlasseObject.afbeelden("Drie willekeurige Dalton-Figuren:", hulpKlasseObject.pick3(uniqueSet));
	}
}
