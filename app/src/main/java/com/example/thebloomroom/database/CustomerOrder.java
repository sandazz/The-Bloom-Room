package com.example.thebloomroom.database;

public class CustomerOrder {
    private int id;
    private String Name;
    private String Description;
    private String price;
    private String Category;
    private String Customer_Name;
    private String Address;
    private String Quantity;

    public CustomerOrder(String name, String description, String price, String category, String customer_Name, String address, String quantity) {
        this.id = id;
        Name = name;
        Description = description;
        this.price = price;
        Category = category;
        Customer_Name = customer_Name;
        Address = address;
        Quantity = quantity;
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
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
