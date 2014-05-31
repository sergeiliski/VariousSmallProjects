package com.designpatterns.observer.exercise2;

import java.util.ArrayList;

public class PaperCompany implements MySubject {
	private ArrayList<MyObserver> observers = new ArrayList<MyObserver>();
	private Paper currentEdition;
	private String companyName;

	public PaperCompany(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public void addObserver(MyObserver obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(MyObserver obs) {
		observers.remove(obs);
	}

	public Paper getPaper() {
		return currentEdition;
	}

	public void setPaper(Paper paper) {
		currentEdition = paper;
		notifyListeners();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String name) {
		companyName = name;
	}

	private void notifyListeners() {
		for (MyObserver observer : observers) {
			observer.updatePaper(currentEdition);
		}
	}
}
