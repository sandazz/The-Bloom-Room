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

    // Parameterized constructor to initialize a CustomerOrder object with provided values
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

    // Getter method for retrieving the Description property
    public String getDescription() {
        return Description;
    }

    // Setter method for setting the Description property
    public void setDescription(String description) {
        Description = description;
    }

    // Getter method for retrieving the price property
    public String getPrice() {
        return price;
    }

    // Setter method for setting the price property
    public void setPrice(String price) {
        this.price = price;
    }

    // Getter method for retrieving the Category property
    public String getCategory() {
        return Category;
    }

    // Setter method for setting the Category property
    public void setCategory(String category) {
        Category = category;
    }

    // Getter method for retrieving the Customer_Name property
    public String getCustomer_Name() {
        return Customer_Name;
    }

    // Setter method for setting the Customer_Name property
    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    // Getter method for retrieving the Address property
    public String getAddress() {
        return Address;
    }

    // Setter method for setting the Address property
    public void setAddress(String address) {
        Address = address;
    }

    // Getter method for retrieving the Quantity property
    public String getQuantity() {
        return Quantity;
    }

    // Setter method for setting the Quantity property
    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
