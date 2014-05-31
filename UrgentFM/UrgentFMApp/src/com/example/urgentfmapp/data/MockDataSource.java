package com.example.urgentfmapp.data;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class MockDataSource implements IDataSource {

	@Override
	public List<NewsItem> getNewsItems() {
		return new ArrayList<NewsItem>() {
			{
				add(new NewsItem(new GregorianCalendar(1999, 2, 5), "Intro 1",
						"This is the body"));
				add(new NewsItem(new GregorianCalendar(2014, 10, 23),
						"Intro 2", "This is another body"));
			}
		};
	}
}
