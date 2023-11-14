package com.example.thebloomroom.database;

public class Order {
    private int id;
    private String Name;
    private String Description;
    private String Price;
    private String Category;

    public Order(int id, String name, String description, String price, String category) {
        this.id = id;
        Name = name;
        Description = description;
        Price = price;
        Category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
