package com.example.thebloomroom;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thebloomroom.database.Category;
import com.example.thebloomroom.database.DBConnector;
import com.example.thebloomroom.database.DataHandler;

public class add_category extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    DBConnector db;
    EditText admin_category_name;
    DataHandler datahandler = new DataHandler(this);
    int id = 0;
    Button admin_category_edit_button,admin_category_submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        admin_category_name = findViewById(R.id.admin_category_input);
        admin_category_edit_button = findViewById(R.id.admin_category_edit_button);
        admin_category_submit_button = findViewById(R.id.admin_category_submit_button);

        datahandler.openDB();

        db = new DBConnector(this);

        editData();

        admin_category_edit_button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                // Update category data
                ContentValues cv = new ContentValues();
                cv.put("Name", admin_category_name.getText().toString());

                sqLiteDatabase = db.getReadableDatabase();
                long recedit = sqLiteDatabase.update("Category", cv, "id="+id, null);
                if (recedit != -1) {
                    Toast.makeText(add_category.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                    admin_category_submit_button.setVisibility(android.view.View.VISIBLE);
                    admin_category_edit_button.setVisibility(android.view.View.GONE);

                } else {
                    Toast.makeText(add_category.this, "Data Updated Failed", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    // Validate category name
    private boolean validName() {
        String fname = admin_category_name.getText().toString().trim();


        if (fname.isEmpty()) {
            admin_category_name.setError("Name is Required.");
            return false;
        } else {
            admin_category_name.setError(null);
            return true;
        }

    }


    @SuppressLint("NotConstructor")
    public void AddCategory(View v) {
        // Add a new category
        String Name = admin_category_name.getText().toString().trim();

        if (!validName()) {
            return;
        }

        Category category = new Category(id, Name);
        try {
            datahandler.AddCategory(category);
            Toast.makeText(getApplicationContext(), "Category Added Successfully.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(add_category.this, add_category.class);
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Category Added Failed.", Toast.LENGTH_LONG).show();
        }
    }

    // Edit existing category data
    private void editData() {
        if (getIntent().getBundleExtra("userdata") != null) {
            Bundle bundle = getIntent().getBundleExtra("userdata");
            id=bundle.getInt("id");
            admin_category_name.setText(bundle.getString("Name"));
            admin_category_edit_button.setVisibility(android.view.View.VISIBLE);
            admin_category_submit_button.setVisibility(android.view.View.GONE);
        }
    }

    // View all categories
    public void viewCategories(View view) {
        Intent intent = new Intent(add_category.this, view_categories.class);
        startActivity(intent);
    }
}