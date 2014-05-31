package com.bestpractice.threading.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingBufferTest {
	public static void main(String[] args) {
		ExecutorService application = Executors.newFixedThreadPool(2);
		Buffer sharedLocation = new BlockingBuffer();

		try {
			application.execute(new Producer(sharedLocation));
			application.execute(new Consumer(sharedLocation));
		} catch (Exception e) {
			e.printStackTrace();
		}
		application.shutdown();
	}
}
