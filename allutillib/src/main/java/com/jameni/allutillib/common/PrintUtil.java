package com.jameni.allutillib.common;

import android.util.Log;

/**
 * 打印信息
 */
public class PrintUtil {


    public static void printMsg(String tag, String str) {

        if (!CommonUtil.isNotEmpty(tag)) {
            tag = "printInfo";
        }

        if (CommonUtil.isNotNull(str)) {
            Log.i(tag, str);
        } else {
            Log.i(tag, "打印对象为空 == null");
        }
    }


    public static void printMsg(String str) {
        printMsg("printInfo", str);
    }

    public static void printMsg(int num) {
        printMsg("printInfo", num + "");
    }

    public static void printMsg(double num) {
        printMsg("printInfo", num + "");
    }

    public static void printMsg(float num) {
        printMsg("printInfo", num + "");
    }

    public static void printMsg(boolean bool) {
        printMsg("printInfo", bool + "");
    }
}
