package com.lzp.bookstore.activity;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.lzp.bookstore.R;
import com.lzp.bookstore.model.Constants;

public class RegistActivity extends Activity {
	private EditText userNameEditText;
	private EditText pwdText;
	private EditText emailEditText;
	private TextView addressEditText;
	private TextView phoneEditText;
	private Button registButton;

	String userName;
	String pwd;
	String email;
	String phone;
	String uid;
	String address;

	private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist);
		initComponents();
		bindEvents();
	}

	private void initComponents() {
		userNameEditText = (EditText) findViewById(R.id.usrName);
		pwdText = (EditText) findViewById(R.id.editText2);
		emailEditText = (EditText) findViewById(R.id.email);
		addressEditText = (EditText) findViewById(R.id.address);
		phoneEditText = (TextView) findViewById(R.id.phone);
		registButton = (Button) findViewById(R.id.regist);
	}

	private void bindEvents() {

		registButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				userName = userNameEditText.getText().toString();
				pwd = pwdText.getText().toString();
				email = emailEditText.getText().toString();
				phone = phoneEditText.getText().toString();
				uid = userName;
				address = addressEditText.getText().toString();
				RequestParams params = new RequestParams();
				params.put("uid", uid);
				params.put("userName", userName);
				params.put("phone", phone);
				params.put("email", email);
				params.put("pswd", pwd);
				params.put("address", address);

				asyncHttpClient.post(Constants.REGIST_URI, params,
						new JsonHttpResponseHandler() {
							@Override
							public void onSuccess(int statusCode,
									Header[] headers, JSONObject response) {
								super.onSuccess(statusCode, headers, response);
								try {
									boolean addFlag = response
											.getBoolean("result");
									if (addFlag) {
										Constants.userID = uid;
										Constants.address = address;
										Constants.user_account_money = 5000;
										Intent nextIntent = new Intent(
												RegistActivity.this,
												MainActivity.class);
										startActivity(nextIntent);
										finish();
									} else {
										Toast.makeText(RegistActivity.this,
												"注册失败", Toast.LENGTH_LONG)
												.show();
									}
								} catch (JSONException e) {
									e.printStackTrace();
								}
							}

							@Override
							public void onFailure(int statusCode,
									Header[] headers, String responseString,
									Throwable throwable) {
								super.onFailure(statusCode, headers,
										responseString, throwable);
								Toast.makeText(RegistActivity.this, "失败",
										Toast.LENGTH_LONG).show();
							}
						});
			}
		});
	}

}
