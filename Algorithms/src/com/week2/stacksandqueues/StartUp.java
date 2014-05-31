package com.week2.stacksandqueues;

public class StartUp {
	public static void main(String[] args) {
		int n = 7;
		System.out.println(--n);
		System.out.println(n);
		System.out.println();

		int p = 7;
		System.out.println(p--);
		System.out.println(p);

		System.out.println("\nTEST LINKED\n");
		LinkedStackOfStrings link = new LinkedStackOfStrings();
		link.push("1");
		link.push("2");
		link.push("3");
		link.push("4");
		System.out.println(link.pop());
		link.push("9");

		System.out.println("\nTEST FIXED\n");
		FixedCapacityOfStrings fix = new FixedCapacityOfStrings(5);
		fix.push("1");
		fix.push("2");
		fix.push("3");
		fix.push("4");
		System.out.println(fix.pop());
	}
}
