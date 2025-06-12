package com.example.rushnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DeviceInfoActivity extends AppCompatActivity {

    private TextView userName, studentNumber, personalStatement, releaseVersion;
    private ImageView profilePicture, backArrow, moreInfoIcon;
    private android.widget.Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_device_info);

        // Handle system window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        userName = findViewById(R.id.user_name);
        studentNumber = findViewById(R.id.student_number);
        personalStatement = findViewById(R.id.personal_statement);
        releaseVersion = findViewById(R.id.release_version);
        profilePicture = findViewById(R.id.profile_picture);
        backArrow = findViewById(R.id.arrow_back);
        moreInfoIcon = findViewById(R.id.menu_icon);
        exitButton = findViewById(R.id.exit_button);

        // Load static or dynamic user info
        loadUserData();

        // Set click listeners
        backArrow.setOnClickListener(v -> finish()); // Return to previous screen
        moreInfoIcon.setOnClickListener(v -> {
            // Navigate to MoreinfoActivity
            Intent intent = new Intent(this, MoreinfoActivity.class);
            startActivity(intent);
        });
        exitButton.setOnClickListener(v -> {
            // Exit app or go to main screen
            Intent intent = new Intent(this, NewsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
        profilePicture.setOnClickListener(v -> {
            Toast.makeText(this, "Profile picture clicked!", Toast.LENGTH_SHORT).show();
            // Optional: navigate to profile editing
        });
    }

    private void loadUserData() {
        // For demonstration, static data; replace with real data source
        userName.setText("H.A.H.U Hettiarachchi");
        studentNumber.setText("2022201537");
        personalStatement.setText("Student");
        // Dynamically get app version
        try {
            String version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            releaseVersion.setText("V." + version);
        } catch (Exception e) {
            releaseVersion.setText("V.01");
        }
    }
}
