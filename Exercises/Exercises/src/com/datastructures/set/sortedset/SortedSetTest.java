package com.datastructures.set.sortedset;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
	private static final String NAMES[] = { "yellow", "green", "black", "tan", "grey", "white", "orange", "red", "green" };

	public SortedSetTest() {
		SortedSet<String> tree = new TreeSet<String>(Arrays.asList(NAMES));
		System.out.println("Sorted set: ");
		printSet(tree);

		System.out.print("\nheadSet (\"orange\"): ");
		printSet(tree.headSet("orange"));

		System.out.print("tailSet (\"orange\"): ");
		printSet(tree.tailSet("orange"));

		System.out.printf("first: %s\n", tree.first());
		System.out.printf("last: %s\n", tree.last());
	}

	private void printSet(SortedSet<String> set) {
		for (String color : set) {
			System.out.printf("%s ", color);
		}

		System.out.println();
	}
}
