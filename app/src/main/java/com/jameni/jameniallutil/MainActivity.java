package com.jameni.jameniallutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jameni.allutillib.app.SystemUtil;
import com.jameni.allutillib.common.CommonUtil;
import com.jameni.allutillib.common.CountUtil;
import com.jameni.allutillib.common.PrintUtil;
import com.jameni.allutillib.i.CountListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountUtil countUtil = new CountUtil(1000 * 10, new CountListener() {
            @Override
            public void countEnd(int flag) {
                print(" end ===" + flag);
            }

            @Override
            public void countting(long timeLeft, int flag) {

                print(timeLeft + "===" + flag);

            }
        });

        countUtil.setTag(100);
        countUtil.start();
    }


    public void click(View view) {

        SystemUtil.launchAppDetailsSettings(this,"com.hy3d.wristband");

    }
    public void print(String str) {
        PrintUtil.printMsg(str);
    }
}
