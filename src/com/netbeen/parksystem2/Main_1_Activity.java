package com.netbeen.parksystem2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class Main_1_Activity extends Activity {

	private TextView title;

	private EditText num1, num2, num3, num4, num5, num6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_1_i_want_park);

		title = (TextView) findViewById(R.id.main_1_title);

		// 给标题栏绑定click监听器，点击标题栏即可返回MainActivity
		title.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Main_1_Activity.this, MainActivity.class));
				Main_1_Activity.this.finish();
			}
		});

		// 获取六个输入框
		num1 = (EditText) findViewById(R.id.packNumber1);
		num2 = (EditText) findViewById(R.id.packNumber2);
		num3 = (EditText) findViewById(R.id.packNumber3);
		num4 = (EditText) findViewById(R.id.packNumber4);
		num5 = (EditText) findViewById(R.id.packNumber5);
		num6 = (EditText) findViewById(R.id.packNumber6);

		// 内部类，实现了TextWatcher接口，增加一个ID属性，用来区分是哪一个EditText触发的该监听器
		class TextWatcherWithInitID implements TextWatcher {

			private EditText editTextID;

			TextWatcherWithInitID(EditText initID) {
				this.editTextID = initID;
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				if (editTextID == num1 && count == 1) {	//前5个if是判断向后输入的时候，焦点随之后移
					num2.requestFocus();
				} else if (editTextID == num2 && count == 1) {
					num3.requestFocus();
				} else if (editTextID == num3 && count == 1) {
					num4.requestFocus();
				} else if (editTextID == num4 && count == 1) {
					num5.requestFocus();
				} else if (editTextID == num5 && count == 1) {
					num6.requestFocus();
				} else if (editTextID == num6 && count == 0) {	//后5个if是判断向前删除的时候，焦点随之前移
					num5.requestFocus();
				} else if (editTextID == num5 && count == 0) {
					num4.requestFocus();
				} else if (editTextID == num4 && count == 0) {
					num3.requestFocus();
				} else if (editTextID == num3 && count == 0) {
					num2.requestFocus();
				} else if (editTextID == num2 && count == 0) {
					num1.requestFocus();
				}
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}

		}

		//为每一个EditText挂一个监听器，用以连续输入六位数字
		num1.addTextChangedListener(new TextWatcherWithInitID(num1));
		num2.addTextChangedListener(new TextWatcherWithInitID(num2));
		num3.addTextChangedListener(new TextWatcherWithInitID(num3));
		num4.addTextChangedListener(new TextWatcherWithInitID(num4));
		num5.addTextChangedListener(new TextWatcherWithInitID(num5));
		num6.addTextChangedListener(new TextWatcherWithInitID(num6));

	}
}
