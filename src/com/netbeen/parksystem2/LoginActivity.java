package com.netbeen.parksystem2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

public class LoginActivity extends Activity {
	private Button loginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		loginButton = (Button)this.findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent(LoginActivity.this, MainActivity.class));
				LoginActivity.this.finish();
			}
		});
		
	}
}
