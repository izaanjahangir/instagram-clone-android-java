package com.izaan.instagramclone;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class LoadingIndicator {
    Activity activity;
    AlertDialog dialog;

    LoadingIndicator(Activity myActivity){
        activity = myActivity;
    }

    void show(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loading_indicator, null));

        builder.setCancelable(false);
        dialog = builder.create();
        dialog.show();
    }

    void hide(){
        dialog.hide();
    }
}
