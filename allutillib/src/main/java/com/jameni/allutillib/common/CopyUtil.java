package com.jameni.allutillib.common;

import android.content.ClipboardManager;
import android.content.Context;

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
        }

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
}
