package com.datastructures.set.hashset;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetTest {
	private static final String COLORS[] = { "red", "white", "green", "blue", "gray", "orange", "tan", "white", "cyan", "peach", "gray", "orange" };

	public HashSetTest() {
		List<String> list = Arrays.asList(COLORS);
		System.out.printf("ArrayList: %s\n", list);
		printNonDuplicates(list);
	}

	private void printNonDuplicates(Collection<String> collection) {
		Set<String> set = new HashSet<String>(collection);
		System.out.println("\nNon Duplicates are: ");

		for (String color : set) {
			System.out.printf("%s ", color);
		}
		System.out.println();
	}
}
