package com.izaan.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void handleSignupPress(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void handleLogin(View view){
        EditText emailEl = findViewById(R.id.emailInputLogin);
        EditText passwordEl = findViewById(R.id.passwordInputLogin);

        String email = emailEl.getText().toString();
        String password = passwordEl.getText().toString();

        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_LONG).show();
            return;
        }

        closeKeyboard();
        
        final LoadingIndicator loading = new LoadingIndicator(this);
        loading.show();

        ParseUser.logInInBackground(email, password, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                loading.hide();
                if (user != null) {
                    Toast.makeText(getApplicationContext(),"Successfull",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void closeKeyboard(){
        final View focusedView = this.getCurrentFocus();
        if (focusedView != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }
}