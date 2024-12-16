package com.example.akshar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class my extends AppCompatActivity {

    private TextView startTimeTextView, endTimeTextView, dateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // Back Button logi

        // Initialize views
        startTimeTextView = findViewById(R.id.startTimeTextView);
        endTimeTextView = findViewById(R.id.endTimeTextView);
        dateTextView = findViewById(R.id.dateTextView);
        TextView mobileNumberEditText = findViewById(R.id.data);
        TextView totalMemberEditText = findViewById(R.id.hello);

        // TimePicker for Start Time
        startTimeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(my.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        startTimeTextView.setText(String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute));
                    }
                }, hour, minute, true);
                timePickerDialog.show();
            }
        });

        // TimePicker for End Time
        endTimeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(my.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        endTimeTextView.setText(String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute));
                    }
                }, hour, minute, true);
                timePickerDialog.show();
            }
        });

        // DatePicker for Date
        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(my.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateTextView.setText(String.format(Locale.getDefault(), "%02d/%02d/%d", dayOfMonth, month + 1, year));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        // Review Button logic with validation
        Button reviewButton = findViewById(R.id.reviewButton);
        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get text from views
                String startTime = startTimeTextView.getText().toString().trim();
                String endTime = endTimeTextView.getText().toString().trim();
                String date = dateTextView.getText().toString().trim();
                String mobileNumber = mobileNumberEditText.getText().toString().trim();
                String totalMember = totalMemberEditText.getText().toString().trim();

                // Validation
                if (startTime.isEmpty() || endTime.isEmpty() || date.isEmpty() || mobileNumber.isEmpty() || totalMember.isEmpty()) {
                    Toast.makeText(my.this, "All fields must be filled.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidMobileNumber(mobileNumber)) {
                    Toast.makeText(my.this, "Mobile Number must be 10 digits.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isNumeric(totalMember)) {
                    Toast.makeText(my.this, "Total Members must be numeric.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // If all validations pass, proceed to the next activity
                Intent intent = new Intent(my.this, computer.class);
                startActivity(intent);
            }
        });
    }

    // Check if a string is numeric
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    // Validate mobile number (10 digits)
    private boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber.matches("\\d{10}");
    }
}
