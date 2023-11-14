package com.example.thebloomroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Customer_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dashboard);
    }

    // Navigate to view followers page for customers
    public void ViewFollowers(View view){
        Intent intent=new Intent(Customer_dashboard.this, view_follower_customer.class);
        startActivity(intent);
    }

    // Navigate to view orders page for customers
    public void ViewOrders(View view){
        Intent intent=new Intent(Customer_dashboard.this, view_orders.class);
        startActivity(intent);
    }

    // Log out from customer dashboard
    public void logout(View view){
        Intent intent=new Intent(Customer_dashboard.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // Override back button behavior to do nothing
    }
}