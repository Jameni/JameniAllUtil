package com.jameni.allutillib.common;

public class NumUtil {


    public static int getIntegerVale(String num) {

        int result = 0;
        if (CommonUtil.isNotEmpty(num)) {
            result = Integer.valueOf(num);
        }
        return result;
    }

    public static double getDoubleVale(String num) {

        double result = 0;
        if (CommonUtil.isNotEmpty(num)) {
            result = Double.valueOf(num);
        }
        return result;
    }

    public static double getFloatValue(String num) {

        float result = 0;
        if (CommonUtil.isNotEmpty(num)) {
            result = Float.valueOf(num);
        }
        return result;
    }

}
