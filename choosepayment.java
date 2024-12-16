package com.example.akshar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class choosepayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choosepayment);
        Button button1=findViewById(R.id.cash_on_delivery_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(choosepayment.this, lastactivity.class);
                startActivity(intent);
            }
        });
        Button button2=findViewById(R.id.credit_card_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(choosepayment.this, credit.class);
                startActivity(intent1);
            }
        });
        Button button3=findViewById(R.id.qrcode);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(choosepayment.this, qrcode.class);
                startActivity(intent3);
            }
        });
        Button button4=findViewById(R.id.back);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(choosepayment.this, computer.class);
                startActivity(intent3);
            }
        });
    }
}