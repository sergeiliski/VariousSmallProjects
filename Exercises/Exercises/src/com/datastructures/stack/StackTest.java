package com.datastructures.stack;

import java.util.Iterator;
import java.util.Stack;

public class StackTest {
	Stack<Number> stack = new Stack<Number>();

	Long longNumber = 12L;
	Integer intNumber = 34567;
	Float floatNumber = 1.0F;
	Double doubleNumber = 1234.4556;

	public StackTest() {
		stack.push(longNumber);
		printStack(stack);

		stack.push(intNumber);
		printStack(stack);

		stack.push(floatNumber);
		printStack(stack);

		stack.push(doubleNumber);
		printStack(stack);

		System.out.println("Poppin 'n' Floppin");
		stack.pop();
		printStack(stack);

		stack.pop();
		printStack(stack);

		stack.pop();
		printStack(stack);
	}

	private void printStack(Stack<Number> stack) {
		Iterator<Number> iterator = stack.iterator();

		System.out.print("Stack contains:");

		while (iterator.hasNext()) {
			System.out.print(iterator.next().toString() + " ");
		}
		System.out.println("");
	}
}
