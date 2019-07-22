package com.obss;

public class Book {
    private String bookName;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return bookName;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
