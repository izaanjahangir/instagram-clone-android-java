package com.izaan.instagramclone;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class LoadingIndicator {
    private String text;
    Activity activity;
    AlertDialog dialog;

    LoadingIndicator(Activity myActivity, String myText) {
        activity = myActivity;
        text = myText;
    }

    public void setText(String myText){
        text = myText;
    }

    void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        View loadingView = inflater.inflate(R.layout.loading_indicator, null);
        TextView loadingTextView = loadingView.findViewById(R.id.loadingText);
        loadingTextView.setText(text);

        builder.setView(loadingView);
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }

    void hide() {
        dialog.hide();
    }
}
