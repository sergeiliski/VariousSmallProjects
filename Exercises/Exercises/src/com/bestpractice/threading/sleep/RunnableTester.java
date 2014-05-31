package com.bestpractice.threading.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTester {
	public static void main(String[] args) {
		PrintTask task1 = new PrintTask("Thread 1");
		PrintTask task2 = new PrintTask("Thread 2");
		PrintTask task3 = new PrintTask("Thread 3");

		System.out.println("Starting threads");

		ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
		threadExecutor.execute(task1);
		threadExecutor.execute(task2);
		threadExecutor.execute(task3);

		threadExecutor.shutdown();
		System.out.println("Thread started, main ends\n");
	}
}
