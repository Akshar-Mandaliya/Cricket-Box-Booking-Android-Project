package com.example.akshar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class surendranagarfirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surendranagarfirst);

        // First button listener
        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(surendranagarfirst.this, surendranagarfirstinfo.class);
                startActivity(intent);
            }
        });

        // Second button listener
        Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(surendranagarfirst.this, surendranagarsecondinfo.class);
                startActivity(i1);  // Missing in your code
            }
        });

        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(surendranagarfirst.this, thirdactivity.class);
                startActivity(intent);
            }
        });
        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(surendranagarfirst.this, "Logout successfully", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(surendranagarfirst.this, secondactivity.class);
                startActivity(intent);
                finish(); // Optionally close this activity
            }
        });
    }
}
