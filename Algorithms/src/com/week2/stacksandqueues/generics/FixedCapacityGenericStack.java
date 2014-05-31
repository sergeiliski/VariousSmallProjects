package com.week2.stacksandqueues.generics;

import java.util.Iterator;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FixedCapacityGenericStack<T> implements Iterable<T> {
	private T[] s;
	private int n = 0;

	@SuppressWarnings("unchecked")
	public FixedCapacityGenericStack(int capacity) {
		s = (T[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public void push(T item) {
		s[n++] = item;
	}

	public T pop() {
		return s[--n];
	}

	@Override
	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<T> {
		private int i = n;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public T next() {
			return s[--i];
		}

		@Override
		public void remove() {
			throw new NotImplementedException();
		}
	}
}
