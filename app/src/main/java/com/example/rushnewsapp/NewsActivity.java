package com.example.rushnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // Back arrow - go to SignInActivity or SignUpActivity as needed
        ImageView arrowBack = findViewById(R.id.arrow_back);
        arrowBack.setOnClickListener(v -> {
            Intent intent = new Intent(NewsActivity.this, SigninActivity.class);
            startActivity(intent);
            finish();
        });

        // More info (optional)
        ImageView moreInfo = findViewById(R.id.more_info);
        moreInfo.setOnClickListener(v -> {
            // Show a dialog or open a new activity for more info
            // startActivity(new Intent(this, InfoActivity.class));
        });

        // Bottom navigation icons
        ImageView sportIcon = findViewById(R.id.sport_icon);
        ImageView academicIcon = findViewById(R.id.academic_icon);
        ImageView otherIcon = findViewById(R.id.other_icon);

        sportIcon.setOnClickListener(v -> {
            Intent intent = new Intent(NewsActivity.this, SearchNewsActivity.class);
            startActivity(intent);
        });

        academicIcon.setOnClickListener(v -> {
            // TODO: Open academic news
            // startActivity(new Intent(this, AcademicNewsActivity.class));
        });

        otherIcon.setOnClickListener(v -> {
            // TODO: Open other news
            // startActivity(new Intent(this, OtherNewsActivity.class));
        });

        // Sport image (inside News Card 1) click listener
        ImageView sportImage = findViewById(R.id.news_image1);
        sportImage.setOnClickListener(v -> {
            Intent intent = new Intent(NewsActivity.this, SearchNewsActivity.class);
            startActivity(intent);
        });

        // "See More" (inside News Card 1) click listener
        findViewById(R.id.see_more1).setOnClickListener(v -> {
            Intent intent = new Intent(NewsActivity.this, SearchNewsActivity.class);
            startActivity(intent);
        });

        // Optional: "See More" for other cards
        findViewById(R.id.see_more2).setOnClickListener(v -> {
            // TODO: Open detailed news page for card 2
            // startActivity(new Intent(this, DetailedNewsActivity.class));
        });
        findViewById(R.id.see_more3).setOnClickListener(v -> {
            // TODO: Open detailed news page for card 3
            // startActivity(new Intent(this, DetailedNewsActivity.class));
        });
    }
}
