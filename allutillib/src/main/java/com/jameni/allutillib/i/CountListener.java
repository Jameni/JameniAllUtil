package com.jameni.allutillib.i;

/**
 * Created by jameni on 2018/1/20.
 * 获取到图片bitmap监听
 */

public interface CountListener {

    public void countEnd(int flag);

    public void countting(long timeLeft, int flag);
}
