package com.bestpractice.threading.sleep;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadWave {
	private static final int THREADS = 100;
	private ArrayList<PrintTask> tasks = new ArrayList<PrintTask>();

	public ThreadWave() {
		for (int i = 0; i < THREADS; i++) {
			tasks.add(new PrintTask("Thread " + i));
		}

		executeTasks();
	}

	private void executeTasks() {
		ExecutorService threadExecutor = Executors.newFixedThreadPool(THREADS);

		for (PrintTask task : tasks) {
			threadExecutor.execute(task);
		}

		threadExecutor.shutdown();
	}
}
