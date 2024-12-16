package com.example.akshar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public class computer extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        Button button1=findViewById(R.id.back);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.back);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button4 = findViewById(R.id.back);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button5 = findViewById(R.id.back);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button6 = findViewById(R.id.back);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button7 = findViewById(R.id.back);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button8 = findViewById(R.id.back);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button9 = findViewById(R.id.back);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button10 = findViewById(R.id.back);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button11 = findViewById(R.id.back);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button12 = findViewById(R.id.back);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, my.class);
                startActivity(intent);
            }
        });

        Button button13 = findViewById(R.id.canclereview);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(computer.this, choosepayment.class);
                startActivity(intent);
            }
        });


        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Spinner spinner = findViewById(R.id.ratingSpinner);
        Button button = findViewById(R.id.paymentButton);
        setupRatingSpinner(spinner);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get text from EditText fields
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validation
                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(computer.this, "All fields must be filled.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isString(username)) {
                    Toast.makeText(computer.this, "Username must be a valid string.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidEmail(email)) {
                    Toast.makeText(computer.this, "Email must contain @ and a domain.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 8) {
                    Toast.makeText(computer.this, "Password must be at least 8 characters long.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // If all validations pass, proceed to the next activity
                Intent intent5 = new Intent(computer.this, choosepayment.class);
                startActivity(intent5);
            }
        });
    }

    private void setupRatingSpinner(Spinner spinner) {
        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add("Excellent");
        arraylist.add("Very Good");
        arraylist.add("Good");
        arraylist.add("Poor");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arraylist);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(computer.this, "Selected Item: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    // Validate if username is a string (only alphabetic characters)
    private boolean isString(String str) {
        return str.matches("[a-zA-Z]+");
    }

    // Validate email format
    private boolean isValidEmail(String email) {
        return email.contains("@") && email.lastIndexOf('.') > email.indexOf('@') + 1;
    }
}
