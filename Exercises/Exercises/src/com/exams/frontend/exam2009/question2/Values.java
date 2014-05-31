package com.exams.frontend.exam2009.question2;

public class Values<T extends Number> {

	private T the_value;

	public Values(T the_value) {
		setThe_value(the_value);
	}

	public T getThe_value() {
		return the_value;
	}

	public void setThe_value(T the_value) {
		this.the_value = the_value;
	}

	@Override
	public String toString() {
		return String.valueOf(the_value);
	}
}
