package com.example.rushnewsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SearchNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_news);

        // Back arrow click listener
        ImageView arrowBack = findViewById(R.id.arrow_back);
        arrowBack.setOnClickListener(v -> {
            Intent intent = new Intent(SearchNewsActivity.this, NewsActivity.class);
            startActivity(intent);
            finish(); // Close SearchNewsActivity
        });
    }
}
