package com.programmeerwedstrijd.minmax;

import java.util.Scanner;

public class Main {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int aantal = Integer.parseInt(scanner.nextLine());

		for (int i = 1; i <= aantal; i++) {
			int arrAantal = Integer.parseInt(scanner.nextLine());
			int[] localArr = new int[arrAantal];
			int count = 0;
			while (arrAantal != 0) {
				localArr[count] = Integer.parseInt(scanner.nextLine());
				arrAantal--;
				count++;
			}
			calculate(localArr, i);
		}
	}

	private static void calculate(int[] arr, int index) {
		int min = 1001, max = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		System.out.println(min + " " + max);
	}
}
