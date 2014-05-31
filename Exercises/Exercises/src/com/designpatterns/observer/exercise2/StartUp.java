package com.designpatterns.observer.exercise2;

import java.util.GregorianCalendar;

public class StartUp {
	public static void main(String[] args) {
		PaperCompany company = new PaperCompany("Deitel NV");
		System.out.println("Paper company name: " + company.getCompanyName());

		Person person = new Person("Jack");
		System.out.println("Citizen's name: " + person.getName());

		Company clientCompany = new Company("NMBS BVBA");
		System.out.println("Client company's name: " + clientCompany.getName());
		System.out.println();

		System.out.println("Retrieving current editions... (should be null)");
		showPaperDetails(company, person, clientCompany);

		System.out.println("Subscribing Jack and NMBS to the paper");
		company.addObserver(person);
		company.addObserver(clientCompany);

		company.setPaper(new Paper("Editie 1: Sinterklaas valt van schoorsteen!", new GregorianCalendar(2012, 00, 01)));
		showPaperDetails(company, person, clientCompany);

		System.out.println("Removing Jack as a subscriber. Asshole can't pay his bills!");
		company.removeObserver(person);

		company.setPaper(new Paper("Editie 3: Sinterklaas dronken opgemerkt. Parlement wilt een verklaring.", new GregorianCalendar(2012, 03, 01)));
		showPaperDetails(company, person, clientCompany);

	}

	private static void showPaperDetails(PaperCompany company, Entity person, Entity clientCompany) {
		if (company.getPaper() != null) {
			System.out.println("\n" + company.getCompanyName());
			System.out.println(company.getPaper().getTitle());
			System.out.println(company.getPaper().getDate());
		} else {
			System.out.println("No paper available yet");
		}

		if (person.getCurrentPaper() != null) {
			System.out.println("\n" + person.getName());
			System.out.println(person.getCurrentPaper().getTitle());
			System.out.println(person.getCurrentPaper().getDate());
		}

		if (clientCompany.getCurrentPaper() != null) {
			System.out.println("\n" + clientCompany.getName());
			System.out.println(clientCompany.getCurrentPaper().getTitle());
			System.out.println(clientCompany.getCurrentPaper().getDate());
		}
	}
}
