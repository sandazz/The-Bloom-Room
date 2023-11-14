package com.example.thebloomroom.database;

// Order class representing the entity for orders
public class Order {
    private int id;
    private String Name;
    private String Description;
    private String Price;
    private String Category;

    // Constructor for the Order class
    public Order(int id, String name, String description, String price, String category) {
        this.id = id;
        Name = name;
        Description = description;
        Price = price;
        Category = category;
    }

    // Getter method for retrieving the unique identifier
    public int getId() {
        return id;
    }

    // Setter method for setting the unique identifier
    public void setId(int id) {
        this.id = id;
    }

    // Getter method for retrieving the name of the ordered item
    public String getName() {
        return Name;
    }

    // Setter method for setting the name of the ordered item
    public void setName(String name) {
        Name = name;
    }

    // Getter method for retrieving the description of the ordered item
    public String getDescription() {
        return Description;
    }

    // Setter method for setting the description of the ordered item
    public void setDescription(String description) {
        Description = description;
    }

    // Getter method for retrieving the price of the ordered item
    public String getPrice() {
        return Price;
    }

    // Setter method for setting the price of the ordered item
    public void setPrice(String price) {
        Price = price;
    }

    // Getter method for retrieving the category of the ordered item
    public String getCategory() {
        return Category;
    }

    // Setter method for setting the category of the ordered item
    public void setCategory(String category) {
        Category = category;
    }
}
