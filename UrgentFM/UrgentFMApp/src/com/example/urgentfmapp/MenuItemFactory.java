package com.example.urgentfmapp;

import com.example.urgentfmapp.data.IDataSource;
import com.example.urgentfmapp.data.MockDataSource;
import com.example.urgentfmapp.data.NewsItem;
import com.example.urgentfmapp.views.NewsItemSummaryBuilder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TableLayout.LayoutParams;

public class MenuItemFactory {
	private IDataSource dataSource;
	private Context context;

	public MenuItemFactory(Context c) {
		this.context = c;
		this.dataSource = new MockDataSource();
	}

	public View getView(MenuItem item) {
		switch (item) {
		case NEWS:
			return getNewsView();
		case RELISTEN:
			return getRelistenView();
		case SCHEDULE:
			return getScheduleView();
		default:
			throw new IllegalArgumentException(
					"Could not generated the requested view type");
		}
	}

	private View getNewsView() {
		LinearLayout layout = new LinearLayout(context);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));

		for (NewsItem item : dataSource.getNewsItems()) {
			View itemView = new NewsItemSummaryBuilder(context, item).getView();
			layout.addView(itemView);
		}

		return layout;
	}

	private View getRelistenView() {
		// TODO Auto-generated method stub
		return null;
	}

	private View getScheduleView() {
		// TODO Auto-generated method stub
		return null;
	}
}
