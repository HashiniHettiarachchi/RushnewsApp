package com.example.rushnewsapp;

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

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etEmail = findViewById(R.id.etEmail);
        btnSignup = findViewById(R.id.btnSignup);
        arrowBack = findViewById(R.id.arrow_back);

        // Back arrow closes the activity
        arrowBack.setOnClickListener(v -> finish());

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    // Registration logic goes here (e.g., save to DB or use Firebase)
                    Toast.makeText(SignupActivity.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                    // Optionally, finish() or go to another activity
                }
            }
        });
    }
}
