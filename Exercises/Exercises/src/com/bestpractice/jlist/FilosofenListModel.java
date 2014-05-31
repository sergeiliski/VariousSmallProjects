package com.bestpractice.jlist;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

public class FilosofenListModel extends AbstractListModel {
	private static final long serialVersionUID = 3393872410734243092L;
	private List<String> filosofen;

	public FilosofenListModel() {
		this.filosofen = new ArrayList<String>();
		filosofen.add("Joske");
		filosofen.add("Marc");
		filosofen.add("Pierre");
	}

	@Override
	public Object getElementAt(int row) {
		return filosofen.get(row);
	}

	@Override
	public int getSize() {
		return filosofen.size();
	}

	public void addFilosoof(String naam) {
		filosofen.add(naam);
		int size = getSize();
		this.fireIntervalAdded(naam, size - 1, size - 1);
	}

	public void removeFilosoof(String naam) {
		int index = filosofen.indexOf(naam);
		if (index >= 0) {
			filosofen.remove(index);
			this.fireIntervalRemoved(naam, index, index);
		}
	}
}
