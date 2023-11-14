package com.example.thebloomroom.database;

public class Category {
    private int id;
    private String Name;

    // Parameterized constructor to initialize a Category object with provided values
    public Category(int id, String name) {
        this.id = id;
        Name = name;
    }

    // Getter method for retrieving the id property
    public int getId() {
        return id;
    }

    // Setter method for setting the id property
    public void setId(int id) {
        this.id = id;
    }

    // Getter method for retrieving the Name property
    public String getName() {
        return Name;
    }

    // Setter method for setting the Name property
    public void setName(String name) {
        Name = name;
    }
}
