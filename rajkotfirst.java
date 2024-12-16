package com.example.akshar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class rajkotfirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajkotfirst);

        // First button listener
        Button button = findViewById(R.id.r1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rajkotfirst.this, rajkotfirstinfo.class);
                startActivity(intent);
            }
        });
        Button b1 = findViewById(R.id.r2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(rajkotfirst.this, rajkotsecondinfo.class);
                startActivity(i1);  // Missing in your code
            }
        });

        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rajkotfirst.this, thirdactivity.class);
                startActivity(intent);
            }
        });
        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(rajkotfirst.this, "Logout successfully", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(rajkotfirst.this, secondactivity.class);
                startActivity(intent);
                finish(); // Optionally close this activity
            }
        });
    }
}