package com.bestpractice.threading.synchronization;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {
	private ArrayBlockingQueue<Integer> buffer;

	public BlockingBuffer() {
		buffer = new ArrayBlockingQueue<Integer>(3);
	}

	@Override
	public void set(int value) {
		try {
			buffer.put(value);
			System.out.printf("%s%2d\t%s%d\n", "Producer writes", value, "Buffers occupied: ", buffer.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int get() {
		int readValue = 0;
		try {
			readValue = buffer.take();
			System.out.printf("%s%2d\t%s%d\n", "Consumer reads ", readValue, "Buffers occupied: ", buffer.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return readValue;
	}
}
