package com.bestpractice.threading.sleep;

public class ThreadTester {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new PrintTask("Thread 1"));
		Thread thread2 = new Thread(new PrintTask("Thread 2"));
		Thread thread3 = new Thread(new PrintTask("Thread 3"));

		System.err.println("Starting threads");

		thread1.start();
		thread2.start();
		thread3.start();

		System.err.println("Threads started, main ends\n");
	}
}
