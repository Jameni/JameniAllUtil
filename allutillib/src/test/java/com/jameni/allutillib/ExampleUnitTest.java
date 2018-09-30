package com.jameni.allutillib;

import com.jameni.allutillib.common.TimeUtil;

import org.junit.Test;

import java.util.Date;

public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
//        print("result==" + TimeUtil.getCurrentDate(TimeUtil.formatType1));
//        print("result==" + TimeUtil.getCurrentDate(TimeUtil.formatType2));
//        print("result==" + TimeUtil.getCurrentDate(TimeUtil.formatType3));
//        print("result==" + TimeUtil.getCurrentDate(TimeUtil.formatType4));
//        print("result==" + TimeUtil.getCurrentDate(TimeUtil.formatType5));
//        print("result==" + TimeUtil.getCurrentDate(TimeUtil.formatType6));

        print("result==" + TimeUtil.getDateToString(new Date().getTime(),TimeUtil.formatType6));

    }

    public void print(String str) {
        System.out.println(str);
    }
}