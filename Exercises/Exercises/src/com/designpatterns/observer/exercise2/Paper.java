package com.designpatterns.observer.exercise2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Paper {
	private String title;
	private Calendar date;

	public Paper(String title, Calendar date) {
		super();
		this.title = title;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMMM yyyy");
		return format.format(date.getTime());
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
}
