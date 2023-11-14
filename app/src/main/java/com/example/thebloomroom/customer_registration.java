package com.example.thebloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thebloomroom.database.Customer;
import com.example.thebloomroom.database.DataHandler;

public class customer_registration extends AppCompatActivity {
    EditText name, email, password, c_password;
    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        name = findViewById(R.id.customer_name_input);
        email = findViewById(R.id.customer_email_input);
        password = findViewById(R.id.customer_password_input);
        c_password = findViewById(R.id.customer_c_password_input);
        dataHandler.openDB();
    }

    public void CustomerLogin(View view) {
        Intent intent = new Intent(customer_registration.this, CustomerLogin.class);
        startActivity(intent);
    }


    //name validation
    private boolean validName() {
        String fname = name.getText().toString().trim();


        if (fname.isEmpty()) {
            name.setError("Name is Required.");
            return false;
        } else {
            name.setError(null);
            return true;
        }

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


    //password validation
    private boolean validPassword() {
        String pass = password.getText().toString().trim();
        String cpass = c_password.getText().toString().trim();

        if (pass.isEmpty()) {
            password.setError("Password is Required.");
            return false;
        } else if (!pass.matches(cpass)) {
            password.setError("Password Did not Matched.");
            return false;
        } else {
            password.setError(null);
            return true;
        }

    }

    //confirm password validation
    private boolean validCPassword() {
        String cpass = c_password.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (cpass.isEmpty()) {
            c_password.setError("Confirm Password is Required.");
            return false;
        } else if (!pass.matches(cpass)) {
            c_password.setError("Password Did not Matched.");
            return false;
        } else {
            c_password.setError(null);
            return true;
        }

    }


    public void Register(View v) {
        String Name = name.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();
        String C_Password = c_password.getText().toString().trim();

        if (!validName() | !validEmail() | !validPassword() | !validCPassword()) {
            return;
        }

        Customer customer = new Customer(Name, Email, Password, C_Password);
        try {
            dataHandler.CustomerRegister(customer);
            Toast.makeText(getApplicationContext(), "Registration Successfully.", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(customer_registration.this,CustomerLogin.class);
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Registration Failed.", Toast.LENGTH_LONG).show();
        }

    }
}