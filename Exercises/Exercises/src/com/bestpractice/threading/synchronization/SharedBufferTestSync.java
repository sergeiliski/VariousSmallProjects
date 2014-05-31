package com.bestpractice.threading.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTestSync {
	public static void main(String[] args) {
		ExecutorService application = Executors.newFixedThreadPool(2);

		Buffer sharedLocation = new SynchronizedBufferMonitor();

		System.out.printf("%-40s%s\t\t%s\n%-40s%s\n\n", "Operation", "Buffer", "Occupied", "-------", "------\t\t-------");

		try {
			application.execute(new Producer(sharedLocation));
			application.execute(new Consumer(sharedLocation));
		} catch (Exception e) {
			e.printStackTrace();
		}
		application.shutdown();
	}
}
