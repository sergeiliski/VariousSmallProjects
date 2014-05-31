package com.example.urgentfmapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;

public class TopBarAdapter extends BaseAdapter {
	private Context context;
	private View[] views = new View[2];

	public int playButtonId = 2000;
	public int trackLabelId = 2001;

	public TopBarAdapter(Context c) {
		context = c;
		createTrackLabel();
		createPlayButton();
	}

	private void createTrackLabel() {
		TextView trackLabel = new TextView(context);
		trackLabel.setText("Joe Cocker - N'oubliez Jamais");
		trackLabel.setId(trackLabelId);
		views[0] = trackLabel;
	}

	private void createPlayButton() {
		ImageView playButton = new ImageView(context);
		playButton.setImageResource(R.drawable.play_icon);
		playButton.setScaleType(ScaleType.CENTER_CROP);
		playButton.setLayoutParams(new GridView.LayoutParams(50, 50));
		playButton.setId(playButtonId);

		playButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				onPlayButtonClick();
			}
		});

		views[1] = playButton;
	}

	protected void onPlayButtonClick() {
		Toast toast = Toast
				.makeText(context, "Play button", Toast.LENGTH_SHORT);
		toast.show();
	}

	@Override
	public int getCount() {
		return views.length;
	}

	@Override
	public Object getItem(int position) {
		return views[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return views[position];
	}
}
