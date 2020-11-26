package com.izaan.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
//import android.provider.Settings;
//import android.text.TextUtils;
import android.view.View;

import com.parse.Parse;

public class MainActivity extends AppCompatActivity {
    private final String APPLICATION_ID = "yPWjwY73wM2GVnBDDZCMneHLz7nEwXOwY74r0Aen";
    private final String CLIENT_KEY = "szR2ZRfMSYbWv1LYkLUD4xM8rk8LCnqzUNa7gwrd";
    private final String SERVER_URL = "https://parseapi.back4app.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(APPLICATION_ID)
                .clientKey(CLIENT_KEY)
                .server(SERVER_URL)
                .build()
        );
//        startActivity(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
    }

    public void handleLoginPress(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void handleSignupPress(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

//    private boolean isNotificationServiceEnabled(){
//        String pkgName = getPackageName();
//        final String flat = Settings.Secure.getString(getContentResolver(),
//                "enabled_notification_listeners");
//        if (!TextUtils.isEmpty(flat)) {
//            final String[] names = flat.split(":");
//            for (String name: names) {
//                final ComponentName cn = ComponentName.unflattenFromString(name);
//                if (cn != null) {
//                    if (TextUtils.equals(pkgName, cn.getPackageName())) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
}