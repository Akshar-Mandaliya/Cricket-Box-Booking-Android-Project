package com.example.akshar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class credit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        Button button1 = findViewById(R.id.back);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(credit.this, choosepayment.class);
                startActivity(intent);
            }
        });

        EditText cardHolderNameEditText = findViewById(R.id.cardHolderNameEditText);
        EditText cardNumberEditText = findViewById(R.id.cardNumberEditText);
        EditText expirationDateEditText = findViewById(R.id.expirationDateEditText1);
        EditText cvvEditText = findViewById(R.id.cvvEditText);
        Button backButton = findViewById(R.id.backToHomeButton);

        expirationDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(credit.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        expirationDateEditText.setText(String.format(Locale.getDefault(), "%02d/%02d/%d", dayOfMonth, month + 1, year));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardHolderName = cardHolderNameEditText.getText().toString().trim();
                String cardNumber = cardNumberEditText.getText().toString().trim();
                String expirationDate = expirationDateEditText.getText().toString().trim();
                String cvv = cvvEditText.getText().toString().trim();

                if (cardHolderName.isEmpty() || cardNumber.isEmpty() || expirationDate.isEmpty() || cvv.isEmpty()) {
                    Toast.makeText(credit.this, "All fields must be filled.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isString(cardHolderName)) {
                    Toast.makeText(credit.this, "Card Holder Name must be a valid string.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidCardNumber(cardNumber)) {
                    Toast.makeText(credit.this, "Card Number must be 10 digits long.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidExpirationDate(expirationDate)) {
                    Toast.makeText(credit.this, "Expiration Date must be in the format DD/MM/YYYY.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidCVV(cvv)) {
                    Toast.makeText(credit.this, "CVV/CVC must be 3 digits long.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(credit.this, lastactivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean isString(String str) {
        return str.matches("[a-zA-Z ]+");
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{10}");
    }

    private boolean isValidExpirationDate(String expirationDate) {
        return expirationDate.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
    }

    private boolean isValidCVV(String cvv) {
        return cvv.matches("\\d{3}");
    }
}
