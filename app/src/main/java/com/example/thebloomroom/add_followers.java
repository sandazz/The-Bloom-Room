package com.example.thebloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thebloomroom.database.DBConnector;
import com.example.thebloomroom.database.DataHandler;
import com.example.thebloomroom.database.Followers;

public class add_followers extends AppCompatActivity {
    EditText follower_name, follower_description, follower_price, follower_category;

    SQLiteDatabase sqLiteDatabase;
    DBConnector db;
    DataHandler datahandler = new DataHandler(this);
    int id = 0;
    Button edit_button, submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_followers);

        follower_name = findViewById(R.id.admin_follower_name_input);
        follower_description = findViewById(R.id.admin_follower_description_input);
        follower_price = findViewById(R.id.admin_follower_price_input);
        follower_category = findViewById(R.id.admin_follower_category_input);
        edit_button = findViewById(R.id.admin_follower_edit_button);
        submit_button = findViewById(R.id.admin_follower_submit_button);

        datahandler.openDB();
        db = new DBConnector(this);

        editData();

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("Name", follower_name.getText().toString());
                cv.put("Description", follower_description.getText().toString());
                cv.put("Price", follower_price.getText().toString());
                cv.put("Category", follower_category.getText().toString());

                sqLiteDatabase = db.getReadableDatabase();
                long result = sqLiteDatabase.update("Followers", cv,"id="+id, null);
                if(result != -1){
                    Toast.makeText(add_followers.this, "Data Updataed Successfully", Toast.LENGTH_SHORT).show();
                    submit_button.setVisibility(View.VISIBLE);
                    edit_button.setVisibility(View.GONE);
                }else {
                    Toast.makeText(add_followers.this, "Data Updataed Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void editData() {
        if (getIntent().getBundleExtra("userdata") != null) {
            Bundle bundle = getIntent().getBundleExtra("userdata");
            id=bundle.getInt("id");
            follower_name.setText(bundle.getString("Name"));
            follower_description.setText(bundle.getString("Description"));
            follower_price.setText(bundle.getString("Price"));
            follower_category.setText(bundle.getString("Category"));
            edit_button.setVisibility(View.VISIBLE);
            submit_button.setVisibility(View.GONE);
        }
    }

    //name validation
    private boolean validName() {
        String fname = follower_name.getText().toString().trim();


        if (fname.isEmpty()) {
            follower_name.setError("Name is Required.");
            return false;
        } else {
            follower_name.setError(null);
            return true;
        }

    }

    //Description validation
    private boolean validDescription() {
        String desc = follower_description.getText().toString().trim();


        if (desc.isEmpty()) {
            follower_description.setError("Description is Required.");
            return false;
        } else {
            follower_description.setError(null);
            return true;
        }

    }

    //Price validation
    private boolean validPrice() {
        String prices = follower_price.getText().toString().trim();

        if (prices.isEmpty()) {
            follower_price.setError("Price is Required.");
            return false;
        } else {
            follower_price.setError(null);
            return true;
        }

    }


    //Category validation
    private boolean validCategory() {
        String cat = follower_category.getText().toString().trim();

        if (cat.isEmpty()) {
            follower_category.setError("Category is Required.");
            return false;
        } else {
            follower_category.setError(null);
            return true;
        }

    }

    public void addFollowers(View v) {
        String Name = follower_name.getText().toString().trim();
        String Description = follower_description.getText().toString().trim();
        String Price = follower_price.getText().toString().trim();
        String Category = follower_category.getText().toString().trim();

        if (!validName() | !validDescription() | !validPrice() | !validCategory()) {
            return;
        }

        Followers followers = new Followers(id,Name,Description,Price,Category);
        try {
            datahandler.AdminAddFollowers(followers);
            Toast.makeText(getApplicationContext(), "Toy Added Successfully.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(add_followers.this, add_followers.class);
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Toy Added Failed.", Toast.LENGTH_LONG).show();
        }

    }

    public void viewFollowers(View view) {
        Intent intent = new Intent(add_followers.this, view_followers.class);
        startActivity(intent);
    }
}