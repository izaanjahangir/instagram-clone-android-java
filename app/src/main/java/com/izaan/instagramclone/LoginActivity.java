package com.izaan.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.izaan.instagramclone.services.KeyboardService;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void handleSignupPress(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void handleLogin(View view) {
        EditText emailEl = findViewById(R.id.emailInputLogin);
        EditText passwordEl = findViewById(R.id.passwordInputLogin);

        String email = emailEl.getText().toString();
        String password = passwordEl.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_LONG).show();
            return;
        }

        KeyboardService.close(this);

        final LoadingIndicator loading = new LoadingIndicator(this, "Logging in");

        loading.show();

        final Activity thisActivity = this;
        ParseUser.logInInBackground(email, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                loading.hide();
                if (user != null) {
                    Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(thisActivity, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}