package com.bestpractice.generics;

public class GenericStackTest {

	private Double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
	private Integer[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	private GenericStack<Double> doubleStack;
	private GenericStack<Integer> integerStack;

	public void testStacks() {
		doubleStack = new GenericStack<Double>(5);
		integerStack = new GenericStack<Integer>(10);

		testPushDouble();
		testPopDouble();
		testPushInteger();
		testPopInteger();
	}

	private void testPushDouble() {
		try {
			System.out.println("\nPushing elements onto doubleStack");

			for (double element : doubleElements) {
				System.out.printf("%.1f ", element);
				doubleStack.push(element);
			}
		} catch (Exception e) {
			System.out.println();
		}
	}

	private void testPopDouble() {
		System.out.println("\nPopping elements from doubleStack");
		double popValue;
		try {
			while (true) {
				popValue = doubleStack.pop();
				System.out.printf("%.1f ", popValue);
			}
		} catch (IllegalArgumentException e) {
			System.out.println();
		}
	}

	private void testPushInteger() {
		System.out.println("\nPushing elements onto integerStack");

		for (int element : integerElements) {
			System.out.printf("%d ", element);
			try {
				integerStack.push(element);
			} catch (Exception e) {
				System.out.println();
			}
		}
	}

	private void testPopInteger() {
		System.out.println("\nPopping elements from integerStack");
		int popValue;

		try {
			while (true) {
				popValue = integerStack.pop();
				System.out.printf("%d ", popValue);
			}
		} catch (Exception e) {
			System.out.println();
		}
	}
}
