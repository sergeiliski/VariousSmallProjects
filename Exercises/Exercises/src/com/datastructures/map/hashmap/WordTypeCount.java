package com.datastructures.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordTypeCount {
	private Map<String, Integer> map;
	private Scanner scanner;

	public WordTypeCount() {
		map = new HashMap<String, Integer>();
		scanner = new Scanner(System.in);

		createMap();
		displayMap();
	}

	private void createMap() {
		System.out.println("Enter a String:");
		String input = scanner.nextLine();
		String[] tokens = input.split(" ");

		for (String token : tokens) {
			String word = token.toLowerCase();
			if (map.containsKey(word)) {
				int count = map.get(word);
				map.put(word, count + 1);
			} else {
				map.put(word, 1);
			}
		}
	}

	private void displayMap() {
		Set<String> keys = map.keySet();
		TreeSet<String> sortedKeys = new TreeSet<String>(keys);
		System.out.println("Map contains:\nKey\t\tValue");

		for (String key : sortedKeys) {
			System.out.printf("%-10s%10s\n", key, map.get(key));
		}

		System.out.printf("\nsize:%d\nisEmpty:%b\n", map.size(), map.isEmpty());
	}
}
