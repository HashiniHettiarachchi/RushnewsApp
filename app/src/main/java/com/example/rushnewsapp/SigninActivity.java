package com.example.rushnewsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SigninActivity extends AppCompatActivity {

    private EditText etUserName, etPassword;
    private Button btnLogin;
    private ImageView arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin); // Make sure your XML file is called activity_signin.xml

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
                    // Here you would normally check credentials with your backend/database
                    Toast.makeText(SigninActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    // Example: startActivity(new Intent(SigninActivity.this, HomeActivity.class));
                    // finish();
                }
            }
        });

        // Back arrow click listener
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Closes the current activity
            }
        });
    }
}
