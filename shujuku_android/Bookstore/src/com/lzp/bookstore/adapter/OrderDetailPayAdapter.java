package com.lzp.bookstore.adapter;

import java.util.List;

import com.lzp.bookstore.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzp.bookstore.model.OrderDetailPayInfo;

public class OrderDetailPayAdapter extends BaseAdapter {
	Context context;
	private List<OrderDetailPayInfo> orderDetailPayList;

	public OrderDetailPayAdapter(Context context,
			List<OrderDetailPayInfo> orderDetailPayList) {
		this.context = context;
		this.orderDetailPayList = orderDetailPayList;
	}

	@Override
	public int getCount() {
		if(orderDetailPayList.isEmpty()){
			return 0;
		}else{
			return orderDetailPayList.size();
		}
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return orderDetailPayList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		OrderDetailPayInfo orderDetailPayInfo = orderDetailPayList.get(position);
		ViewHolder holder;
		
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.order_detail_pay_item,null);
			holder = new ViewHolder();
			
			holder.bkIDTextView = (TextView)convertView.findViewById(R.id.bk_id);
			holder.bkNameTextView = (TextView)convertView.findViewById(R.id.bk_name);
			holder.bkNumTextView = (TextView)convertView.findViewById(R.id.bk_num);
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		
		holder.bkIDTextView.setText(orderDetailPayInfo.gettBID());
		holder.bkNameTextView.setText(orderDetailPayInfo.getBkName());
		holder.bkNumTextView.setText(orderDetailPayInfo.getBkNum());
		
		return convertView;
	}
	
	final class ViewHolder{
		public TextView bkIDTextView;
		public TextView bkNameTextView;
		public TextView bkNumTextView;
	}

}
