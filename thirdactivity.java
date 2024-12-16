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

public class thirdactivity extends AppCompatActivity {
    @Override
                protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_thirdactivity);

                        Button button = findViewById(R.id.cityButton1);
                        button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                        Intent intent = new Intent(thirdactivity.this, surendranagarfirst.class);
                                        startActivity(intent);
                                }
                        });
        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(thirdactivity.this, "Logout successfully", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(thirdactivity.this, secondactivity.class);
                startActivity(intent);
                finish(); // Optionally close this activity
            }
        });
                    Button as = findViewById(R.id.cityButton2);
                    as.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i1 = new Intent(thirdactivity.this, rajkotfirst.class);
                            startActivity(i1);
                        }
                    });

                    Button ass = findViewById(R.id.cityButton3);
                    ass.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i11 = new Intent(thirdactivity.this, ahmadabadfirst.class);
                            startActivity(i11);
                        }
                    });

                    Button asss = findViewById(R.id.cityButton4);
                    asss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i111 = new Intent(thirdactivity.this, suratfirst.class);
                            startActivity(i111);
                        }
                    });

                    Button assss = findViewById(R.id.cityButton5);
                    assss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i111 = new Intent(thirdactivity.this, morbifirst.class);
                            startActivity(i111);
                        }
                    });

                    Button asssss = findViewById(R.id.cityButton6);
                    asssss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i1111 = new Intent(thirdactivity.this, vadodarafirst.class);
                            startActivity(i1111);
                        }
                    });





                        
                }
        }








