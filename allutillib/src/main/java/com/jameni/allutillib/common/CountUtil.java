package com.jameni.allutillib.common;

import android.os.CountDownTimer;

import com.jameni.allutillib.i.CountListener;

public class CountUtil extends CountDownTimer {

    private CountListener listener;
    private int tag;

    public void setTag(int tag) {
        this.tag = tag;
    }

    public CountUtil(long millisInFuture, CountListener listener) {
        super(millisInFuture, 1000);//间隔1秒
        this.listener = listener;
    }

    @Override
    public void onFinish() {
        if (CommonUtil.isNotNull(listener)) {
            listener.countEnd(tag);
        }
    }

    @Override
    public void onTick(long avaliable) {
        long timeLeft = avaliable / 1000;//剩余时间 单位 秒
        if (CommonUtil.isNotNull(listener)) {
            listener.countting(timeLeft, tag);
        }

    }
}
