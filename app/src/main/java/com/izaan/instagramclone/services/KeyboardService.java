package com.izaan.instagramclone.services;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardService {
    public static void close(Activity myActivity) {
        final View focusedView = myActivity.getCurrentFocus();

        if (focusedView != null) {
            InputMethodManager imm = (InputMethodManager) myActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }
}
