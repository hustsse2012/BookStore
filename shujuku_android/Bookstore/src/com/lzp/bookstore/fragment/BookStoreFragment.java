package com.lzp.bookstore.fragment;

import java.util.ArrayList;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.lzp.bookstore.R;
import com.lzp.bookstore.activity.BookDescActivity;
import com.lzp.bookstore.adapter.BookstoreAdapter;
import com.lzp.bookstore.model.Book;
import com.lzp.bookstore.model.Constants;

public class BookStoreFragment extends Fragment {
	private List<Book> bookList = new ArrayList<Book>();
	private GridView bookGridView;
	private View v;
	private BookstoreAdapter bookstoreAdapter;
	private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
	private EditText searchEdit;
	private Button searchButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.content_frame_gridview_layout, container,
				false);

		initView();
		loadData();


		return v;
	}

	private void initView() {
		bookGridView = (GridView) v.findViewById(R.id.girdview);
		bookstoreAdapter = new BookstoreAdapter(getActivity(), bookList);
		bookGridView.setAdapter(bookstoreAdapter);
		searchEdit = (EditText) v.findViewById(R.id.search_edittext);
		searchButton = (Button) v.findViewById(R.id.search_Button);

		searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String keyString = searchEdit.getText().toString();
				if (!keyString.isEmpty()) {
					RequestParams params = new RequestParams();
					params.put("keyword", keyString);

					asyncHttpClient.post(Constants.SearchServlet,
							new JsonHttpResponseHandler() {
								public void onSuccess(int statusCode,
										Header[] headers, JSONObject response) {
									bookList.clear();
									JSONArray jsonArray;
									try {
										jsonArray = response
												.getJSONArray("result");

										for (int i = 0; i < jsonArray.length(); i++) {
											JSONObject tempJsonObject = (JSONObject) jsonArray
													.get(i);
											String TBID = tempJsonObject
													.getString("TBID");
											String BID = tempJsonObject
													.getString("BID");
											String name = tempJsonObject
													.getString("name");
											String authors = tempJsonObject
													.getString("authors");
											String publish = tempJsonObject
													.getString("publish");
											float price = (float) tempJsonObject
													.getDouble("price");
											String catalogue = tempJsonObject
													.getString("catalogue");
											int buy_num = 0;
											int stockNum = tempJsonObject
													.getInt("stockNum");// 库存量
											String supplierID = tempJsonObject
													.getString("supplierID");

											bookList.add(new Book(TBID, BID,
													name, authors, publish,
													price, catalogue, buy_num,
													stockNum, supplierID));

										}
										bookstoreAdapter.notifyDataSetChanged();
									} catch (JSONException e) {
										e.printStackTrace();
									}

								};

								public void onFailure(int statusCode,
										Header[] headers, Throwable throwable,
										JSONObject errorResponse) {
									Toast.makeText(getActivity(), "ssss",
											Toast.LENGTH_LONG).show();
								};

							}

					);
				}
			}
		});
	}

	private void loadData() {

		asyncHttpClient.post(Constants.GET_BOOKS_URI,
				new JsonHttpResponseHandler() {
					public void onSuccess(int statusCode, Header[] headers,
							JSONObject response) {

						JSONArray jsonArray;
						try {
							jsonArray = response.getJSONArray("result");
							// Toast.makeText(getActivity(), jsonArray+"",
							// Toast.LENGTH_LONG).show();
							for (int i = 0; i < jsonArray.length(); i++) {
								JSONObject tempJsonObject = (JSONObject) jsonArray
										.get(i);
								String TBID = tempJsonObject.getString("TBID");
								String BID = tempJsonObject.getString("BID");
								String name = tempJsonObject.getString("name");
								String authors = tempJsonObject
										.getString("authors");
								String publish = tempJsonObject
										.getString("publish");
								float price = (float) tempJsonObject
										.getDouble("price");
								String catalogue = tempJsonObject
										.getString("catalogue");
								int buy_num = 0;
								int stockNum = tempJsonObject
										.getInt("stockNum");// 库存量
								String supplierID = tempJsonObject
										.getString("supplierID");

								Book book = new Book(TBID, BID, name, authors,
										publish, price, catalogue, buy_num,
										stockNum, supplierID);

								bookList.add(book);

							}

							Toast.makeText(getActivity(),
									bookList.size() + "aa", Toast.LENGTH_LONG)
									.show();
							bookstoreAdapter.notifyDataSetChanged();
						} catch (JSONException e) {
							e.printStackTrace();
						}

					};

					public void onFailure(int statusCode, Header[] headers,
							Throwable throwable, JSONObject errorResponse) {
						Toast.makeText(getActivity(), "ssss", Toast.LENGTH_LONG)
								.show();
					};

				}

		);
	}

}
