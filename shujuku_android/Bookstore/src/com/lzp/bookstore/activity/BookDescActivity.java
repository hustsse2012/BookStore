package com.lzp.bookstore.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.lzp.bookstore.R;

public class BookDescActivity extends Activity {
	private TextView nameTextView;
	private TextView priceTextView;
	private TextView numTextView;
	private TextView publishTextView;
	private TextView authorsTextView;
	private TextView cataLoguetextView;
	private TextView supplierTextView;
	
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_desc);
		intent = getIntent();
		initView();
	}
	
	private void initView(){
		nameTextView = (TextView)findViewById(R.id.bk_item_name);
		nameTextView.setText(intent.getStringExtra("name"));
		priceTextView = (TextView)findViewById(R.id.bk_item_price);
		priceTextView.setText(intent.getStringExtra("price"));
		numTextView = (TextView)findViewById(R.id.bk_item_num);
		numTextView.setText(intent.getStringExtra("num"));
		publishTextView = (TextView)findViewById(R.id.bk_item_publish);
		publishTextView.setText(intent.getStringExtra("publish"));
		authorsTextView = (TextView)findViewById(R.id.bk_item_authors);
		authorsTextView.setText(intent.getStringExtra("authors"));
		cataLoguetextView = (TextView)findViewById(R.id.bk_item_catalogue);
		cataLoguetextView.setText(intent.getStringExtra("catalogue"));
		supplierTextView = (TextView)findViewById(R.id.bk_item_supplierID);
		supplierTextView.setText(intent.getStringExtra("supplier"));
		
	}
	
	
}
