package com.week2.stacksandqueues;

public class FixedCapacityOfStrings {
	private String[] s;
	private int n = 0;

	public FixedCapacityOfStrings(int capacity) {
		s = new String[capacity];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public void push(String item) {
		s[n++] = item;
	}

	public String pop() {
		String item = s[--n];
		s[n] = null;
		return item;
	}
}
