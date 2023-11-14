package com.example.thebloomroom.database;

public class Customer {
    private String Name;
    private String Email;
    private String Password;
    private String Repeat_Password;

    public Customer(String name, String email, String password, String repeat_Password) {
        Name = name;
        Email = email;
        Password = password;
        Repeat_Password = repeat_Password;
    }

    public Customer() {
        Name = "";
        Email = "";
        Password = "";
        Repeat_Password = "";
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRepeat_Password() {
        return Repeat_Password;
    }

    public void setRepeat_Password(String repeat_Password) {
        Repeat_Password = repeat_Password;
    }
}
