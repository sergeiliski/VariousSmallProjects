package com.week2.stacksandqueues.generics;

import java.util.Iterator;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GenericLinkedStack<T> implements Iterable<T> {
	private Node first = null;

	private class Node {
		T item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(T item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public T pop() {
		T item = first.item;
		first = first.next;
		return item;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new NotImplementedException();
		}
	}
}
