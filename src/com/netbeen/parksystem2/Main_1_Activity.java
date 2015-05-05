package com.netbeen.parksystem2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class Main_1_Activity extends Activity {

	private TextView title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_1_i_want_park);
		
		title = (TextView)findViewById(R.id.main_1_title);
		
		title.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Main_1_Activity.this, MainActivity.class));
				Main_1_Activity.this.finish();
			}
		});
	}
}
