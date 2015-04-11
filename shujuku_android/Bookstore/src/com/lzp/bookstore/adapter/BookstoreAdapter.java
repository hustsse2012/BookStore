package com.lzp.bookstore.adapter;

import java.util.List;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.lzp.bookstore.R;
import com.lzp.bookstore.activity.BookDescActivity;
import com.lzp.bookstore.model.Book;
import com.lzp.bookstore.model.Constants;

public class BookstoreAdapter extends BaseAdapter {

	Context context;
	private List<Book> bookList;
	AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

	public BookstoreAdapter(Context context, List<Book> bookList) {
		super();
		this.context = context;
		this.bookList = bookList;
	}

	@Override
	public int getCount() {
		return bookList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return bookList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final Book book = bookList.get(position);
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.gridview_item, null);

			holder = new ViewHolder();

			holder.bookImageView = (ImageView) convertView
					.findViewById(R.id.book_image);
			holder.bookNameTextView = (TextView) convertView
					.findViewById(R.id.book_name);
			holder.bookPriceTextView = (TextView) convertView
					.findViewById(R.id.book_price);
			holder.bookNumTextView = (TextView) convertView
					.findViewById(R.id.book_num);
			holder.addBookTextView = (Button) convertView
					.findViewById(R.id.add_book);
			holder.descBookTextView = (Button) convertView
					.findViewById(R.id.desc_book);
			holder.addToCartTextView = (Button) convertView
					.findViewById(R.id.add_to_cart);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// holder.bookImageView.setImageDrawable(R.drawable.bk1);
		holder.bookImageView.setImageResource(R.drawable.bk1);
		holder.bookNameTextView.setText(book.getName());
		holder.bookPriceTextView.setText(Float.toString(book.getPrice()));
		holder.bookNumTextView.setText(Integer.toString(book.getBuy_num()));

		holder.addBookTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(context, book.getStockNum() + "", 0).show();
				if ((book.getStockNum() - book.getBuy_num()) > 0) {
					int buyNum = book.getBuy_num() + 1;
					book.setBuy_num(buyNum);
					holder.bookNumTextView.setText(Integer.toString(buyNum));
					// holder.bookNumTextView.setText("azhangman");
					holder.bookNumTextView.setText(Integer.toString(book
							.getBuy_num()));

				} else {
				}
			}
		});

		holder.descBookTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (book.getBuy_num() > 0) {
					int buyNum = book.getBuy_num() - 1;
					book.setBuy_num(buyNum);
					holder.bookNumTextView.setText(Integer.toString(buyNum));
				} else {
					holder.bookNumTextView.setText("0");
				}
			}
		});

		holder.addToCartTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				RequestParams params = new RequestParams();
				params.put("userPhone", Constants.userID);
				params.put("bookID", book.getBID());
				params.put("bookname", book.getName());
				params.put("quantity", book.getBuy_num());
				// TODO
				asyncHttpClient.post(Constants.POST_TO_CART_URI, params,
						new JsonHttpResponseHandler() {
							@Override
							public void onSuccess(int statusCode,
									Header[] headers, JSONObject response) {
								boolean flag;
								try {
									flag = response.getBoolean("flag");
									if (flag) {
										Toast.makeText(context, "添加成功",
												Toast.LENGTH_LONG).show();
									} else {
										Toast.makeText(context, "添加失败",
												Toast.LENGTH_LONG).show();
									}
								} catch (JSONException e) {
									e.printStackTrace();
								}

							}

							@Override
							public void onFailure(int statusCode,
									Header[] headers, Throwable throwable,
									JSONObject errorResponse) {
								super.onFailure(statusCode, headers, throwable,
										errorResponse);
							}
						});
			}
		});
		holder.bookImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent newIntent = new Intent(context,
						BookDescActivity.class);
				newIntent.putExtra("name", book.getName());
				newIntent.putExtra("price", book.getPrice());
				newIntent.putExtra("num", book.getBuy_num());
				newIntent.putExtra("publish", book.getPublish());
				newIntent.putExtra("authors", book.getAuthors());
				newIntent.putExtra("catalogue", book.getCatalogue());
				newIntent.putExtra("supplier", book.getSupplierID());
				context.startActivity(newIntent);
			}
		});

		return convertView;

	}

	final class ViewHolder {
		public ImageView bookImageView;
		public TextView bookNameTextView;
		public TextView bookPriceTextView;
		public TextView bookNumTextView;
		public Button addBookTextView;
		public Button descBookTextView;
		public Button addToCartTextView;

	}

}
