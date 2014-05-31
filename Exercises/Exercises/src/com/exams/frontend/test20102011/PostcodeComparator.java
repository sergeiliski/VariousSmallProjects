package com.exams.frontend.test20102011;

import java.util.Comparator;

public class PostcodeComparator implements Comparator<Klantenkantoor> {

	@Override
	public int compare(Klantenkantoor kantoor1, Klantenkantoor kantoor2) {
		return kantoor1.getPostcode() - kantoor2.getPostcode();
	}
}
