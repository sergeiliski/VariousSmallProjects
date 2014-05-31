package com.bestpractice.threading.synchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CircularBuffer implements Buffer {
	private Lock accessLock = new ReentrantLock();
	private Condition canWrite = accessLock.newCondition();
	private Condition canRead = accessLock.newCondition();

	private int[] buffer = { -1, -1, -1 };
	private int occupiedBuffers = 0;

	private int writeIndex = 0;
	private int readIndex = 0;

	@Override
	public void set(int value) {
		accessLock.lock();
		try {
			while (occupiedBuffers == buffer.length) {
				System.out.printf("All buffers full. Producer waits.\n");
				canWrite.await();
			}

			buffer[writeIndex] = value;
			writeIndex = (writeIndex + 1) % buffer.length;

			occupiedBuffers++;
			displayState("Producer writes " + value);
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
			while (occupiedBuffers == 0) {
				System.out.printf("All buffers empty. Consumer waits.\n");
				canRead.await();
			}

			readValue = buffer[readIndex];
			readIndex = (readIndex + 1) % buffer.length;

			occupiedBuffers--;
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
		System.out.printf("%s%s%s)\n%s", operation, " (buffers occupied:", occupiedBuffers, "buffers: ");

		for (int value : buffer) {
			System.out.printf("%2d ", value);
		}

		System.out.print("\n     ");

		for (int i = 0; i < buffer.length; i++) {
			System.out.print("---- ");
		}

		System.out.print("\n     ");

		for (int i = 0; i < buffer.length; i++) {
			if (i == writeIndex && i == readIndex) {
				System.out.print("WR");
			} else if (i == writeIndex) {
				System.out.print(" W ");
			} else if (i == readIndex) {
				System.out.print("R ");
			} else {
				System.out.print("   ");
			}
		}

		System.out.println("\n");
	}
}
