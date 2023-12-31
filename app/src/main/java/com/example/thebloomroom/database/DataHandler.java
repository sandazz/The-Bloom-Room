package com.example.thebloomroom.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// DataHandler class for handling database operations
public class DataHandler {
    private Context con;
    private DBConnector dbCon;
    private SQLiteDatabase db;

    // Constructor for the DataHandler
    public DataHandler(Context con) {
        this.con = con;
    }

    // Method to open the database
    public void openDB() {
        this.dbCon = new DBConnector(con);
        this.db = dbCon.getWritableDatabase();
    }

    // Method to register a customer in the database
    public void CustomerRegister(Customer customer) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", customer.getName());
        contentValues.put("Email", customer.getEmail());
        contentValues.put("Password", customer.getPassword());
        contentValues.put("Repeat_Password", customer.getRepeat_Password());
        db.insert("Customer", null, contentValues);
    }

    // Method to register an admin in the database
    public void AdminRegister(Admin admin) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", admin.getName());
        contentValues.put("Email", admin.getEmail());
        contentValues.put("Password", admin.getPassword());
        contentValues.put("Repeat_Password", admin.getRepeat_Password());
        db.insert("Admin", null, contentValues);
    }

    // Method to check admin login credentials
    public boolean AdminLogin (String email, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM Admin  WHERE Email=? and Password=?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // Method to check customer login credentials
    public boolean CustomerLogin (String email, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM Customer  WHERE Email=? and Password=?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // Method to add a category by an admin
    public void AddCategory(Category category) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", category.getName());
        db.insert("Category", null, contentValues);
    }

    // Method to add followers by an admin
    public void AdminAddFollowers(Followers followers) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", followers.getName());
        contentValues.put("Description", followers.getDescription());
        contentValues.put("Price", followers.getPrice());
        contentValues.put("Category", followers.getCategory());
        db.insert("Followers", null, contentValues);
    }

    // Method to add a customer order
    public void addOrder(CustomerOrder customerOrder) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", customerOrder.getName());
        contentValues.put("Description", customerOrder.getDescription());
        contentValues.put("Price", customerOrder.getPrice());
        contentValues.put("Category", customerOrder.getCategory());
        contentValues.put("Customer_Name", customerOrder.getCustomer_Name());
        contentValues.put("Address", customerOrder.getAddress());
        contentValues.put("Quantity", customerOrder.getQuantity());
        db.insert("CustomerOrder", null, contentValues);
    }

    // Method to process an order
    public void OrderProcess(Process toys) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", toys.getName());
        contentValues.put("Description", toys.getDescription());
        contentValues.put("Price", toys.getPrice());
        contentValues.put("Category", toys.getCategory());
        contentValues.put("Customer_Name", toys.getCustomer_Name());
        contentValues.put("Address", toys.getAddress());
        contentValues.put("Quantity", toys.getQuantity());
        contentValues.put("Status", toys.getStatus());
        db.insert("Processing", null, contentValues);
    }
}
