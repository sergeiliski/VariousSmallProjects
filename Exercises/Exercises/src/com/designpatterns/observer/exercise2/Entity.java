package com.designpatterns.observer.exercise2;

public abstract class Entity implements MyObserver {
	private String name;
	private Paper currentPaper;

	public Entity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Paper getCurrentPaper() {
		return currentPaper;
	}

	public void setCurrentPaper(Paper currentPaper) {
		this.currentPaper = currentPaper;
	}

	@Override
	public void updatePaper(Paper paper) {
		this.currentPaper = paper;
	}
}
