package com.bestpractice.generics;

public class GenericStack<E> {
	private final int SIZE;
	private int top;
	private E[] elements;

	public GenericStack() {
		this(10);
	}

	public GenericStack(int size) {
		SIZE = size > 0 ? size : 10;
		top = -1;
		elements = (E[]) new Object[SIZE];
	}

	public void push(E value) {
		if (top == SIZE - 1) {
			throw new IllegalArgumentException(String.format("Stack is full, cannot push %s", value));
		}
		elements[++top] = value;
	}

	public E pop() {
		if (top == -1) {
			throw new IllegalArgumentException("Stack is empty, cannot pop");
		}

		return elements[top--];
	}
}
