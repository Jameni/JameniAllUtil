package com.jameni.allutillib.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DoubleUtil {


    //加法
    public static Double add(Double num1, Double num2) {
        BigDecimal b1 = new BigDecimal(num1.toString());
        BigDecimal b2 = new BigDecimal(num2.toString());
        return b1.add(b2).doubleValue();
    }
    //减法
    public static Double sub(Double before, Double behind) {
        BigDecimal b1 = new BigDecimal(before.toString());
        BigDecimal b2 = new BigDecimal(behind.toString());
        return b1.subtract(b2).doubleValue();
    }


    /**
     * 保留两位小数点
     * @param num
     * @return
     */
    public static String getmun(Double num) {

        if (num % 1.0 == 0) {
            return String.valueOf( Integer.parseInt(new java.text.DecimalFormat("0").format(num)));
        }
        BigDecimal b = new BigDecimal(num);
        int saveBitNum = 2;// 四舍五入,保留两个小数.
        double c = b.setScale(saveBitNum, BigDecimal.ROUND_HALF_UP).doubleValue();
        return String.valueOf(c);

    }


    //保留一位小数
    public static String getmun(String num) {

        double n= Double.valueOf(num);
        if (n % 1.0 == 0) {
            return String.valueOf( Integer.parseInt(new java.text.DecimalFormat("0").format(n)));
        }
        BigDecimal b = new BigDecimal(num);
        int saveBitNum = 1;// 四舍五入,保留1个小数.
        double c = b.setScale(saveBitNum, BigDecimal.ROUND_HALF_UP).doubleValue();
        return String.valueOf(c);

    }


    /**
     *
     * 如果后面是0 ，就去掉0
     * @param num 格式化double
     * @return
     */
    public static String formatDouble(double num) {

        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
        return  decimalFormat.format(num);

    }



}
