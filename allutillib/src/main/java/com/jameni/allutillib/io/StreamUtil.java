package com.jameni.allutillib.io;

import com.jameni.allutillib.common.CommonUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {


    //留转化为 字符串
    public static String toString(InputStream inputStream) {

        String result = "";

        if (CommonUtil.isNotNull(inputStream)) {
            try {
                ByteArrayOutputStream bios = new ByteArrayOutputStream();
                int i = -1;
                while ((i = inputStream.read()) != -1) {
                    bios.write(i);
                }
                inputStream.close();
                result = bios.toString("utf-8");
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
        return result;
    }
}
