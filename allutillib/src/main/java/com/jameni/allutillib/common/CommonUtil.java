package com.jameni.allutillib.common;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class CommonUtil {

    /**
     * 判断是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj) {

        if (obj != null) {
            return true;
        }
        return false;

    }

    /**
     * 判断是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {

        if (str != null && !str.equals("")) {
            return true;
        }
        return false;

    }


    public static boolean isNotEmpty(EditText editText) {

        if (isNotNull(editText)) {
            return isNotEmpty(editText.getText().toString().trim());
        }
        return false;

    }

    public static boolean isNotEmpty(TextView textView) {

        if (isNotNull(textView)) {
            return isNotEmpty(textView.getText().toString().trim());
        }
        return false;

    }

    public static void tip(Context context, String str) {
        if (!isNotNull(context) || !isNotNull(str)) {
            return;
        }

        ToastUtil.getInstance().showToast(context, str, 2300);
    }

    /**
     * 判断对象是否为null
     *
     * @param obj
     * @return
     */
    public static boolean matchList(Object obj) {

        if (isNotNull(obj) && obj instanceof List<?>) {
            List<?> temp = (List<?>) obj;
            return temp.size() > 0;
        }
        return false;
    }


    public static boolean matchJSONArray(JSONArray array) {

        if (isNotNull(array)) {
            return array.length() > 0;
        }
        return false;

    }

    public static String getSelfValue(String str) {
        return str == null ? "" : str;

    }


    /**
     * 获取到json值
     *
     * @param json
     * @param key
     * @return
     */
    public static String getJsonValue(JSONObject json, String key) {
        try {
            if (isNotNull(json)) {
                if (json.has(key)) {
                    String value = json.getString(key);
                    if (!value.equals("") && value.equals("null")) {
                        value = "";
                    }
                    return value;
                } else {
                    return "";
                }
            }
            return "";
        } catch (JSONException e) {
            e.printStackTrace();
            PrintUtil.printMsg("页面数据解析出错==" + e.getMessage());
            return "";
        }
    }

    /**
     * 获取到json值
     *
     * @param json
     * @param key
     * @return
     */
    public static int getJsonValue_int(JSONObject json, String key) {
        try {
            if (isNotNull(json)) {
                if (json.has(key)) {

                    int value = json.getInt(key);
                    return value;
                } else {
                    return 0;
                }
            }
            return 0;
        } catch (JSONException e) {
            e.printStackTrace();
            PrintUtil.printMsg("页面数据解析出错==" + e.getMessage());
            return 0;
        }
    }


    /**
     * 获取到json对象
     *
     * @param json
     * @param key
     * @return
     */
    public static JSONObject getJSONObject(JSONObject json, String key) {
        try {
            if (isNotNull(json)) {
                if (json.has(key)) {
                    return json.getJSONObject(key);
                } else {
                    return new JSONObject();
                }
            }
            return new JSONObject();
        } catch (JSONException e) {
            e.printStackTrace();
            PrintUtil.printMsg("页面数据解析出错==" + e.getMessage());
            return new JSONObject();
        }
    }


    public static JSONArray getJSONArray(JSONObject json, String key) {
        try {
            if (isNotNull(json)) {
                if (json.has(key)) {
                    return json.getJSONArray(key);
                } else {
                    return new JSONArray();
                }
            }
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
            PrintUtil.printMsg("页面数据解析出错==" + e.getMessage());
            return new JSONArray();
        }
    }


    public static JSONObject getJSONArrayItem(JSONArray array, int i) {
        try {
            if (isNotNull(array) && array.length() > 0 && array.length() > i) {
                return array.getJSONObject(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            PrintUtil.printMsg("页面数据解析出错==" + e.getMessage());
            return new JSONObject();
        }
        return new JSONObject();

    }

    public static JSONArray makeJSONArray(String str) {

        if (isNotNull(str)) {

            try {
                JSONArray array = new JSONArray(str);
                return array;
            } catch (JSONException e) {
                e.printStackTrace();
                PrintUtil.printMsg("页面数据解析出错==" + e.getMessage());
                return new JSONArray();
            }
        }

        return new JSONArray();

    }

    public static JSONObject makeJSON(String str) {

        if (isNotNull(str)) {
            try {
                JSONObject array = new JSONObject(str);
                return array;
            } catch (JSONException e) {
                e.printStackTrace();
                PrintUtil.printMsg("页面数据解析出错==" + e.getMessage());
                return new JSONObject();
            }
        }

        return new JSONObject();

    }


    public static int getListSize(Object obj) {
        if (isNotNull(obj)) {
            if (obj instanceof List) {

                List list = toSelf(obj);
                if (isNotNull(list)) {
                    return list.size();
                }


            } else if (obj instanceof JSONArray) {

                JSONArray array = toSelf(obj);
                if (isNotNull(array)) {
                    return array.length();
                }

            } else if (obj instanceof Map) {

                Map map = toSelf(obj);
                if (isNotNull(map)) {
                    return map.size();
                }

            } else if (obj.getClass().isArray()) {

                Object[] array = toSelf(obj);
                if (isNotNull(array)) {
                    return array.length;
                }
            }


        }
        return 0;
    }

    //这个方法为了防止数组越界
    public static <T> T getListItem(List<T> list, int i) {

        if (matchList(list) && i >= 0 && list.size() > i) {
            return list.get(i);
        }

        return null;
    }


    public static String getIntentValue(String key, Intent data) {
        String value = "";
        if (!isNotEmpty(key)) {
            return value;
        }
        if (!isNotNull(data)) {
            return value;
        }
        value = getSelfValue(data.getStringExtra(key));

        return value;
    }

    public static int getIntentValue_Integer(String key, Intent data) {
        if (!isNotEmpty(key)) {
            return 0;
        }
        return data.getIntExtra(key, 0);

    }


    /**
     * 字符串切割
     *
     * @param key  原字符
     * @param flag 切割标识
     * @return
     */
    public static String[] cutString(String key, String flag) {

        if (isNotEmpty(key) && isNotEmpty(flag) && key.contains(flag)) {

            String[] array = key.split(flag);
            return array;
        }
        return null;
    }

    public static <T> T toSelf(Object object) {
        if (object == null) return null;
        return (T) object;
    }


    //    要判断一个字符串是不是包含空格关检查 ' '
    public static boolean hasSpace(final String s) {
        if (s == null) return true;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
