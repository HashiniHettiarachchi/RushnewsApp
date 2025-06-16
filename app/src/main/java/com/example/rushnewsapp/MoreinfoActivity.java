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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MoreinfoActivity extends AppCompatActivity {

    ImageView arrowBack, moreInfoIcon;
    LinearLayout homeLayout, profileLayout, deviceInfoLayout;
    TextView signOut, userNameTextView;  // Added userNameTextView

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
        userNameTextView = findViewById(R.id.user_name);  // Bind user_name TextView

        // ✅ Show the logged-in user's name or email
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String displayName = user.getDisplayName();
            String email = user.getEmail();

            if (displayName != null && !displayName.isEmpty()) {
                userNameTextView.setText(displayName);
            } else {
                userNameTextView.setText(email);  // fallback
            }
        } else {
            userNameTextView.setText("Guest User");  // fallback if not logged in
        }

        // Go back
        arrowBack.setOnClickListener(v -> finish());

        // Placeholder for more info icon
        moreInfoIcon.setOnClickListener(v ->
                Toast.makeText(this, "More options coming soon", Toast.LENGTH_SHORT).show());


        // Home layout clicked → open NewsActivity
        homeLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MoreinfoActivity.this, NewsActivity.class);
            startActivity(intent);
        });


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
        // Add actual FirebaseAuth.getInstance().signOut(); here if needed
    }
}
