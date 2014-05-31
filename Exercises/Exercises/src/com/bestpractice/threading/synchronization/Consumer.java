package com.bestpractice.threading.synchronization;

import java.util.Random;

public class Consumer implements Runnable {
	private static Random generator = new Random();
	private Buffer sharedLocation;

	public Consumer(Buffer shared) {
		sharedLocation = shared;
	}

	@Override
	public void run() {
		int sum = 0;
		for (int count = 1; count <= 10; count++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sum += sharedLocation.get();
				// System.out.printf("\t\t\t%2d\n", sum);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("\n%s %d.\n%s\n", "Consumer read values totaling", sum, "Terminating Consumer");
	}
}
