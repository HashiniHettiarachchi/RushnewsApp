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
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, SigninActivity.class);
                startActivity(intent);
                // Optional: finish(); to prevent going back to splash
            }
        });

        // Sign Up button click listener (if you want to add signup functionality later)
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add SignupActivity later if needed
                // Intent intent = new Intent(SplashActivity.this, SignupActivity.class);
                // startActivity(intent);

                // For now, just show a message
                android.widget.Toast.makeText(SplashActivity.this, "Sign Up functionality coming soon!", android.widget.Toast.LENGTH_SHORT).show();
            }
        });
    }
}