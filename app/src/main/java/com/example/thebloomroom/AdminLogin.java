package com.example.thebloomroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thebloomroom.database.DataHandler;

public class AdminLogin extends AppCompatActivity {
    EditText email, password;
    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        // Initialize UI elements
        email = findViewById(R.id.admin_email_login_input);
        password = findViewById(R.id.admin_password_login_input);
        // Open the database connection
        dataHandler.openDB();
    }

    // Validate admin email
    private boolean validEmail() {
        String Email = email.getText().toString().trim();


        if (Email.isEmpty()) {
            email.setError("Email is Required.");
            return false;
        } else {
            email.setError(null);
            return true;
        }

    }

    // Validate admin password
    private boolean validPassword() {
        String Password = password.getText().toString().trim();

        if (Password.isEmpty()) {
            password.setError("Password is Required.");
            return false;
        } else {
            password.setError(null);
            return true;
        }

    }

    // Handle admin login
    public void AdminLogin(View view) {
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();

        if (!validEmail() | !validPassword()) {
            return;
        }

        // Check admin login credentials
        Boolean AdminLogin = dataHandler.AdminLogin(Email, Password);
        if (AdminLogin == true) {
            Toast.makeText(getApplicationContext(), "Logging Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AdminLogin.this, Admin_dashboard.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Logging Failed.", Toast.LENGTH_SHORT).show();
        }
    }

    // Navigate to admin registration page
    public void registration(View view) {
        Intent intent = new Intent(AdminLogin.this, admin_registration.class);
        startActivity(intent);
    }
}