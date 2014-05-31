package com.example.urgentfmapp.views;

import java.util.HashMap;
import java.util.Map;

import com.example.urgentfmapp.data.NewsItem;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TableLayout.LayoutParams;

public class NewsItemSummaryBuilder{
	private Map<Integer, View> layout = new HashMap<Integer, View>();
	private static int nextId = 90000;
	private NewsItem newsItem;
	private Context context;

	public NewsItemSummaryBuilder(Context context, NewsItem newsItem) {
		this.context = context;
		this.newsItem = newsItem;
		
		layout.put(0, getSubjectLabel());
		layout.put(1, getDateLabel());
		layout.put(2, getIntroductionLabel());
	}

	private View getSubjectLabel() {
		TextView view = new TextView(context);
		view.setText("0");
		return view;
	}
	
	private View getDateLabel() {
		TextView view = new TextView(context);
		view.setText("1");
		return view;
	}
	
	private View getIntroductionLabel() {
		TextView view = new TextView(context);
		view.setText("2");
		return view;
	}

	public View getView(){
		final GridView view = new GridView(context);
		view.setNumColumns(2);
		view.setId(nextId++);
		view.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
		view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		view.setAdapter(new NewsItemAdapter());
		
		view.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast toast = Toast.makeText(context, "ID: " + view.getId(),
						Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		
		return view;
	}
	
	private class NewsItemAdapter extends BaseAdapter {
		// Disables clicking on individual cells from a gridview
//		@Override
//		public boolean areAllItemsEnabled() {
//		    return false;
//		}
//
//		@Override
//		public boolean isEnabled(int position) {
//		    return false;
//		}

		@Override
		public int getCount() {
			return layout.size();
		}

		@Override
		public Object getItem(int pos) {
			return layout.get(pos);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int pos, View view, ViewGroup parent) {	
			return layout.get(pos);
		}		
	}
}
