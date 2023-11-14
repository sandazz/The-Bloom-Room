package com.example.thebloomroom.database;

public class Customer {
    private String Name;
    private String Email;
    private String Password;
    private String Repeat_Password;

    // Parameterized constructor to initialize a Customer object with provided values
    public Customer(String name, String email, String password, String repeat_Password) {
        Name = name;
        Email = email;
        Password = password;
        Repeat_Password = repeat_Password;
    }

    // Default constructor to initialize an empty Customer object
    public Customer() {
        Name = "";
        Email = "";
        Password = "";
        Repeat_Password = "";
    }

    // Getter method for retrieving the Name property
    public String getName() {
        return Name;
    }

    // Setter method for setting the Name property
    public void setName(String name) {
        Name = name;
    }

    // Getter method for retrieving the Email property
    public String getEmail() {
        return Email;
    }

    // Setter method for setting the Email property
    public void setEmail(String email) {
        Email = email;
    }

    // Getter method for retrieving the Password property
    public String getPassword() {
        return Password;
    }

    // Setter method for setting the Password property
    public void setPassword(String password) {
        Password = password;
    }

    // Getter method for retrieving the Repeat_Password property
    public String getRepeat_Password() {
        return Repeat_Password;
    }

    // Setter method for setting the Repeat_Password property
    public void setRepeat_Password(String repeat_Password) {
        Repeat_Password = repeat_Password;
    }
}
