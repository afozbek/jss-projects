package com.obss.week3.springdemo.booklibrary;

import java.util.List;

public class BookReader {
    private IBookLibrary IBookLibrary;

    public BookReader() {
        this.IBookLibrary = new JavaBookLibrary();
    }

    public List<Book> read() {
        List<Book> books = IBookLibrary.search("java");

        for (Book book : books) {
            System.out.println(book.getBookName());
        }

        return books;
    }
}
