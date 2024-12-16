package com.example.akshar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class secondactivity extends AppCompatActivity {
    private EditText etName, etPassword;
    private Button btnLogin, btnRegister;
    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFS = "user_prefs";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        btnRegister.setOnClickListener(v -> registerUser());
        btnLogin.setOnClickListener(v -> loginUser());
    }

    private void registerUser() {
        String name = etName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (name.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both name and password", Toast.LENGTH_SHORT).show();
        } else if (password.length() < 8) {
            Toast.makeText(this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(USERNAME_KEY, name);
            editor.putString(PASSWORD_KEY, password);
            editor.apply();
            Toast.makeText(this, "Registration successful! You can now log in.", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etPassword.setText("");
        }
    }

    private void loginUser() {
        String registeredName = sharedPreferences.getString(USERNAME_KEY, null);
        String registeredPassword = sharedPreferences.getString(PASSWORD_KEY, null);
        String inputName = etName.getText().toString().trim();
            String inputPassword = etPassword.getText().toString().trim();

            if (registeredName == null || registeredPassword == null) {
                Toast.makeText(this, "Please register before logging in.", Toast.LENGTH_SHORT).show();
            } else if (inputName.equals(registeredName) && inputPassword.equals(registeredPassword)) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(secondactivity.this, thirdactivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "First Register After The Login.", Toast.LENGTH_SHORT).show();
        }
    }
}
