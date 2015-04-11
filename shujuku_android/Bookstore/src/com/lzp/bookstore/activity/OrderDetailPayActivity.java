package com.lzp.bookstore.activity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.lzp.bookstore.R;
import com.lzp.bookstore.adapter.OrderDetailPayAdapter;
import com.lzp.bookstore.model.Constants;
import com.lzp.bookstore.model.OrderDetailPayInfo;

public class OrderDetailPayActivity extends Activity {
	private List<OrderDetailPayInfo> orderDetailList = new ArrayList<OrderDetailPayInfo>();
	private ListView listView;

	private TextView userNameTextView;
	private TextView addressTextView;
	private TextView phoneTextView;
	private TextView orderTimetView;
	private TextView deliverTimeTextView;
	private Button payAfterGoods;
	private RelativeLayout afterGoods;
	private Button payButton;

	private int level;
	private String OID;
	private String UID;
	private String userName;
	private String address;
	private String phone;
	private String orderTime;
	private String deliverTime;
	private float moneyShouldPay;
	private float moneyRealPay;

	private String result;
	private float discount;
	private String deliver;
	private int allItems = 0;

	private OrderDetailPayAdapter orderDetailPayAdapter;
	private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_detail_pay_layout);

		initView();
		loadData();

	}

	private void loadData() {
		RequestParams params = new RequestParams();
		params.put("UID", Constants.userID);
		params.put("OID", getIntent().getStringExtra("OID"));
		asyncHttpClient.post(Constants.ORDER_DETAIL_URI, params,
				new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(int statusCode, Header[] headers,
							JSONObject response) {
						try {
							result = response.getString("result");
							if (result.equals("empty")) {
								Toast.makeText(OrderDetailPayActivity.this,
										"获取数据为空", Toast.LENGTH_LONG).show();
							} else {
								JSONArray jsonArray = new JSONArray(result);
								for (int i = 0; i < jsonArray.length(); i++) {
									JSONObject tempJsonObject = (JSONObject) jsonArray
											.get(i);
									String bookName = tempJsonObject
											.getString("bookName");
									String bookID = tempJsonObject
											.getString("bookID");
									String quantity = tempJsonObject
											.getString("quantity");

									OrderDetailPayInfo orderDetailPayInfo = new OrderDetailPayInfo(
											bookID, bookName, quantity);
									orderDetailList.add(orderDetailPayInfo);
									allItems++;
								}

								orderDetailPayAdapter.notifyDataSetChanged();

								// 获取送货时间，金额等信息

								JSONObject object = (JSONObject) jsonArray
										.get(0);
								Toast.makeText(OrderDetailPayActivity.this,
										object.toString(), 0).show();
								OID = object.getString("OID");
								UID = object.getString("UID");
								userName = object.getString("name");
								address = object.getString("del_address");
								phone = object.getString("phone");
								orderTime = object.getString("order_time");
								moneyShouldPay = (float) object
										.getDouble("money_should_pay");
								level = object.getInt("level");

							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
						userNameTextView.setText(userName);
						addressTextView.setText(address);
						phoneTextView.setText(phone);
						orderTimetView.setText(orderTime);
						deliverTimeTextView.setText(deliverTime);

						if (level < 3) {
							afterGoods.setVisibility(View.GONE);
						} else {
							payAfterGoods
									.setOnClickListener(new OnClickListener() {
										@Override
										public void onClick(View v) {
											deliver = "货到付款";
										}
									});
						}
						switch (level) {
						case 0:
							discount = 0;
							break;
						case 1:
							discount = (float) 0.1;
							break;
						case 2:
							discount = (float) 0.15;
							break;
						case 3:
							discount = (float) 0.15;
							break;
						case 4:
							discount = (float) 0.2;
							break;
						case 5:
							discount = (float) 0.25;
							break;

						default:
							break;
						}
						moneyRealPay = (1 - discount) * moneyShouldPay;
						((TextView) findViewById(R.id.money_should_pay))
								.setText(moneyRealPay + "");
						if (moneyRealPay < Constants.user_account_money) {
							Constants.user_account_money -= moneyRealPay;
							payButton.setEnabled(true);
						} else {
							Toast.makeText(OrderDetailPayActivity.this,
									"账户余额不足", Toast.LENGTH_SHORT).show();
							payButton.setEnabled(false);
						}

						Timestamp t = new Timestamp(System.currentTimeMillis());
						deliverTime = t.toString();
						((TextView) findViewById(R.id.deliver_time))
								.setText(deliverTime + "");
						
					}

				});

	}

	private void initView() {
		userNameTextView = (TextView) findViewById(R.id.user_name);
		addressTextView = (TextView) findViewById(R.id.address);
		phoneTextView = (TextView) findViewById(R.id.user_phone);
		orderTimetView = (TextView) findViewById(R.id.order_time);
		deliverTimeTextView = (TextView) findViewById(R.id.deliver_time);
		afterGoods = (RelativeLayout) findViewById(R.id.after_goods);
		payAfterGoods = (Button) findViewById(R.id.pay_after_goods);
		payButton = (Button) findViewById(R.id.pay_button);
		listView = (ListView) findViewById(R.id.order_item_detail);
		orderDetailPayAdapter = new OrderDetailPayAdapter(this, orderDetailList);
		listView.setAdapter(orderDetailPayAdapter);

		payButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (result.equals("empty") || result.isEmpty()) {
					Toast.makeText(OrderDetailPayActivity.this, "发生错误",
							Toast.LENGTH_LONG).show();
				} else {

					RequestParams params = new RequestParams();
					params.put("OID", OID);
					params.put("UID", UID);
					params.put("pay_time", deliverTime);
					params.put("money_should_pay", moneyShouldPay);
					params.put("money_real_pay", moneyRealPay);
					params.put("deliver_time", deliverTime);

					asyncHttpClient.post(Constants.OEDER_DETAIL_PAY_URI,
							params, new JsonHttpResponseHandler() {
								public void onSuccess(int statusCode,
										Header[] headers, JSONObject response) {
									Toast.makeText(OrderDetailPayActivity.this,
											"成功", Toast.LENGTH_LONG).show();
								};
							});
				}
			}
		});
	}

}
