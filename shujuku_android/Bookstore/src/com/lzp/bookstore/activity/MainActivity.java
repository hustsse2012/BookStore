package com.lzp.bookstore.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lzp.bookstore.R;
import com.lzp.bookstore.fragment.BookStoreFragment;
import com.lzp.bookstore.fragment.CartFragment;
import com.lzp.bookstore.fragment.SlidingFragment;

// 不要改这个activity
public class MainActivity extends FragmentActivity {
	private SlidingMenu menu;
	private Fragment mContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 设置标题
		setTitle("MyBookstore");

		// 初始化滑动菜单
		initSlidingMenu();
	}

	/**
	 * 初始化滑动菜单
	 */
	private void initSlidingMenu() {
		// 设置主界面视图
		setContentView(R.layout.content_frame);
		// getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
		// new SampleListFragment()).commit();

		// 设置滑动菜单的属性值
		menu = new SlidingMenu(this);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		 menu.setShadowWidthRes(R.dimen.shadow_width);
		 menu.setShadowDrawable(R.drawable.shadow);
		 menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		// 设置滑动菜单的视图界面
		mContent = new BookStoreFragment();
		menu.setMenu(R.layout.menu_frame);
		menu.setContent(R.layout.content_frame);
		getSupportFragmentManager().beginTransaction().replace(
				R.id.content_frame, mContent).commit();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new SlidingFragment()).commit();
	}

	@Override
	public void onBackPressed() {
		// 点击返回键关闭滑动菜单
		if (menu.isMenuShowing()) {
			menu.showContent();
		} else {
			super.onBackPressed();
		}
	}

	public void switchContent(Fragment newContent) {
		mContent = newContent;
		getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, newContent).commit();
		menu.showContent();
	}
}
