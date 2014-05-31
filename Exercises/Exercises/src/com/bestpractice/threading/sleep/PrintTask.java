package com.bestpractice.threading.sleep;

import java.util.Random;

public class PrintTask implements Runnable {
	private int sleepTime;
	private String threadName;
	private static Random generator = new Random();

	public PrintTask(String name) {
		threadName = name;
		sleepTime = generator.nextInt(20000);
	}

	@Override
	public void run() {
		try {
			System.out.printf("%s going to sleep for %d\n", threadName, sleepTime);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s done sleeping\n", threadName);
	}
}
