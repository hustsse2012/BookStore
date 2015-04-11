package com.lzp.bookstore.fragment;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.lzp.bookstore.R;
import com.lzp.bookstore.adapter.OrderDetailAdapter;
import com.lzp.bookstore.model.Constants;
import com.lzp.bookstore.model.OrderDetailInfo;

public class OrderDetailFragment extends Fragment {
	private List<OrderDetailInfo> orderDetailInfoList = new ArrayList<OrderDetailInfo>();
	private ListView listView;
	private OrderDetailAdapter orderDetailAdapter;
	AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
	
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.order_detail_layout, container, false);
		
		initView(v);
		loadData();
		
		return v;
	}

	private void initView(View v){
		listView = (ListView)v.findViewById(R.id.order_detail);
		orderDetailAdapter = new OrderDetailAdapter(getActivity(), orderDetailInfoList);
		listView.setAdapter(orderDetailAdapter);
	}
	
	private void loadData(){
		RequestParams params = new RequestParams();
		params.put("userID",Constants.userID);
		asyncHttpClient.post(Constants.GET_ORDER, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				try {
					JSONArray jsonArray = response.getJSONArray("flag");
					for(int i =0;i<jsonArray.length();i++){
						JSONObject obj = (JSONObject)jsonArray.get(i);
						String OID = obj.getString("OID");
						String orderTime = obj.getString("order_time");
						String address = obj.getString("del_address");
						String state = obj.getString("state");
						float money = (float) obj.getDouble("money");
						int orderItemCount = obj.getInt("order_item_count");
						String userID = obj.getString("userID");
						
						OrderDetailInfo info = new OrderDetailInfo(OID, orderTime, address, state, money, userID, orderItemCount);
						orderDetailInfoList.add(info);
					}
					
					orderDetailAdapter.notifyDataSetChanged();
				} catch (JSONException e) {
					e.printStackTrace();
				} 
			}
		});
	}
	
}
