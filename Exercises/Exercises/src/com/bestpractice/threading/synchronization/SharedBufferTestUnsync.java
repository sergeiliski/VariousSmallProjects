package com.bestpractice.threading.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTestUnsync {

	public static void main(String[] args) {
		ExecutorService application = Executors.newFixedThreadPool(2);

		Buffer sharedLocation = new UnsynchronizedBuffer();

		System.out.println("Action\t\tValue\tProduced\tConsumed");
		System.out.println("-----\t\t-----\t------\t------\n");

		try {
			Producer producer = new Producer(sharedLocation);
			Consumer consumer = new Consumer(sharedLocation);

			application.execute(producer);
			application.execute(consumer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		application.shutdown();
	}
}
