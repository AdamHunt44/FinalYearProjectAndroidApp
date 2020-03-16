package com.example.attendanceapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.attendanceapplication.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static final int SIGN_IN = 0;
    Intent activityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Read the shared file for user tokens before checking other firebase login
        // If it is empty, show the login screen
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            showLogin();
        }
        // Otherwise attempt to login with the custom token

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        System.out.println("The current user is: " + currentUser);
    }

    public void showLogin() {
        activityIntent = new Intent(this, LoginActivity.class);
        startActivity(activityIntent);
    }
}