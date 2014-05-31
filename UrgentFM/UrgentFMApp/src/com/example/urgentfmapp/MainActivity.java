package com.example.urgentfmapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initializeTopBar();
		initializeMenu();
	}

	private void initializeTopBar() {
		GridView topbar = (GridView) findViewById(R.id.topbar_grid);
		TopBarAdapter topBarAdapter = new TopBarAdapter(this);
		topbar.setAdapter(topBarAdapter);
	}

	private void initializeMenu() {
		GridView menu = (GridView) findViewById(R.id.menu_grid);
		MenuItemAdapter menuItemAdapter = new MenuItemAdapter(this);
		menu.setAdapter(menuItemAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
