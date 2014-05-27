package com.akiguchilab.walkcountassistapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class Splash extends Activity{
	
	public Splash(){
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		
		Handler handler = new Handler();
		handler.postDelayed(new Runnable(){
			@Override
			public void run(){
				Intent intent = new Intent(Splash.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		}, 3000);
	}
}
