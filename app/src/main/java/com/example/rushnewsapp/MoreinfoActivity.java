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

        // Handle edge insets
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

        // Go back
        arrowBack.setOnClickListener(v -> finish());

        // Placeholder for more info icon
        moreInfoIcon.setOnClickListener(v ->
                Toast.makeText(this, "More options coming soon", Toast.LENGTH_SHORT).show());

        // Home layout clicked
        homeLayout.setOnClickListener(v ->
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show());
        // You can enable navigation to HomeActivity here

        // My Profile clicked → open UserInfoActivity
        profileLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MoreinfoActivity.this, UserInfoActivity.class);
            startActivity(intent);
        });

        // Device Info clicked
        deviceInfoLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MoreinfoActivity.this, DeviceInfoActivity.class);
            startActivity(intent);
        });

        // Sign out logic
        signOut.setOnClickListener(v ->
                Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show());
        // Add actual sign-out logic here (Firebase or SharedPreferences clear, etc.)
    }
}
