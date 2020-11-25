package com.izaan.instagramclone;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class NotificationListener extends NotificationListenerService {
    private static final String TAG = "NotificationListener";
    private static final String WA_PACKAGE = "com.whatsapp";

    @Override
    public void onListenerConnected() {
        Log.i(TAG, "Notification Listener connected");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (!sbn.getPackageName().equals(WA_PACKAGE)) return;

        Notification notification = sbn.getNotification();
        Bundle bundle = notification.extras;

        String from = bundle.getString(NotificationCompat.EXTRA_TITLE);
        String message = bundle.getString(NotificationCompat.EXTRA_TEXT);
        String group = NotificationCompat.getGroup(notification);
        String category = NotificationCompat.getCategory(notification);
//        Log.i(TAG, "category: " + category);
//        Log.i(TAG, "group: " + group);

        if(group != null && group.equals("group_key_messages") && category == null) {
            Log.i(TAG, "From: " + from);
            Log.i(TAG, "Message: " + message);
        }
    }
}
