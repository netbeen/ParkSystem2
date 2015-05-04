package com.netbeen.parksystem2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private Fragment1 fragment1;
	private Fragment2 fragment2;
	private Fragment3 fragment3;
	private Fragment4 fragment4;

	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;

	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initViews();
		fragmentManager = getFragmentManager();
		setTabSelection(0);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bottomTabTextview1:
			setTabSelection(0);
			break;
		case R.id.bottomTabTextview2:
			setTabSelection(1);
			break;
		case R.id.bottomTabTextview3:
			setTabSelection(2);
			break;
		case R.id.bottomTabTextview4:
			setTabSelection(3);
			break;
		default:
			break;
		}
	}

	private void initViews() {
		textview1 = (TextView) findViewById(R.id.bottomTabTextview1);
		textview2 = (TextView) findViewById(R.id.bottomTabTextview2);
		textview3 = (TextView) findViewById(R.id.bottomTabTextview3);
		textview4 = (TextView) findViewById(R.id.bottomTabTextview4);
		textview1.setOnClickListener(this);
		textview2.setOnClickListener(this);
		textview3.setOnClickListener(this);
		textview4.setOnClickListener(this);
	}

	private void setTabSelection(int index) {
		Drawable drawable;
		clearSelection();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 更换Textview中显示的图片
			drawable = getResources().getDrawable(R.drawable.radio_icon1_check);
			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
			textview1.setCompoundDrawables(null, drawable, null, null);

			// 更换contentArea中显示的内容
			if (fragment1 == null) {
				fragment1 = new Fragment1();
				transaction.add(R.id.contentAera, fragment1);
			} else {
				transaction.show(fragment1);
			}
			break;
		case 1:
			drawable = getResources().getDrawable(R.drawable.radio_icon2_check);
			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
			textview2.setCompoundDrawables(null, drawable, null, null);

			if (fragment2 == null) {
				fragment2 = new Fragment2();
				transaction.add(R.id.contentAera, fragment2);
			} else {
				transaction.show(fragment2);
			}
			break;
		case 2:
			drawable = getResources().getDrawable(R.drawable.radio_icon3_check);
			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
			textview3.setCompoundDrawables(null, drawable, null, null);

			if (fragment3 == null) {
				fragment3 = new Fragment3();
				transaction.add(R.id.contentAera, fragment3);
			} else {
				transaction.show(fragment3);
			}
			break;
		case 3:
			drawable = getResources().getDrawable(R.drawable.radio_icon4_check);
			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
			textview4.setCompoundDrawables(null, drawable, null, null);

			if (fragment4 == null) {
				fragment4 = new Fragment4();
				transaction.add(R.id.contentAera, fragment4);
			} else {
				transaction.show(fragment4);
			}
			break;
		default:
			break;
		}
		transaction.commit();
	}

	/**
	 * 清除掉所有的选中状态。
	 */
	private void clearSelection() {
		Drawable drawable;

		drawable = getResources().getDrawable(R.drawable.radio_icon1);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		textview1.setCompoundDrawables(null, drawable, null, null);

		drawable = getResources().getDrawable(R.drawable.radio_icon2);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		textview2.setCompoundDrawables(null, drawable, null, null);

		drawable = getResources().getDrawable(R.drawable.radio_icon3);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		textview3.setCompoundDrawables(null, drawable, null, null);

		drawable = getResources().getDrawable(R.drawable.radio_icon4);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		textview4.setCompoundDrawables(null, drawable, null, null);
	}

	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (fragment1 != null)
			transaction.hide(fragment1);
		if (fragment2 != null)
			transaction.hide(fragment2);
		if (fragment3 != null)
			transaction.hide(fragment3);
		if (fragment4 != null)
			transaction.hide(fragment4);
	}
}
