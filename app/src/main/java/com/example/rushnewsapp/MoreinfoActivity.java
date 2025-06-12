package com.example.rushnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MoreinfoActivity extends AppCompatActivity {

    ImageView arrowBack, moreInfoIcon;
    LinearLayout homeLayout, profileLayout, deviceInfoLayout;
    TextView signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_moreinfo);

        // Handle edge insets for immersive UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind UI components
        arrowBack = findViewById(R.id.arrow_back);
        moreInfoIcon = findViewById(R.id.more_info_icon);
        homeLayout = findViewById(R.id.home_layout);
        profileLayout = findViewById(R.id.profile_layout);
        deviceInfoLayout = findViewById(R.id.device_info_layout);
        signOut = findViewById(R.id.sign_out);

        // Back button functionality
        arrowBack.setOnClickListener(v -> finish());

        // More info icon click (you can expand this logic)
        moreInfoIcon.setOnClickListener(v ->
                Toast.makeText(this, "More options coming soon", Toast.LENGTH_SHORT).show());

        // Home layout click
        homeLayout.setOnClickListener(v ->
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show());
        // startActivity(new Intent(this, HomeActivity.class)); // Uncomment if HomeActivity exists

        // Profile layout click
        profileLayout.setOnClickListener(v ->
                Toast.makeText(this, "My Profile clicked", Toast.LENGTH_SHORT).show());
        // startActivity(new Intent(this, ProfileActivity.class));

        // Device info layout click
        deviceInfoLayout.setOnClickListener(v ->
                Toast.makeText(this, "Device Info clicked", Toast.LENGTH_SHORT).show());
        // startActivity(new Intent(this, DeviceInfoActivity.class));

        // Sign out click
        signOut.setOnClickListener(v ->
                Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show());
        // Implement actual sign-out logic (e.g., clear user session, go to login screen)
    }
}
