package com.exams.frontend.exam2009.question4;

import java.util.Comparator;

public class HeightComparator implements Comparator<StripFiguur> {

	@Override
	public int compare(StripFiguur figuur1, StripFiguur figuur2) {
		long heightDifference = figuur2.getGrootte() - figuur1.getGrootte();
		return (int) heightDifference;
	}
}
