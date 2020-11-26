package com.izaan.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void handleSignup(View view){
        EditText firstNameEl = findViewById(R.id.firstNameSignup);
        EditText lastNameEl = findViewById(R.id.lastNameSignup);
        EditText emailEl = findViewById(R.id.emailInputSignup);
        EditText passwordEl = findViewById(R.id.passwordInputSignup);
        EditText confirmPasswordEl = findViewById(R.id.confirmPasswordInputSignup);

        String firstName = firstNameEl.getText().toString();
        String lastName = lastNameEl.getText().toString();
        String email = emailEl.getText().toString();
        String password = passwordEl.getText().toString();
        String confirmPassword = confirmPasswordEl.getText().toString();

        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_LONG).show();
            return;
        }

        if(!isValidEmailAddress(email)) {
            Toast.makeText(getApplicationContext(),"Email is not valid",Toast.LENGTH_LONG).show();
            return;
        }

        if(!password.equals(confirmPassword)) {
            Toast.makeText(getApplicationContext(),"Password and confirm password should match",Toast.LENGTH_LONG).show();
            return;
        }

        ParseUser user = new ParseUser();
        user.setUsername(email);
        user.setPassword(password);
        user.setEmail(email);

        user.put("firstName", firstName);
        user.put("lastName", lastName);
        
        final View focusedView = this.getCurrentFocus();
        if (focusedView != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(getApplicationContext(),"Registration successfull",Toast.LENGTH_LONG).show();
                    clearFields();
                } else {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void clearFields(){
        EditText firstNameEl = findViewById(R.id.firstNameSignup);
        EditText lastNameEl = findViewById(R.id.lastNameSignup);
        EditText emailEl = findViewById(R.id.emailInputSignup);
        EditText passwordEl = findViewById(R.id.passwordInputSignup);
        EditText confirmPasswordEl = findViewById(R.id.confirmPasswordInputSignup);

        firstNameEl.setText("");
        lastNameEl.setText("");
        emailEl.setText("");
        passwordEl.setText("");
        confirmPasswordEl.setText("");
    }

    private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}