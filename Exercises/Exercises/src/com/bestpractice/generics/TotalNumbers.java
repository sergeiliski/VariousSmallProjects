package com.bestpractice.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TotalNumbers {
	public static void main(String[] args) {
		Number[] numbers = { 1, 2.4, 3, 4.1 };
		Integer[] intNumbers = { 1, 2, 3, 4 };
		Collection<Integer> intList = new ArrayList<Integer>(Arrays.asList(intNumbers));
		Collection<Number> numberList = new ArrayList<Number>(Arrays.asList(numbers));

		System.out.printf("Numberlist contains: %s\n", numberList);
		System.out.printf("Total of the elements in NumberList: %.1f\n", sum(numberList));

		System.out.printf("intList contains: %s\n", intList);
		System.out.printf("Integer list: %.1f\n", sum(intList));
	}

	public static double sum(Collection<? extends Number> list) {
		double total = 0;

		for (Number element : list) {
			total += element.doubleValue();
		}

		return total;
	}
}
