package com.contactapp.Models;

public class ContactBean {
    private String name;
    private String email;
    private String phone;


    public ContactBean(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    private String getEmail() {
        return email;
    }


    private String getPhone() {
        return phone;
    }


    private String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Name: " + getName() + " - Email: " + getEmail() + " - Phone: " + getPhone();
    }
}
