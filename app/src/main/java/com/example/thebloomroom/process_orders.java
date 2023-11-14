package com.example.thebloomroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.thebloomroom.adapter.ProcessOrderAdapter;
import com.example.thebloomroom.database.CustomerOrder;
import com.example.thebloomroom.database.DBConnector;
import com.example.thebloomroom.database.Order;
import com.example.thebloomroom.database.Process;


import java.util.ArrayList;

public class process_orders extends AppCompatActivity {
    DBConnector db;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    ProcessOrderAdapter processOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_orders);

        recyclerView = findViewById(R.id.process_recyclerView);
        db = new DBConnector(this);
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

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
        processOrderAdapter = new ProcessOrderAdapter(this, customerOrders, sqLiteDatabase, R.layout.processing_order_row);
        recyclerView.setAdapter(processOrderAdapter);
    }

    public void process(View view){
        Toast.makeText(getApplicationContext(), "Order Process Successfully", Toast.LENGTH_SHORT).show();
    }
}