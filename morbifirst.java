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

public class morbifirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morbifirst);
        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(morbifirst.this, morbifirstinfo.class);
                startActivity(intent);
            }
        });

        Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i11 = new Intent(morbifirst.this, morbisecondinfo.class);
                startActivity(i11);  // Missing in your code
            }
        });
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(morbifirst.this, thirdactivity.class);
                startActivity(intent);
            }
        });
        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(morbifirst.this, "Logout successfully", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(morbifirst.this, secondactivity.class);
                startActivity(intent);
                finish(); // Optionally close this activity
            }
        });
    }
}