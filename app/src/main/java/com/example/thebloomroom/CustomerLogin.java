package com.example.thebloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thebloomroom.database.DataHandler;

public class CustomerLogin extends AppCompatActivity {
    EditText email, password;
    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        email = findViewById(R.id.customer_email_login_input);
        password = findViewById(R.id.customer_password_login_input);
        dataHandler.openDB();

    }
    //Email validation
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

    //Password validation
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

    public void CustomerLogin(View view) {
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();

        if (!validEmail()  | !validPassword() ) {
            return;
        }
        Boolean CustomerLogin = dataHandler.CustomerLogin(Email, Password);
        if (CustomerLogin == true) {
            Toast.makeText(getApplicationContext(), "Logging Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CustomerLogin.this, Customer_dashboard.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Logging Failed.", Toast.LENGTH_SHORT).show();
        }
    }


    public void CustomerRegister(View view) {
        Intent intent = new Intent(CustomerLogin.this, customer_registration.class);
        startActivity(intent);
    }
}