package com.jameni.allutillib.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static String formatType1 = "yyyy年MM月dd日";
    public static String formatType2 = "yyyy-MM-dd";
    public static String formatType3 = "yyyy年MM月dd日 hh:ss";
    public static String formatType4 = "yyyy-MM-dd hh:ss";
    public static String formatType5 = "MM月dd日 hh:ss";
    public static String formatType6 = "MM-dd hh:ss";

    public static String getCurrentDate(String format) {
        Date d = new Date();
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(d);
    }

    public static long getCurrentStamp() {
        return new Date().getTime();
    }


    // 时间戳转换成字 日期
    public static String getDateToString(long stamp, String format) {
        Date d = new Date(stamp);
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(d);
    }


    /* 将字符串转为时间戳 */
    public static long getStringToDate(String time, String format) {

        long result = 0;
        SimpleDateFormat sf = new SimpleDateFormat(format);
        try {
            Date date = sf.parse(time);
            if (CommonUtil.isNotNull(date)) {
                result = date.getTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return result;
    }


    //这个月
    public static int getThisMonth() {
        Date date = new Date();
        return date.getMonth() + 1;
    }

    //今天的号数
    public static int getThisDay() {
        Date date = new Date();
        return date.getDate();
    }

    //今年
    public static int getThisYear() {

        Date date = new Date();
        return date.getYear();
    }

    //比较时间大小
    public int compareDate(String startDate, String endDate, String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date start = df.parse(startDate);
            Date end = df.parse(endDate);

            if (start.getTime() > end.getTime()) {
//                开始时间  大于  结束时间
                return -1;
            } else if (start.getTime() < end.getTime()) {
//                开始时间  小于  结束时间
                return 1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
