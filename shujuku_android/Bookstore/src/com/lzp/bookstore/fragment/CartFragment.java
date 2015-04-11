package com.lzp.bookstore.fragment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.lzp.bookstore.R;
import com.lzp.bookstore.activity.OrderDetailPayActivity;
import com.lzp.bookstore.adapter.CartAdapter;
import com.lzp.bookstore.model.CartItem;
import com.lzp.bookstore.model.Constants;

public class CartFragment extends Fragment {

	private ListView mListView;
	private BaseAdapter mAdapter;
	private Button mButton;
	private List<CartItem> mCartList = new ArrayList<CartItem>();
	private AsyncHttpClient client;
	private int itemCounts = 0;
	private float moneyShouldPay = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_cart_layout, null, false);
		client = new AsyncHttpClient();
		initView(v);
		bindEvents();
		loadData();
		return v;
	}

	private void bindEvents() {
		mButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				long mills = new Date().getTime();
				Timestamp t = new Timestamp(mills);
				final String oID =  mills+Constants.userID;
				String orderTime = t.toString();
				RequestParams params = new RequestParams();
				params.add("OID", oID);
				params.add("order_time", orderTime);
				params.add("del_address", Constants.address);
				params.add("state", "-1");
				params.add("money", moneyShouldPay+"");
				params.add("userID", Constants.userID);
				params.add("order_item_count", itemCounts+"");
				client.post(getActivity(), Constants.ORDER_GENERATE_SERVLET_URL, params, new JsonHttpResponseHandler(){

					@Override
					public void onFailure(int statusCode, Header[] headers,
							String responseString, Throwable throwable) {
						// TODO Auto-generated method stub
						super.onFailure(statusCode, headers, responseString, throwable);
					}

					@Override
					public void onSuccess(int statusCode, Header[] headers,
							JSONObject js) {
						try {
							boolean flag = js.getBoolean("flag");
							if(flag){
								insertItems(oID);
							}
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					
					
				});
			}
		});
	}
	static int pos=0;
	private void insertItems(final String oID) {
		RequestParams params;
		for (CartItem bookItem : mCartList) {
			params = new RequestParams();
			String bookName = bookItem.getBookName();
			String bookID = bookItem.getBookID();
			String quantity = bookItem.getAmount()+"";
			params.add("bookName", bookName);
			params.add("quantity", quantity);
			params.add("orderID", oID);
			params.add("TBID", bookItem.getTBID()+"");
			client.post(getActivity(), Constants.ORDER_ITEM_GENERATE_SERVLET_URL, params, new JsonHttpResponseHandler(){

				@Override
				public void onFailure(int statusCode, Header[] headers,
						String responseString, Throwable throwable) {
					// TODO Auto-generated method stub
					super.onFailure(statusCode, headers, responseString, throwable);
				}

				@Override
				public void onSuccess(int statusCode, Header[] headers,
						JSONObject js) {
					Toast.makeText(getActivity(), js.toString(), 0).show();
					pos++;
					Intent i = new Intent(getActivity(),OrderDetailPayActivity.class);
					i.putExtra("OID", oID);
					startActivity(i);
					if(pos==mCartList.size()){
						
					}
				}
				
			});
		}
		
		
		
	}
	private void loadData() {
		mAdapter = new CartAdapter(getActivity(), mCartList);
		mListView.setAdapter(mAdapter);
		RequestParams params = new RequestParams();
		params.put("userID", Constants.userID);
		client.post(getActivity(), Constants.GET_CART_URL, params,
				new JsonHttpResponseHandler() {

					@Override
					public void onFailure(int statusCode, Header[] headers,
							String responseString, Throwable throwable) {
						super.onFailure(statusCode, headers, responseString,
								throwable);
					}

					@Override
					public void onSuccess(int statusCode, Header[] headers,
							JSONObject ja) {
						try {
							JSONArray js = ja.getJSONArray("flag");
							JSONObject jo;
							for (int i = 0; i < js.length(); i++) {
								jo = js.getJSONObject(i);
								float price = (float) jo.getDouble("price");
								float discount = (float) jo
										.getDouble("discount");
								String bookName = jo.getString("bookName");
								String bookID = jo.getString("bookID");
								int TBID = jo.getInt("TBID");
								Toast.makeText(getActivity(), TBID+"", 0).show();
								int amount = jo.getInt("quantity");
								itemCounts+=amount;
								moneyShouldPay += price;
								mCartList.add(new CartItem(bookName, price,
										discount, amount, bookID,TBID));
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
						mAdapter.notifyDataSetChanged();
					}

				});

	}

	private void initView(View v) {
		mListView = (ListView) v.findViewById(R.id.fragment_cart_listview);
		mButton = (Button) v.findViewById(R.id.submit_order);
	}

}
