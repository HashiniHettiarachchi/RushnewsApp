package com.example.rushnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {
    private Button signin, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);

        // Sign In button click listener
        signin.setOnClickListener(v -> {
            startActivity(new Intent(SplashActivity.this, SigninActivity.class));
            finish(); // Remove if you want to keep splash in back stack
        });

        // Sign Up button click listener (updated)
        signup.setOnClickListener(v -> {
            startActivity(new Intent(SplashActivity.this, SignupActivity.class));
            finish(); // Remove if you want to keep splash in back stack
        });
    }
}
