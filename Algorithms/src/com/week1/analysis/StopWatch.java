package com.week1.analysis;

public class StopWatch {
	private final long startTime;

	public StopWatch() {
		startTime = System.currentTimeMillis();
	}

	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - startTime) / 1000.0;
	}
}
