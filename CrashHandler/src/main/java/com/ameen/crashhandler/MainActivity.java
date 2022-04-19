package com.ameen.crashhandler;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		CrashHunt hunt = CrashHunt.getInstance();
		hunt.initialize(this);
		textView.setOnClickListener((view) -> {

		});
	}
}