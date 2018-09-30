package com.jameni.allutillib.common;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class FileUtil {

    public static File getFileByPath(final String filePath) {
        return CommonUtil.hasSpace(filePath) ? null : new File(filePath);
    }



    public static boolean isFileExists(final File file) {
        return file != null && file.exists();
    }

    public static String getFileProvider(Context context, String behind) {

        if (context == null || !CommonUtil.isNotEmpty(behind)) {
            return "";
        }
        return context.getPackageName() + behind;
    }


    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        } else {
           return  "";
        }
        return CommonUtil.isNotNull(sdDir) ? sdDir.toString() : "";
    }

}
