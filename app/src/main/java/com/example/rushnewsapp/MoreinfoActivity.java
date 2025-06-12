package com.example.rushnewsapp;

import android.content.Intent;
import android.os.Bundle;
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

        // Back button
        arrowBack.setOnClickListener(v -> finish());

        // Optional: handle more info icon
        moreInfoIcon.setOnClickListener(v ->
                Toast.makeText(this, "More options coming soon", Toast.LENGTH_SHORT).show());

        // Home
        homeLayout.setOnClickListener(v ->
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show());
        // startActivity(new Intent(this, HomeActivity.class));

        // Profile
        profileLayout.setOnClickListener(v ->
                Toast.makeText(this, "My Profile clicked", Toast.LENGTH_SHORT).show());
        // startActivity(new Intent(this, ProfileActivity.class));

        // Device Info - navigate to DeviceInfoActivity
        deviceInfoLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MoreinfoActivity.this, DeviceInfoActivity.class);
            startActivity(intent);
        });


        // Sign out
        signOut.setOnClickListener(v ->
                Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show());
        // Implement sign-out logic here
    }
}
