package com.example.thebloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }

    public void addCategory(View view){
        Intent intent = new Intent(Admin_dashboard.this, add_category.class);
        startActivity(intent);
    }

    public void addFollowers(View view){
        Intent intent = new Intent(Admin_dashboard.this, add_followers.class);
        startActivity(intent);
    }

    public void viewOrders(View view){
        Intent intent = new Intent(Admin_dashboard.this, view_orders.class);
        startActivity(intent);
    }

    public void processOrders(View view){
        Intent intent = new Intent(Admin_dashboard.this, process_orders.class);
        startActivity(intent);
    }

    public void logOut(View view){
        Intent intent = new Intent(Admin_dashboard.this, MainActivity.class);
        startActivity(intent);
    }
}