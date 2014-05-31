package com.example.urgentfmapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TableLayout.LayoutParams;

public class MenuItemAdapter extends BaseAdapter {
	private MenuItemFactory menuItemFactory;
	private View[] menuItems = new View[3];
	private Activity context;

	public int newsMenuId = 2100;
	public int scheduleMenuId = 2101;
	public int relistenMenuId = 2102;

	public MenuItemAdapter(Activity c) {
		this.context = c;
		menuItemFactory = new MenuItemFactory(context);
		createNewsItem();
		createScheduleItem();
		createRelistenItem();
	}

	private View getBaseViewItem() {
		TextView tv = new TextView(context);
		tv.setTextSize(20);
		tv.setGravity(Gravity.CENTER);
		return tv;
	}

	private void createNewsItem() {
		TextView view = (TextView) getBaseViewItem();
		view.setText("News");
		view.setId(newsMenuId);

		view.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				onNewsItemClick();
			}
		});

		menuItems[0] = view;
	}

	protected void onNewsItemClick() {
		View newsView = menuItemFactory.getView(MenuItem.NEWS);

		LinearLayout mainLayout = (LinearLayout) context
				.findViewById(R.id.main_layout);
		mainLayout.addView(newsView);
	}

	private void createScheduleItem() {
		TextView view = (TextView) getBaseViewItem();
		view.setText("Schedule");
		view.setId(scheduleMenuId);

		view.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				onScheduleItemClick();
			}
		});

		menuItems[1] = view;
	}

	protected void onScheduleItemClick() {
		Toast toast = Toast.makeText(context, "Schedule item",
				Toast.LENGTH_SHORT);
		toast.show();
	}

	private void createRelistenItem() {
		TextView view = (TextView) getBaseViewItem();
		view.setText("Relisten");
		view.setId(relistenMenuId);

		view.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				onRelistenItemClick();
			}
		});

		menuItems[2] = view;
	}

	protected void onRelistenItemClick() {
		Toast toast = Toast.makeText(context, "Relisten item",
				Toast.LENGTH_SHORT);
		toast.show();
	}

	@Override
	public int getCount() {
		return menuItems.length;
	}

	@Override
	public Object getItem(int pos) {
		return menuItems[pos];
	}

	@Override
	public long getItemId(int pos) {
		return 0;
	}

	@Override
	public View getView(int pos, View arg1, ViewGroup parent) {
		parent.setBackgroundColor(Color.rgb(0, 206, 209));
		return menuItems[pos];
	}
}
