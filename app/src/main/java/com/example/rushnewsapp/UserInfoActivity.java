package com.example.rushnewsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class UserInfoActivity extends AppCompatActivity {
    private Button btnEditInfo, btnSignOut;
    private ImageView backArrow, moreInfo;
    private TextView userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_info);


        // Initialize views
        backArrow = findViewById(R.id.back_arrow);
        moreInfo = findViewById(R.id.more_info);
        btnEditInfo = findViewById(R.id.btn_edit_info);
        btnSignOut = findViewById(R.id.btn_sign_out);
        userInfo = findViewById(R.id.user_info);

        // Set listener for back button
        backArrow.setOnClickListener(v -> finish());

        // Optional: More Info
        moreInfo.setOnClickListener(v ->
                Toast.makeText(this, "More options coming soon...", Toast.LENGTH_SHORT).show()
        );

        // Edit Info (Placeholder)
        btnEditInfo.setOnClickListener(v ->
                Toast.makeText(this, "Edit Info clicked", Toast.LENGTH_SHORT).show()
        );

        // Sign out confirmation popup
        btnSignOut.setOnClickListener(v -> showSignOutDialog());
    }

    private void showSignOutDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Sign Out")
                .setMessage("You are really want to sign out?")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Sign out logic here (e.g., clear session, go to login)
                    Toast.makeText(UserInfoActivity.this, "Signed out", Toast.LENGTH_SHORT).show();
                    finish(); // Or redirect to login screen
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
