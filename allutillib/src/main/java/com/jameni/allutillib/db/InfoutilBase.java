package com.jameni.allutillib.db;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.jameni.allutillib.common.CommonUtil;

public class InfoutilBase {

    protected Context context;
    protected SharedPreferences shared;
    protected SharedPreferences.Editor editor;
    protected String fileName;

    public InfoutilBase(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
        initSharedPreference();// 初始化存储文件
    }

    // 初始化存储文件
    private void initSharedPreference() {
        shared = context.getSharedPreferences(CommonUtil.isNotEmpty(fileName) ? fileName : "temp", Activity.MODE_PRIVATE);
        editor = shared.edit();
    }


}
