package com.jameni.allutillib.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.FileProvider;
import android.telephony.TelephonyManager;

import com.jameni.allutillib.common.CommonUtil;
import com.jameni.allutillib.common.FileUtil;

import java.io.File;

public class SystemUtil {

    //安装一个app
    public static void installApp(Activity activity, Context context, final String fileProvider, final String filePath) {


        if (activity == null) return;
        if (context == null) return;

        if (!CommonUtil.isNotEmpty(fileProvider)) return;

        //判断文件是否存在
        File file = FileUtil.getFileByPath(filePath);
        if (!FileUtil.isFileExists(file)) return;

        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data;
        String type = "application/vnd.android.package-archive";
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            data = Uri.fromFile(file);
        } else {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            data = FileProvider.getUriForFile(context, fileProvider, file);
        }
        intent.setDataAndType(data, type);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

    }

    //判断手机是否root
    private static boolean isDeviceRooted() {
        String su = "su";
        String[] locations = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/",
                "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/"};
        for (String location : locations) {
            if (new File(location + su).exists()) {
                return true;
            }
        }
        return false;
    }


    /**
     * 跳到应用详情系统设置页面
     */
    public static void goAppDetailsSettings(Activity activity, final String packageName) {
        if (CommonUtil.isNotNull(activity)) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + packageName));
            activity.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

        }
    }


    /**
     * 跳到应用详情系统设置页面
     */
    public static void goSystemSettingPage(Activity activity, final String packageName) {
        if (!CommonUtil.isNotNull(activity)) return;

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (Build.VERSION.SDK_INT >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + packageName));

        } else if (Build.VERSION.SDK_INT <= 8) {

            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", packageName);

        }

        activity.startActivity(intent);
    }

    //去系统设置页面
    public static void goSystemSettingPage(Activity activity) {
        if (CommonUtil.isNotNull(activity)) {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            activity.startActivity(intent);
        }
    }

    //拨打电话页面
    public static void goCallPage(Activity activity, String tel) {
        if (CommonUtil.isNotNull(activity) && CommonUtil.isNotEmpty(tel)) {
            Intent intent = new Intent(Intent.ACTION_DIAL);

            if (tel.startsWith("tel:")) {
                intent.setData(Uri.parse(tel));
            } else {
                intent.setData(Uri.parse("tel:" + tel));
            }

            activity.startActivity(intent);
        }
    }


    //获取app版本名
    public static String getVersionName(Context context) {

        String verName = "";
        if (CommonUtil.isNotNull(context)) {
            try {
                PackageManager pm = context.getPackageManager();
                if (CommonUtil.isNotNull(pm)) {
                    PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
                    if (CommonUtil.isNotNull(info)) {
                        verName = info.versionName;
                    }
                }

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return verName;
            }

        }

        return CommonUtil.getSelfValue(verName);

    }


    //获取app版本号
    public static String getVersionCode(Context context) {

        String verCode = "";
        if (CommonUtil.isNotNull(context)) {
            try {
                PackageManager pm = context.getPackageManager();
                if (CommonUtil.isNotNull(pm)) {
                    PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
                    if (CommonUtil.isNotNull(info)) {
                        verCode = info.versionCode + "";
                    }
                }

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return verCode;
            }

        }

        return CommonUtil.getSelfValue(verCode);

    }


    /**
     * 获取手机IMEI
     */
    @SuppressLint("MissingPermission")
    public static String getDeviceId(Context context) {

        String deviceId = "";

        if (CommonUtil.isNotNull(context)) {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);

            if (CommonUtil.isNotNull(tm)) {
                deviceId = tm.getDeviceId();
            }
        }

        return CommonUtil.getSelfValue(deviceId);
    }

    /**
     * 是否连接网络
     */
    public static boolean isNetworkConnected(Context context) {

        boolean isConnected = false;

        if (CommonUtil.isNotNull(context)) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (CommonUtil.isNotNull(cm)) {
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                if (CommonUtil.isNotNull(netInfo)) {
                    isConnected = netInfo.isAvailable();
                }
            }
        }

        return isConnected;
    }


    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     */
    public static boolean isOPenGps(Context context) {
        boolean isOpen = false;
        if (CommonUtil.isNotNull(context)) {
            LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

            if (CommonUtil.isNotNull(lm)) {
                boolean gps = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
                boolean network = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                if (gps || network) {
                    isOpen = true;
                }
            }
        }

        return isOpen;
    }

}
