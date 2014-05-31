package com.datastructures.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueExample {
	public static void main(String[] args) {
		PriorityQueue<Double> queue = new PriorityQueue<Double>();

		queue.offer(3.2);
		queue.offer(5.7);
		queue.offer(1.2);

		while (queue.size() > 0) {
			System.out.printf("%.1f ", queue.peek());
			queue.poll();
		}
	}
}
