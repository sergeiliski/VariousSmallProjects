package com.exams.frontend.exam2009.question4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class HulpKlasse {
	public void afbeelden(String message, Collection<StripFiguur> collectie) {
		System.out.println(message);

		for (StripFiguur stripFiguur : collectie) {
			System.out.println(stripFiguur);
		}

		System.out.println();
	}

	public List<StripFiguur> pick3(Collection<StripFiguur> list) {
		ArrayList<StripFiguur> daltons = new ArrayList<StripFiguur>(list);
		Random random = new Random();
		while (daltons.size() > 3) {
			int choice = random.nextInt(daltons.size());
			daltons.remove(daltons.get(choice));
		}
		return daltons;
	}
}
