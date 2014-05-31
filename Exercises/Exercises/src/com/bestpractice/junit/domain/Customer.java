package com.bestpractice.junit.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Customer {

	private int id;
	private String name;
	private String address;
	private int age;
	private boolean goodCustomer = true;
	private Representative representative;

	public Customer(int id, String name) {
		setID(id);
		this.name = name;
	}

	public void setAddress(String street, int number, String city) {
		address = street + " " + number + ", " + city + ".";
	}

	public void setDateOfBirth(Calendar birthDate) {
		Calendar currentDate = new GregorianCalendar();
		age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
		if (currentDate.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH)) {
			age -= 1;
		} else if (currentDate.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH)) {
			if (currentDate.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH)) {
				age -= 1;
			}
		}
	}

	public void setGoodCustomer(boolean goodCustomer) {
		this.goodCustomer = goodCustomer;
	}

	public boolean isGoodCustomer() {
		return goodCustomer;
	}

	public int getId() {
		return id;
	}

	public void setID(int id) {
		if (id > 0) {
			this.id = id;
		} else {
			throw new IllegalArgumentException("ID moet groter dan 0 zijn");
		}
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		if (address == null) {
			return "No address";
		} else {
			return address;
		}
	}

	public int getAge() {
		return age;
	}

	public void setRepresentative(Representative representative) {
		this.representative = representative;
	}

	public Representative getRepresentative() {
		return representative;
	}

}
