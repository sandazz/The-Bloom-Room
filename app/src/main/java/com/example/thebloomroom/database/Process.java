package com.example.thebloomroom.database;

// Process class representing the entity for processing orders
public class Process {
    private String Name;
    private String Description;
    private String price;
    private String Category;
    private String Customer_Name;
    private String Address;
    private String Quantity;
    private String Status;

    // Constructor for the Process class
    public Process(String name, String description, String price, String category, String customer_Name, String address, String quantity, String status) {
        Name = name;
        Description = description;
        this.price = price;
        Category = category;
        Customer_Name = customer_Name;
        Address = address;
        Quantity = quantity;
        Status = status;
    }

    // Getter method for retrieving the name of the processed item
    public String getName() {
        return Name;
    }

    // Setter method for setting the name of the processed item
    public void setName(String name) {
        Name = name;
    }

    // Getter method for retrieving the description of the processed item
    public String getDescription() {
        return Description;
    }

    // Setter method for setting the description of the processed item
    public void setDescription(String description) {
        Description = description;
    }

    // Getter method for retrieving the price of the processed item
    public String getPrice() {
        return price;
    }

    // Setter method for setting the price of the processed item
    public void setPrice(String price) {
        this.price = price;
    }

    // Getter method for retrieving the category of the processed item
    public String getCategory() {
        return Category;
    }

    // Setter method for setting the category of the processed item
    public void setCategory(String category) {
        Category = category;
    }

    // Getter method for retrieving the name of the customer who placed the order
    public String getCustomer_Name() {
        return Customer_Name;
    }

    // Setter method for setting the name of the customer who placed the order
    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    // Getter method for retrieving the address of the customer for the processed order
    public String getAddress() {
        return Address;
    }

    // Setter method for setting the address of the customer for the processed order
    public void setAddress(String address) {
        Address = address;
    }

    // Getter method for retrieving the quantity of the processed item
    public String getQuantity() {
        return Quantity;
    }

    // Setter method for setting the quantity of the processed item
    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    // Getter method for retrieving the status of the processing order
    public String getStatus() {
        return Status;
    }

    // Setter method for setting the status of the processing order
    public void setStatus(String status) {
        Status = status;
    }
}
