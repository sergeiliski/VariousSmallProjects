package com.bestpractice.generics;

public class GenericStackMethods {

	private Double[] doubleElements = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6 };
	private Integer[] integerElements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	private GenericStack<Double> doubleStack;
	private GenericStack<Integer> integerStack;

	public void testStacks() {
		doubleStack = new GenericStack<Double>(5);
		integerStack = new GenericStack<Integer>(10);

		testPush("doubleStack", doubleStack, doubleElements);
		testPop("doubleStack", doubleStack);
		testPush("integerStack", integerStack, integerElements);
		testPop("integerStack", integerStack);
	}

	private <T> void testPush(String name, GenericStack<T> stack, T[] elements) {
		try {
			System.out.printf("\nPushing elements onto %s\n", name);

			for (T element : elements) {
				System.out.printf("%s ", element);
				stack.push(element);
			}
		} catch (IllegalArgumentException e) {
			System.out.println();
		}
	}

	private <T> void testPop(String name, GenericStack<T> stack) {
		try {
			System.out.printf("\nPopping elements from %s\n", name);
			T popValue;

			while (true) {
				popValue = stack.pop();
				System.out.printf("%s ", popValue);
			}
		} catch (IllegalArgumentException e) {
			System.out.println();
		}
	}
}
