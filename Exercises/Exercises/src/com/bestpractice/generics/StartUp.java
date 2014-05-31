package com.bestpractice.generics;

public class StartUp {
	public static void main(String[] args) {
		// Print Array
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6, 7 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

		PrintArray.printArray(integerArray);
		PrintArray.printArray(doubleArray);
		PrintArray.printArray(characterArray);

		PrintArray.<Integer> showCombinedLength(integerArray, integerArray);

		// Generics with return
		System.out.println(GenericsWithReturn.maximum(6.7, 2.1, 7.9));
		System.out.println(GenericsWithReturn.maximum(5, 2, 4));
		System.out.println(GenericsWithReturn.maximum("appel", "banaan", "ananas"));

		// Generic Stack
		GenericStackTest stackTest = new GenericStackTest();
		stackTest.testStacks();

		// Generic Stack methods
		GenericStackMethods stackMethodTest = new GenericStackMethods();
		stackMethodTest.testStacks();
	}
}
