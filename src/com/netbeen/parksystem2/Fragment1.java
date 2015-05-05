package com.netbeen.parksystem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Fragment1 extends ListFragment {

	private static final String TAG = "##MyListFragment##";
	final String[] from = new String[] {"title", "info","icon"};
    final int[] to = new int[] {R.id.text1, R.id.text2,R.id.icon};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView");
		View layout = inflater.inflate(R.layout.fragment1, container, false);
		return layout;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), getSimpleData(), R.layout.list_item1, from, to);
		this.setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		switch (position) {
		case 0:
			startActivity(new Intent(getActivity(), Main_1_Activity.class));
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
		}
	}
	
	private List<Map<String, Object>> getSimpleData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        
        map = new HashMap<String, Object>();
        map.put("title", "我要停车");
        map.put("info", "停好车后，点击此处完成缴费");
        map.put("icon", R.drawable.fragment1_1);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "次日续时");
        map.put("info", "次日泊位提前申请，助您无忧停车");
        map.put("icon", R.drawable.fragment1_2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "快速充值");
        map.put("info", "随时随地，想冲就冲");
        map.put("icon", R.drawable.fragment1_3);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "泊位搜索");
        map.put("info", "搜索深圳市所有路边停车泊位");
        map.put("icon", R.drawable.fragment1_4);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "停车资讯");
        map.put("info", "获取最新最权威的停车资讯");
        map.put("icon", R.drawable.fragment1_5);
        list.add(map);

        return list;
    }
}
