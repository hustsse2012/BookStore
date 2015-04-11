package com.lzp.bookstore.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzp.bookstore.R;
import com.lzp.bookstore.model.OrderDetailInfo;

public class OrderDetailAdapter extends BaseAdapter {
	Context context;
	private  List<OrderDetailInfo> orderDetailList;
	
	public OrderDetailAdapter(Context context,
			List<OrderDetailInfo> orderDetailList) {
		this.context = context;
		this.orderDetailList = orderDetailList;
	}

	@Override
	public int getCount() {
		if(orderDetailList.isEmpty()){
			return 0;
		}else{
			return orderDetailList.size();
		}
	}

	@Override
	public Object getItem(int arg0) {
		return orderDetailList.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		OrderDetailInfo infos = orderDetailList.get(position);
		ViewHolder holder;
		
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.gridview_item, null);
			
			holder = new ViewHolder();
			
			holder.OIDTextView = (TextView)convertView.findViewById(R.id.oid);
			holder.orderTimeTextView = (TextView)convertView.findViewById(R.id.order_time);
			holder.addressTextView = (TextView)convertView.findViewById(R.id.address);
			holder.deliverOptionTextView = (TextView)convertView.findViewById(R.id.deliver_option);
			holder.moneyTextView = (TextView)convertView.findViewById(R.id.money);
			holder.itemCountsTextView = (TextView)convertView.findViewById(R.id.item_counts);
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}

		holder.OIDTextView.setText(infos.getOID());;
		holder.orderTimeTextView.setText(infos.getOrderTime());;
		holder.addressTextView.setText(infos.getAddress());;
		if(infos.getState().equals("-1")){
			holder.deliverOptionTextView.setText("未付款");
		}else{
			holder.deliverOptionTextView.setText("已付款");
		}
		
		holder.moneyTextView.setText(Float.toString(infos.getMoney()));
		holder.itemCountsTextView .setText(Float.toString(infos.getItemCount()));;
		
		return convertView;
		
	}
	
	class ViewHolder{
		public TextView OIDTextView;
		public TextView orderTimeTextView;
		public TextView addressTextView;
		public TextView deliverOptionTextView;
		public TextView moneyTextView;
		public TextView itemCountsTextView;
		
	}

}
