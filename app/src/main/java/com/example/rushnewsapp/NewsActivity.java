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
            // You can choose which activity to go to
            Intent intent = new Intent(NewsActivity.this, SigninActivity.class);
            startActivity(intent);
            finish();
        });

        // More info (optional)
        ImageView moreInfo = findViewById(R.id.more_info);
        moreInfo.setOnClickListener(v ->
                        // Show a dialog or open a new activity for more info
                {/* TODO: Implement more info action */}
        );

        // Bottom navigation icons (example: open different categories)
        ImageView sportIcon = findViewById(R.id.sport_icon);
        ImageView academicIcon = findViewById(R.id.academic_icon);
        ImageView otherIcon = findViewById(R.id.other_icon);

        sportIcon.setOnClickListener(v -> {
            // TODO: Show sport news
        });

        academicIcon.setOnClickListener(v -> {
            // TODO: Show academic news
        });

        otherIcon.setOnClickListener(v -> {
            // TODO: Show other news
        });

        // News cards "See More..." (example for first card)
        findViewById(R.id.see_more1).setOnClickListener(v -> {
            // TODO: Open detailed news page
        });
        findViewById(R.id.see_more2).setOnClickListener(v -> {
            // TODO: Open detailed news page
        });
        findViewById(R.id.see_more3).setOnClickListener(v -> {
            // TODO: Open detailed news page
        });
    }
}
