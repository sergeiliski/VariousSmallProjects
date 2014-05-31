package com.bestpractice.generics;

public class PrintArray {
	public static <E> void printArray(E[] inputArray) {
		for (E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static <E extends Number> void showCombinedLength(E[] array1, E[] array2) {
		System.out.println(array1.length + array2.length);
	}
}
