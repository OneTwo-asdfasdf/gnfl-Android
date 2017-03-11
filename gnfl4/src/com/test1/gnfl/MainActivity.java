package com.test1.gnfl;



import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		
		
		
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				Intent intent = new Intent(MainActivity.this, home.class);
				startActivity(intent);
				
				finish();
			}
		}, 1000);
	}

}
