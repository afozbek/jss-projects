package com.obss.week3.springdemo.booklibrary;

import java.util.List;

public interface IBookLibrary {
    List<Book> search(String java);

    void addBook(String bookName);
}
