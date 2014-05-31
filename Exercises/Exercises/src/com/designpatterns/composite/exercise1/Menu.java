package com.designpatterns.composite.exercise1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {
	private List<MenuComponent> menuComponents = new ArrayList<>();
	private String name, description;

	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void add(MenuComponent component) {
		menuComponents.add(component);
	}

	@Override
	public void remove(MenuComponent component) {
		menuComponents.remove(component);
	}

	@Override
	public MenuComponent getChild(int i) {
		return menuComponents.get(i);
	}

	@Override
	public String getName() {
		return name;
	}

	public String getdescription() {
		return description;
	}

	@Override
	public void print() {
		System.out.print("\n" + getName());
		System.out.println("," + getDescription());
		System.out.println("---------------------");

		Iterator<MenuComponent> it = menuComponents.iterator();

		while (it.hasNext()) {
			MenuComponent comp = it.next();
			comp.print();
		}
	}

	@Override
	public Iterator<MenuComponent> createIterator() {
		return menuComponents.iterator();
	}
}
