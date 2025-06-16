package com.example.rushnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserInfoActivity extends AppCompatActivity {
    private Button btnEditInfo, btnSignOut;
    private ImageView backArrow, moreInfo;
    private TextView userInfo;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_info);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        // Initialize views
        backArrow = findViewById(R.id.back_arrow);
        moreInfo = findViewById(R.id.more_info);
        btnEditInfo = findViewById(R.id.btn_edit_info);
        btnSignOut = findViewById(R.id.btn_sign_out);
        userInfo = findViewById(R.id.user_info);

        // Show user info
        if (user != null) {
            String email = user.getEmail();
            String name = user.getDisplayName();

            String infoText = "Email: " + email;
            if (name != null && !name.isEmpty()) {
                infoText = "Username: " + name + "\n" + infoText;
            }

            userInfo.setText(infoText);
        } else {
            userInfo.setText("No user is currently logged in.");
        }

        // Back button
        backArrow.setOnClickListener(v -> finish());

        // More info
        moreInfo.setOnClickListener(v ->
                Toast.makeText(this, "More options coming soon...", Toast.LENGTH_SHORT).show()
        );

        // Edit info
        btnEditInfo.setOnClickListener(v -> {
            Intent intent = new Intent(UserInfoActivity.this, EditInfoActivity.class);
            startActivity(intent);
        });

        // Sign out
        btnSignOut.setOnClickListener(v -> showSignOutDialog());
    }

    private void showSignOutDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Sign Out")
                .setMessage("You really want to sign out?")
                .setPositiveButton("OK", (dialog, which) -> {
                    auth.signOut(); // Firebase sign out

                    Toast.makeText(UserInfoActivity.this, "Signed out", Toast.LENGTH_SHORT).show();

                    // 🔁 Redirect to Splash Screen (NOT SigninActivity)
                    Intent intent = new Intent(UserInfoActivity.this, SplashActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
