package com.designpatterns.iterator.exercise1;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseIterator implements MyIterator {
	private List<MenuItem> items = new ArrayList<>();
	int position = 0;

	public PancakeHouseIterator(List<MenuItem> list) {
		items = list;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.size() || items.get(position) == null) {
			return false;
		}

		return true;
	}

	@Override
	public Object next() {
		MenuItem item = items.get(position);
		position++;
		return item;
	}
}
