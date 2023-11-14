package com.example.thebloomroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Navigate to admin login activity
    public void admin(View view){
        Intent intent = new Intent(MainActivity.this, AdminLogin.class);
        startActivity(intent);
    }

    // Navigate to customer login activity
    public void customer(View view){
        Intent intent = new Intent(MainActivity.this, CustomerLogin.class);
        startActivity(intent);
    }
}