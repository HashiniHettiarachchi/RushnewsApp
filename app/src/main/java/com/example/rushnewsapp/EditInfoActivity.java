package com.example.rushnewsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditInfoActivity extends AppCompatActivity {
    private EditText editUsername, editEmail;
    private Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_info);

        // Initialize views
        editUsername = findViewById(R.id.edit_username);
        editEmail = findViewById(R.id.edit_email);
        btnOk = findViewById(R.id.btn_ok);
        btnCancel = findViewById(R.id.btn_cancel);

        // Optionally pre-fill fields from intent extras
        Intent intent = getIntent();
        String currentUsername = intent.getStringExtra("username");
        String currentEmail = intent.getStringExtra("email");

        if (currentUsername != null) editUsername.setText(currentUsername);
        if (currentEmail != null) editEmail.setText(currentEmail);

        // OK button: send back data
        btnOk.setOnClickListener(v -> {
            String newUsername = editUsername.getText().toString().trim();
            String newEmail = editEmail.getText().toString().trim();

            if (newUsername.isEmpty() || newEmail.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            // You can send data back via intent (optional)
            Intent resultIntent = new Intent();
            resultIntent.putExtra("updatedUsername", newUsername);
            resultIntent.putExtra("updatedEmail", newEmail);
            setResult(RESULT_OK, resultIntent);
            finish(); // Close popup
        });

        // Cancel button
        btnCancel.setOnClickListener(v -> finish());
    }
}


