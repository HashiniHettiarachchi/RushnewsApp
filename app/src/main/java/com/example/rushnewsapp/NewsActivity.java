package com.example.rushnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // Back arrow - go to SignInActivity
        ImageView arrowBack = findViewById(R.id.arrow_back);
        arrowBack.setOnClickListener(v -> {
            Intent intent = new Intent(NewsActivity.this, SigninActivity.class);
            startActivity(intent);
            finish();
        });

        // Menu icon - go to MoreinfoActivity
        ImageView menuIcon = findViewById(R.id.menu_icon);
        menuIcon.setOnClickListener(v -> {
            Intent intent = new Intent(NewsActivity.this, MoreinfoActivity.class);
            startActivity(intent);
        });

        // ✅ Profile icon - go to UserInfoActivity
        ImageView profileIcon = findViewById(R.id.more_info);
        profileIcon.setOnClickListener(v -> {
            Intent intent = new Intent(NewsActivity.this, UserInfoActivity.class);
            startActivity(intent);
        });

        // Bottom Navigation
        ImageView sportIcon = findViewById(R.id.sport_icon);
        ImageView academicIcon = findViewById(R.id.academic_icon);
        ImageView otherIcon = findViewById(R.id.other_icon);

        sportIcon.setOnClickListener(v -> {
            Intent intent = new Intent(NewsActivity.this, SearchNewsActivity.class);
            startActivity(intent);
        });

        academicIcon.setOnClickListener(v -> {
            // TODO: Add AcademicNewsActivity when ready
            // startActivity(new Intent(this, AcademicNewsActivity.class));
        });

        otherIcon.setOnClickListener(v -> {
            // TODO: Add OtherNewsActivity when ready
            // startActivity(new Intent(this, OtherNewsActivity.class));
        });

        // News Card 1 Image click
        ImageView sportImage = findViewById(R.id.news_image1);
        sportImage.setOnClickListener(v -> {
            Intent intent = new Intent(NewsActivity.this, SearchNewsActivity.class);
            startActivity(intent);
        });

        // News Card "See More" Buttons
        findViewById(R.id.see_more1).setOnClickListener(v -> {
            Intent intent = new Intent(NewsActivity.this, SearchNewsActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.see_more2).setOnClickListener(v -> {
            // TODO: Open detailed news for card 2
        });

        findViewById(R.id.see_more3).setOnClickListener(v -> {
            // TODO: Open detailed news for card 3
        });
    }
}
