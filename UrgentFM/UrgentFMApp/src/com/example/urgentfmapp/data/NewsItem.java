package com.example.urgentfmapp.data;

import java.util.Calendar;

public class NewsItem {
	private Calendar datePosted;
	private String introduction;
	private String body;

	public NewsItem(Calendar date, String intro, String body) {
		this.datePosted = date;
		this.introduction = intro;
		this.body = body;
	}

	public Calendar getDatePosted() {
		return datePosted;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getBody() {
		return body;
	}
}
