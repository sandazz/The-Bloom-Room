package com.example.thebloomroom;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebloomroom.adapter.ViewOrderAdapter;
import com.example.thebloomroom.database.CustomerOrder;
import com.example.thebloomroom.database.DBConnector;

import java.util.ArrayList;

public class view_orders extends AppCompatActivity {
    DBConnector db;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    ViewOrderAdapter viewOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders);

        recyclerView = findViewById(R.id.order_recyclerView);
        db = new DBConnector(this);
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    // Display data in the RecyclerView
    private void displayData() {
        sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from CustomerOrder", null);
        ArrayList<CustomerOrder> customerOrders = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String price = cursor.getString(3);
            String category = cursor.getString(4);
            String cname = cursor.getString(5);
            String address = cursor.getString(6);
            String qtn = cursor.getString(7);

            customerOrders.add(new CustomerOrder (name,description,price,category,cname,address,qtn));
        }
        cursor.close();
        viewOrderAdapter = new ViewOrderAdapter(this, customerOrders, sqLiteDatabase, R.layout.view_order_row);
        recyclerView.setAdapter(viewOrderAdapter);
    }
}