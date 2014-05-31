package com.exams.frontend.exam2009.question2;

import java.util.ArrayList;
import java.util.Arrays;

public class StartUp {

	public static void main(String[] args) {
		ArrayList<Values> list = new ArrayList<Values>(Arrays.asList(new Values(5f), new Values(6), new Values(12L), new Values(55.4), new Values(80.9)));

		for (Values value : list) {
			System.out.println(value.getThe_value().toString());
		}
	}
}
