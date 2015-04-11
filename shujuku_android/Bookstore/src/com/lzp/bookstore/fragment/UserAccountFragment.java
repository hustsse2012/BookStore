package com.lzp.bookstore.fragment;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.lzp.bookstore.R;
import com.lzp.bookstore.model.Constants;

public class UserAccountFragment extends Fragment {

	private EditText userName;
	private EditText password;
	private EditText email;
	private EditText address;
	private EditText phone;
	private TextView level;
	private TextView accountmoney;
	private TextView balanceMoney;
	private TextView hasConsumeMoney;
	private Button submitButton;
	private AsyncHttpClient client;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_user_account, null, false);
		client = new AsyncHttpClient();
		initView(v);
		bindEvents();
		loadData();
		return v;
	}

	private void bindEvents() {
		submitButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				RequestParams params = new RequestParams();
				params.add("UID", Constants.userID);
				params.add("password", password.getEditableText().toString());
				params.add("address", address.getEditableText().toString());
				params.add("email", email.getEditableText().toString());
				params.add("phone", phone.getEditableText().toString());
				params.add("name", userName.getEditableText().toString());
				client.post(getActivity(), Constants.UPDATE_ACCOUNT_SERVLET_URL, params,
						new JsonHttpResponseHandler() {

							@Override
							public void onFailure(int statusCode,
									Header[] headers, String responseString,
									Throwable throwable) {
								// TODO Auto-generated method stub
								super.onFailure(statusCode, headers,
										responseString, throwable);
							}

							@Override
							public void onSuccess(int statusCode,
									Header[] headers, JSONObject responseString) {
								Toast.makeText(getActivity(), "success",
										Toast.LENGTH_SHORT).show();
							}

						});
			}
		});
	}

	private void loadData() {
		RequestParams params = new RequestParams();
		params.add("userID", Constants.userID);
		client.post(getActivity(), Constants.GET_ACCOUNT_SERVLET_URL, params,
				new JsonHttpResponseHandler() {

					@Override
					public void onFailure(int statusCode, Header[] headers,
							String responseString, Throwable throwable) {
						super.onFailure(statusCode, headers, responseString,
								throwable);
					}

					@Override
					public void onSuccess(int statusCode, Header[] headers,
							JSONObject js) {
						try {
							JSONObject user = js.getJSONObject("flag");
							Toast.makeText(getActivity(), user.toString(),0).show();
							userName.setText(user.getString("userName"));
							password.setText(user.getString("password"));
							email.setText(user.getString("email"));
							address.setText(user.getString("address"));
							phone.setText(user.getString("phone"));
							level.setText(user.getInt("level") + "");
							accountmoney.setText(""
									+ ((float) user
											.getDouble("userAccountMoney")));
							balanceMoney.setText(""
									+ ((float) user.getDouble("accountBalance")));
							hasConsumeMoney.setText(""
									+ ((float) user
											.getDouble("moneyHasConsume")));
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}

				});
	}

	private void initView(View v) {
		userName = (EditText) v.findViewById(R.id.usrName);
		password = (EditText) v.findViewById(R.id.password);
		email = (EditText) v.findViewById(R.id.email);
		address = (EditText) v.findViewById(R.id.address);
		phone = (EditText) v.findViewById(R.id.phone);
		level = (TextView) v.findViewById(R.id.level);
		accountmoney = (TextView) v.findViewById(R.id.accountmoney);
		balanceMoney = (TextView) v.findViewById(R.id.balancemoney);
		hasConsumeMoney = (TextView) v.findViewById(R.id.consumemoney);
		submitButton = (Button) v.findViewById(R.id.submituser);
	}

}
