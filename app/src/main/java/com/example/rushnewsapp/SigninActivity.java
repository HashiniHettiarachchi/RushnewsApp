package com.example.rushnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity {

    private EditText etUserName, etPassword;
    private Button btnLogin;
    private ImageView arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);

        // Initialize views
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        arrowBack = findViewById(R.id.arrow_back);

        // Login button click listener
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty()) {
                    Toast.makeText(SigninActivity.this, "Please enter your username", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(SigninActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                } else {
                    // Normally you'd check credentials here
                    Toast.makeText(SigninActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                    // Navigate to NewsActivity
                    Intent intent = new Intent(SigninActivity.this, NewsActivity.class);
                    startActivity(intent);
                    finish(); // Prevent user from returning to this screen
                }
            }
        });

        // Back arrow click listener → Go to SplashActivity
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, SplashActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // Optional: prevent going back to this activity
            }
        });
    }
}
