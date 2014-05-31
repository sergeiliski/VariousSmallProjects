import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] a;
	private int n;

	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		a = (Item[]) new Object[1];
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}

		if (n == a.length) {
			resize(2 * a.length);
		}

		a[n++] = item;
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int index = StdRandom.uniform(a.length);
		while (a[index] == null) {
			index = StdRandom.uniform(a.length);
		}

		Item item = a[index];
		a[index] = null;
		if (n > 0 && n == a.length / 4) {
			resize(a.length / 2);
		}

		return item;
	}

	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int index = StdRandom.uniform(a.length);
		while (a[index] == null) {
			index = StdRandom.uniform(a.length);
		}

		return a[index];
	}

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		Object[] copy = new Object[capacity];
		for (int i = 0; i < n; i++) {
			if (a[i] != null) {
				copy[i] = a[i];
			}
		}
		a = (Item[]) copy;
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomizedIterator();
	}

	private class RandomizedIterator implements Iterator<Item> {
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i < n;
		}

		@Override
		public Item next() {
			if (a[i + 1] == null) {
				throw new NoSuchElementException();
			}
			return a[i++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
