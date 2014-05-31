package com.bestpractice.threading.synchronization;

public class SynchronizedBufferMonitor implements Buffer {
	private int buffer = -1;
	private boolean occupied = false;

	@Override
	public synchronized void set(int value) {
		while (occupied) {
			try {
				System.out.println("Producer tries to write.");
				displayState("Buffer full. Producer waits.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		buffer = value;
		occupied = true;
		displayState("Producer writes " + buffer);

		notify();
	}

	@Override
	public synchronized int get() {
		while (!occupied) {
			try {
				System.out.println("Consumer tries to read.");
				displayState("Buffer empty. Consumer waits.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		occupied = false;
		int readValue = buffer;

		displayState("Consumer reads " + readValue);
		notify();

		return readValue;
	}

	public void displayState(String operation) {
		System.out.printf("%-40s%d\t\t%b\n\n", operation, buffer, occupied);
	}

}
