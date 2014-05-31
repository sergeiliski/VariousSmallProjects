package com.designpatterns.iterator.exercise1;

public class DinerMenuIterator implements MyIterator {
	private MenuItem[] list;
	private int position = 0;

	public DinerMenuIterator(MenuItem[] list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		if (position >= list.length || list[position] == null) {
			return false;
		}

		return true;
	}

	@Override
	public Object next() {
		MenuItem menuItem = list[position];
		position++;
		return menuItem;
	}
}
