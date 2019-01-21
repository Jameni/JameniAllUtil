package com.jameni.allutillib.common;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class FileUtil {

    /**
     * 通过路径获取文件FILE
     *
     * @param filePath
     * @return
     */

    public static File getFileByPath(final String filePath) {
        return CommonUtil.hasSpace(filePath) ? null : new File(filePath);
    }


    /**
     * 文件是否存在
     *
     * @param file
     * @return
     */
    public static boolean isFileExists(final File file) {
        return file != null && file.exists();
    }

    public static String getFileProvider(Context context, String behind) {

        if (context == null || !CommonUtil.isNotEmpty(behind)) {
            return "";
        }
        return context.getPackageName() + behind;
    }


    /**
     * 得到sd卡路径
     *
     * @return
     */
    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        } else {
            return "";
        }
        return CommonUtil.isNotNull(sdDir) ? sdDir.toString() : "";
    }


    public boolean isFileExit(String path) {
        File file = new File(path);
        return isFileExists(file);
    }

    public void createPath(String path) {
        if (!isFileExit(path)) {
            File file = new File(path);
            file.mkdirs();
        }
    }


    /**
     * 判断文件夹下是否为空
     * @param path
     * @return
     */
    public boolean isDrectoryEmpty(String path) {

        if (isFileExit(path)) {
            File file = new File(path);
            File[] fileList = file.listFiles();

            if (fileList != null && fileList.length > 0) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }
}
