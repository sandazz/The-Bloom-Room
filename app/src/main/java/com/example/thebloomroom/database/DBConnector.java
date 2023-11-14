package com.example.thebloomroom.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// DBConnector class for managing the SQLite database
public class DBConnector extends SQLiteOpenHelper {

    // Constructor for DBConnector
    public DBConnector(@Nullable Context context) {
        super(context, "The_Bloom_Room", null,1);
    }

    // Method called when the database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Customer (id INTEGER PRIMARY KEY AUTOINCREMENT,Name text,Email text,Password text,Repeat_Password text)");
        db.execSQL("CREATE TABLE Admin (id INTEGER PRIMARY KEY AUTOINCREMENT,Name text,Email text,Password text,Repeat_Password text)");
        db.execSQL("CREATE TABLE Category (id INTEGER PRIMARY KEY AUTOINCREMENT,Name text)");
        db.execSQL("CREATE TABLE Followers (id INTEGER PRIMARY KEY AUTOINCREMENT,Name text,Description text,Price text,Category text)");
        db.execSQL("CREATE TABLE CustomerOrder (id INTEGER PRIMARY KEY AUTOINCREMENT,Name text,Description text,Price text,Category text,Customer_Name text,Address Text,Quantity text)");
        db.execSQL("CREATE TABLE Processing (id INTEGER PRIMARY KEY AUTOINCREMENT,Name text,Description text,Price text,Category text,Customer_Name text,Address Text,Quantity text,Status text)");
    }

    // Method called when the database needs to be upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Customer");
        db.execSQL("DROP TABLE IF EXISTS Admin");
        db.execSQL("DROP TABLE IF EXISTS Category");
        db.execSQL("DROP TABLE IF EXISTS Followers");
        db.execSQL("DROP TABLE IF EXISTS CustomerOrder");
        db.execSQL("DROP TABLE IF EXISTS Processing");

    }
}
