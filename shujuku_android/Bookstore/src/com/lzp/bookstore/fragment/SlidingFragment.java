package com.lzp.bookstore.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lzp.bookstore.R;
import com.lzp.bookstore.activity.MainActivity;


public class SlidingFragment extends ListFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.slidingmenu_list, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		adapter.add(new SampleItem("书店", android.R.drawable.ic_menu_search));
		adapter.add(new SampleItem("购物车", android.R.drawable.ic_menu_search));
		adapter.add(new SampleItem("我的订单", android.R.drawable.ic_menu_search));
		adapter.add(new SampleItem("我的账户", android.R.drawable.ic_menu_search));
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
			newContent = new BookStoreFragment();
			break;
		case 1:
			newContent = new CartFragment();
			;
			break;
		case 2:
			newContent = new OrderDetailFragment();
			;
			break;
		case 3:
			newContent = new UserAccountFragment();
			;
			break;

		}
		if (newContent != null)
			switchFragment(newContent);
	}

	private void switchFragment(Fragment newContent) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchContent(newContent);
		} // TODO Auto-generated method stub
		
	}

	private class SampleItem {
		public String tag;
		public int iconRes;

		public SampleItem(String tag, int iconRes) {
			this.tag = tag;
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		@Override
		public int getCount() {

			return 4;
		}

		@Override
		public int getPosition(SampleItem item) {
			// TODO Auto-generated method stub
			return super.getPosition(item);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(
						R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView
					.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView
					.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

	}
}
