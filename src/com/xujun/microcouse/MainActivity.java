package com.xujun.microcouse;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class MainActivity extends Activity {

	private MenuItem serchItem;
	private MenuItem settingItem;
	private MenuItem uploadItem;
	private MenuItem downloadItem;
	private SearchView sv;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);//是否显示返回箭头,默认情况是false,
		//如果setDisplayShowHomeEnabled setDisplayShowTitleEnabled 都是false,
//		那么退回图标设置为true/false都不见
		actionBar.setDisplayShowHomeEnabled(false);//是否显示logo,默认是true
		actionBar.setDisplayShowTitleEnabled(true);//是否显示title,默认是true

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		serchItem = menu.findItem(R.id.action_search);
		uploadItem = menu.findItem(R.id.action_upload);
		settingItem = menu.findItem(R.id.action_settings);
		downloadItem = menu.findItem(R.id.action_download);
		sv = (SearchView) serchItem.getActionView();
		sv.setQueryHint(getString(R.string.hello_world));
		sv.setIconifiedByDefault(true);
		sv.setOnQueryTextListener(oQueryTextListener);
		return super.onCreateOptionsMenu(menu);
	}

	OnQueryTextListener oQueryTextListener = new OnQueryTextListener() {

		@Override
		public boolean onQueryTextSubmit(String query) {
			// action when press button search
			Log.d("test1", "query string is:" + query);
			return true;
		}

		@Override
		public boolean onQueryTextChange(String newText) {
			Log.d("test1", "query string is:" + newText);
			return false;
		}
	};

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case android.R.id.home:
			System.out.println("action_back");
			break;

		case R.id.action_settings:
			System.out.println("action_settings");
			break;
		case R.id.action_upload:
			System.out.println("action_upload");
			break;
		case R.id.action_download:
			System.out.println("action_download");
			break;
		// 不会响应action_search了，因为在menuXML文件里面
		// android:actionViewClass="android.widget.SearchView"
		case R.id.action_search:
			System.out.println("action_search");
			break;

		default:
			break;

		}
		return super.onOptionsItemSelected(item);

	}
}
