package com.lzp.bookstore.activity;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class LogInActivity extends Activity {
	private EditText accountEditText;
	private EditText pwdEditText;
	private Button loginBtn;
	
	private String account;
	private String pwd;

	Intent nextIntent;
	SharedPreferences accountsPrefs;
	SharedPreferences curreentAccountsPrefs;
	
	Context context;
	
	private AsyncHttpClient asyncHttpClient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_in);

		context=getApplicationContext();
		asyncHttpClient=new AsyncHttpClient();
		
		initComponents();
		bindEvents();
	}
	
	protected void initComponents(){
		accountEditText=(EditText)findViewById(R.id.login_input_phone);
		pwdEditText=(EditText)findViewById(R.id.login_input_pwd);
		loginBtn=(Button)findViewById(R.id.log_in);
	}
	
	protected void bindEvents(){
		loginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				account=accountEditText.getText().toString();
				pwd=pwdEditText.getText().toString();
				if(!account.isEmpty()){
					requestLogin();
				}
			}
		});
		
	}
	
	private void requestLogin(){
		
		RequestParams params=new RequestParams();
//		params.put(Constants.ACTION_FLAG,"LogIn");
		params.put("userPhone", account);
		params.put("pswd", pwd);
		
		asyncHttpClient.get(this, Constants.LOGIN_URI, params, new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				try {
					int  flag = response.getInt("flag");
					
					if(flag == 1){
						Constants.userID = account;
						Constants.user_account_money = (float) response.getDouble("money");
						Constants.address = response.getString("address");
						nextIntent=new Intent(LogInActivity.this,MainActivity.class);
						startActivity(nextIntent);
						finish();
					}else if(flag == 0){
						Toast.makeText(LogInActivity.this,"wrong",Toast.LENGTH_SHORT).show();
					}else{
						Toast.makeText(LogInActivity.this,"wrong",Toast.LENGTH_SHORT).show();
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			@Override
			public void onFailure(int statusCode, Header[] headers,
					String responseString, Throwable throwable) {
				Toast.makeText(LogInActivity.this,statusCode+"",Toast.LENGTH_SHORT).show();
			}
		});
	}

}
