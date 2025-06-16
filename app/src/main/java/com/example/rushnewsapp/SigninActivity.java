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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SigninActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private ImageView arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Initialize views
        etEmail=findViewById(R.id.etEmail);// Should be an email field
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        arrowBack = findViewById(R.id.arrow_back);

        // Login button click listener
        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty()) {
                etEmail.setError("Please enter your email");
            } else if (password.isEmpty()) {
                etPassword.setError("Please enter your password");
            } else {
                // Firebase login
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                FirebaseUser user = auth.getCurrentUser();
                                Toast.makeText(SigninActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                                // Navigate to NewsActivity
                                startActivity(new Intent(SigninActivity.this, NewsActivity.class));
                                finish();
                            } else {
                                Toast.makeText(SigninActivity.this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });

        // Back arrow click listener → Go to SplashActivity
        arrowBack.setOnClickListener(v -> {
            Intent intent = new Intent(SigninActivity.this, SplashActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
