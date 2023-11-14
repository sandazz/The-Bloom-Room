package com.example.thebloomroom;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebloomroom.adapter.OrderAdapter;
import com.example.thebloomroom.database.DBConnector;
import com.example.thebloomroom.database.Followers;

import java.util.ArrayList;

public class view_follower_customer extends AppCompatActivity {
    DBConnector db;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_follower_customer);
        recyclerView = findViewById(R.id.rv);
        db = new DBConnector(this);
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
    }

    // Display data in the RecyclerView
    private void displayData() {
        sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Followers", null);
        ArrayList<Followers> followers = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String price = cursor.getString(3);
            String category = cursor.getString(4);

            followers.add(new Followers (id,name,description,price,category));
        }
        cursor.close();
        orderAdapter = new OrderAdapter(this, followers, sqLiteDatabase, R.layout.activity_view_follower_customer);
        recyclerView.setAdapter(orderAdapter);
    }
}