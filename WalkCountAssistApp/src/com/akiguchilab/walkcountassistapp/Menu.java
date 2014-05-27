package com.akiguchilab.walkcountassistapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Menu extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		
		TextView textview1 = (TextView)findViewById(R.id.textView1);
		textview1.setText("こんにちは ○さん!");
	}
	
	@Override
	protected void onResume(){
		super.onResume();
	}
	
	@Override
	protected void onPause(){
		super.onPause();
	}
	
}
