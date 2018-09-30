package com.jameni.allutillib.common;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class ToastUtil {
	private Toast mToast;
	private Handler mHandler = new Handler();
	private Runnable r = new Runnable() {
		public void run() {
			mToast.cancel();
		}
	};

	public static ToastUtil instance;

	public static ToastUtil getInstance() {
		if (instance == null) {
			instance = new ToastUtil();
		}

		return instance;
	}

	public void showToast(Context mContext, String text, int duration) {

		mHandler.removeCallbacks(r);
		if (mToast != null)
			mToast.setText(text);
		else
			mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
		mHandler.postDelayed(r, duration);

		mToast.show();
	}
	public void showToast(Context mContext, String text) {

		mHandler.removeCallbacks(r);
		if (mToast != null)
			mToast.setText(text);
		else
			mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
		mHandler.postDelayed(r, Toast.LENGTH_LONG);

		mToast.show();
	}

	public void showToast(Context mContext, int resId, int duration) {
		showToast(mContext, mContext.getResources().getString(resId), duration);
	}
}
