import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node first, last;

	private int size;

	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	public Deque() {
		first = last = null;
		size = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}

		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		first.prev = null;
		oldFirst.prev = first;
		size++;
	}

	public void addLast(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}

		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldLast;
		oldLast.next = last;
		size++;
	}

	public Item removeFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}

		Item oldFirst = first.item;
		first = first.next;
		size--;
		return oldFirst;
	}

	public Item removeLast() {
		if (first == null) {
			throw new NoSuchElementException();
		}

		Item oldLast = last.item;
		last = last.prev;
		size--;
		return oldLast;
	}

	@Override
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}

	private class DequeIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
