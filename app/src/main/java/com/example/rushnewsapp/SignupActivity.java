package com.example.rushnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText etUserName, etPassword, etConfirmPassword, etEmail;
    private Button btnSignup;
    private ImageView arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize views
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etEmail = findViewById(R.id.etEmail);
        btnSignup = findViewById(R.id.btnSignup);
        arrowBack = findViewById(R.id.arrow_back);

        // Navigate back to SplashActivity on back arrow click
        arrowBack.setOnClickListener(v -> {
            Intent intent = new Intent(SignupActivity.this, SplashActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Finish this activity so user can't come back with back button
        });

        // Sign Up button click handler
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();
                String email = etEmail.getText().toString().trim();

                // Input validation
                if (TextUtils.isEmpty(username)) {
                    etUserName.setError("Please enter your username");
                } else if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Please enter your password");
                } else if (TextUtils.isEmpty(confirmPassword)) {
                    etConfirmPassword.setError("Please confirm your password");
                } else if (!password.equals(confirmPassword)) {
                    etConfirmPassword.setError("Passwords do not match");
                } else if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Please enter your email");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Enter a valid email");
                } else {
                    // Registration logic (e.g., save to database or Firebase)
                    Toast.makeText(SignupActivity.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();

                    // Optional: navigate to login or home screen here
                    // Example:
                    // startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                    // finish();
                }
            }
        });
    }
}
