package com.bestpractice.threading.synchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedBuffer implements Buffer {
	private Lock accessLock = new ReentrantLock();
	private Condition canWrite = accessLock.newCondition();
	private Condition canRead = accessLock.newCondition();
	private int buffer = -1;
	private boolean occupied = false;

	@Override
	public void set(int value) {
		accessLock.lock();

		try {
			while (occupied) {
				System.out.println("Producer tries to write.");
				displayState("Buffer full. Producer waits.");
				canWrite.await();
			}

			buffer = value;
			occupied = true;
			displayState("Producer writes " + buffer);

			canRead.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			accessLock.unlock();
		}
	}

	@Override
	public int get() {
		int readValue = 0;
		accessLock.lock();

		try {
			while (!occupied) {
				System.out.println("Consumer tries to read.");
				displayState("Buffer empty. Consumer waits.");
				canRead.await();
			}

			occupied = false;

			readValue = buffer;
			displayState("Consumer reads " + readValue);

			canWrite.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			accessLock.unlock();
		}

		return readValue;
	}

	public void displayState(String operation) {
		System.out.printf("%-40s%d\t\t%b\n\n", operation, buffer, occupied);
	}
}
