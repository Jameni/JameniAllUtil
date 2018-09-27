package com.jameni.allutillib.common;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

/**
 * 获取屏幕信息
 *
 * @author jameni
 */
public class GetWindowSize {

    private Context context;
    private WindowManager wm;

    public GetWindowSize(Context context) {
        this.context = context;
        wm = ((Activity) context).getWindowManager();
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public int getWindowWidth() {
        return wm.getDefaultDisplay().getWidth();
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public int getWindowHeight() {
        return wm.getDefaultDisplay().getHeight();
    }

    // 状态栏高度
    public int getstatusBarHeight() {

        int result = 0;
        if (context != null) {
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = context.getResources().getDimensionPixelSize(resourceId);
            }
        }

        return result;
    }

    /**
     * 获取导航栏高度
     */
    public int getNavigationBarHeight() {
        int result = 0;
        int resourceId = 0;
        int rid = context.getResources().getIdentifier("config_showNavigationBar", "bool", "android");
        if (rid != 0) {
            resourceId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            return context.getResources().getDimensionPixelSize(resourceId);
        } else
            return 0;
    }


    //除了状态栏的 页面高度
    public int getPageHight() {
        return getWindowHeight() - getstatusBarHeight();
    }

    //除了状态栏和 页面title的高度
    public int getContentHight(int dimen) {
        return getPageHight() - getPageTitleHight(dimen);
    }

    //页面title的高度
    public int getPageTitleHight(int dimen) {
        return context.getResources().getDimensionPixelOffset(dimen);
    }
}
