package com.week2.stacksandqueues;

import java.util.NoSuchElementException;

public class LinkedQueueOfStrings {
	private int n;
	private Node first, last;

	private class Node {
		private String item;
		private Node next;
	}

	public LinkedQueueOfStrings() {
		first = null;
		last = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public String peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		} else {
			return first.item;
		}
	}

	public void enqueue(String item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;

		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}

		n++;
	}

	public String dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		} else {
			String item = first.item;
			first = first.next;
			n--;
			if (isEmpty()) {
				last = null;
			}

			return item;
		}
	}
}
