package com.example.thebloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Customer_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dashboard);
    }

    public void ViewFollowers(View view){
        Intent intent=new Intent(Customer_dashboard.this, view_follower_customer.class);
        startActivity(intent);
    }

    public void ViewOrders(View view){
        Intent intent=new Intent(Customer_dashboard.this, view_orders.class);
        startActivity(intent);
    }

    public void logout(View view){
        Intent intent=new Intent(Customer_dashboard.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }
}