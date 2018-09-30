package com.jameni.allutillib.common;

/**
 * 判断正则的工具类
 */
public class CheckUtil {


    //是否是手机
    public static boolean isTel(String tel) {
        boolean flag = false;
        if (CommonUtil.isNotNull(tel) && !CommonUtil.hasSpace(tel) && tel.length() == 11 && tel.startsWith("1")) {
            flag = true;
        }
        return flag;
    }
}
