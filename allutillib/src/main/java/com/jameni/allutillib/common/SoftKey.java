package com.jameni.allutillib.common;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class SoftKey {

    public static void closeSoftKeyboard(EditText editText, Context context) {
        editText.clearFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

    }

}
