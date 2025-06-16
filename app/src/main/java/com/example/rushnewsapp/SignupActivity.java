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

import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    private EditText etUserName, etPassword, etConfirmPassword, etEmail;
    private Button btnSignup;
    private ImageView arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Initialize views
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etEmail = findViewById(R.id.etEmail);
        btnSignup = findViewById(R.id.btnSignup);
        arrowBack = findViewById(R.id.arrow_back);

        // Back to splash screen
        arrowBack.setOnClickListener(v -> {
            startActivity(new Intent(SignupActivity.this, SplashActivity.class));
            finish();
        });

        // Sign up logic
        btnSignup.setOnClickListener(v -> {
            String username = etUserName.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

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
                // Firebase Authentication - Create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignupActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();

                                // Optional: go to login or main activity
                                startActivity(new Intent(SignupActivity.this, SigninActivity.class));
                                finish();
                            } else {
                                Toast.makeText(SignupActivity.this, "Sign-up failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}
