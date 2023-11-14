package com.example.thebloomroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Admin_dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }

    // Navigate to the add category screen
    public void addCategory(View view){
        Intent intent = new Intent(Admin_dashboard.this, add_category.class);
        startActivity(intent);
    }

    // Navigate to the add followers screen
    public void addFollowers(View view){
        Intent intent = new Intent(Admin_dashboard.this, add_followers.class);
        startActivity(intent);
    }

    // Navigate to the view orders screen
    public void viewOrders(View view){
        Intent intent = new Intent(Admin_dashboard.this, view_orders.class);
        startActivity(intent);
    }

    // Navigate to the process orders screen
    public void processOrders(View view){
        Intent intent = new Intent(Admin_dashboard.this, process_orders.class);
        startActivity(intent);
    }

    // Log out of the admin dashboard
    public void logOut(View view){
        Intent intent = new Intent(Admin_dashboard.this, MainActivity.class);
        startActivity(intent);
    }
}