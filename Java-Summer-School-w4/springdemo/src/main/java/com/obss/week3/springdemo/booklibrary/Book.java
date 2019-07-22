package com.obss.week3.springdemo.booklibrary;

import java.io.Serializable;

public class Book implements Serializable {
    private String bookName;

    @Override
    public String toString() {
        return "This book name is: " + bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
