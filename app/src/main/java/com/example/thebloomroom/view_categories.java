package com.example.thebloomroom;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thebloomroom.adapter.CategoryAdapter;
import com.example.thebloomroom.database.Category;
import com.example.thebloomroom.database.DBConnector;

import java.util.ArrayList;

public class view_categories extends AppCompatActivity {
    DBConnector db;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_categories);

        recyclerView = findViewById(R.id.admin_category_view_recycler);
        db = new DBConnector(this);
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    // Display data in the RecyclerView
    private void displayData(){
        sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Category", null);
        ArrayList<Category> categories = new ArrayList<>();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            categories.add(new Category(id, name));
        }
        cursor.close();
        categoryAdapter = new CategoryAdapter(this, categories, sqLiteDatabase,R.layout.category_row);
        recyclerView.setAdapter(categoryAdapter);
    }
}