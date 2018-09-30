package com.jameni.allutillib.common;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import java.io.Serializable;

public class CopyUtil {
    /**
     * 实现文本复制功能
     *
     * @param content
     */
    public static void copy(String content, Context context) {
        // 得到剪贴板管理器
        if (context != null) {
            ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            cmb.setText(content.trim());


            ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            //noinspection ConstantConditions
            cm.setPrimaryClip(ClipData.newPlainText("text", content));
        }

    }


    /**
     * 获取剪贴板的文本
     *
     * @return 剪贴板的文本
     */
    public static CharSequence getText(Context context) {
        return CopyUtil.getText(context, 0);
    }


    /**
     * 获取剪贴板的文本
     *
     * @return 剪贴板的文本
     */
    public static CharSequence getText(Context context, int position) {

        if (CommonUtil.isNotNull(context)) {
            ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = cm.getPrimaryClip();
            if (clip != null && clip.getItemCount() > 0 && clip.getItemCount() > position) {
                return clip.getItemAt(position).coerceToText(context);
            }
        }
        return null;
    }


    /**
     * 实现粘贴功能
     *
     * @param context
     * @return
     */
    public static String paste(Context context) {
        // 得到剪贴板管理器
        if (context != null) {
            ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            return cmb.getText().toString().trim();
        }

        return null;
    }

    public static <T> T deepClone(final String data) {
        if (data == null) return null;
        //noinspection unchecked
        return (T) data;
    }
}
