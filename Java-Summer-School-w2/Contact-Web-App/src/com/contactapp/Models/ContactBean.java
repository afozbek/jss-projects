package com.contactapp.Models;

import java.io.Serializable;

public class ContactBean implements Serializable {
    private int id;
    private String name;
    private String email;
    private String phone;


    public ContactBean(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " - Email: " + getEmail() + " - Phone: " + getPhone();
    }

    // GETTER-SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
