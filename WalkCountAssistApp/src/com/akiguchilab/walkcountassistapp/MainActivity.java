package com.akiguchilab.walkcountassistapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		//画面上部のタイトルバーを表示しない
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.title_main);
		
		//ウィンドウマネージャのインスタンス取得
		WindowManager windowmanager = (WindowManager)getSystemService(WINDOW_SERVICE);
		//ディスプレイのインスタンス取得
		Display disp = windowmanager.getDefaultDisplay();
		//ターゲットデバイスの画面横幅の取得
		float width = disp.getWidth();
		//画面幅の倍率を求める　　　480はベース画面の横幅
		float scale = width / 480;
		
		//指定のテキストビューのテキストサイズに倍率をかける
		TextView textview = (TextView) findViewById(R.id.textView1);
		textview.setTextSize(50 * scale);
		
		((Button) findViewById(R.id.start)).setOnClickListener(StartListener);
	}

	@Override
	protected void onResume(){
		super.onResume();
	}
	
	protected void onPause(){
		super.onPause();
	}
	
	
	OnClickListener StartListener = new OnClickListener(){
		private SharedPreferences preference;
		private Editor editor;
		Intent intent = new Intent();
		
		public void onClick(View v){
			//プリファレンスの準備
			preference = getSharedPreferences("Setinfo", MODE_PRIVATE);
			editor = preference.edit();
			
			if (preference.getBoolean("Launched", false) == false){
				//初回起動時に設定画面に移行
				intent.setClassName("com.akiguchilab.walkcountassistapp", "com.akiguchilab.walkcountassistapp.Setting");
				
				//プリファレンスの書き換え
				editor.putBoolean("Launched", true);
				editor.commit();
			}else{
				//次回起動時はメニュー画面に移行
				intent.setClassName("com.akiguchilab.walkcountassistapp", "com.akiguchilab.walkcountassistapp.Menu");
			}
			
			startActivity(intent);
		}
	};	
}