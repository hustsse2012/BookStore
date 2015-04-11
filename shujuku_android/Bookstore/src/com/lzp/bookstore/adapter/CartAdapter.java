package com.lzp.bookstore.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzp.bookstore.R;
import com.lzp.bookstore.model.CartItem;

public class CartAdapter extends BaseAdapter {

	private Context mContext;
	private List<CartItem> mCartList;

	public CartAdapter(Context mContext, List<CartItem> mCartList) {
		this.mContext = mContext;
		this.mCartList = mCartList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mCartList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mCartList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_cartlist, null);
			holder = new ViewHolder();
			holder.bookID = (TextView) convertView.findViewById(R.id.bookid);
			holder.bookName = (TextView) convertView
					.findViewById(R.id.bookname);
			holder.bookPrice = (TextView) convertView.findViewById(R.id.price);
			holder.quantity = (TextView) convertView
					.findViewById(R.id.quantity);
			holder.discount = (TextView) convertView
					.findViewById(R.id.discount);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		CartItem cart = mCartList.get(position);
		holder.bookID.setText(cart.getBookID());
		holder.bookName.setText(cart.getBookName());
		holder.bookPrice.setText(cart.getPrice() + "");
		holder.discount.setText(cart.getDiscount() + "");
		holder.quantity.setText(cart.getAmount() + "");
		return convertView;
	}

	final class ViewHolder {
		public TextView bookID;
		public TextView bookName;
		public TextView bookPrice;
		public TextView quantity;
		public TextView discount;
	}
}
